package banany.retrovi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;

import static android.widget.Toast.makeText;
/**
 * Created by kamil on 27.02.16.
 */


public class JSONScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_screen);
        Pair<String, byte[]> json = JSONCollection.loadJSONFromFile(getResources());
        String description;
        byte[] img_base64;
        description = json.first;
        img_base64 = json.second;
        try {
            makeText(this, description
                    , Toast.LENGTH_LONG).show();
            ImageView image = (ImageView) findViewById(R.id.poka);
            Bitmap bMap = BitmapFactory.decodeByteArray(img_base64, 0, img_base64.length);
            image.setImageBitmap(bMap);
            //image.setImageResource(R.drawable.index);
        } catch(Exception ex) {
            makeText(this, "nie wyszlo"
                    , Toast.LENGTH_LONG).show();
            return;
        }
    }
}
