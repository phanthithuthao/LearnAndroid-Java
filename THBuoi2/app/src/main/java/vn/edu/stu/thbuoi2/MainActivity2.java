package vn.edu.stu.thbuoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    public static ArrayList<String> kbg = new ArrayList<String>() {
        {
            add("KÉO");
            add("BÚA");
            add("GIẤY");
        }
    };
    TextView tvBanRa, tvMayRa, tvKetQua;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvent();
        getDataFromIntent();
    }

    private void addControls() {
        tvBanRa = findViewById(R.id.tvBanRa);
        tvMayRa = findViewById(R.id.tvMayRa);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnBack = findViewById(R.id.btnBack);
    }

    private void addEvent() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("BANRA")) {
            String banRa = intent.getStringExtra("BANRA");
            if (banRa == ""){
                tvKetQua.setText("KHÔNG CÓ THÔNG TIN");
            }else {
                tvBanRa.setText("Bạn ra: " + banRa);
                int iBanRa = kbg.indexOf(banRa);

                int iMayRa= new Random().nextInt(kbg.size());
                String mayRa = kbg.get(iMayRa);
                tvMayRa.setText("Máy ra: " + mayRa);

                int kq = iBanRa - iMayRa;
                if (kq == 0) tvKetQua.setText("Kết quả: HÒA");
                else if (kq == 1 || kq == -2) {
                    tvKetQua.setText("Kết quả: BẠN THẮNG");
                }else tvKetQua.setText("Kết quả: BẠN THUA");
            }
        }else {
            tvBanRa.setText("KHÔNG CÓ THÔNG TIN");
        }
    }
}