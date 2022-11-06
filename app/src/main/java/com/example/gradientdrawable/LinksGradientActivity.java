package com.example.gradientdrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LinksGradientActivity extends AppCompatActivity {

    private Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_gradient);

        this.testButton = findViewById(R.id.testButton);
        this.testButton.setOnClickListener(view ->
                this.startActivity(new Intent(this, SeekBackgroundActivity.class))
        );
    }
}