package com.example.homework332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner switch_lang;
    Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = switch_lang.getSelectedItemPosition();
                Locale locale = null;
                switch (selected) {
                    case 0:
                        locale = new Locale("ru");
                        break;
                    case 1:
                        locale = new Locale("en");
                        break;
                }
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }

    private void initView() {
        switch_lang = findViewById(R.id.switch_lang);
        btn_result = findViewById(R.id.btn_result);
    }
}
