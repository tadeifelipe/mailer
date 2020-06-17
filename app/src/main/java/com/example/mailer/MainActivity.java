package com.example.mailer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("App Mailer");

        Button buttonSend = findViewById(R.id.activity_main_botao_enviar);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(MainActivity.this);
            }
        });

    }

    public void sendEmail(Context context) {
        EditText recipient = findViewById(R.id.activity_main_email);
        EditText corpo = findViewById(R.id.activity_main_corpo);
        EditText subject = findViewById(R.id.activity_main_subject);
        String[] recipientString = recipient.getText().toString().split(",");

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipientString);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, corpo.getText().toString());
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose your manager E-mail:"));
    }
}
