package com.simant.esoftwarica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.simant.esoftwarica.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyHolder> {

    List<Student> stut_list = new ArrayList<>();
    Context contexts;

    public StudentAdapter(List<Student> stut_list, Context contexts) {
        this.stut_list = stut_list;
        this.contexts = contexts;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user, parent, false);
        MyHolder myholder = new MyHolder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        final Student stu = stut_list.get(position);

        holder.fullname.setText("Name: " + stu.getFullname());
        holder.age.setText("Age: " + stu.getAge());
        holder.address.setText("Address: " + stu.getAddress());
        holder.gender.setText("Gender: " + stu.getGender());
//        holder.delete.setImageResource(R.drawable.ic_delete);
        holder.imageview.setImageDrawable(contexts.getResources().getDrawable(R.drawable.delete));

        String gen = stu.getGender();

        if (gen == "Male") {
            holder.imageview.setImageResource(R.drawable.male);
        } else if (gen == "Female") {
            holder.imageview.setImageDrawable(contexts.getResources().getDrawable(R.drawable.female));
        } else {
            holder.imageview.setImageDrawable(contexts.getResources().getDrawable(R.drawable.female));
        }


        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexts, "Hey " + stu.getFullname(), Toast.LENGTH_SHORT).show();
            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student studen = stut_list.get(position);

                // Remove the item on remove/button click
                stut_list.remove(position);

                notifyItemRemoved(position);

                notifyItemRangeChanged(position, stut_list.size());

                // Show the removed item label
                Toast.makeText(contexts, "Removed : " + studen.getFullname(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return stut_list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageview, delete;
        TextView fullname, age, address, gender;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.stimage);
            fullname = itemView.findViewById(R.id.stfullname);
            age = itemView.findViewById(R.id.st_age);
            address = itemView.findViewById(R.id.staddress);
            gender = itemView.findViewById(R.id.stgender);
            delete = itemView.findViewById(R.id.stdelete);

        }
    }
}
