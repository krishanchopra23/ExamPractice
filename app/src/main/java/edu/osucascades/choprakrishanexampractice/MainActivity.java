package edu.osucascades.choprakrishanexampractice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mMangleButton;
    private EditText mFirstNameInput;

    private static final int REQUEST_CODE = 0;
    private static final String KEY_INDEX = "index";

    private String[] lastNames = new String[] {
            "Smith",
            "Carter",
            "Scott",
            "Doe",
            "Graham"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstNameInput = (EditText) findViewById(R.id.first_name_input);

        mMangleButton = (Button) findViewById(R.id.mangle_button_id);
        mMangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mFirstNameInput.length() <= 0) {
                    Toast.makeText(MainActivity.this, "Name field is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, ManglerActivity.class);
                    intent.putExtra("FirstName", mFirstNameInput.getText().toString());
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        } else {
            if (requestCode == REQUEST_CODE) {
                if (data == null) {
                    return;
                }
            }
        }
        mFirstNameInput.setText("");
    }



}
