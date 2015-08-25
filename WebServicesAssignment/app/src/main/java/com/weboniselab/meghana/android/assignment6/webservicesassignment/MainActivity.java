package com.weboniselab.meghana.android.assignment6.webservicesassignment;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ListView listView;
    InputStream inputStream;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;
    HttpURLConnection httpURLConnection;
    URL url;
    String list[];
    List<String> items;
    ArrayAdapter<String> itemsAdapter;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsyncTaskOperations asyncTaskOperations=new AsyncTaskOperations();
        asyncTaskOperations.execute(Constants.SERVER_URL);
        items = new ArrayList<>();
    }
    class AsyncTaskOperations extends AsyncTask<String, String, List> {
        @Override
        protected List doInBackground(String... urls) {

            try {
                connectToApi(urls);
                inputStream=httpURLConnection.getInputStream();
                bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                stringBuilder=new StringBuilder();
                while ((result=bufferedReader.readLine())!=null){
                    stringBuilder.append(result);
                }
                result=stringBuilder.toString();
                inputStream.close();
            }catch (Exception e){
                Log.e("Error: ", e.getMessage());
            }
            return parseJsonObject(result);
        }
        public void connectToApi(String[] urls){
            try {
                url = new URL(urls[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                httpURLConnection.setRequestMethod("GET");
            }catch (Exception e){
                Log.e("Error: ", e.getMessage());
            }
        }
        public List parseJsonObject(String result){
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("contacts");
                list=new String[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject=jsonArray.getJSONObject(i);
                    items.add(jsonObject.getString("name"));
                }
            }catch (Exception e){
                Log.e("Error:", e.getMessage());
            }
            return items;
        }
      @Override
        protected void onPostExecute(List list) {
          listView = (ListView) findViewById(R.id.listView);
          itemsAdapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
          listView.setAdapter(itemsAdapter);

        }
    }
}
