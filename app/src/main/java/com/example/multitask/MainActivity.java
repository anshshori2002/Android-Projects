package com.example.multitask;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b5;
    TextView t1,t2;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient gc;
    private static int RC_SIGN_IN=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText1);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button1);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView3);
        b5=(Button)findViewById(R.id.button5);
        firebaseAuth=FirebaseAuth.getInstance();
        SignInButton signInButton= findViewById(R.id.sign_in);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(MainActivity.this,Third.class);
                startActivity(i2);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this,Second.class);
                startActivity(i1);
                finish();
            }
        });
        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gc= GoogleSignIn.getClient(this,googleSignInOptions);
        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }
    private void signIn() {
        Intent signInIntent = gc.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Task<GoogleSignInAccount> googleSignIn=GoogleSignIn.getSignedInAccountFromIntent(data);
        GoogleSignInAccount google =googleSignIn.getResult();
        AuthCredential auth= GoogleAuthProvider.getCredential(google.getIdToken(),null);
        firebaseAuth.signInWithCredential(auth).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "SignIn Successful ", Toast.LENGTH_SHORT).show();
                    Intent j=new Intent(MainActivity.this,Third.class);
                    startActivity(j);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "SignIn Unsucessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}