package banany.retrovi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by kamil on 28.02.16.
 */


public class JSONCollection {
    private static Type type = new TypeToken<Map<String, String>>() {
    }.getType();

    public static Map<String, String> mapFromJSON(Resources resources) {
        Gson gson = new Gson();

        DownloadTask dlTask = new DownloadTask();
        dlTask.execute();

        Log.d("debug", " nie udalo sie");
        InputStream inputStream = resources.openRawResource(R.raw.przykladowy);
        return gson.fromJson(new InputStreamReader(inputStream), type);


    }
    public static String JSONFromMap(Context context, Map<String, String> stringStringMap) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(stringStringMap, type);
    }

    public static String ImageViewToString(ImageView imageView) {
        imageView.setDrawingCacheEnabled(true);
        imageView.measure(ImageView.MeasureSpec.makeMeasureSpec(0, ImageView.MeasureSpec.UNSPECIFIED),
                ImageView.MeasureSpec.makeMeasureSpec(0, ImageView.MeasureSpec.UNSPECIFIED));
        imageView.layout(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
        imageView.buildDrawingCache();

        Bitmap bitmap = Bitmap.createBitmap(imageView.getDrawingCache());
        imageView.setDrawingCacheEnabled(false); //


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();

        return Base64.encodeToString(b, Base64.DEFAULT);
    }
}