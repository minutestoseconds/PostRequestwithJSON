package com.learntodroid.postrequestwithjson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeleteMembersRepository {

    private static DeleteMembersRepository instance;

    private DeleteMembersService deleteMembersService;

    public static DeleteMembersRepository getInstance() {
        if (instance == null) {
            instance = new DeleteMembersRepository();
        }
        return instance;
    }

    public DeleteMembersRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-melba-baas-2e2f9.cloudfunctions.net/app/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        deleteMembersService = retrofit.create(DeleteMembersService.class);
    }

    public DeleteMembersService getDeleteMembersService() {
        return deleteMembersService;
    }
}
