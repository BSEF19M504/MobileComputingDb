package com.mobilecomputingdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonViewAll;
    EditText editName, editRollNumber;
    Switch switchIsActive;
    ListView listViewStudent;
    List<Student> list;
    StudentAdapter arrayAdapter;
    boolean isLoaded;

    @Override
    protected void onPostResume() {
        super.onPostResume();
        listViewStudent.setAdapter(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        editName = findViewById(R.id.editTextName);
        editRollNumber = findViewById(R.id.editTextRollNumber);
        switchIsActive = findViewById(R.id.switchStudent);
        listViewStudent = findViewById(R.id.listViewStudent);
        isLoaded = false;

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            Student studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                    editName.setText("");
                    editRollNumber.setText("");
                    switchIsActive.setChecked(false);
                    StudentDAO dbHelper  = new StudentDAO(MainActivity.this);
                    dbHelper.addStudent(studentModel);
                    if(isLoaded) {
                        list = dbHelper.getAllStudents();
                        arrayAdapter = new StudentAdapter
                                (MainActivity.this, android.R.layout.simple_list_item_1,list);
                        listViewStudent.setAdapter(arrayAdapter);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLoaded = true;
                StudentDAO dbHelper = new StudentDAO(MainActivity.this);
                list = dbHelper.getAllStudents();
                arrayAdapter = new StudentAdapter
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                listViewStudent.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();

            }
        });
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, UpdateDeleteActivity.class);
                intent.putExtra("StudentData",list.get(i).getId());
                startActivity(intent);
            }
        });

    }

}