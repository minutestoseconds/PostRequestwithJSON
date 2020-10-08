package com.learntodroid.postrequestwithjson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class SignUpRepository {
    private static SignUpRepository instance;

    private SignUpService signUpService;

    public static SignUpRepository getInstance() {
        if (instance == null) {
            instance = new SignUpRepository();
        }
        return instance;
    }

    public SignUpRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-melba-baas-2e2f9.cloudfunctions.net/app/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        signUpService = retrofit.create(SignUpService.class);
    }

    public SignUpService getSignUpService() {
        return signUpService;
    }
}
