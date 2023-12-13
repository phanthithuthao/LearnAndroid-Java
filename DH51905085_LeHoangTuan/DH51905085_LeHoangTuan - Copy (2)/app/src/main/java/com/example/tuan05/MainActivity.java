package com.example.tuan05;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.tuan05.Util.Appdatabase;
import com.example.tuan05.Util.DBUtil;

import java.util.ArrayList;

import Entity.NhanVien;


public class MainActivity extends AppCompatActivity {
    Button imgbtnthem;
    ArrayAdapter<NhanVien> adapter;
    ArrayList<NhanVien> dsSinhVien;
    ListView lvDSsinhvien;
    NhanVien chon = null;
    Appdatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBUtil.copyDatabaseFromAssets(MainActivity.this);
        addControls();
        addEvents();
    }

    private void addControls() {
        database=Appdatabase.getAppDatabase(this);
        imgbtnthem = findViewById(R.id.btnThem);
        lvDSsinhvien=findViewById(R.id.lvSinhVien);
        dsSinhVien=new ArrayList<>();
        dsSinhVien.addAll(database.daoNhanVien().getAll());
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,dsSinhVien);
        lvDSsinhvien.setAdapter(adapter);
    }

    private void addEvents() {
        imgbtnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemNhanVienActivity.class);
                resultLauncher.launch(intent);
                //startActivity(intent);
            }
        });
        lvDSsinhvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                xulyChon(position);
            }
        });
        lvDSsinhvien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                NhanVien nhanVien = dsSinhVien.get(position);

                int a = database.daoNhanVien().delete(nhanVien);
                dsSinhVien.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void xulyChon(int position) {
        chon=dsSinhVien.get(position);
        Intent intent=new Intent(MainActivity.this, ThemNhanVienActivity.class);
        intent.putExtra("CHON",  chon);
//        startActivity(intent);
        resultLauncher.launch(intent);
    }

    private void xulyXoa(int i) {

    }

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        if (result.getData().hasExtra("Them")) {
                            NhanVien a = (NhanVien) result.getData().getSerializableExtra("Them");
                            dsSinhVien.add(a);
                            database.daoNhanVien().insert(a);
                            dsSinhVien.clear();
                            dsSinhVien.addAll(database.daoNhanVien().getAll());
                            adapter.notifyDataSetChanged();
                        }
                        else if (result.getData().hasExtra("Sua")) {
                            NhanVien a = (NhanVien) result.getData().getSerializableExtra("Sua");
                            for(int i = 0;i<dsSinhVien.size();i++){
                                if(dsSinhVien.get(i).getMa()==a.getMa()){
                                    dsSinhVien.set(i,a);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });


}

