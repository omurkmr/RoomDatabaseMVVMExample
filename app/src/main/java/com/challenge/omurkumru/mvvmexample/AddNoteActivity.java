package com.challenge.omurkumru.mvvmexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "EXTRA_PRIORITY";

    private EditText editTextTitle,editTextDescription;
    private NumberPicker numberPickerPriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        editTextTitle = findViewById(R.id.edit_text_title);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close );
        setTitle("Add Note");

    }

    public void saveNote(){
        String desc = editTextDescription.getText().toString();
        String title = editTextTitle.getText().toString();
        int priority = numberPickerPriority.getValue();

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,desc);
        data.putExtra(EXTRA_PRIORITY,priority );

        setResult(RESULT_OK,data);
         finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }

    }
}
