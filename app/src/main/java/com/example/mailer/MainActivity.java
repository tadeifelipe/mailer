package com.example.mailer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("App Mailer");
        final String email = findViewById(R.id.activity_main_email).toString();
        final String corpo = findViewById(R.id.activity_main_corpo).toString();

        Button buttonSend = findViewById(R.id.activity_main_botao_enviar);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(MainActivity.this, email, corpo);
            }
        });

    }

    public void sendEmail(Context context, String email, String corpo) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL,email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Teste");
        intent.putExtra(Intent.EXTRA_TEXT, corpo);
        context.startActivity(Intent.createChooser(intent,"Choose your manager E-mail:"));
    }
}
