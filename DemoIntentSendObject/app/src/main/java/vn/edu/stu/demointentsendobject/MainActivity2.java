package vn.edu.stu.demointentsendobject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import model.SinhVien;

public class MainActivity2 extends AppCompatActivity {
    TextView tvSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControl();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("SINH_VIEN")){
            SinhVien sv = (SinhVien) intent.getSerializableExtra("SINH_VIEN");
            tvSV.setText(sv.toString());
        }
    }

    private void addControl() {
        tvSV = findViewById(R.id.tvSV);
    }
}