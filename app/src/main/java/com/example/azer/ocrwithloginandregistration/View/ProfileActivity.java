package com.example.azer.ocrwithloginandregistration.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.azer.ocrwithloginandregistration.Database.DatabaseHelper;
import com.example.azer.ocrwithloginandregistration.Model.User;
import com.example.azer.ocrwithloginandregistration.R;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
TextView tv_welcome, tv_name,tv_email,tv_phoneno,tv_dob,tv_address;
    ArrayList<User>userArrayList;
    DatabaseHelper db;
    Button btn_editpro, btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initialize();
        String email=getIntent().getStringExtra("email");
        userArrayList=db.getData(email);
        Toast.makeText(getApplicationContext(),"size: "+userArrayList.size(),Toast.LENGTH_SHORT).show();
        tv_welcome.setText("Welcome ");
        tv_welcome.setTextColor(getColor(R.color.colorAccent));

        tv_name.setText(userArrayList.get(0).getName());
        tv_email.setText(userArrayList.get(0).getEmail());
        tv_phoneno.setText(userArrayList.get(0).getPhoneno());
        tv_dob.setText(userArrayList.get(0).getDateofbirth());
        tv_address.setText(userArrayList.get(0).getAddress());

        btn_editpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,EditProfileActivity.class));
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            }
        });
    }

    private void initialize() {
        db=new DatabaseHelper(ProfileActivity.this);
        userArrayList=new ArrayList<User>();
        tv_name=(TextView)findViewById(R.id.tv_name);
        tv_email=(TextView)findViewById(R.id.tv_email);
        tv_phoneno=(TextView)findViewById(R.id.tv_phone);
        tv_dob=(TextView)findViewById(R.id.tv_dob);
        tv_address=(TextView)findViewById(R.id.tv_address);
        tv_welcome=(TextView)findViewById(R.id.welcome);
        btn_editpro=(Button)findViewById(R.id.edit_profile);
        btn_logout=(Button)findViewById(R.id.signout);
    }
}
