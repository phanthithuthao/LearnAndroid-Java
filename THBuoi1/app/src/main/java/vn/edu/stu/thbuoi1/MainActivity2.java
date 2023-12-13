package vn.edu.stu.thbuoi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button btnTimX;
    EditText etA,etB,etC;
    TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
    }

    private void addControls() {
        btnTimX = findViewById(R.id.btnTimX);
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        etC = findViewById(R.id.etC);
        tvKetQua = findViewById(R.id.tvKetQua);
    }

    private void addEvents() {
        btnTimX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double soA = Double.parseDouble(etA.getText().toString());
                double soB = Double.parseDouble(etB.getText().toString());
                double soC = Double.parseDouble(etC.getText().toString());

                if(soA != 0){
                    double delta= soB * soB - 4 * soA * soC;
                    if (delta > 0) {
                        tvKetQua.setText("Phuong trinh co 2 nghiem phan biet:\n x1 = " + (-soB + Math.sqrt(delta)) / (2 * soA) + "\n x2 = " + (-soB - Math.sqrt(delta)) / (2 * soA));
                    } else if (delta == 0) {
                        double x = -soB / (2 * soA);
                        tvKetQua.setText("Phuong trinh co nghiem kep:\n x = " + x);
                    } else {
                        tvKetQua.setText("Phuong trinh vo nghiem");
                    }
                }else{
                    if (soB == 0) {
                        if (soC != 0) {
                            tvKetQua.setText("Phuong trinh vo nghiem");
                        } else {
                            tvKetQua.setText("Phuong trinh co vo so nghiem");
                        }
                    } else {
                        tvKetQua.setText("Phuong trinh co nghiem x = " + (-soC / soB));
                    }
                }

            }
        });
    }
}