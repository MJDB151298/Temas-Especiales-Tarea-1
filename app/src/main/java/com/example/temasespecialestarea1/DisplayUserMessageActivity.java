package com.example.temasespecialestarea1;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.temasespecialestarea1.entities.User;

public class DisplayUserMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user_message);

        //Recuperando el mensaje de main activity
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("USER");
        TextView textView = findViewById(R.id.messageTextView);
        textView.setText(user.toString());
    }
}