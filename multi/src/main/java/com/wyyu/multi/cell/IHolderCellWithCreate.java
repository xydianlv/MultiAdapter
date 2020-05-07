package com.wyyu.multi.cell;

import androidx.annotation.NonNull;
import android.view.View;

/**
 * Created by wyyu on 2019-10-11.
 **/

public interface IHolderCellWithCreate extends IHolderCell {

    void onCreateView(@NonNull View itemView);
}
