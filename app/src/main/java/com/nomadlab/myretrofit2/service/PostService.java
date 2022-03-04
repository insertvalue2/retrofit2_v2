package com.nomadlab.myretrofit2.service;

import android.util.Log;

import com.nomadlab.myretrofit2.interfaces.IPostObserver;
import com.nomadlab.myretrofit2.models.response.ResponsePostDto;
import com.nomadlab.myretrofit2.repository.PostRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostService  {

    private static final String TAG = PostService.class.getName();
    Retrofit retrofit;
    PostRepository repository;
    ResponsePostDto responsePostDto;
    IPostObserver iPostBinding;

    public void setIPostBinding(IPostObserver iPostBinding) {
        this.iPostBinding = iPostBinding;
    }

    public PostService() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        repository = retrofit.create(PostRepository.class);
    }


    public ResponsePostDto getPost(int id) {
        repository.post(id).enqueue(new Callback<ResponsePostDto>() {
            @Override
            public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {
               if (response.isSuccessful()) {
                   iPostBinding.postBinding(response.body());
                   Log.d(TAG, "responsePostDto : " + responsePostDto);
               } else {
                   Log.d(TAG, "status code : " + response.code());
               }
            }
            @Override
            public void onFailure(Call<ResponsePostDto> call, Throwable t) {
            }
        });

        return responsePostDto;
    }



}
