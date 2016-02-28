package banany.retrovi;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by kamil on 28.02.16.
 */


public class JSONCollection {
    private static TextView tv;

    private static Type type = new TypeToken<Map<String, String>>(){}.getType();

    public static Map <String, String> mapFromJSON (Resources resources) {
        Gson gson = new Gson();
        InputStream inputStream = resources.openRawResource(R.raw.przykladowy);
        return gson.fromJson(new InputStreamReader(inputStream), type);
    }

    public static void JSONFromMap(Context context, Map <String, String> stringStringMap){
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(stringStringMap, type);
        Log.d("a", json);
    }
}
