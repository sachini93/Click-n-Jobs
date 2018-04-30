package com.example.stp.findjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ApplyJob extends AppCompatActivity {
    DBHandeller DB;

    EditText txtName;
    EditText txtAge;
    EditText txtGender;
    EditText txtQualification;
    EditText txtEmail;
    Button button_back;
    Button button_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job);

        button_send=(Button)findViewById(R.id.button_send);
        button_back=(Button)findViewById(R.id.button_back);

        txtName=(EditText)findViewById(R.id.editText_name);
        txtAge=(EditText)findViewById(R.id.editText_age);
        txtGender=(EditText)findViewById(R.id.editText_gender);
        txtQualification=(EditText)findViewById(R.id.editText_qualification);
        txtEmail=(EditText)findViewById(R.id.editText_email);

        DB=new DBHandeller(this,"com.example.stp.findjob.Jobs.db",null,1);


    }

    public void onCancelClick(View view){
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ApplyJob.this, MainActivity.class);
                ApplyJob.this.startActivity(intent);
            }
        });

    }

    public void onSendClick(View view){
        //get form data and save candidate
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=txtName.getText().toString();
                String age=txtAge.getText().toString();
                String email=txtEmail.getText().toString();
                String gender=txtGender.getText().toString();
                String qualification=txtQualification.getText().toString();

                if(txtName.length()!=0&&txtAge.length()!=0&&txtEmail.length()!=0&&txtGender.length()!=0&&txtQualification.length()!=0){

                    Candidate candidate=new Candidate(name,age,email,gender,qualification);
                    boolean result=DB.addCandidates(candidate);

                    //reset values
                    txtName.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtGender.setText("");
                    txtQualification.setText("");

                    if(result){
                        Toast.makeText(ApplyJob.this,"Application Sent",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(ApplyJob.this,"Error occurred!",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(ApplyJob.this,"Please enter all fields!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
