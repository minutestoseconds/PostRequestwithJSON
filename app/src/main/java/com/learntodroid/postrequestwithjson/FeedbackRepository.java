package com.learntodroid.postrequestwithjson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class FeedbackRepository {
    private static FeedbackRepository instance;

    private FeedbackService feedbackService;

    public static FeedbackRepository getInstance() {
        if (instance == null) {
            instance = new FeedbackRepository();
        }
        return instance;
    }

    public FeedbackRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-melba-baas-2e2f9.cloudfunctions.net/app/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        feedbackService = retrofit.create(FeedbackService.class);
    }

    public FeedbackService getFeedbackService() {
        return feedbackService;
    }
}
