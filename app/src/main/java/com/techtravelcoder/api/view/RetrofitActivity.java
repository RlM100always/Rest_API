package com.techtravelcoder.api.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.techtravelcoder.api.R;
import com.techtravelcoder.api.model.Post;

public class RetrofitActivity extends AppCompatActivity {

    TextView getPost ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        getPost=findViewById(R.id.get_post);

        getPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PostRecyclerView.class);
                startActivity(intent);
            }
        });
    }
}