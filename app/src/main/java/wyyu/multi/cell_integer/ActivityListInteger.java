package wyyu.multi.cell_integer;

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
import wyyu.multi.cell_integer.adapter.AdapterListInteger;
import wyyu.multi.cell_integer.cell.CellIntegerA;
import wyyu.multi.cell_integer.cell.CellIntegerB;
import wyyu.multi.cell_integer.data.DataIntegerA;
import wyyu.multi.cell_integer.data.DataIntegerB;
import wyyu.multi.cell_integer.data.IIntegerData;
import wyyu.multi.cell_integer.manager.IntegerCellManager;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class ActivityListInteger extends AppCompatActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ActivityListInteger.class));
    }

    @BindView(R.id.integer_recycler) RecyclerView recyclerView;

    private AdapterListInteger<Integer, IIntegerData> adapter;
    private Unbinder unbinder;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_integer);

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
        initView();
        loadList();
    }

    private void initView() {
        adapter = new AdapterListInteger<>(new IntegerCellManager());

        adapter.register(IIntegerData.DATA_A, new CellIntegerA());
        adapter.register(IIntegerData.DATA_B, new CellIntegerB());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(adapter);
    }

    private void loadList() {
        Observable.unsafeCreate(new Observable.OnSubscribe<List<IIntegerData>>() {
            @Override public void call(Subscriber<? super List<IIntegerData>> subscriber) {
                List<IIntegerData> dataList = new ArrayList<>();
                for (int index = 0; index < Constants.COUNT; index++) {
                    if (index % 2 == 0) {
                        dataList.add(new DataIntegerA(index));
                    } else {
                        dataList.add(new DataIntegerB(index));
                    }
                }
                subscriber.onNext(dataList);
                subscriber.onCompleted();
            }
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<IIntegerData>>() {
                @Override public void call(List<IIntegerData> dataList) {
                    if (adapter != null) {
                        adapter.initList(dataList);
                    }
                }
            }, new Action1<Throwable>() {
                @Override public void call(Throwable throwable) {
                    Log.e("ActivityListIntegerTest", throwable.getMessage());
                }
            });
    }
}
