package wyyu.multi;

import android.app.Application;
import com.facebook.soloader.SoLoader;
import java.io.IOException;

/**
 * Created by wyyu on 2019-10-11.
 **/
public class AppController extends Application {

    @Override public void onCreate() {
        super.onCreate();

        try {
            SoLoader.init(getApplicationContext(), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
