package com.example.bluexmax.studyec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.latte_core.activities.ProxyActivity;
import com.example.latte_core.app.Latte;
import com.example.latte_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toast.makeText(Latte.getApplicationContext(),"context",Toast.LENGTH_LONG).show();
//    }

    @Override
    public LatteDelegate setRootDelegate(){
        return new ExampleDelegate();
    }
}
