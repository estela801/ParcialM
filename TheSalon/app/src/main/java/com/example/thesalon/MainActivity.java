package com.example.thesalon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtvAppName, txtvSlogan;
    ImageView imgvLogo;

    Animation bottomAnim;
    private static  int SPLASH_SCREEN = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtvAppName = findViewById(R.id.txtvAppName);
        txtvSlogan = findViewById(R.id.txtvSlogan);
        imgvLogo = findViewById(R.id.imgvLogo);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        txtvSlogan.setAnimation(bottomAnim);
        txtvAppName.setAnimation(bottomAnim);
        imgvLogo.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(imgvLogo, "logo_transition");
                pairs[1] = new Pair<View, String>(txtvAppName, "appName_transition");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                    finish();
                }else{
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_SCREEN);
    }


}