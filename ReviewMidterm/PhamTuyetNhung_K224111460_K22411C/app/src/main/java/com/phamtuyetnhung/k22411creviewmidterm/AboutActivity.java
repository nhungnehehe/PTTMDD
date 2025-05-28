package com.phamtuyetnhung.k22411creviewmidterm;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutActivity extends AppCompatActivity {
    TextView txt_student_id;
    TextView txt_student_name;
    TextView txt_email;
    TextView txt_class;
    ImageView imgAvatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        txt_student_id = findViewById(R.id.txt_student_id);
        txt_student_name = findViewById(R.id.txt_student_name);
        txt_email = findViewById(R.id.txt_email);
        txt_class = findViewById(R.id.txt_class);
        imgAvatar = findViewById(R.id.imgAvatar);
    }
}