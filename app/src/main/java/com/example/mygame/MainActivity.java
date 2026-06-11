// นี่คือตัวอย่างโค้ดที่แก้ไขแล้ว โดยสมมติว่า UnknownFile.java คือ MainActivity.java
package com.example.mygame;
import android.view.View; 
import android.widget.Button; 
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import com.example.mygame.R; // การ import R ที่ถูกต้อง

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // การใช้งาน R ที่ถูกต้อง
        setContentView(R.layout.activity_main);
        
    }
    Button button = findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();});
}
private void checkButton(){ 
    if (button == null) {
        Toast.makeText(this, "Button not found", Toast.LENGTH_SHORT).show();
    }
    checkButton(); 
    
}else{
    button.setEnabled(true);
}

button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
    Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
}}`
Toast.makeText(this, "Button enabled", Toast.LENGTH_SHORT).show();

}

}
