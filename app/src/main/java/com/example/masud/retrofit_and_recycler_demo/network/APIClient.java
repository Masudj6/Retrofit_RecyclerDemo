package com.example.masud.retrofit_and_recycler_demo.network;
import com.example.masud.retrofit_and_recycler_demo.Service.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    /********
     * URLS
     *******/
    private  static  final String BASE_URL="http://api.androiddeft.com/";


    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance(){
        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public  static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);
    }
}
