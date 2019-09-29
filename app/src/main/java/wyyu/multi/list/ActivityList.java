package wyyu.multi.list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wyyu.multi.adapter.MultiAdapter;
import com.wyyu.multi.cell.ClassCellManager;
import java.util.List;
import wyyu.multi.R;
import wyyu.multi.list.cell.CellA;
import wyyu.multi.list.cell.CellB;
import wyyu.multi.list.data.DataA;
import wyyu.multi.list.data.DataB;

/**
 * Created by wyyu on 2019-09-27.
 **/

public class ActivityList extends AppCompatActivity {

    @BindView(R.id.main_recycler_view) RecyclerView recyclerView;

    private MultiAdapter<Class<?>, Object> adapter;
    private ModelTest modelTest;
    private Unbinder unbinder;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

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
        initModel();

        loadList();
    }

    private void initView() {
        adapter = new MultiAdapter<>(new ClassCellManager());

        adapter.register(DataA.class, new CellA());
        adapter.register(DataB.class, new CellB());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(adapter);
    }

    private void initModel() {
        modelTest = ViewModelProviders.of(this).get(ModelTest.class);
    }

    private void loadList() {
        modelTest.loadList(new ModelTest.LoadCallback() {
            @Override public void callback(List<Object> cellTestList) {
                adapter.initItemList(cellTestList, true);
            }

            @Override public void onFailure() {

            }
        });
    }
}
