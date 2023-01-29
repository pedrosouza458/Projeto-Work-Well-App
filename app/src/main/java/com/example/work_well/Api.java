package com.example.work_well;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Api {
    String BASE_URL = "http://10.0.2.2/work-well/";
    @GET("api/user/tasks")
    Call<com.example.work_well.Results> getTasks(@Header("Email") String email, @Header("Password") String password);

}

