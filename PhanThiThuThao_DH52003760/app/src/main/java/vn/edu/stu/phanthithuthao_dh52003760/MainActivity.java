package vn.edu.stu.phanthithuthao_dh52003760;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import model.SinhVien;

public class MainActivity extends AppCompatActivity {
    Button btnThem;
    ListView lvSV;
    ArrayList<SinhVien>dsSV;
    ArrayAdapter<SinhVien> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    private void addControls() {
        btnThem = findViewById(R.id.btnThem);
        lvSV = findViewById(R.id.lvSV);
        dsSV = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1, dsSV
        );
        lvSV.setAdapter(adapter);
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}