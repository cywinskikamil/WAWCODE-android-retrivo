package banany.retrovi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Pair;
import android.widget.Toast;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static android.widget.Toast.makeText;
/**
 * Created by kamil on 27.02.16.
 */


public class JSONScreen extends AppCompatActivity {
    private static Pair<String, byte[]> loadJSONFromFile() {
        JSONParser jsonParser = new JSONParser();
        Pair<String, byte[]> json;
        try {
            Object object = jsonParser.parse(new FileReader("/home/kamil/AndroidStudioProjects/WAWCODE-android-retrivo/przykladowy.json"));
            JSONObject jsonObject = (JSONObject) object;

            String description = (String) jsonObject.get("description");
            byte[] img_base64= Base64.decode((String) jsonObject.get("img_base64"), Base64.DEFAULT);
            json = new Pair<>(description, img_base64);
        } catch (Exception ex) {
            json = new Pair<>("asd", Base64.decode("asd", Base64.DEFAULT));
        }
        return json;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_screen);

        makeText(this, "JSONLAND\n"
                , Toast.LENGTH_LONG).show();
        Pair<String, byte[]> json = loadJSONFromFile();
        String description, in;
        byte[] img_base64;
        description = json.first;
        img_base64 = json.second;
        try {
            makeText(this, description
                    , Toast.LENGTH_LONG).show();
        } catch(Exception ex) {
            return;
        }
    }
}
