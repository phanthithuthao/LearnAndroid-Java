package vn.edu.stu.demomenuanddialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView tvAction;
    Button btnContext;
    Button btnContext2;
    Button btnAlertDialog, btnCustomDialog, btnProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvent();
        addControls();
    }
    private void addControls() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvAction = findViewById(R.id.tvAction);
        btnContext = findViewById(R.id.btnContext);
        registerForContextMenu(btnContext);
        btnContext2=findViewById(R.id.btnContext2);
        registerForContextMenu(btnContext2);
        btnAlertDialog=findViewById(R.id.btnAlertDialog);
        btnCustomDialog=findViewById(R.id.btnCustomDialog);
        btnProgressDialog=findViewById(R.id.btnProgressDialog);

    }
    private void addEvent() {
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyAlertDialog();
            }
        });
    }

    private void xuLyAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("This is Alert Dialog");
        builder.setIcon(android.R.drawable.ic_dialog_alert); // hoac su dung trong android.R.drawable.ic_dialog_alert
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvAction.setText("Ổn man");
            }
        });
        builder.setNegativeButton("Not OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvAction.setText("Không ổn man");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.btnContext){
            getMenuInflater().inflate(R.menu.menu_context,menu);
        }else if (v.getId() == R.id.btnContext2){
            getMenuInflater().inflate(R.menu.menu_context2,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuContext1){
            tvAction.setText("Context1");
        } else if (item.getItemId() == R.id.menuContext2) {
            tvAction.setText("Context2");
        }
        return super.onContextItemSelected(item);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuSearch = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) menuSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tvAction.setText(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAlert){
            tvAction.setText("Alert");
        } else if (item.getItemId() == R.id.menuAbout) {
            tvAction.setText("About");
        } else if (item.getItemId()==R.id.menuExit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}