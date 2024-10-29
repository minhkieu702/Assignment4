package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class ContactDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        TextView nameTextView = findViewById(R.id.detailName);
        TextView phoneTextView = findViewById(R.id.detailPhone);
        Button callButton = findViewById(R.id.callButton);
        Button smsButton = findViewById(R.id.smsButton);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");

        nameTextView.setText(name);
        phoneTextView.setText(phone);

        callButton.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            startActivity(callIntent);
        });

        smsButton.setOnClickListener(v -> {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phone));
            startActivity(smsIntent);
        });
    }
}
