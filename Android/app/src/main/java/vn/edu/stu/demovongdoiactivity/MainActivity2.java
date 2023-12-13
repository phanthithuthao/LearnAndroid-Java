package vn.edu.stu.demovongdoiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        xuLyMotPhan();
        addEvent();
        addControls();

    }

    private void addEvent() {
    }

    private void addControls() {

    }

    private void xuLyMotPhan() {
        Toast.makeText(getApplicationContext(), "Che Khuat Mot Phan", Toast.LENGTH_SHORT)
                .show();
        setContentView(R.layout.activity_main2);
    }
}