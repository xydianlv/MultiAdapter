package com.wyyu.processor

import com.google.auto.service.AutoService
import com.wyyu.expand.BindHolder
import java.lang.StringBuilder
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

/**
 * Created by wyyu on 2021/7/30.
 **/

@AutoService(Processor::class)
class ProcessorHolder : AbstractProcessor() {

    private var msg: Messager? = null

    override fun init(processingEnv: ProcessingEnvironment?) {
        super.init(processingEnv)

        msg = processingEnv?.messager
        msg?.printMessage(Diagnostic.Kind.NOTE, "init success")
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun getSupportedAnnotationTypes(): Set<String> {
        val annotationSet: MutableSet<String> = LinkedHashSet()
        annotationSet.add(BindHolder::class.java.canonicalName)
        return annotationSet
    }

    override fun process(p0: MutableSet<out TypeElement>?, p1: RoundEnvironment?): Boolean {
        processorCell(p1)
        return true
    }

    private fun processorCell(p1: RoundEnvironment?) {
        val elementSet = p1?.getElementsAnnotatedWith(BindHolder::class.java)
        if (elementSet == null || elementSet.isEmpty()) {
            return
        }
        for (element in elementSet) {
            if (element !is TypeElement) {
                continue
            }
            val cellName = element.qualifiedName.toString()
            generateHolder(cellName)
        }
    }

    private fun generateHolder(cellName: String) {
        val packageName = cellName.substring(0, cellName.lastIndexOf("."))
        val className = "Holder" + cellName.substring(cellName.lastIndexOf(".") + 1)
        val holderName = className + "Core"

        val strBuilder = StringBuilder()

        strBuilder.append("package ").append(packageName).append(";\n\n")

        strBuilder.append("import androidx.recyclerview.widget.RecyclerView;\n")
        strBuilder.append("import androidx.annotation.NonNull;\n")
        strBuilder.append("import androidx.annotation.Nullable;\n")
        strBuilder.append("import androidx.annotation.Keep;\n")
        strBuilder.append("import com.wyyu.multi.holder.IViewHolder;\n")
        strBuilder.append("import android.view.LayoutInflater;\n")
        strBuilder.append("import android.view.ViewGroup;\n")
        strBuilder.append("import android.view.View;\n\n")

        strBuilder.append("@Keep\n")
        strBuilder.append("public final class ").append(className)
        strBuilder.append(" implements IViewHolder {\n\n")

        strBuilder.append("    @NonNull\n@Override\n")
        strBuilder.append("    public RecyclerView.ViewHolder onCreateViewHolder")
        strBuilder.append("(@NonNull ViewGroup parent) {\n")
        strBuilder.append("        ").append(cellName).append(" cell =")
        strBuilder.append(" new ").append(cellName).append("();\n")
        strBuilder.append("        View itemView = LayoutInflater.from(parent.getContext())")
        strBuilder.append(".inflate(cell.getHolderLayout(), parent, false);\n")
        strBuilder.append("        return new ").append(holderName).append("(itemView, cell);\n")
        strBuilder.append("    }\n\n")

        strBuilder.append("    @Override\n")
        strBuilder.append("    public void onBindViewHolder")
        strBuilder.append("(@NonNull RecyclerView.ViewHolder holder, int position,")
        strBuilder.append(" @Nullable Object itemData, @NonNull Object... params) {\n")
        strBuilder.append("        ((").append(holderName)
            .append(")holder).cell.onBindCell(position, itemData, params);\n")
        strBuilder.append("    }\n\n")

        strBuilder.append("    @Override\n")
        strBuilder.append("    public void onUpdateViewHolder")
        strBuilder.append("(@NonNull RecyclerView.ViewHolder holder,")
        strBuilder.append(" int updateType, @Nullable Object... params) {\n")
        strBuilder.append("        ((").append(holderName).append(")holder).cell")
        strBuilder.append(".onUpdateCell(updateType, params);\n")
        strBuilder.append("    }\n\n")

        strBuilder.append("    private static class ").append(holderName)
        strBuilder.append(" extends RecyclerView.ViewHolder {\n\n")

        strBuilder.append("        private ").append(cellName).append(" cell;\n\n")

        strBuilder.append("        private ").append(holderName).append("(@NonNull ")
        strBuilder.append("View itemView, @NonNull ").append(cellName).append(" cell) {")
        strBuilder.append("\n")
        strBuilder.append("            super(itemView);\n\n")
        strBuilder.append("            this.cell = cell;\n\n")
        strBuilder.append("            this.cell.onCreateView(itemView);\n")
        strBuilder.append("        }\n")

        strBuilder.append("    }\n")
        strBuilder.append("}\n")

        try {
            val sourceFile = processingEnv.filer.createSourceFile("$packageName.$className")
            val writer = sourceFile.openWriter()
            writer.write(strBuilder.toString())
            writer.flush()
            writer.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}