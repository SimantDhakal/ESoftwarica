package com.simant.esoftwarica;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txtName, txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        imageView = findViewById(R.id.profile);
//        txtAddress = findViewById(R.id.address);
//        txtName = findViewById(R.id.name);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            imageView.setImageResource(bundle.getInt("profile"));
            txtName.setText(bundle.getString("name"));
            txtAddress.setText(bundle.getString("address"));
        }
    }
}
