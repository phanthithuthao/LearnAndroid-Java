package vn.edu.stu.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    TextView tvUsername,tvPassword;
    Button btnLogin;
    String userStateFile = "UserState";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void xuLyLogin() {
        String userName = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if (userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")){
            Toast.makeText(this, "Login succeeded", Toast.LENGTH_LONG).show();
            SharedPreferences preferences = getSharedPreferences(userStateFile,MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("username", userName);
            editor.putString("password",password);
            editor.apply();
        }else{
            Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show();
            SharedPreferences preferences = getSharedPreferences(userStateFile,MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("username");
            editor.remove("password");
            editor.apply();
        }

    }

    private void addControls() {
        etUsername = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etTenSV);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLogin();
            }
        });
    }


}