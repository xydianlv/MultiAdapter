package wyyu.multi.litho.data;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wyyu on 2019-10-11.
 **/

@IntDef({ DataTypeT.ONLY_TEXT, DataTypeT.ONLY_IMAGE, DataTypeT.TEXT_AND_IMAGE })
@Retention(RetentionPolicy.SOURCE) public @interface DataTypeT {

    int ONLY_TEXT = 0;

    int ONLY_IMAGE = 1;

    int TEXT_AND_IMAGE = 2;
}