package com.example.masud.retrofit_and_recycler_demo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.masud.retrofit_and_recycler_demo.Service.ApiService;
import com.example.masud.retrofit_and_recycler_demo.model.Employee;
import com.example.masud.retrofit_and_recycler_demo.model.EmployeeList;
import com.example.masud.retrofit_and_recycler_demo.network.APIClient;
import com.example.masud.retrofit_and_recycler_demo.viewHolder.EmployeeAdapter;
import com.example.masud.retrofit_and_recycler_demo.viewHolder.ProgramingAdapter;
import com.example.masud.retrofit_and_recycler_demo.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    //private static final String URL = "http://api.androiddeft.com/retrofit/json_object.json";

    RecyclerView recyclerView;
    private ProgressDialog pDialog;
    boolean connected = false;
    private ArrayList<Employee> employeeList;
    private EmployeeAdapter eAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.programing_list);

        //Creating an object of our api interface
        ApiService api=APIClient.getApiService();



         //check internet connection ...........................................................
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            /**
             * Calling JSON
             */
            Call<EmployeeList> call = api.getMyJSON();
            //progresss dialoge ..........................
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Loading Data.. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();

            /**
             * Enqueue Callback will be call when get response...
             */
            call.enqueue(new Callback<EmployeeList>() {
                @Override
                public void onResponse(Call<EmployeeList> call, retrofit2.Response<EmployeeList> response) {


                    if(response.isSuccessful()){
                        pDialog.dismiss();
                        /**
                         * Got Successfully
                         */
                        employeeList= (ArrayList<Employee>) response.body().getEmployee();
                        eAdapter=new EmployeeAdapter(employeeList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(eAdapter);
                    }

                }

                @Override
                public void onFailure(Call<EmployeeList> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "no data found", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "pls connect this internet", Toast.LENGTH_LONG).show();
            connected = false;
        }




























       /* String data[]={"c","c++","java","python","php","dart","dotnet"};
        recyclerView.setAdapter(new ProgramingAdapter(data));*/


        /*//check internet connection ...........................................................
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;


            RequestQueue queue = Volley.newRequestQueue(this);


            //progresss dialoge ..........................
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Loading Data.. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();


            StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    pDialog.dismiss();

                    Log.d("CODE", response);
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    User[] users = gson.fromJson(response, User[].class);
                    recyclerView.setAdapter(new ProgramingAdapter(MainActivity.this, users));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "no data found", Toast.LENGTH_SHORT).show();

                }
            });
            queue.add(request);


        } else {
            Toast.makeText(this, "pls connect this internet", Toast.LENGTH_LONG).show();
            connected = false;
        }*/
        //........................................................................................,.
















        /*//notification .............................
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        //google developer theke neya ........
        FirebaseMessaging.getInstance().subscribeToTopic("generel")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfull";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });*//*notification er jonno */


    }
}
