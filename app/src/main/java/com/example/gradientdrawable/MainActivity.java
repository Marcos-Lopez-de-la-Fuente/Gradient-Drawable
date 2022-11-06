package com.example.gradientdrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button getAccessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getAccessButton = findViewById(R.id.get_access_btn);
        this.getAccessButton.setOnClickListener(view ->
                this.startActivity(new Intent(this, LinksGradientActivity.class))
        );
    }
}