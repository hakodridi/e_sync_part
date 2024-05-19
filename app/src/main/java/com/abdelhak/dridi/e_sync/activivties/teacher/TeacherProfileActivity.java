package com.abdelhak.dridi.e_sync.activivties.teacher;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.abdelhak.dridi.e_sync.R;

public class TeacherProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.menu_home_btn).setOnClickListener(v->{
            startActivity(new Intent(TeacherProfileActivity.this, TeacherHomeActivity.class));
        });

        findViewById(R.id.menu_time_table_btn).setOnClickListener(v->{
            startActivity(new Intent(TeacherProfileActivity.this, TeacherTimeTableActivity.class));
        });
    }
}