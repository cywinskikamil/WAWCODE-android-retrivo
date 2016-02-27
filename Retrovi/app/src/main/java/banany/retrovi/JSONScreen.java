package banany.retrovi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static android.widget.Toast.makeText;

/**
 * Created by kamil on 27.02.16.
 */

public class JSONScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_screen);

        makeText(this, "JSONLAND\n"
                , Toast.LENGTH_LONG).show();
    }
}
