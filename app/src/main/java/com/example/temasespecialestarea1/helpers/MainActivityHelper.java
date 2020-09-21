package com.example.temasespecialestarea1.helpers;

import com.example.temasespecialestarea1.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityHelper {
    public static ArrayList<Integer> getLanguagesCheckboxes(){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(R.id.java_checkBox); result.add(R.id.python_checkBox);
        result.add(R.id.js_checkBox); result.add(R.id.go_checkBox);
        result.add(R.id.c_checkBox); result.add(R.id.char_checkBox);
        return result;
    }
}
