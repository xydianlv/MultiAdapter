package wyyu.multi.normal.holder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import wyyu.multi.R;
import wyyu.multi.normal.data.DataNormal;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class HolderNormalA extends RecyclerView.ViewHolder {

    public static final int LAYOUT = R.layout.layout_holder_normal_a;

    private TextView itemContent;
    private TextView itemIndex;

    public HolderNormalA(@NonNull View itemView) {
        super(itemView);

        itemContent = itemView.findViewById(R.id.holder_normal_a_content);
        itemIndex = itemView.findViewById(R.id.holder_normal_a_index);
    }

    public void setItemValue(DataNormal data) {
        itemContent.setText(data.content);
        itemIndex.setText(String.valueOf(data.index));
    }
}
