package wyyu.multi.normal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import wyyu.multi.R;
import wyyu.multi.app.Constants;
import wyyu.multi.normal.adapter.AdapterListNormal;
import wyyu.multi.normal.data.DataNormal;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class ActivityListNormal extends AppCompatActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ActivityListNormal.class));
    }

    @BindView(R.id.normal_recycler) RecyclerView recyclerView;

    private AdapterListNormal adapter;
    private Unbinder unbinder;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_normal);

        unbinder = ButterKnife.bind(this);
        initActivity();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    private void initActivity() {
        initList();
        loadData();
    }

    private void initList() {
        adapter = new AdapterListNormal();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        Observable.unsafeCreate(new Observable.OnSubscribe<List<DataNormal>>() {
            @Override public void call(Subscriber<? super List<DataNormal>> subscriber) {
                List<DataNormal> dataList = new ArrayList<>();
                for (int index = 0; index < Constants.COUNT; index++) {
                    dataList.add(new DataNormal(index));
                }
                subscriber.onNext(dataList);
                subscriber.onCompleted();
            }
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<DataNormal>>() {
                @Override public void call(List<DataNormal> dataList) {
                    if (adapter != null) {
                        adapter.setDataList(dataList);
                    }
                }
            }, new Action1<Throwable>() {
                @Override public void call(Throwable throwable) {
                    Log.e("", throwable.getMessage());
                }
            });
    }
}
