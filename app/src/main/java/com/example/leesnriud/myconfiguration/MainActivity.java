package com.example.leesnriud.myconfiguration;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android configuration
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_configuration)
    TextView tvConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StringBuffer status = new StringBuffer();
        //获取系统的Configuration对象
        Configuration cfg = getResources().getConfiguration();

        status.append("densityDpi:" + cfg.densityDpi + "\n");
        status.append("fontScale:" + cfg.fontScale + "\n");
        status.append("hardKeyboardHidden:" + cfg.hardKeyboardHidden + "\n");
        status.append("keyboard:" + cfg.keyboard + "\n");
        status.append("keyboardHidden:" + cfg.keyboardHidden + "\n");
        status.append("locale:" + cfg.locale + "\n");
        status.append("mcc:" + cfg.mcc + "\n");
        status.append("mnc:" + cfg.mnc + "\n");
        status.append("navigation:" + cfg.navigation + "\n");
        status.append("navigationHidden:" + cfg.navigationHidden + "\n");
        status.append("orientation:" + cfg.orientation + "\n");
        status.append("screenHeightDp:" + cfg.screenHeightDp + "\n");
        status.append("screenWidthDp:" + cfg.screenWidthDp + "\n");
        status.append("screenLayout:" + cfg.screenLayout + "\n");
        status.append("smallestScreenWidthDp:" + cfg.densityDpi + "\n");
        status.append("touchscreen:" + cfg.densityDpi + "\n");
        status.append("uiMode:" + cfg.densityDpi + "\n");
        tvConfiguration.setText(status.toString());

    }

    @OnClick(R.id.bt_myconfiguration)
    public void onViewClicked() {
        Configuration config = getResources().getConfiguration();
        //如果是横屏的话切换成竖屏
        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        //如果竖屏的话切换成横屏
        if(config.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE?"横屏":"竖屏";
        Toast.makeText(MainActivity.this, "系统屏幕方向发生改变 \n 修改后的方向为" + screen, Toast.LENGTH_SHORT).show();
    }
}
