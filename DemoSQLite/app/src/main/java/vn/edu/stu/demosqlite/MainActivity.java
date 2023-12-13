package vn.edu.stu.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import model.SinhVien;

public class MainActivity extends AppCompatActivity {
    String DB_NAME = "dbsinhvien.sqlite", DB_PATH_SUFFIX = "/databases/";
    Button btnThem;
    ListView lvSV;
    ArrayAdapter<SinhVien> adapter;
    String[] tens = {"Ti","Suu","Dan","Meo","Ngo","Mui","Than","Dau","Tuat","Hoi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyDbFromAssets();
        addControls();
        addEvents();
        getListFromDb();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListFromDb();
    }

    private void copyDbFromAssets() {
        File dbFile = getDatabasePath(DB_NAME);
        if (!dbFile.exists()) {
            File dbDir = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!dbDir.exists()) {
                dbDir.mkdir();
            }
            try {
                InputStream is = getAssets().open(DB_NAME);
                String outputFilePath = getApplicationInfo().dataDir + DB_PATH_SUFFIX + DB_NAME;
                OutputStream os = new FileOutputStream(outputFilePath);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0){
                    os.write(buffer, 0,length);
                }
                os.flush();
                os.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addControls() {
        btnThem = findViewById(R.id.btnThem);
        lvSV = findViewById(R.id.lvSV);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvSV.setAdapter(adapter);
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThem();
            }
        });
        lvSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                xuLySua(position);
            }
        });
        lvSV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                xuLyXoa(position);
                return true;
            }
        });
    }

    private void xuLyXoa(int position) {
        SinhVien sv = adapter.getItem(position);
        SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        int count = database.delete(
                "sinhvien",
                "ma = ?",
                new String[]{sv.getMa() + ""}
        );
        database.close();
        Toast.makeText(
                this,
                "Đã xóa " + count + " sinh viên",
                Toast.LENGTH_LONG
        ).show();
        getListFromDb();
    }

    private void xuLySua(int position) {
        SinhVien sv = adapter.getItem(position);
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("SINHVIEN", sv);
        startActivity(intent);
//        Random rd = new Random();
//        String ten = "new" + tens[rd.nextInt(12)];
//        String lop = "new lop" + (rd.nextInt(10) + 1);
//        SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
//        ContentValues row = new ContentValues();
//        row.put("ten", ten);
//        row.put("lop",lop);
//        int count = database.update(
//                "sinhvien",
//                row,
//                "ma = ?",
//                new String[]{sv.getMa()+ ""}
//        );
//        Toast.makeText(this,"Da cap nhat " + count + " dong",Toast.LENGTH_LONG).show();
//        getListFromDb();
    }

    private void xuLyThem() {
//        Random rd = new Random();
//        String ten = "new" + tens[rd.nextInt(12)];
//        String lop = "new lop" + (rd.nextInt(10) + 1);
//
//        SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
//        ContentValues row = new ContentValues();
//        row.put("ten", ten);
//        row.put("lop",lop);
//        long newID = database.insert(
//                "sinhvien",
//                null,
//                row
//        );
//        database.close();
//
//        Toast.makeText(
//                this,
//                "Da them sinh vien ca ma: " + newID,
//                Toast.LENGTH_LONG
//        ).show();
//        getListFromDb();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    private void getListFromDb() {
        SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        //Cursor cursor = database.rawQuery("Select * From sinhvien",null);
        //Cursor cursor = database.rawQuery("Select * From sinhvien Where lop = ? And ma > ?",new String[]{"Lop 5","1"});
        Cursor cursor = database.query(
                "sinhvien",
                null, //new String[]{"ma","ten","lop"},
                null, //"lop = ?",
                null, //new String[]{"Lop 5"},
                null,
                null,
                null //"ma desc"
        );
        adapter.clear();
        while (cursor.moveToNext()){
            int ma = cursor.getInt(0);
            String ten = cursor.getString(1);
            String lop = cursor.getString(2);
            adapter.add(new SinhVien(ma,ten,lop));
        }
        cursor.close();
        database.close();
        adapter.notifyDataSetChanged();
    }
}