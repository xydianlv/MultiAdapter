package com.wyyu.processor;

import com.hendraanggrian.RParser;
import com.wyyu.expand.BindCell;
import com.wyyu.expand.CellView;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;

/**
 * Created by wyyu on 2019-09-27.
 **/

public class ProcessorHolder extends AbstractProcessor {

    @Override public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        processorHolder(roundEnvironment, loadViewIdMap(roundEnvironment));
        return true;
    }

    @Override public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(BindCell.class.getCanonicalName());
        annotations.add(CellView.class.getCanonicalName());
        return annotations;
    }

    private void processorHolder(RoundEnvironment roundEnv, Map<String, Set<ViewKeyValue>> value) {
        RParser parser = RParser.builder(processingEnv)
            .setSupportedAnnotations(BindCell.class)
            .setSupportedTypes("layout")
            .build();
        parser.scan(roundEnv);

        for (Element element : roundEnv.getElementsAnnotatedWith(BindCell.class)) {
            if (!(element instanceof TypeElement)) {
                continue;
            }
            String cellName = ((TypeElement) element).getQualifiedName().toString();
            String packageName = cellName.substring(0, cellName.lastIndexOf("."));

            String layoutStr =
                parser.parse(packageName, element.getAnnotation(BindCell.class).value());

            Map<String, String> viewIdMap = loadViewIdFromValue(value.get(cellName));

            generateHolder(viewIdMap, layoutStr, cellName);
        }
    }

    private Map<String, String> loadViewIdFromValue(Set<ViewKeyValue> value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Map<String, String> viewIdMap = new HashMap<>();
        for (ViewKeyValue viewKeyValue : value) {
            viewIdMap.put(viewKeyValue.viewName, viewKeyValue.viewId);
        }
        return viewIdMap;
    }

    private Map<String, Set<ViewKeyValue>> loadViewIdMap(RoundEnvironment roundEnv) {
        RParser parser = RParser.builder(processingEnv)
            .setSupportedAnnotations(CellView.class)
            .setSupportedTypes("id")
            .build();
        parser.scan(roundEnv);

        Map<String, Set<ViewKeyValue>> viewIdMap = new HashMap<>();

        for (Element element : roundEnv.getElementsAnnotatedWith(CellView.class)) {
            if (!(element instanceof VariableElement)) {
                continue;
            }
            String cellName =
                ((TypeElement) element.getEnclosingElement()).getQualifiedName().toString();

            VariableElement ve = (VariableElement) element;
            String viewName = ve.getSimpleName().toString();

            String packageName = cellName.substring(0, cellName.lastIndexOf("."));
            String viewIdStr =
                parser.parse(packageName, element.getAnnotation(CellView.class).value());

            Set<ViewKeyValue> set = viewIdMap.get(cellName);
            if (set == null) {
                set = new HashSet<>();
                set.add(new ViewKeyValue(viewName, viewIdStr));
                viewIdMap.put(cellName, set);
            } else {
                set.add(new ViewKeyValue(viewName, viewIdStr));
            }
        }

        return viewIdMap;
    }

    /**
     * 构建一个 ViewHolder
     *
     * @param viewMap <ViewName,ViewId> 的一个 Map
     * @param layoutStr 布局字符串
     * @param cellName 类名，包含包名前缀
     */
    private void generateHolder(Map<String, String> viewMap, String layoutStr, String cellName) {
        String packageName = cellName.substring(0, cellName.lastIndexOf("."));
        String className = "Holder" + cellName.substring(cellName.lastIndexOf(".") + 1);
        String holderName = className + "Core";

        StringBuilder builder = new StringBuilder();

        builder.append("package ").append(packageName).append(";\n\n");

        builder.append("import android.support.v7.widget.RecyclerView;\n");
        builder.append("import android.support.annotation.NonNull;\n");
        builder.append("import com.wyyu.multi.holder.IViewHolder;\n");
        builder.append("import com.wyyu.multi.cell.IHolderCellWithCreate;\n");
        builder.append("import android.view.LayoutInflater;\n");
        builder.append("import android.view.ViewGroup;\n");
        builder.append("import android.view.View;\n\n");

        builder.append("public final class ").append(className);
        builder.append(" implements IViewHolder {\n\n");

        builder.append("    public ").append(className).append("() {\n\n");

        builder.append("    }\n\n");

        builder.append("    @Override\n");
        builder.append("    public RecyclerView.ViewHolder onCreateViewHolder");
        builder.append("(@NonNull ViewGroup parent) {\n");
        builder.append("        return new ").append(holderName).append("(");
        builder.append("LayoutInflater.from(parent.getContext())\n");
        builder.append("            .inflate(").append(layoutStr).append(", parent, false));\n");
        builder.append("    }\n\n");

        builder.append("    @Override\n");
        builder.append("    public void onBindViewHolder");
        builder.append("(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item) {\n");
        builder.append("        ((").append(holderName).append(")holder).cell.cacheCell(item);\n");
        builder.append("    }\n\n");

        builder.append("    @Override\n");
        builder.append("    public void updateItem");
        builder.append("(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item,");
        builder.append(" int updateType, Object... params) {\n");
        builder.append("        ((").append(holderName).append(")holder).cell");
        builder.append(".updateCell(item, updateType, params);\n");
        builder.append("    }\n\n");

        builder.append("    private static class ").append(holderName);
        builder.append(" extends RecyclerView.ViewHolder {\n\n");

        builder.append("        private ").append(cellName).append(" cell;\n\n");

        builder.append("        private ").append(holderName).append("(@NonNull View itemView) {");
        builder.append("\n");
        builder.append("            super(itemView);\n\n");
        builder.append("            cell = new ").append(cellName).append("();\n\n");

        if (viewMap != null && !viewMap.isEmpty()) {
            for (String key : viewMap.keySet()) {
                builder.append("            cell.").append(key).append(" = itemView.findViewById(");
                builder.append(viewMap.get(key)).append(");\n");
            }
        }

        builder.append("\n");
        builder.append("            if (cell instanceof IHolderCellWithCreate) {\n");
        builder.append("                ((IHolderCellWithCreate) cell).onCreateView(itemView);\n");
        builder.append("            }\n");

        builder.append("        }\n");
        builder.append("    }\n");

        builder.append("}\n");

        try {
            JavaFileObject object =
                processingEnv.getFiler().createSourceFile(packageName + "." + className);
            Writer writer = object.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
