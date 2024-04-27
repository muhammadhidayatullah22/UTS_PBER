package com.example.gituserapp.Ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.gituserapp.R;
import com.example.gituserapp.Retrofit.ApiConfig;
import com.example.gituserapp.Response.Items;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivProfile;
    private TextView tvUsername, tvBio, tvRepository, tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        ivProfile = findViewById(R.id.ivProfile);
        tvUsername = findViewById(R.id.tvUsername);
        tvName = findViewById(R.id.tvName);
        tvRepository = findViewById(R.id.tvRepository);
        tvBio = findViewById(R.id.tvBio);

        String username = getIntent().getStringExtra("username");

        Call<Items> call = ApiConfig.getApi().callDetailUser(username);
        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(@NonNull Call<Items> call, @NonNull Response<Items> response) {
                if (response.isSuccessful()){
                    Items items = response.body();
                    tvUsername.setText(items.getLogin());
                    tvName.setText(items.getName());
                    tvRepository.setText(items.getRepository());
                    tvBio.setText(items.getBio());
                    Glide.with(DetailActivity.this).load(items.getAvatarUrl()).into(ivProfile);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Items> call, @NonNull Throwable t) {
                Log.e("DetailActivity", t.toString());
            }
        });
    }
}
