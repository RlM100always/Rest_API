package com.techtravelcoder.api.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.techtravelcoder.api.R;
import com.techtravelcoder.api.adapter.MyAdapter;
import com.techtravelcoder.api.api.APIClient;
import com.techtravelcoder.api.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private APIClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_recycler_view);

        recyclerView= findViewById(R.id.recyclerview_post_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        apiClient= retrofit.create(APIClient.class);
        Toast.makeText(this, "Bangladesh", Toast.LENGTH_SHORT).show();



        getPost();
    }

    private void getPost() {
        Call<List<Post>> call = apiClient.getPost(new int[]{2,3});
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), ""+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post> posts= response.body();
                adapter= new MyAdapter(posts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}