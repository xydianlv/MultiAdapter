package com.wyyu.multiktest.normal.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wyyu.multiktest.R;
import com.wyyu.multiktest.normal.holder.HolderNormalA;

/**
 * Created by wyyu on 2021/7/30.
 **/

public class ListNormalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderNormalA(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.activity_list_normal, parent, false));
    }

    @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override public int getItemCount() {
        return 0;
    }
}
