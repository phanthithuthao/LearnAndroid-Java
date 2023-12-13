package vn.edu.stu.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnDS;
    ListView lvAe;
    ArrayList<String> dsAe;
    ArrayAdapter<String> adapter;

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
                android.R.layout.simple_list_item_1,
                dsAe
        );
        lvAe.setAdapter(adapter);
    }

    private void addEvents() {
        btnDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsAe.clear();
                for (int i = 1; i <= 500; i++){
                    dsAe.add("Ae thu: " + i);
                }
                //Thong bao cho adapter co du lieu thay doi
                adapter.notifyDataSetChanged();
            }
        });
        //Su kien click vao item
        lvAe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position >= 0 && position < dsAe.size()){
                    String ae = dsAe.get(position);
                    Toast.makeText(
                            MainActivity.this,
                            "Ta la: " + ae,
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