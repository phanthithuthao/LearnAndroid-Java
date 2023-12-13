package vn.edu.stu.demointentbasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button btnTroVe;
    TextView tvSo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addControls();
        addEvent();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("So")) {
            int so = intent.getIntExtra("So", 0);
            tvSo.setText(so + "");
        }
    }

    private void addControls() {
        btnTroVe = findViewById(R.id.btnTroVe);
        tvSo = findViewById(R.id.tvSo);
    }

    private void addEvent() {
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}