package edu.osucascades.choprakrishanexampractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ManglerActivity extends AppCompatActivity {

    private Button mRemangleButton;
    private Button mResetButton;
    private TextView mMangleName;

    private static final String EXTRA_ACTIVITY = "edu.osucascades.choprakrishanexampractice.extra_activity";

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
        setContentView(R.layout.activity_mangler);

        final String firstName = getIntent().getStringExtra("FirstName");
        String mangleName = firstName + ' ' + lastNames[(int)(Math.random() * lastNames.length)];

        mMangleName = (TextView) findViewById(R.id.first_name_mangle);
        mMangleName.setText(mangleName);

        mRemangleButton = (Button) findViewById(R.id.remangle_button_id);
        mRemangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMangleName = firstName + ' ' + lastNames[(int)(Math.random() * lastNames.length)];
                mMangleName.setText(newMangleName);
            }
        });

        mResetButton = (Button) findViewById(R.id.reset_button_id);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetIntent = new Intent();
                setResult(Activity.RESULT_OK, resetIntent);
                finish();
            }
        });
    }
}
