package banany.retrovi;

import android.content.res.Resources;
import android.util.Base64;
import android.util.Pair;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kamil on 28.02.16.
 */
public class JSONCollection {
    public static Pair<String, byte[]> loadJSONFromFile(Resources resources) {
        JSONParser jsonParser = new JSONParser();
        Pair<String, byte[]> json;
        try {
            InputStream inputStream = resources.openRawResource(R.raw.przykladowy);
            Object object = jsonParser.parse(new InputStreamReader(inputStream));
            JSONObject jsonObject = (JSONObject) object;

            String description = (String) jsonObject.get("description");
            byte[] img_base64 = Base64.decode((String) jsonObject.get("img_base64"), Base64.DEFAULT);
            json = new Pair<>(description, img_base64);
        } catch (Exception ex) {
            json = new Pair<>("wyjatek", Base64.decode("asd", Base64.DEFAULT));
        }
        return json;
    }


}
