package wyyu.multi.multi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.wyyu.multi.adapter.MultiAdapter;
import java.util.ArrayList;
import java.util.List;
import wyyu.multi.R;
import wyyu.multi.multi.cell.CellMultiA;
import wyyu.multi.multi.cell.CellMultiB;
import wyyu.multi.multi.cell.CellMultiC;
import wyyu.multi.multi.data.DataMulti;
import wyyu.multi.multi.data.DataType;

/**
 * Created by wyyu on 2019-09-29.
 **/

public class ActivityMultiList extends AppCompatActivity {

    private static final String CONTENT = "梵·高通过这幅画作不是想用浩瀚的宇宙来反衬出人类的渺小，令人类生出畏惧之心，而是传达出一种不向命运低头的精神。";

    private static final int RES_ID = R.mipmap.img_test;
    private static final int COUNT = 32;

    @BindView(R.id.multi_list_recycler) RecyclerView recyclerView;

    private MultiAdapter<Integer, DataMulti> adapter;
    private Unbinder unbinder;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_list);

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
        adapter = new MultiAdapter<>(new IntegerCellManager());

        adapter.register(DataType.ONLY_TEXT, new CellMultiA());
        adapter.register(DataType.ONLY_IMAGE, new CellMultiB());
        adapter.register(DataType.TEXT_AND_IMAGE, new CellMultiC());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadList() {
        List<DataMulti> dataMultiList = new ArrayList<>(COUNT);
        for (int index = 0; index < COUNT; index++) {
            dataMultiList.add(new DataMulti(index, RES_ID, CONTENT));
        }

        adapter.initItemList(dataMultiList, true);
    }
}
