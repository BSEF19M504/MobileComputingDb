package com.mobilecomputingdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter{
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = (Student) getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.holder_item,null,true);

        TextView textView1 = convertView.findViewById(R.id.textView);
        textView1.setText(student.getName());
        TextView textView2 = convertView.findViewById(R.id.textView2);
        String roll = Integer.toString(student.getRollNumber());
        textView2.setText(roll);
        TextView textView3 = convertView.findViewById(R.id.textView3);
        String isEnrolled = student.isEnroll()?"Enrolled":"Not Enrolled";
        textView3.setText(isEnrolled);

        return convertView;
    }
}
