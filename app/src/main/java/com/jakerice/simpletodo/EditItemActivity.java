package com.jakerice.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText editItem;
    Button btnUpdate;
    String pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        editItem = (EditText) findViewById(R.id.editText);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        Intent intent = getIntent();
        String extraText = intent.getStringExtra("itemText");
        pos = intent.getStringExtra("itemPos");
        editItem.setText(extraText);
        editItem.setSelection(extraText.length());
    }
    @Override
    protected void onResume() {
        super.onResume();

        editItem.setFocusableInTouchMode(true);
        editItem.requestFocus();
    }

    public void onUpdate(View v) {
        String newText = editItem.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("itemText", newText);
        resultIntent.putExtra("itemPos", pos);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
