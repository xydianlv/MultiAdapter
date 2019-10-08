package wyyu.multi.update;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.wyyu.multi.adapter.MultiAdapter;
import com.wyyu.multi.cell.ClassCellManager;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import wyyu.multi.R;
import wyyu.multi.update.cell.CellNotify;
import wyyu.multi.update.cell.CellUpdate;
import wyyu.multi.update.data.DataNotify;
import wyyu.multi.update.data.DataUpdate;
import wyyu.multi.update.event.EventNotifyItem;
import wyyu.multi.update.event.EventUpdateItem;

/**
 * Created by wyyu on 2019-10-08.
 **/

public class ActivityUpdateList extends AppCompatActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, ActivityUpdateList.class));
    }

    @BindView(R.id.update_list_recycler) RecyclerView recyclerView;

    private MultiAdapter<Class<?>, Object> adapter;

    private Unbinder unbinder;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_list);

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
        registerEvent();
        initList();
        loadList();
    }

    private void registerEvent() {

        LiveEventBus.get()
            .with(EventNotifyItem.EVENT, EventNotifyItem.class)
            .observe(this, new Observer<EventNotifyItem>() {
                @Override public void onChanged(@Nullable EventNotifyItem event) {
                    if (adapter != null && event != null) {
                        adapter.notifyItem(event.dataNotify);
                    }
                }
            });

        LiveEventBus.get()
            .with(EventUpdateItem.EVENT, EventUpdateItem.class)
            .observe(this, new Observer<EventUpdateItem>() {
                @Override public void onChanged(@Nullable EventUpdateItem event) {
                    if (adapter != null && event != null) {
                        adapter.updateItem(recyclerView, event.dataUpdate, CellUpdate.UPDATE_A);
                    }
                }
            });
    }

    private void initList() {
        adapter = new MultiAdapter<>(new ClassCellManager());

        adapter.register(DataNotify.class, new CellNotify());
        adapter.register(DataUpdate.class, new CellUpdate());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(adapter);
    }

    private void loadList() {
        Observable.unsafeCreate(new Observable.OnSubscribe<List<Object>>() {
            @Override public void call(Subscriber<? super List<Object>> subscriber) {
                List<Object> objectList = new ArrayList<>();
                for (int index = 0; index < 36; index++) {
                    if (index % 2 == 0) {
                        objectList.add(new DataNotify(index));
                    } else {
                        objectList.add(new DataUpdate(index));
                    }
                }
                subscriber.onNext(objectList);
                subscriber.onCompleted();
            }
        })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<Object>>() {
                @Override public void call(List<Object> objectList) {
                    adapter.initItemList(objectList, true);
                }
            }, new Action1<Throwable>() {
                @Override public void call(Throwable throwable) {
                    Log.e("ActivityUpdateList", throwable.getMessage());
                }
            });
    }
}
