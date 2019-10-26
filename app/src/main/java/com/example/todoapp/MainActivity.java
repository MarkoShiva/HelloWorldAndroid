package com.example.todoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.todoapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /** Called when the user taps the Send button*/
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void sendMessage(View view) {
        // Do something in the response to button click
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        if (Objects.equals(message, "")){
            Toast.makeText(this, "You need to enter a message.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
}
