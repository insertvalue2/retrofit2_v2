package com.nomadlab.myretrofit2.interfaces;

import com.nomadlab.myretrofit2.models.response.ResponsePostDto;

import java.util.List;

public interface IPostObserver {

    void postBinding(ResponsePostDto postDto);

    void postListBinding(List<ResponsePostDto> list);



}
