package com.cookandroid.w13b1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

import com.cookandroid.w13b1.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static int LINE = 1, CIRCLE = 2, RECTANGLE = 3;
    static int curShape = LINE;
    static int curColor = Color.DKGRAY;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        setTitle("간단  그림판  (개선)");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선  그리기");
        menu.add(0, 2, 0, "원  그리기");
        menu.add(0, 3, 0, "사각형  그리기");
        SubMenu sMenu = menu.addSubMenu("색상   변경  >>");
        sMenu.add(0, 4, 0, "빨강");
        sMenu.add(0, 5, 0, "초록");
        sMenu.add(0, 6, 0, "파랑");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = CIRCLE; // 원
                return true;
            case 3:
                curShape = RECTANGLE; // 사각형
                return true;
            case 4:
                curColor = Color.RED;
                return true;
            case 5:
                curColor = Color.GREEN;
                return true;
            case 6:
                curColor = Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private static class MyGraphicView extends View {
        Myshape currentShape = null;
        ArrayList<Myshape> MyshapeArrayList = new ArrayList<>();
        public MyGraphicView(Context context) {
            super(context);
        }
        //터치  이벤트  설정
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    currentShape = new Myshape(curShape);
                    currentShape.color = curColor;
                    currentShape.startX = (int) event.getX();
                    currentShape.startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    currentShape.stopX = (int) event.getX();
                    currentShape.stopY = (int) event.getY();
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    currentShape.stopX = (int) event.getX();
                    currentShape.stopY = (int) event.getY();
                    MyshapeArrayList.add(currentShape);
                    currentShape = null;
                    this.invalidate();
                    break;
            }
            return true;
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            for (Myshape currentShape : MyshapeArrayList) {
                paint.setColor(currentShape.color);
                drawShape(currentShape, canvas, paint);
            }
            if (currentShape != null) drawShape(currentShape, canvas, paint);
        }
        private void drawShape(Myshape currentShape, Canvas canvas, Paint paint) {
            switch (currentShape.shape) {
                case LINE:
                    canvas.drawLine(currentShape.startX, currentShape.startY,
                            currentShape.stopX, currentShape.stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(currentShape.stopX - currentShape.startX, 2) +
                            Math.pow(currentShape.stopY - currentShape.startY, 2));
                    canvas.drawCircle(currentShape.startX, currentShape.startY, radius, paint);
                    break;
                case RECTANGLE:
                    Rect rect = new Rect(currentShape.startX, currentShape.startY,
                            currentShape.stopX, currentShape.stopY);
                    canvas.drawRect(rect, paint);
                    break;
            }
        }
        private static class Myshape {
            int shape, startX, startY, stopX, stopY, color;
            public Myshape(int shape) {
                this.shape = shape;
            }
/*
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(10);
            canvas.drawLine(20, 40, 600, 20, paint);

            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
            canvas.drawLine(20, 60, 600, 60, paint);

            paint.setColor(Color.MAGENTA);
            paint.setStrokeWidth(0);

            paint.setStyle(Paint.Style.FILL);
            Rect rect1 = new Rect(20, 100, 20 + 150, 100 + 150);
            canvas.drawRect(rect1, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);
            Rect rect2 = new Rect(260, 100, 260 + 200, 100 + 200);
            canvas.drawRect(rect2, paint);

            RectF rect3 = new RectF(500, 100, 500 + 200, 100 + 200);

            canvas.drawRoundRect(rect3, 40, 40, paint);
            canvas.drawCircle(120, 440, 100, paint);

            paint.setStrokeWidth(10);
            Path path1 = new Path();
            path1.moveTo(20, 580);
            path1.lineTo(20 + 100, 580 + 100);
            path1.lineTo(20 + 200, 580);
            path1.lineTo(20 + 300, 580 + 100);
            path1.lineTo(20 + 400, 580);
            canvas.drawPath(path1, paint);

            paint.setStyle(Paint.Style.STROKE);
            Rect rect4 = new Rect(40, 800, 40 + 150, 800 + 150);
            canvas.drawRect(rect4, paint);
            paint.setStrokeWidth(10);

            path1.moveTo(20, 1000);
            path1.lineTo(20 + 200, 1000 );
            path1.moveTo(110, 1000);
            path1.lineTo(110, 1000+100);
            path1.moveTo(40,  1050);
            path1.lineTo(40 , 1050 + 100);
            path1.moveTo(40,  1150);
            path1.lineTo(40 + 150, 1150);
            canvas.drawPath(path1, paint);

            path1.moveTo(360, 800);
            path1.lineTo(360 - 100, 800 + 150);
            path1.moveTo(360, 800);
            path1.lineTo(360 + 100, 800 + 150);
            path1.moveTo(240,  1000);
            path1.lineTo(240 + 250 , 1000);
            canvas.drawCircle(360, 1100, 80, paint);
            canvas.drawPath(path1, paint);

            path1.moveTo(630, 800);
            path1.lineTo(630 - 80, 800 + 150);
            path1.moveTo(630, 800);
            path1.lineTo(630 + 80, 800 + 150);
            path1.moveTo(750, 800);
            path1.lineTo(750, 800 + 250);
            path1.moveTo(600,  1000);
            path1.lineTo(600 , 1000 + 150);
            path1.moveTo(600,  1150);
            path1.lineTo(600 + 150, 1150);
            canvas.drawPath(path1, paint);

            paint.setStrokeWidth(0);
            paint.setTextSize(120);
            canvas.drawText("안드로이드", 200, 780, paint);*/
        }

    }

}
