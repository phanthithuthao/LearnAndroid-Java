package vn.edu.stu.thbuoi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etA, etB;
    Button btnTimX;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnTimX = findViewById(R.id.btnTimX);
    }

    private void addEvents() {
        btnTimX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double soA = Double.parseDouble(etA.getText().toString());
                double soB = Double.parseDouble(etB.getText().toString());
                if (soA == 0) {
                    if (soB != 0) {
                        tvKetQua.setText("Phuong trinh vo nghiem");
                    } else {
                        tvKetQua.setText("Phuong trinh co vo so nghiem");
                    }
                } else {
                    tvKetQua.setText("Phuong trinh co nghiem x = " + (-soB / soA));
                }
            }
        });
    }
}