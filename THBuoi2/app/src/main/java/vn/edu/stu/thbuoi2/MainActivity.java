package vn.edu.stu.thbuoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnKeo, btnGiay, btnBua, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addControl() {
        btnKeo = findViewById(R.id.btnKeo);
        btnBua = findViewById(R.id.btnBua);
        btnGiay = findViewById(R.id.btnGiay);
        btnStop = findViewById(R.id.btnStop);
    }

    private void addEvent() {
        btnKeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnBua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnGiay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyRa(v);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void xuLyRa(View v) {
        String banRa = ((Button) v).getText().toString().toUpperCase();
        Intent intent = new Intent(
                MainActivity.this,
                MainActivity2.class
        );
        intent.putExtra("BANRA",banRa);
        startActivity(intent);
    }
}