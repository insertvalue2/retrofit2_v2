package com.nomadlab.myretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.nomadlab.myretrofit2.interfaces.IPostObserver;
import com.nomadlab.myretrofit2.models.response.ResponsePostDto;
import com.nomadlab.myretrofit2.service.PostService;

import java.util.List;

/**
 * service 객체 + Object Patten 사용 로직
 */
public class MainActivity extends AppCompatActivity implements IPostObserver {

    private PostService postService;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        requestPostById();
    }

    private void requestPostById() {
        postService.getPost(10);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initData() {
        titleTextView = findViewById(R.id.titleTextView);
        postService = new PostService();
        postService.setIPostBinding(this);
    }


    /**
     * 응답 callback
     * @param postDto
     */
    @Override
    public void postBinding(ResponsePostDto postDto) {
        // 테이터 넘어 옴
        titleTextView.setText(postDto.title);
    }

    /**
     * 응답 callback
     * @param list
     */
    @Override
    public void postListBinding(List<ResponsePostDto> list) {
        // 리싸이클러 뷰 바인딩
        Log.d("TAG", list.toString());
    }

}