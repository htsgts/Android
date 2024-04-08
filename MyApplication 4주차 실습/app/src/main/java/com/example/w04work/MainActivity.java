package com.example.w04work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //이름 버튼 클릭 통제
        Button btn1 = (Button)findViewById(R.id.button2);
        btn1.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                btn1.setText("문승신");
                Toast.makeText(getApplicationContext(), "문승신", Toast.LENGTH_SHORT).show();
            }
        });
        //학번 버튼 클릭 통제
        Button btn2 = (Button)findViewById(R.id.button3);
        btn2.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                btn2.setText("202007013");
                Toast.makeText(getApplicationContext(), "202007013", Toast.LENGTH_SHORT).show();
            }
        });
        //주소 버튼 클릭 통제
        Button btn3 = (Button)findViewById(R.id.button4);
        btn3.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                btn3.setText("경기도 부천시 괴안동");
                Toast.makeText(getApplicationContext(), "경기도 부천시 괴안동", Toast.LENGTH_SHORT).show();
            }
        });
        //전화 번호 버튼 클릭 통제
        Button btn4 = (Button)findViewById(R.id.button5);
        btn4.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                btn4.setText("010-1234-5678");
                Toast.makeText(getApplicationContext(), "010-1234-5678", Toast.LENGTH_SHORT).show();
            }
        });
        //소개 버튼 클릭 통제
        Button btn5 = (Button)findViewById(R.id.button6);
        btn5.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                btn5.setText("나는 문승신입니다.");
                Toast.makeText(getApplicationContext(), "나는 문승신입니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}