package wyyu.multi.litho;

import android.content.Context;
import android.content.Intent;
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
import wyyu.multi.litho.cell.CellTestC;
import wyyu.multi.litho.cell.CellTestA;
import wyyu.multi.litho.cell.CellTestB;
import wyyu.multi.litho.data.DataTest;
import wyyu.multi.litho.data.DataTypeT;
import wyyu.multi.R;

/**
 * Created by wyyu on 2019-10-11.
 **/

public class ActivityLithoCardList extends AppCompatActivity {

    private static final String CONTENT = "梵·高通过这幅画作不是想用浩瀚的宇宙来反衬出人类的渺小，令人类生出畏惧之心，而是传达出一种不向命运低头的精神。";

    private static final int RES_ID = R.mipmap.img_test;
    private static final int COUNT = 32;

    public static void open(Context context) {
        context.startActivity(new Intent(context, ActivityLithoCardList.class));
    }

    @BindView(R.id.multi_litho_card_list) RecyclerView recycler;

    private MultiAdapter<Integer, DataTest> multiAdapter;
    private Unbinder unbinder;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litho_card_list);

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
        multiAdapter = new MultiAdapter<>(new DataCellManager());

        multiAdapter.register(DataTypeT.ONLY_TEXT, new CellTestA());
        multiAdapter.register(DataTypeT.ONLY_IMAGE, new CellTestB());
        multiAdapter.register(DataTypeT.TEXT_AND_IMAGE, new CellTestC());

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(multiAdapter);
    }

    private void loadList() {
        List<DataTest> dataMultiList = new ArrayList<>(COUNT);
        for (int index = 0; index < COUNT; index++) {
            dataMultiList.add(new DataTest(index, RES_ID, CONTENT));
        }

        multiAdapter.initItemList(dataMultiList, true);
    }
}
