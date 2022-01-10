package com.example.geektech01urok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn_go;
    private EditText get_message, gmail_message, themes_message;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setbinding();
        setGmail_message();
    }
    protected void setbinding(){
        btn_go = findViewById(R.id.btn_black_GO);
        get_message = findViewById(R.id.et_message);
        get_message = findViewById(R.id.et_message);
        gmail_message = findViewById(R.id.et_gmail_com);
        themes_message = findViewById(R.id.et_themes);
    }

    private void setGmail_message(){
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + gmail_message.getText()));
                intent.putExtra(Intent.EXTRA_SUBJECT, themes_message.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, get_message.getText());
                startActivity(Intent.createChooser(intent, ""));
            }
        });
    }

}