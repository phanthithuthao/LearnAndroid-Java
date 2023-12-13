package vn.edu.stu.phanthithuthao_dh52003760;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.SinhVien;

public class MainActivity2 extends AppCompatActivity {
    Button btnLuu;
    EditText etTenSV,etNS;
    ImageButton btnDatePicker;
    CheckBox cbAn, cbNgu;
    final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
    }

    private void addControls() {
        etTenSV = findViewById(R.id.etTenSV);
        etNS = findViewById(R.id.etNS);
        btnLuu = findViewById(R.id.btnLuu);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        cbAn = findViewById(R.id.cbAn);
        cbNgu = findViewById(R.id.cbNgu);
    }

    private void addEvents() {
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChonNgay();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xuLyLuu();
            }
        });
    }

    private void xuLyChonNgay() {
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd,yyyy");
                etNS.setText(simpleDateFormat.format(calendar.getTime()));
            }
        } ,nam,thang,ngay);
        datePickerDialog.show();
    }

//    private void xuLyLuu() {
//        SinhVien sv = new SinhVien();
//        sv.setTen(etTenSV.getText().toString());
//        sv.setNgaySinh(calendar.getTime());
//
//    }
}