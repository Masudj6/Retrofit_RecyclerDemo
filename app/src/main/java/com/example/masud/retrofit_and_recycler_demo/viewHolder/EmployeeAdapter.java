package com.example.masud.retrofit_and_recycler_demo.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.masud.retrofit_and_recycler_demo.R;
import com.example.masud.retrofit_and_recycler_demo.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewholder> {

    private List<Employee> employees;

    public EmployeeAdapter(List<Employee> employees) {
        this.employees = employees;
    }


    @NonNull
    @Override
    public EmployeeViewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_list, parent, false);

        return new EmployeeViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewholder holder, int position) {
        Employee employee = employees.get(position);
        holder.employeeName.setText(employee.getName());
        holder.email.setText(employee.getEmail());
        holder.designation.setText(employee.getDesignation());
        holder.salary.setText(employee.getSalary());
        holder.dob.setText(employee.getDob());
        holder.contactNumber.setText(employee.getContactNumber());

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public  class EmployeeViewholder extends RecyclerView.ViewHolder {
        public TextView employeeName, designation, email, salary, dob,contactNumber;

        public EmployeeViewholder(@NonNull View view) {
            super(view);
            employeeName = (TextView) view.findViewById(R.id.employeeName);
            email = (TextView) view.findViewById(R.id.email);
            designation = (TextView) view.findViewById(R.id.designation);
            salary = (TextView) view.findViewById(R.id.salary);
            dob = (TextView) view.findViewById(R.id.dob);
            contactNumber = (TextView) view.findViewById(R.id.contactNumber);
        }
    }
}
