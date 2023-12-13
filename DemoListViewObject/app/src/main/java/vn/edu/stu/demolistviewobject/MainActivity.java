package vn.edu.stu.demolistviewobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import Model.AnhEm;

public class MainActivity extends AppCompatActivity {
    Button btnDS;
    ListView lvAe;
    ArrayList<AnhEm> dsAe;
    ArrayAdapter<AnhEm> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        btnDS = findViewById(R.id.btnDS);
        lvAe = findViewById(R.id.lvAe);
        dsAe = new ArrayList<>();
        //3 thong so la: context main chinh, giao  hien thi list , data
        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_checked,
                dsAe
        );
        lvAe.setAdapter(adapter);
    }

    private void addEvents() {
        btnDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsAe.clear();
                Random rd = new Random();
                for (int i = 1; i <= 500; i++){
                    String ten = "Anh em thu " + i;
                    int tuoi = rd.nextInt(43) + 18;
                    dsAe.add(new AnhEm(ten,tuoi));
                }
                //Thong bao cho adapter co du lieu thay doi

                adapter.notifyDataSetChanged();
            }
        });
        lvAe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position >= 0 && position < dsAe.size()){
                    AnhEm anhEm = dsAe.get(position);
                    Toast.makeText(
                                    MainActivity.this,
                                    "Tên: " + anhEm.getTen() + ", Tuổi: " + anhEm.getTuoi(),
                                    Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        lvAe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(position >= 0 && position < dsAe.size()){
                    dsAe.remove(position);
                    adapter.notifyDataSetChanged();
                }
                return true;
            }
        });
    }

}