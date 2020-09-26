package com.example.temasespecialestarea1;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.temasespecialestarea1.entities.User;
import com.example.temasespecialestarea1.helpers.MainActivityHelper;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DatePicker) findViewById(R.id.datePicker)).updateDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
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

    public AlertDialog.Builder createPopUpWindow(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Faltan parametros");
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder;
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
        ((DatePicker) findViewById(R.id.datePicker)).updateDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        //((EditText) findViewById(R.id.editTextDate)).getText().clear();

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

    public void save(View view){
        boolean canSend = true;
        EditText first_name = findViewById(R.id.nameText);
        EditText last_name = findViewById(R.id.lastNameText);
        Spinner spinner_gender = findViewById(R.id.spinner_gender);
        AlertDialog alert = createPopUpWindow().create();
        if(first_name.getText().toString().equalsIgnoreCase("") || last_name.getText().toString().equalsIgnoreCase("")){
            alert.show();
        }
        else{
            DatePicker born = findViewById(R.id.datePicker);
            ArrayList<String> languages = new ArrayList<>();
            boolean likesProgramming = false;
            if(((RadioButton) findViewById(R.id.yesProgramming_radioButton)).isChecked()){
                ArrayList<Integer> checkboxes_id = MainActivityHelper.getLanguagesCheckboxes();
                for(int id : checkboxes_id){
                    CheckBox language_checkbox = findViewById(id);
                    if(language_checkbox.isChecked()){
                        languages.add(language_checkbox.getText().toString());
                    }
                }
                if(languages.size() == 0){
                    alert.show();
                    canSend = false;
                }

                likesProgramming = true;
            }

            if(canSend){
                Intent intent = new Intent(this, DisplayUserMessageActivity.class);
                User user = new User(first_name.getText().toString(), last_name.getText().toString(), spinner_gender.getSelectedItem().toString(),
                        born.getDayOfMonth() + "/" + (born.getMonth()+1) + "/" + born.getYear(), likesProgramming, languages);
                intent.putExtra("USER", user);
                startActivity(intent);
            }


        }
    }
}
