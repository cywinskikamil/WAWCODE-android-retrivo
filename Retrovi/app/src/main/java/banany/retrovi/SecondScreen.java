package banany.retrovi;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

/**
 * Created by kamil on 27.02.16.
 */
public class SecondScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        makeText(this, "Photo not saved\n"
                + getIntent().getPackage()
                , Toast.LENGTH_LONG).show();

        Uri uri = Uri.parse(getIntent().getPackage());
        ImageView image;
        image = (ImageView) findViewById(R.id.imageView1);
        image.setImageURI(uri);
    }
}
