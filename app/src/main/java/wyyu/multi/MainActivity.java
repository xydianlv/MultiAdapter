package wyyu.multi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import wyyu.multi.litho.ActivityLithoCardList;
import wyyu.multi.list.ActivityList;
import wyyu.multi.multi.ActivityMultiList;
import wyyu.multi.update.ActivityUpdateList;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.click_list).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityList.class));
            }
        });

        findViewById(R.id.click_multi).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityMultiList.class));
            }
        });

        findViewById(R.id.click_update).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                ActivityUpdateList.open(MainActivity.this);
            }
        });

        findViewById(R.id.click_litho).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                ActivityLithoCardList.open(MainActivity.this);
            }
        });
    }
}
