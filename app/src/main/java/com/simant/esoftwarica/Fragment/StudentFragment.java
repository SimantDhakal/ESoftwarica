package com.simant.esoftwarica.Fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.simant.esoftwarica.Contacts;
import com.simant.esoftwarica.MainActivity;
import com.simant.esoftwarica.R;
import com.simant.esoftwarica.model.Student;

public class StudentFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,View.OnClickListener{

    private String fullname,gender,address,age;
    EditText editTextFullname, editTextAge, editTextAddress;
    RadioGroup radioGroup;
    RadioButton radioButtonMale, radioButtonFemale, radioButtonOther;
    Button buttonSave;

    public StudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student, container, false);

        editTextFullname = view.findViewById(R.id.etFullname);
        editTextAge = view.findViewById(R.id.etAge);
        editTextAddress = view.findViewById(R.id.etAddress);
        radioButtonMale = view.findViewById(R.id.rdoMale);
        radioButtonFemale = view.findViewById(R.id.rdoFemale);
        radioButtonOther = view.findViewById(R.id.rdoOthers);
        radioGroup=view.findViewById(R.id.rdoGroup);
        buttonSave = view.findViewById(R.id.btnSave);

        radioGroup.setOnCheckedChangeListener(this);
        buttonSave.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnSave)
        {
            fullname = editTextFullname.getText().toString();
            age=editTextAge.getText().toString();
            address=editTextAddress.getText().toString();
            if(validate())
            {
                MainActivity.studentListArray.add(new Student(fullname,gender,age,address));
                Toast.makeText(getContext(),"Student added", Toast.LENGTH_SHORT).show();


            }



        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i== R.id.rdoMale)
        {
            gender="Male";
        }
        if(i == R.id.rdoFemale)
        {
            gender = "Female";
        }
        if(i== R.id.rdoOthers)
        {
            gender ="Other";
        }
    }

    private boolean validate(){
        if(TextUtils.isEmpty(fullname))
        {
            editTextFullname.setError("Please enter a name");
            editTextFullname.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(age))
        {
            editTextAge.setError("Please enter age");
            editTextAge.requestFocus();
            return false;
        }

        if(!TextUtils.isDigitsOnly(age))
        {
            editTextAge.setError("Please enter age");
            editTextAge.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(address))
        {
            editTextAddress.setError("Please enter an address");
            editTextAddress.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(gender))
        {
            Toast.makeText(getContext(), "Please select a gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  true;
    }
}
