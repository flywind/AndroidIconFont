package com.uxdpen.library.iconfont;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
/**
 * Created by Flywind on 2017/12/28.
 * http://www.uxdpen.com
 */

public class IconFont{

    /* Root Directory. src/main/assets/fonts/ */
    private static final String ROOT = "fonts/";

    private static String FILE_NAME = "iconfont.ttf";

    /* FontAwesome font file name */
    private static final String FONT_AWESOME = ROOT + FILE_NAME;

    /* Cache Font asset to avoid extra memory head */
    private static final Hashtable<String, Typeface> cache = new Hashtable<>();


    /**
     * @param context context passed
     * @return returns TypeFace object from cache
     */
    /* Returns FontAwesome TypeFace */
    public static Typeface getTypeface(Context context) {
        synchronized (cache) {
            if (!cache.containsKey(FONT_AWESOME)) {
                cache.put(FONT_AWESOME, processFontFromRaw(context));
            }else {
                Log.i(IconFont.class.getSimpleName(),"Loading typeface from cache");
            }
            return cache.get(FONT_AWESOME);
        }
    }

    private static Typeface processFontFromRaw(Context context) {
        Typeface typeface = null;
        InputStream inputStream = null;

        String outPath = context.getCacheDir() + "/tmp" + System.currentTimeMillis() + ".raw";

        try {
            inputStream = context.getResources().openRawResource(R.raw.iconfont);
        } catch (Resources.NotFoundException ignored) {
        }

        try {
            assert inputStream != null;
            byte[] buffer = new byte[inputStream.available()];
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(outPath));
            int num;
            while ((num = inputStream.read(buffer)) > 0) {
                stream.write(buffer, 0, num);
            }
            stream.close();
            typeface = Typeface.createFromFile(outPath);
            if (new File(outPath).delete()){
                Log.i(IconFont.class.getSimpleName(),"Deleted " + outPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return typeface;
    }
}
