package com.example.azer.ocrwithloginandregistration.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.azer.ocrwithloginandregistration.Database.DatabaseHelper;
import com.example.azer.ocrwithloginandregistration.Model.User;
import com.example.azer.ocrwithloginandregistration.R;

public class EditProfileActivity extends AppCompatActivity {
    DatabaseHelper db;
EditText et_name, et_email,et_phoneno,et_dateofbirth,et_address;
    Button save;
    RadioGroup gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        db= new DatabaseHelper(EditProfileActivity.this);
        initialize();


        final String name=et_name.getText().toString();
        final String email=et_email.getText().toString();
        final String phone=et_phoneno.getText().toString();
        final String address=et_address.getText().toString();
        final String dateofbirth=et_dateofbirth.getText().toString();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertInfo(new User(name,email,phone,dateofbirth,address));
                Toast.makeText(EditProfileActivity.this,"Information added successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initialize() {
        save=(Button)findViewById(R.id.save);
        et_name=(EditText)findViewById(R.id.epfullname);
        et_address=(EditText)findViewById(R.id.address);
        et_email=(EditText)findViewById(R.id.epemail);
        et_phoneno=(EditText)findViewById(R.id.phoneno);
        et_dateofbirth=(EditText)findViewById(R.id.birthday);
        gender=(RadioGroup)findViewById(R.id.radiogroup);
    }
}
