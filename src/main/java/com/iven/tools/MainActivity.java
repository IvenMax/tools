package com.iven.tools;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.iven.tools.base.BaseActivity;
import com.iven.tools.tools.LocationUtils;
import com.iven.tools.tools.T;

public class MainActivity extends BaseActivity {
    private static final String TAG = "IVEN_MainActivity";
    private Button btn_location;
    private Context context;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setTitle() {
        title_title.setText("首页");
        title_left.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.mipmap.title_back),
                null, null, null);
        title_left.setOnClickListener(this);
    }

    @Override
    public void initWidget() {
        btn_location = (Button) findViewById(R.id.btn_location);
        btn_location.setOnClickListener(this);
        context = getApplication().getApplicationContext();
    }

    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.title_left:
                finish();
                break;
            case R.id.btn_location:
                boolean gpsEnabled = LocationUtils.isGpsEnabled(context);
                T.showShort(context,"gpsEnabled = " + gpsEnabled);
                break;
        }
    }
}
