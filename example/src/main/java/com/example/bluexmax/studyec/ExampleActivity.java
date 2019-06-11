package com.example.bluexmax.studyec;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.latte.ec.launcher.LauncherDelegate;
import com.example.latte.ec.launcher.LauncherScrollDelegate;
import com.example.latte_core.activities.ProxyActivity;
import com.example.latte_core.app.Latte;
import com.example.latte_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate(){
        return new LauncherDelegate();
    }
}
