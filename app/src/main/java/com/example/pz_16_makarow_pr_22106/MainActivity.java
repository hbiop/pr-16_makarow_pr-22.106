package com.example.pz_16_makarow_pr_22106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button save;
    Button load;
    EditText etText;
    TextView text;
    final String SAVED_TEXT = "saved_text";
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.button);
        save.setOnClickListener(this);
        text = (TextView) findViewById(R.id.textview);
        load = (Button) findViewById(R.id.button4);
        load.setOnClickListener(this);
        etText = (EditText) findViewById(R.id.editTextTextPersonName3);
        etText.setOnClickListener(this);
        loadText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        text.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                saveText();
                break;
            case R.id.button4:
                loadText();
                break;
        }
    }
}