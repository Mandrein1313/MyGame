package com.example.mygame;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import com.example.mygame.R;

public class MainActivity extends Activity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // การใช้งาน R ที่ถูกต้อง
        button = findViewById(R.id.button);

        // การตั้งค่า listener สำหรับปุ่ม
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        checkButton();
    }

    private void checkButton() {
        if (button == null) {
            Toast.makeText(this, "Button not found", Toast.LENGTH_SHORT).show();
        } else {
            button.setEnabled(true);
            Toast.makeText(this, "Button enabled", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
protected void onDestroy() {
    super.onDestroy();
}

}
