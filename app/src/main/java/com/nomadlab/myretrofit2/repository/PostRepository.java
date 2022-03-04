package com.nomadlab.myretrofit2.repository;

import com.nomadlab.myretrofit2.models.request.ReqPostDto;
import com.nomadlab.myretrofit2.models.response.ResponsePostDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostRepository {

    @GET("posts/{id}")
    Call<ResponsePostDto> post(@Path("id") int id);

    @GET("posts")
    Call<List<ResponsePostDto>> postList();

    // @FieldMap HashMap<String, Object>, @Field("userId") int userId 방식
    @POST("posts")
    Call<ResponsePostDto> createPost(@Body ReqPostDto reqPostDto);

    @PUT("posts/{postId}")
    Call<ResponsePostDto> updatePost(@Body ReqPostDto reqPostDto);

    @DELETE("posts/{postId}")
    Call<Void> deletePost(@Path("postId") int postId);

    // https://jsonplaceholder.typicode.com/posts?userId=1
    @FormUrlEncoded
    @GET("/posts")
    Call<List<ResponsePostDto>> searchByUserId(@Field("userId") int userId);

}
