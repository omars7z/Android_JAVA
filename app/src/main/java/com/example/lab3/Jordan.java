package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RatingBar;

public class Jordan extends AppCompatActivity {

    RadioButton rb1, rb2, rb3, rb4;
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jordan);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb = findViewById(R.id.rb);

        rb.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> questionOne());
    }
    public void questionOne(){
//        if(){
            rb.setRating(2);
//        }else{

//        }
    }
}