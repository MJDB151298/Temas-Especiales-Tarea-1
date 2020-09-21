package com.example.temasespecialestarea1;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.temasespecialestarea1.helpers.MainActivityHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToGenderSpinner();
    }

    public void addItemsToGenderSpinner(){
        Spinner gender_spinner = findViewById(R.id.spinner_gender);
        List<String> list = new ArrayList<>();
        list.add("Masculino"); list.add("Femenino");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender_spinner.setAdapter(dataAdapter);
    }
    
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        ArrayList<Integer> checkboxes_id = MainActivityHelper.getLanguagesCheckboxes();
        switch(view.getId()) {
            case R.id.yesProgramming_radioButton:
                if(checked){
                    for(int id : checkboxes_id)
                        findViewById(id).setEnabled(true);
                }
                break;
            case R.id.noProgramming_radioButton:
                if(checked){
                    for(int id : checkboxes_id)
                        findViewById(id).setEnabled(false);
                }
                break;
        }
    }

    public void clean_screen(View view){
        ((EditText) findViewById(R.id.nameText)).getText().clear();
        ((EditText) findViewById(R.id.lastNameText)).getText().clear();

        clean_checkboxes();

        RadioButton yesProgramming = findViewById(R.id.yesProgramming_radioButton);
        RadioButton noProgramming = findViewById(R.id.noProgramming_radioButton);
        if(noProgramming.isChecked()){
            noProgramming.toggle();
            yesProgramming.toggle();
            onRadioButtonClicked(yesProgramming);
        }
    }

    public void clean_checkboxes(){
        ArrayList<Integer> checkboxes_id = MainActivityHelper.getLanguagesCheckboxes();
        for(int id : checkboxes_id){
            CheckBox language_checkbox = findViewById(id);
            if(language_checkbox.isChecked())
                language_checkbox.toggle();
        }
    }
}
