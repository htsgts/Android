package com.example.w05test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0));

        setContentView(baseLayout, params);

        //버튼 객체 생성
        Button btn = new Button(this);

        //버튼 디자인(꾸미기)
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn);

        //버튼 동작 통제
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "코드로  생성한  버튼입니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}