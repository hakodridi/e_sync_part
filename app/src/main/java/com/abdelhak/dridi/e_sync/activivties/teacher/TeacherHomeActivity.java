package com.abdelhak.dridi.e_sync.activivties.teacher;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.abdelhak.dridi.e_sync.R;

public class TeacherHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.menu_profile_btn).setOnClickListener(v->{
            startActivity(new Intent(TeacherHomeActivity.this, TeacherProfileActivity.class));
        });

        findViewById(R.id.menu_time_table_btn).setOnClickListener(v->{
            startActivity(new Intent(TeacherHomeActivity.this, TeacherTimeTableActivity.class));
        });
    }
}