package com.wyyu.multi.cell;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.wyyu.multi.holder.IViewHolder;
import java.util.Arrays;

/**
 * Created by wyyu on 2019-09-27.
 **/

public abstract class AbsCellManager<T, V> implements ICellManager<T, V> {

    protected static final int DEFAULT_LENGTH = 6;

    private IViewHolder[] holderArray;
    private T[] keyArray;

    public AbsCellManager() {
        holderArray = new IViewHolder[DEFAULT_LENGTH];
        keyArray = loadKeyArray();
    }

    @Override public void register(@NonNull T keyValue, @NonNull IHolderCell holderCell) {
        int index = loadNewIndex();

        if (index < 0) {
            this.holderArray =
                Arrays.copyOf(this.holderArray, this.holderArray.length + DEFAULT_LENGTH);
            this.keyArray = Arrays.copyOf(this.keyArray, this.keyArray.length + DEFAULT_LENGTH);

            index = loadNewIndex();
        }

        holderArray[index] = loadHolderFromCell(holderCell);
        keyArray[index] = keyValue;
    }

    private int loadNewIndex() {
        int indexPre = -1;
        int funIndex = 0;

        while (funIndex < keyArray.length && keyArray[funIndex] != null) {
            funIndex++;
        }
        if (funIndex < keyArray.length) {
            indexPre = funIndex;
        }

        return indexPre;
    }

    private IViewHolder loadHolderFromCell(IHolderCell holderCell) {
        try {
            String holderName = loadHolderName(holderCell);
            if (holderName == null || holderName.length() == 0) {
                return null;
            }
            Class holderClass = Class.forName(holderName);
            return (IViewHolder) holderClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String loadHolderName(IHolderCell holderCell) {
        if (holderCell.getClass().getPackage() == null) {
            return null;
        }
        String packageName = holderCell.getClass().getPackage().getName();
        String mid = ".Holder";
        String className = holderCell.getClass().getName();
        String nameNext = className.substring(className.lastIndexOf(".") + 1);

        return packageName + mid + nameNext;
    }

    @Override public int getItemViewType(@NonNull V item) {
        if (keyArray == null || keyArray.length == 0) {
            throw new IllegalArgumentException(
                "The Item = " + item.getClass().getName() + " Not Register To Adapter");
        }
        for (int index = 0; index < keyArray.length; index++) {
            if (loadKeyFromItem(item).equals(keyArray[index])) {
                return index;
            }
        }
        throw new IllegalArgumentException(
            "The Item = " + item.getClass().getName() + " Not Register To Adapter");
    }

    @NonNull @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return holderArray[viewType].onCreateViewHolder(parent);
    }

    @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, V item) {
        holderArray[holder.getItemViewType()].onBindViewHolder(holder, item);
    }

    @Override
    public void updateItem(@NonNull RecyclerView.ViewHolder holder, V item, int updateType,
        Object... params) {
        holderArray[holder.getItemViewType()].updateItem(holder, item, updateType, params);
    }
}
