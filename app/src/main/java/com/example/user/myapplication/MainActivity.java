package com.example.user.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;

    private Button btnCacl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etInput = (EditText)findViewById(R.id.et_input);//透過findViewById找到一個控件，並使用=把他綁在一個變數上， 我們就可以利用那個變數操作綁定的控件
        btnCacl = (Button)findViewById(R.id.btn_cacl);

        btnCacl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_str = etInput.getText().toString();
                Toast.makeText(MainActivity.this,"Hello "+input_str,Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_reset) {
            etInput.setText("");
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_about) {
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("About this App");
            ad.setMessage("Author:侯景勛");

            DialogInterface.OnClickListener listener =
                    new DialogInterface.OnClickListener(){
                      public  void onClick(DialogInterface di,int i){

                      }
                    };
             ad.setPositiveButton("確定",listener);
             ad.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
