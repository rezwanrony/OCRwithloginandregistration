package com.example.azer.ocrwithloginandregistration.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.azer.ocrwithloginandregistration.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText et_email, et_password;
    ProgressDialog progressDialog;
    FirebaseAuth authentication;
    Button btnSignup, btnLogin, btnReset;
    String email,fullname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        authentication = FirebaseAuth.getInstance();
btnSignup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,SignupActivity.class));
    }
});

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ResetPasswordActivity.class));
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String login_email=et_email.getText().toString();
                final String password=et_password.getText().toString();

                if (TextUtils.isEmpty(login_email)){

                    Toast.makeText(getApplicationContext(),"Enter email address!",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){

                    Toast.makeText(getApplicationContext(),"Enter password!",Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.setMessage("Logging in Please Wait...");
                progressDialog.show();

                authentication.signInWithEmailAndPassword(login_email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(!task.isSuccessful()){

                                Toast.makeText(MainActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();


                        }

                        else {
                            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                            intent.putExtra("email",login_email);
                            startActivity(intent);
                        }

                        progressDialog.dismiss();
                    }
                });
            }
        });

    }

    private void initialize() {
        et_email= (EditText) findViewById(R.id.email);
        et_password = (EditText) findViewById(R.id.password);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        progressDialog = new ProgressDialog(this);
    }
}
