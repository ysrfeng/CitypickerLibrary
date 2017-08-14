package com.ysr.citypickerlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ysr.citypicker.CityPickerActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private TextView tv_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_click = (TextView) findViewById(R.id.tv_click);
        tv_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ARouter.getInstance().build("/lib/CityPickerActivity").navigation();
                ARouter.getInstance().build("/lib/CityPickerActivity").navigation(MainActivity.this, REQUEST_CODE_PICK_CITY);
//                startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),
//                        REQUEST_CODE_PICK_CITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tv_click.setText("当前选择：" + city);
            }
        }
    }

}
