package edu.osucascades.choprakrishanexampractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mMangleButton;
    EditText mNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mNameInput = (EditText) findViewById(R.id.mangle_button_id);

        mMangleButton = (Button) findViewById(R.id.mangle_button_id);
        mMangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mNameInput.getText().toString();
                Toast.makeText(MainActivity.this, firstName, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
