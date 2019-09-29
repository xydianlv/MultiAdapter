package wyyu.multi.multi.data;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wyyu on 2019-09-29.
 **/

@IntDef({ DataType.ONLY_TEXT, DataType.ONLY_IMAGE, DataType.TEXT_AND_IMAGE })
@Retention(RetentionPolicy.SOURCE) public @interface DataType {

    int ONLY_TEXT = 0;

    int ONLY_IMAGE = 1;

    int TEXT_AND_IMAGE = 2;
}
