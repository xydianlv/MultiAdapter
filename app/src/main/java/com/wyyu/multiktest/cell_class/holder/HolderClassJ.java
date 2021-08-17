package com.wyyu.multiktest.cell_class.holder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wyyu.expand.BindHolder;
import com.wyyu.multi.cell.IHolderCell;
import com.wyyu.multiktest.cell_class.data.DataClassA;
import com.wyyu.multiktest.cell_class.data.DataClassB;
import com.wyyu.multiktest.databinding.LayoutHolderClassJBinding;

@BindHolder("com.wyyu.multiktest.databinding.LayoutHolderClassJBinding")
public class HolderClassJ implements IHolderCell {

    private LayoutHolderClassJBinding binding;

    @Override
    public void onCreateView(@NonNull Object binding) {
        if (binding instanceof LayoutHolderClassJBinding) {
            this.binding = (LayoutHolderClassJBinding) binding;
        }
    }

    @Override
    public void onBindCell(int position, @Nullable Object itemData, @Nullable Object... params) {
        if (itemData instanceof DataClassA) {
            binding.cellClassJIndex.setText(((DataClassA) itemData).getIndex());
            binding.cellClassJContent.setText(((DataClassA) itemData).getContent());
        }
        if (itemData instanceof DataClassB) {
            binding.cellClassJIndex.setText(((DataClassB) itemData).getIndex());
            binding.cellClassJContent.setText(((DataClassB) itemData).getContent());
        }
    }

    @Override
    public void onUpdateCell(int updateType, @Nullable Object... params) {

    }
}
