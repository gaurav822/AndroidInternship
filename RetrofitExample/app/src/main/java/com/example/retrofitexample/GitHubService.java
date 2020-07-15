package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/{username}/repos")

     Call<List<Pojo>> getRepos(@Path("username") String username);

}
