package wyyu.multi.list;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import wyyu.multi.list.data.DataA;
import wyyu.multi.list.data.DataB;

/**
 * Created by wyyu on 2019-09-27.
 **/

public class ModelTest extends ViewModel {

    public ModelTest() {

    }

    void loadList(@NonNull final LoadCallback callback) {

        Observable.unsafeCreate(new Observable.OnSubscribe<List<Object>>() {
            @Override public void call(Subscriber<? super List<Object>> subscriber) {
                List<Object> cellTestList = new ArrayList<>();
                for (int index = 0; index < 32; index++) {
                    if (index % 2 == 0) {
                        cellTestList.add(new DataA(index));
                    } else {
                        cellTestList.add(new DataB(index));
                    }
                }
                subscriber.onNext(cellTestList);
                subscriber.onCompleted();
            }
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<Object>>() {
                @Override public void call(List<Object> cellTestList) {
                    callback.callback(cellTestList);
                }
            }, new Action1<Throwable>() {
                @Override public void call(Throwable throwable) {
                    callback.onFailure();
                }
            });
    }

    public interface LoadCallback {

        void callback(List<Object> cellTestList);

        void onFailure();
    }
}
