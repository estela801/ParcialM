package com.example.thesalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mainMenu extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);
        userName=findViewById(R.id.txtvUserName);

        //FIrebase
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser= mAuth.getCurrentUser();
        userName.setText(currentUser.getDisplayName());
    }

    //go to addDate1
    public void addDate(View view) {
        Intent intent = new Intent(this, addDate1.class);
        startActivity(intent);
        finish();
    }

    public void seeReports(View view) {
        Intent intent = new Intent(this, lastServices.class);
        startActivity(intent);
        finish();
    }

    public void goCatalogue(View view) {
        Intent intent = new Intent(this, catalogue.class);
        startActivity(intent);
        finish();
    }
}