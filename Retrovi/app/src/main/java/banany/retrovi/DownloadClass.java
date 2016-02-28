package banany.retrovi;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by kamil on 28.02.16.
 */
class DownloadTask extends AsyncTask<String, Void, String> {

    private static Type type = new TypeToken<Map<String, Object>>() {
    }.getType();

    protected String doInBackground(String ...img) {

//        Log.d("debug", "do wyslania ");
//        Gson gson = new Gson();
//        try {
//            URL url = new URL("http://167.114.120.35:5000/api/found/add");
//
//            HttpURLConnection client = (HttpURLConnection) url.openConnection();
//            JSONObject request = new JSONObject();
//            try {
//                request.put("category_id", 8);
//                request.put("control_question", "a");
//                request.put("description", "a");
//                request.put("name", "a");
//                request.put("user_id", 20);
//                //request.put("photo" , img[0]);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            client.setDoOutput(true);
//            client.setDoInput(true);
//            client.setRequestProperty("Content-Type","application/json");
//
//            client.connect();
//            Log.d("doInBackground(Request)", request.toString());
//
//            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
//            String output = request.toString();
//            writer.write(output);
//            writer.flush();
//            writer.close();
//
//            StringBuilder sb = new StringBuilder();
//            int HttpResult = client.getResponseCode();
//            if(HttpResult == HttpURLConnection.HTTP_OK){
//                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(),"utf-8"));
//                String line = null;
//                while ((line = br.readLine()) != null) {
//                    sb.append(line + "\n");
//                }
//                br.close();
//                Log.d("debug", "kurczaki "+sb.toString());
//            } else {
//                Log.d("debug", "ad " + client.getResponseMessage());
//            }
//
////            String result = "Asdada";
////            Log.d("doInBackground(Resp)", result.toString());
//
//            client.disconnect();
//            return "dziala";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "nie dziala";
    }

    //This Method is called when Network-Request finished
    protected void onPostExecute(String serverData) {
        Log.d("debug", "dane " + serverData);
        return;
    }
}