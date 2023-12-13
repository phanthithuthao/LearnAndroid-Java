package vn.edu.stu.demointentsendobject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import model.SinhVien;

public class MainActivity extends AppCompatActivity {
    EditText etMaSV, etTenSV;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvent();
    }

    private void addControls() {
        etMaSV = findViewById(R.id.etMaSV);
        etTenSV = findViewById(R.id.etTenSV);
        btnSend = findViewById(R.id.btnSend);
    }

    private void addEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maSV = Integer.parseInt(etMaSV.getText().toString());
                String tenSV = etTenSV.getText().toString();
                SinhVien sv = new SinhVien(maSV,tenSV);

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("SINH_VIEN", sv);
                startActivity(intent );
            }

        });
    }
}