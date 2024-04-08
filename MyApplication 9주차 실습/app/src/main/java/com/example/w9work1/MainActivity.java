package com.example.w9work1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button btn1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        btn1 = (Button) findViewById(R.id.button);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "배경색 (빨강)");
        menu.add(0, 2, 0, "배경색 (초록)");
        menu.add(0, 3, 0, "배경색 (파랑)");
        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
        sMenu.add(0, 4, 0, "버튼 45도 회전");
        sMenu.add(0, 5, 0, "버튼 2배 확대");
        return true;
//        MenuInflater mInflater = getMenuInflater();
//        mInflater.inflate(R.menu.menu1, menu);
//        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) baseLayout.setBackgroundColor(Color.RED);
        else if (item.getItemId() == 2) baseLayout.setBackgroundColor(Color.GREEN);
        else if (item.getItemId() == 3) baseLayout.setBackgroundColor(Color.BLUE);
        else if (item.getItemId() == 4) btn1.setRotation(45);
        else if (item.getItemId() == 5) btn1.setScaleX(2);
        else return false;
        return true;
        /*
        if (item.getItemId() == R.id.itemRed) baseLayout.setBackgroundColor(Color.RED);
        else if (item.getItemId() == R.id.itemGreen) baseLayout.setBackgroundColor(Color.GREEN);
        else if (item.getItemId() == R.id.itemBlue) baseLayout.setBackgroundColor(Color.BLUE);
        else if (item.getItemId() == R.id.subRotate) btn1.setRotation(45);
        else if (item.getItemId() == R.id.subSize) btn1.setScaleX(2);
        else return false;
        return true;
        */
    }
}