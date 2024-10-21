package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextStudentId, editTextFullName;
    private Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextStudentId = findViewById(R.id.editText);
        editTextFullName = findViewById(R.id.editText2);
        buttonSave = findViewById(R.id.buttonSave);

        // Tải thông tin đã lưu (nếu có)
        loadPreferences();

        buttonSave.setOnClickListener(v -> savePreferences());
    }

    private void savePreferences() {
        String studentId = editTextStudentId.getText().toString();
        String fullName = editTextFullName.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("student_id", studentId);
        editor.putString("full_name", fullName);

        editor.apply(); // Lưu không đồng bộ

        Toast.makeText(this, "Thông tin đã được lưu!", Toast.LENGTH_SHORT).show();
    }

    private void loadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        String studentId = sharedPreferences.getString("student_id", "");
        String fullName = sharedPreferences.getString("full_name", "");

        editTextStudentId.setText(studentId);
        editTextFullName.setText(fullName);
    }
}