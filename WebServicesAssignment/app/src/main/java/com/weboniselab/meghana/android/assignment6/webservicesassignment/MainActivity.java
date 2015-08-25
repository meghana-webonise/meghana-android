package com.weboniselab.meghana.android.assignment6.webservicesassignment;

import android.app.Activity;
import android.net.Network;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.transform.ErrorListener;

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
    ContactsAdapter contactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* AsyncTaskOperations asyncTaskOperations=new AsyncTaskOperations();
        asyncTaskOperations.execute(Constants.SERVER_URL);*/
        items = new ArrayList<>();
        listView=(ListView) findViewById(R.id.listView);

        RequestQueue queue = Volley.newRequestQueue(this);
        final JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Constants.SERVER_URL,
                null,new Response.Listener<JSONObject> (){

            @Override
            public void onResponse(JSONObject response) {
                    Gson gson=new Gson();
                    ContactsResponse contactsResponse =gson.fromJson(response.toString(), ContactsResponse.class);
                    listView = (ListView) findViewById(R.id.listView);
                     List<Contacts> list1=contactsResponse.getContacts();
                     contactsAdapter=new ContactsAdapter(MainActivity.this,list1);
                     listView.setAdapter(contactsAdapter);

            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonObjectRequest);
    }


    /*class AsyncTaskOperations extends AsyncTask<String, String, List> {
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
    }*/


}
