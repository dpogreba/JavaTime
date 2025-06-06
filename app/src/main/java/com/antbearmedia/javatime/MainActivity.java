package com.antbearmedia.javatime;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private TextView timeTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView = findViewById(R.id.timeTextView);
        handler = new Handler();

        updateTime();

        // Load SettingsFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.settings_container, new SettingsFragment());
        fragmentTransaction.commit();
    }

    private void updateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);
        timeTextView.setText(formattedTime);

        handler.postDelayed(this::updateTime, 1000);
    }
}
