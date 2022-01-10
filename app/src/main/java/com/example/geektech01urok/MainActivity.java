package com.example.geektech01urok;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_go;
    private EditText get_message, gmail_message, themes_message;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_go = findViewById(R.id.btn_black_GO);
        get_message = findViewById(R.id.et_message);
        gmail_message= findViewById(R.id.et_username);
        themes_message = findViewById(R.id.et_password);
       /* btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "your_emailid@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "gdfgdfg");
                    intent.putExtra(Intent.EXTRA_TEXT, "gdfgfdg");
                    startActivity(intent);
                } catch(Exception e) {
                    Toast.makeText(MainActivity.this, "Sorry...You don't have any mail app", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });*/
        /*btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(Intent.ACTION_VIEW)
                        .setType("plain/text")
                        .setData(Uri.parse("test@gmail.com"))
                        .setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail")
                        .putExtra(Intent.EXTRA_EMAIL, new String[]{"test@gmail.com"})
                        .putExtra(Intent.EXTRA_SUBJECT,get_message.getText())
                        .putExtra(Intent.EXTRA_TEXT, themes_message.getText());
                startActivity(intent);
            }
        });*/
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("mailto:" + gmail_message.getText()));
                intent.putExtra(Intent.EXTRA_SUBJECT, themes_message.getText().toString());
                intent.putExtra(Intent.EXTRA_EMAIL, gmail_message.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, get_message.getText());
                startActivity(Intent.createChooser(intent, ""));
            }
        });
    }
}