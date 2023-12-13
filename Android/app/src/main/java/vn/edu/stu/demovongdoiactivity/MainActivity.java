package vn.edu.stu.demovongdoiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCKMP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this, "onCreate duoc goi", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        //addEvent();
        //addControls();
        xuLyCheKhuatMotPhan();
    }
    public void xuLyCheKhuatMotPhan(){
        Intent intent = new Intent(
                MainActivity.this, MainActivity2.class
        );
        startActivity(intent);
    }
//    private void addEvent() {
//        btnCKMP = findViewById(R.id.btnCKMP);
//    }
//
//    private void addControls() {
//        btnCKMP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(
//                        MainActivity.this,
//                        MainActivity2.class
//                );
//                startActivity(intent);
//            }
//        });
//    }

}