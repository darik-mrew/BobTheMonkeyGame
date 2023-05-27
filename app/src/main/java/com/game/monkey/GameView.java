package com.game.monkey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    public static float screenRatioX;
    public static float screenRatioY;
    private boolean isPlay;
    Background background1, background2;
    private int screenX, screenY;
    Paint paint;

    public GameView(Context context, int x, int y) {
        super(context);

        this.screenY = screenY;
        this.screenX = screenX;

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());
        background2.x = screenX;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        paint = new Paint();
    }

    @Override
    public void run() {
        while (isPlay) {
            update();
            draw();
            sleep();
        }
    }
    private void update() {
        background1.x -= 10 * screenRatioX;
        background2.x -= 10 * screenRatioY;

        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX;
        }

        if (background2.x + background2.background.getWidth() < 0) {
            background2.x = screenX;
        }

    }
    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(background2.background, background2.x, background2.y, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }
    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void resume() {
        isPlay = true;
        thread = new Thread(this);
        thread.start();
    }
    public void pause() {
        try {
            isPlay = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
