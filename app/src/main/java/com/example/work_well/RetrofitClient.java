package com.example.work_well;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private com.example.work_well.Api myApi;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(com.example.work_well.Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(com.example.work_well.Api.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public com.example.work_well.Api getMyApi() {
        return myApi;
    }
}
