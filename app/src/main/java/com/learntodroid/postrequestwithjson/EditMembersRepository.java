package com.learntodroid.postrequestwithjson;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class EditMembersRepository {
    private static EditMembersRepository instance;

    private EditMembersService editMembersService;

    public static EditMembersRepository getInstance() {
        if (instance == null) {
            instance = new EditMembersRepository();
        }
        return instance;
    }

    public EditMembersRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-melba-baas-2e2f9.cloudfunctions.net/app/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        editMembersService = retrofit.create(EditMembersService.class);
    }

    public EditMembersService getEditMembersService() {
        return editMembersService;
    }
}
