package com.mobilecomputingdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateDeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        Intent intent = getIntent();
        int index = intent.getIntExtra("StudentData",-1);
        if(index == -1)
            finish();
        StudentDAO studentDAO = new StudentDAO(getApplicationContext());

        Student student = studentDAO.getStudentById(index);

        EditText editText1 = findViewById(R.id.editTextTextPersonName);
        editText1.setText(student.getName());
        EditText editText2 = findViewById(R.id.editTextTextPersonName2);
        String roll = Integer.toString(student.getRollNumber());
        editText2.setText(roll);
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setChecked(student.isEnroll());

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            Student studentModel;

            @Override
            public void onClick(View view) {
                studentModel = new Student(student.getId(),editText1.getText().toString(), Integer.parseInt(editText2.getText().toString()), switch1.isChecked());
                editText1.setText("");
                editText1.setText("");
                switch1.setChecked(false);
                StudentDAO dbHelper  = new StudentDAO(getApplicationContext());
                dbHelper.updateStudent(studentModel);
                finish();
            }
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentDAO dbHelper  = new StudentDAO(getApplicationContext());
                dbHelper.deleteStudent(student.getId());
                finish();
            }
        });

    }
}