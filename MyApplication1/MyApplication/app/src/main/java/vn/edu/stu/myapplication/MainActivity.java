package vn.edu.stu.myapplication;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText txtUserName, txtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa

        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtPass = (EditText) findViewById(R.id.txtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        //onclick
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = "duong";
                String password = "123456";
                if (txtUserName.getText().toString().equals(username) && txtPass.getText().toString().equals(password)) {
                    Toast.makeText(getApplicationContext(), R.string.loginsuccess, Toast.LENGTH_LONG).show();

                    Intent mh = new Intent(MainActivity.this, SPActivity.class);
                    startActivity(mh);
                }
                else{
                    Toast.makeText(getApplicationContext(), R.string.loginerror, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}