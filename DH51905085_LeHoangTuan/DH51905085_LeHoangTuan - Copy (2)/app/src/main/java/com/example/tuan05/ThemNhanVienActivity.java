package com.example.tuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tuan05.Dao.DaoPhong;
import com.example.tuan05.Util.Appdatabase;
import com.example.tuan05.Util.Appdatabasephong;
import com.example.tuan05.Util.DBUtil;

import java.util.ArrayList;
import java.util.Calendar;

import Entity.NhanVien;
import Entity.Phong;


public class ThemNhanVienActivity extends AppCompatActivity {
    EditText txtTen,txtID,txtMaPhong;
//    TextView txtNgay;
    ImageButton btnDatePicker;
    //CheckBox ckcAn,ckcNgu;
    Button btnLuu,btnChange;
//    Calendar calendar;
    NhanVien chon;
    RadioButton radNam,radNu;
    Spinner MaPhong;
    Appdatabase database;
    ArrayAdapter<Phong> adapterphong;
    ArrayList<Phong> dsphong;
    Appdatabasephong appdatabasephong;
    int resultCode=115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_them_sua_nhanvien);
        DBUtil.copyDatabaseFromAssets(ThemNhanVienActivity.this);
        addControl();
        getIntentData();
        addEvents();
    }

    private void addEvents() {


    btnLuu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            xuLyLuu();
        }
    });
    btnChange.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            xulyThayThe();
        }
    });
    }

    private void xulyThayThe() {
        if(chon==null){
            chon= new NhanVien();

        }
        chon.setMa(Integer.parseInt(txtID.getText().toString()));
        chon.setTen(txtTen.getText().toString());
        //chon.setBirthDay(calendar.getTime());
        if(radNam.isChecked()){
            chon.setPhai(1);
        }
        else{
            chon.setPhai(0);
        }
        chon.setMaPhong((txtMaPhong.getText().toString()));
        Intent intent=getIntent();
        intent.putExtra("Sua",chon);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    private void xuLyLuu() {
        if(chon==null){
            chon= new NhanVien();

        }
        //chon.setMa(Integer.parseInt(txtID.getText().toString()));
        chon.setTen(txtTen.getText().toString());
        //chon.setBirthDay(calendar.getTime());
       if(radNam.isChecked()){
            chon.setPhai(1);
       }
       else{
           chon.setPhai(0);
       }
        chon.setMaPhong((txtMaPhong.getText().toString()));
        Intent intent=getIntent();
        intent.putExtra("Them",chon);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }





    private void getIntentData() {
        Intent intent = getIntent();
        if (intent.hasExtra("CHON")){
            chon = (NhanVien) intent.getSerializableExtra("CHON");
            if(chon!=null){
                txtTen.setText(chon.getTen());
                txtID.setText(chon.getMa()+"");
                txtMaPhong.setText(chon.getMaPhong()+"");
                int phai =chon.getPhai();
                if (phai==1){
                    radNam.setChecked(true);
                }
                else{
                    radNu.setChecked(true);
                }

                //calendar.setTime(chon.getBirthDay());
//                txtNgay.setText(FormatUtil.formatDate(calendar.getTime()));
//                ckcAn.setChecked(chon.isAn());
//                ckcNgu.setChecked(chon.isNgu());
                btnChange.setVisibility(View.VISIBLE);
                btnLuu.setVisibility(View.GONE);
                txtTen.setEnabled(true);

            }else{
                resetView();
            }

        }else{
            resetView();
        }
    }

    private void resetView() {
    txtTen.setText("");
    radNam.setChecked(true);
    chon=null;
    btnChange.setVisibility(View.GONE);
    btnLuu.setVisibility(View.VISIBLE);
    txtTen.setEnabled(true);
    }

    private void addControl() {
        appdatabasephong = Appdatabasephong.getAppDatabase(this);
        database=Appdatabase.getAppDatabase(this);
        txtTen = findViewById(R.id.txtTen);
        txtID = findViewById(R.id.txtID);
        txtID.setEnabled(false);
        radNam=findViewById(R.id.radNam);
        radNu=findViewById(R.id.radNu);
        MaPhong= findViewById(R.id.spinerMaPhong);
        dsphong = new ArrayList<>();
        ArrayList<NhanVien> dsnv= new ArrayList<>();
        dsnv.addAll(database.daoNhanVien().getAll());
        //dsphong.addAll(appdatabasephong.daoPhong().getAllPhong());
        adapterphong= new ArrayAdapter<>(ThemNhanVienActivity.this, android.R.layout.simple_spinner_item,dsphong);
        MaPhong.setAdapter(adapterphong);
        txtMaPhong=findViewById(R.id.txtMaPhong);
        btnLuu=findViewById(R.id.btnLuu);
        //calendar=Calendar.getInstance();
        chon=null;
        btnChange=findViewById(R.id.btnChange);

    }


}