package com.nomadlab.myretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nomadlab.myretrofit2.models.request.ReqPostDto;
import com.nomadlab.myretrofit2.models.response.ResponsePostDto;
import com.nomadlab.myretrofit2.service.JPHService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubActivity extends AppCompatActivity {

    JPHService jphService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        initData();
        // 버튼 4개 생성 호출해서 결과값 확인해 보기
    }

    private void initData() {
        jphService = JPHService.retrofit.create(JPHService.class);
    }



    private void testCode() {
        jphService.post(10).enqueue(new Callback<ResponsePostDto>() {
            @Override
            public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {

            }

            @Override
            public void onFailure(Call<ResponsePostDto> call, Throwable t) {

            }
        });


        jphService.createPost(new ReqPostDto("Title", "body", 1)).enqueue(new Callback<ResponsePostDto>() {
            @Override
            public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {

            }

            @Override
            public void onFailure(Call<ResponsePostDto> call, Throwable t) {

            }
        });


        jphService.deletePost(10).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });


        jphService.updatePost(new ReqPostDto("123", "aa", 1)).enqueue(new Callback<ResponsePostDto>() {
            @Override
            public void onResponse(Call<ResponsePostDto> call, Response<ResponsePostDto> response) {

            }

            @Override
            public void onFailure(Call<ResponsePostDto> call, Throwable t) {

            }
        });
    }

}