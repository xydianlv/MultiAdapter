package wyyu.multi.cell_class;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wyyu.multi.cell.ClassCellManager;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import wyyu.multi.R;
import wyyu.multi.app.Constants;
import wyyu.multi.cell_class.adapter.AdapterListClass;
import wyyu.multi.cell_class.cell.CellClassA;
import wyyu.multi.cell_class.cell.CellClassB;
import wyyu.multi.cell_class.data.DataClassA;
import wyyu.multi.cell_class.data.DataClassB;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class ActivityListClass extends AppCompatActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ActivityListClass.class));
    }

    @BindView(R.id.class_recycler) RecyclerView recyclerView;

    private AdapterListClass<Class<?>, Object> adapter;
    private Unbinder unbinder;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_class);

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
        adapter = new AdapterListClass<>(new ClassCellManager());

        adapter.register(DataClassA.class, new CellClassA());
        adapter.register(DataClassB.class, new CellClassB());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadList() {
        Observable.unsafeCreate(new Observable.OnSubscribe<List<Object>>() {
            @Override public void call(Subscriber<? super List<Object>> subscriber) {
                List<Object> objectList = new ArrayList<>();
                for (int index = 0; index < Constants.COUNT; index++) {
                    if (index % 2 == 0) {
                        objectList.add(new DataClassA(index));
                    } else {
                        objectList.add(new DataClassB(index));
                    }
                }
                subscriber.onNext(objectList);
                subscriber.onCompleted();
            }
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<Object>>() {
                @Override public void call(List<Object> objects) {
                    if (adapter != null) {
                        adapter.initList(objects);
                    }
                }
            }, new Action1<Throwable>() {
                @Override public void call(Throwable throwable) {

                }
            });
    }
}
