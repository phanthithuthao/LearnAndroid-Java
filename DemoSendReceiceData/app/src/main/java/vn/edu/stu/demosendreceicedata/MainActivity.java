package vn.edu.stu.demosendreceicedata;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnMo;
    EditText etSo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvent();
    }

    private void addControls() {
        btnMo = findViewById(R.id.btnMo);
        etSo = findViewById(R.id.etSo);
    }

    private void addEvent() {
        btnMo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int so = Integer.parseInt(etSo.getText().toString());
                Intent intent = new Intent(
                        MainActivity.this,
                        MainActivity2.class
                );
                intent.putExtra("So", so);
                startActivity(intent);
            }
        });
    }
}