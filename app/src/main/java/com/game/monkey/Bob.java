package com.game.monkey;

import android.content.res.Resources;
import static com.game.monkey.GameView.screenRatioX;
import static com.game.monkey.GameView.screenRatioY;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Bob {
    int x, y, width, height;
    Bitmap mon1, mon2, mon3, mon4;
    private GameView gameView;
    Bob (int ScreenY, Resources res) {
        mon1 = BitmapFactory.decodeResource(res, R.drawable.pic1);
        mon2 = BitmapFactory.decodeResource(res, R.drawable.pic2);
        mon3 = BitmapFactory.decodeResource(res, R.drawable.pic3);
        mon4 = BitmapFactory.decodeResource(res, R.drawable.pic4);

        width = mon1.getWidth();
        height = mon1.getHeight();

        width /= 4;
        height /= 4;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

    }
}
