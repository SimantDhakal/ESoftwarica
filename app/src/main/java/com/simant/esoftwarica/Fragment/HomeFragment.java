package com.simant.esoftwarica.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simant.esoftwarica.Contacts;
import com.simant.esoftwarica.ContactsAdapter;
import com.simant.esoftwarica.MainActivity;
import com.simant.esoftwarica.R;
import com.simant.esoftwarica.StudentAdapter;
import com.simant.esoftwarica.model.Student;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        if(MainActivity.studentListArray.isEmpty()) {
            MainActivity.studentListArray.add(new Student("Simant Dhakal", "Male", "23", "Balkot"));
            MainActivity.studentListArray.add(new Student("Adele Maria", "Female", "20", "California"));
            MainActivity.studentListArray.add(new Student("Saimon Branch", "Male", "26", "Siliconia"));

            StudentAdapter adapter = new StudentAdapter(MainActivity.studentListArray, getContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }else {
            StudentAdapter adapter2 = new StudentAdapter(MainActivity.studentListArray, getContext());
            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this.getContext());
            recyclerView.setLayoutManager(layoutManager2);
            recyclerView.setAdapter(adapter2);
        }
        return view;
    }

}
