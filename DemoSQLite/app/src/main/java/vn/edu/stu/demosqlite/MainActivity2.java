package vn.edu.stu.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import model.SinhVien;

public class MainActivity2 extends AppCompatActivity {
    Button btnLuu;
    EditText etTen, etLop, etMa;
    String DB_NAME = "dbsinhvien.sqlite", DB_PATH_SUFFIX = "/databases/";
    SinhVien sv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("SINHVIEN")){
            sv = (SinhVien) intent.getSerializableExtra("SINHVIEN");
            if (sv != null){
                etMa.setText(sv.getMa() + "");
                etTen.setText(sv.getTen());
                etLop.setText(sv.getLop());
            }
        }
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLuu();
            }
        });
    }

    private void xuLyLuu() {

        String ten = etTen.getText().toString();
        String lop = etLop.getText().toString();
        if (sv == null) {
            SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            ContentValues row = new ContentValues();
            row.put("ten", ten);
            row.put("lop", lop);

            long newID = database.insert(
                    "sinhvien",
                    null,
                    row
            );
            database.close();

            Toast.makeText(
                    this,
                    "Da them sinh vien ca ma: " + newID,
                    Toast.LENGTH_LONG
            ).show();
        } else {
        SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        ContentValues row = new ContentValues();
        row.put("ten", ten);
        row.put("lop",lop);
        int count = database.update(
                "sinhvien",
                row,
                "ma = ?",
                new String[]{sv.getMa()+ ""}
        );
        Toast.makeText(this,"Da cap nhat " + count + " dong",Toast.LENGTH_LONG).show();
        }
        finish();
    }

    private void addControls() {
        btnLuu = findViewById(R.id.btnLuu);
        etTen = findViewById(R.id.etTen);
        etLop = findViewById(R.id.etLop);
        etMa = findViewById(R.id.etMa);
    }
}