package wyyu.multi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import wyyu.multi.cell_class.ActivityListClass;
import wyyu.multi.cell_integer.ActivityListInteger;
import wyyu.multi.normal.ActivityListNormal;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.click_normal).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                ActivityListNormal.open(MainActivity.this);
            }
        });

        findViewById(R.id.click_cell_class).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                ActivityListClass.open(MainActivity.this);
            }
        });

        findViewById(R.id.click_cell_integer).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                ActivityListInteger.open(MainActivity.this);
            }
        });
    }
}
