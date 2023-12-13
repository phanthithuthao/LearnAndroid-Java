package vn.edu.stu.demothread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button btnNormalTask,btnRunnableTask,btnThreadTask,btnStopThreadTask,btnThreadHandler,btnStopThreadHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addControls() {
        progressBar=findViewById(R.id.progressBar);
        btnNormalTask=findViewById(R.id.btnNormalTask);
        btnRunnableTask=findViewById(R.id.btnRunnableTask);
        btnThreadTask=findViewById(R.id.btnThreadTask);
        btnStopThreadTask=findViewById(R.id.btnStopThreadTask);
        btnThreadHandler=findViewById(R.id.btnStopThreadHandler);
    }

    private void addEvents() {
        btnNormalTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNormalTask();
            }
        });
    }

    private void xuLyNormalTask() {
        try {
            int data = 0;
            while (data<=100){
                Thread.sleep(100);
                data++;
                progressBar.setProgress(data);
            }
        }
        catch (Exception e){
            Log.e("Loi", e.toString());
        }
    }
}