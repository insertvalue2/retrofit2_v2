package com.nomadlab.myretrofit2.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsePostDto {

    @SerializedName("userId")
    @Expose
    public int userId;

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("body")
    @Expose
    public String body;

    @Override
    public String toString() {
        return "ResponsePostDto{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
