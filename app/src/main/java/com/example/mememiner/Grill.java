package com.example.mememiner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Grill {

    public Grill(){
        //TODO initialize member varialbes here.
    }

    static Bitmap fryImage(Bitmap image, int amount, Context context){

        float contrast = amount * 0.1f;
        float brightness = 0.01f;
        Bitmap fried = changeBitmapContrastBrightness(image,contrast,brightness);

        try{
            File bitTmp = new File(context.getCacheDir(), "tmp.jpg");
            bitTmp.createNewFile();

            FileOutputStream fout = new FileOutputStream(bitTmp.getPath());
            if (fried.compress(Bitmap.CompressFormat.JPEG,amount/3,fout)){
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap deepFried = BitmapFactory.decodeFile(bitTmp.getPath(),options);
                fried = deepFried;
            }

            bitTmp.delete();
        } catch(IOException e){

            e.printStackTrace();

            fried = null;
        }

        return fried;
    }

    //found this on stack exchange, it adjusts contrast.
    public static Bitmap changeBitmapContrastBrightness(Bitmap bmp, float contrast, float brightness)
    {

        ColorMatrix cm = new ColorMatrix(new float[]
                {
                        contrast, 0, 0, 0, brightness,
                        0, contrast, 0, 0, brightness,
                        0, 0, contrast, 0, brightness,
                        0, 0, 0, 1, 0
                });

        Bitmap ret = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());

        Canvas canvas = new Canvas(ret);

        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(cm));
        canvas.drawBitmap(bmp, 0, 0, paint);

        return ret;


    }
     //distorts the image by widening/heightening
    static Bitmap widenImage(Bitmap image, int amount1, int amount2){

        Bitmap Image = image;

        int width = amount1*Image.getWidth();
        int height = amount2*Image.getHeight();
        Image = Bitmap.createScaledBitmap(Image,width,height,false);

        return Image;
    }

}
