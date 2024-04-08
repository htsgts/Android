package com.cookandroid.w14a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray;
    MyGraphicView graphicView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.yuhan);
        setTitle("미니포토샵");
        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.iconLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);
        }
        private static class MyGraphicView extends View {
            public MyGraphicView(Context context) {
                super(context);
            }
            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.jeju);
                int picX = (this.getWidth() - picture.getWidth()) / 2;
                int picY = (this.getHeight() - picture.getHeight()) / 2;
                canvas.drawBitmap(picture, picX, picY, null);
                picture.recycle();
            }
        }
    }
}