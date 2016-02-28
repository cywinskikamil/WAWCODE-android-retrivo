package banany.retrovi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Map;

import static android.widget.Toast.makeText;
/**
 * Created by kamil on 27.02.16.
 */


public class JSONScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_screen);

        Map<String, String> myMap = JSONCollection.mapFromJSON(getResources());//
        String description = myMap.get("description");
        byte[] img_base64 = Base64.decode(myMap.get("img_base64"), Base64.DEFAULT);

        try {
            makeText(this, description
                    , Toast.LENGTH_LONG).show();
            ImageView image = (ImageView) findViewById(R.id.poka);
            Bitmap bMap = BitmapFactory.decodeByteArray(img_base64, 0, img_base64.length);
            image.setImageBitmap(bMap);
        } catch(Exception ex) {
            makeText(this, "nie wyszlo"
                    , Toast.LENGTH_LONG).show();
            return;
        }
        JSONCollection.JSONFromMap(getApplicationContext(), myMap);
    }
}
