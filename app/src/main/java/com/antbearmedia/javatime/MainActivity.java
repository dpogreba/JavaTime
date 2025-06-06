package com.antbearmedia.javatime;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import android.os.Handler;

public class MainActivity extends Activity {

    private TextView timeTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView = findViewById(R.id.timeTextView);
        handler = new Handler();

        updateTime();
    }

    private void updateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);
        timeTextView.setText(formattedTime);

        handler.postDelayed(this::updateTime, 1000);
    }
}
