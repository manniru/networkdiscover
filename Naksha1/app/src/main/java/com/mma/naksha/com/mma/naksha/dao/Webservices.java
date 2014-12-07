package com.mma.naksha.com.mma.naksha.dao;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mannir on 06/12/2014.
 */
public class Webservices {

    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        protected void onPostExecute(String result) {
            ///Toast.makeText(getBaseContext(), "Sent to Server!", Toast.LENGTH_LONG).show();
            // Gson gson = new Gson();
            Log.d("m3", result);
            //String rt = result.substring(4);
            //  User user2 = gson.fromJson(result, User.class);


            /// amounttv.setText("Amount: "+ user2.getAmount());


            ///tts = new TextToSpeech(ctx, null);
            ///tts.speak(user2.getUsername()+"Thank you for using Jibril NFC", TextToSpeech.QUEUE_FLUSH, null);

            //ttobj.speak("Thank you for using Jibril Mobile NFC", TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void post(String url) {


        // \n is for new line
        ///Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + lat + "\nLong: " + lon, Toast.LENGTH_LONG).show();
        //Log.d("m1", "onClick"+"lat="+latitude+", lon="+longitude);


        // if(phone.equals("")) phone = "60142178326";
        // serverip = serveriptxt.getText().toString();
        // http://localhost:8080/marwaserver/json.jsp?q=hello
        /// String url = server+"?q=track&mobileno="+phone+"&lat="+lat+"&lon="+lon;
        // if(serverip.equals("192.168.0.5")) url = "http://"+serverip+":8080/nfc/json.jsp?mobileno="+phone+"&tagid="+tagid;
        Log.d("url=", url);
       /// Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();
        new HttpAsyncTask().execute(url);

    }
}
