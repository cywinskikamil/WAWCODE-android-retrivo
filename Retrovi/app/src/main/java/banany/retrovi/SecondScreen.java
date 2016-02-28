package banany.retrovi;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by kamil on 27.02.16.
 */
public class SecondScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        Uri uri = Uri.parse(getIntent().getPackage());
        ImageView image;
        image = (ImageView) findViewById(R.id.imageView1);
        image.setImageURI(uri);
//        String img_base64 = JSONCollection.ImageViewToString(image);
//        DownloadTask dlTask = new DownloadTask();
//        dlTask.execute(img_base64);
    }
}
