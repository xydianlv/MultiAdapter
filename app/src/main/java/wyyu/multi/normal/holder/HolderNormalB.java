package wyyu.multi.normal.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import wyyu.multi.R;
import wyyu.multi.normal.data.DataNormal;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class HolderNormalB extends RecyclerView.ViewHolder {

    public static final int LAYOUT = R.layout.layout_holder_normal_b;

    private ImageView itemImage;
    private TextView itemIndex;

    public HolderNormalB(@NonNull View itemView) {
        super(itemView);

        itemImage = itemView.findViewById(R.id.holder_normal_b_image);
        itemIndex = itemView.findViewById(R.id.holder_normal_b_index);
    }

    public void setItemValue(DataNormal data) {
        itemIndex.setText(String.valueOf(data.index));
        itemImage.setImageResource(data.resId);
    }
}
