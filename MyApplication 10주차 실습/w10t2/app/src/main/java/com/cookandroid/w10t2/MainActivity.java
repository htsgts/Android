package com.cookandroid.w10t2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String[] versionArray = new String[] {"Q(10)", "R(11)", "S(12)","T(13)","U(14)"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(
                        MainActivity.this);
                dlg.setTitle("유한대학교");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setItems(versionArray,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                button1.setText(versionArray[which]);
                            }
                        });
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        "확인을 눌렀네요", Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        });
    }}