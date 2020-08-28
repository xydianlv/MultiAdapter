package wyyu.multi.normal.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import wyyu.multi.normal.data.DataNormal;
import wyyu.multi.normal.holder.HolderNormalA;
import wyyu.multi.normal.holder.HolderNormalB;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class AdapterListNormal extends RecyclerView.Adapter {

    private List<DataNormal> dataList;

    public AdapterListNormal() {
        dataList = new ArrayList<>();
    }

    @NonNull @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == HolderNormalA.LAYOUT) {
            return new HolderNormalA(LayoutInflater.from(parent.getContext())
                .inflate(HolderNormalA.LAYOUT, parent, false));
        } else {
            return new HolderNormalB(LayoutInflater.from(parent.getContext())
                .inflate(HolderNormalB.LAYOUT, parent, false));
        }
    }

    @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HolderNormalA.LAYOUT:
                ((HolderNormalA) holder).setItemValue(dataList.get(position));
                break;
            case HolderNormalB.LAYOUT:
                ((HolderNormalB) holder).setItemValue(dataList.get(position));
                break;
        }
    }

    @Override public int getItemViewType(int position) {
        return dataList.get(position).index % 2 == 0 ? HolderNormalA.LAYOUT : HolderNormalB.LAYOUT;
    }

    @Override public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    public void setDataList(List<DataNormal> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return;
        }
        if (this.dataList == null) {
            this.dataList = new ArrayList<>();
        }
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }
}
