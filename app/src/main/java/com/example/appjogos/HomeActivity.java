package com.example.appjogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appjogos.model.User;

public class HomeActivity extends AppCompatActivity {

    private TextView tvUser;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        user = (User) getIntent().getSerializableExtra("Users");
        tvUser = findViewById(R.id.tvUser);

        if (user != null) {
            tvUser.setText("Bem_Vindo " + user.getName());
        }
    }
}
