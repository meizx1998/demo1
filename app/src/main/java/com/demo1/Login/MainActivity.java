package com.demo1.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.demo1.model.ConnectJWXT;

public class MainActivity extends AppCompatActivity {
    EditText stunum,psw;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stunum=(EditText) findViewById(R.id.Stunum);
        psw=findViewById(R.id.Psw);
        login=findViewById(R.id.bottom);
        final ConnectJWXT connectJWXT=new ConnectJWXT();

        new Thread(){

            @Override
            public void run() { connectJWXT.openlogin();
              Log.e("MainActivity",connectJWXT.get__VIEWSTATE());

            }
        }.start();



    }
}
