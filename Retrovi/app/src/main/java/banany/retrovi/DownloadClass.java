package banany.retrovi;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by kamil on 28.02.16.
 */
class DownloadTask extends AsyncTask<String, Void, String> {

    private static Type type = new TypeToken<Map<String, Object>>() {
    }.getType();

    protected String doInBackground(String ...img) {

        Log.d("debug", "do wyslania ");
        Gson gson = new Gson();
        try {
            URL url = new URL("http://167.114.120.35:5000/api/found");

            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            JSONObject request = new JSONObject();
            try {
                request.put("category_id", 48);
                request.put("control_question", "A kolor?");
                request.put("description", "asdfOpis");
                request.put("name", "asdasd");
                request.put("photo" , "kamilos");//img[0]);
                request.put("user_id", 32);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestMethod("POST");
            client.connect();
            Log.d("doInBackground(Request)", request.toString());

            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            String output = request.toString();
            writer.write(output);
            writer.flush();
            writer.close();

            InputStream input = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//            StringBuilder result = new StringBuilder();
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                result.append(line);
//            }
            String result = "Asdada";
            Log.d("doInBackground(Resp)", result.toString());

            client.disconnect();
            return "dziala";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "nie dziala";
    }

    //This Method is called when Network-Request finished
    protected void onPostExecute(String serverData) {
        Log.d("debug", "dane " + serverData);
        return;
    }
}