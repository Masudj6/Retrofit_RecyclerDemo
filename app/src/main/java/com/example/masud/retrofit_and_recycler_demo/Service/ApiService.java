package com.example.masud.retrofit_and_recycler_demo.Service;

import com.example.masud.retrofit_and_recycler_demo.model.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("retrofit/json_object.json")
    Call<EmployeeList>getMyJSON();
}
