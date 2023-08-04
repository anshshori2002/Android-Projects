package com.example.multitask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Third extends AppCompatActivity {
    ImageButton bu,i4,i5;
    ImageView image;
    FirebaseAuth fireauth;
    GoogleSignInClient google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        bu=(ImageButton) findViewById(R.id.bu);
        i4= (ImageButton) findViewById(R.id.imagebtn4);
        i5=(ImageButton) findViewById(R.id.imageBtn5);

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i1 = new Intent(Third.this,Fifth.class);
                startActivity(i1);
                finish();
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Third.this,Fourth.class);
                startActivity(intent);
                finish();
            }
        });

        fireauth=FirebaseAuth.getInstance();
        FirebaseUser fireUser =fireauth.getCurrentUser();
        if(fireUser!=null)
        {
            Glide.with(Third.this).load(fireUser.getPhotoUrl()).into(image);
        }
        google= GoogleSignIn.getClient(Third.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                google.signOut();
                fireauth.signOut();
            }
        });


    }
}