package banany.retrovi;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by kamil on 28.02.16.
 */
public class JSONCollection {
    public static Map <String, String> mapFromJSON (Resources resources) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        InputStream inputStream = resources.openRawResource(R.raw.przykladowy);
        return gson.fromJson(new InputStreamReader(inputStream), type);
    }
}
