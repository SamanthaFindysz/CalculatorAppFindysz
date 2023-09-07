package com.example.calculatorappfindysz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String operator = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v){
        //first we make a reference to the EditText by locating it with its id
        EditText value1ET = findViewById(R.id.value1);
        //use that reference to extract the text and save it into a String var
        //getText returns an Editable, not a String. So we call toString so we can
        //save it in a string variable.
        String value1 = value1ET.getText().toString();

        EditText value2ET = findViewById(R.id.value2);
        String value2 = value2ET.getText().toString(); //we will learn how to make numeric later

        String fullText = value1 + ", " + value2;
        // first param is a searchable tag, the second is what you are logging
        Log.i("sammie", "First screen: " + fullText);

        /*
        To switch screens we need to create an Intent, tell it where to go
        Put data in the intent (optional)
        startActivity to actually launch the intent (go to other screen)

        (Make the package, address it, stuff it, mail it)
         */

        // coming from this screen, going to ShowInfoActivity
        //Intent intent = new Intent(this, ShowInfoActivity.class);

        //optional - you don't have to put anything int the intent, will switch screens only
        //intent.putExtra("NAME", name);
        //intent.putExtra("AGE", age);
        //intent.putExtra("HOBBY", hobby);
        // launch the new screen
        //startActivity(intent);
    }

    public void defineOperator(View v){
        if(v.getId() == R.id.add){
            Log.i("sammie", "add");
            operator = "add";
        }
        else if(v.getId() == R.id.subtract){
            Log.i("sammie", "subtract");
            operator = "subtract";
        }
        else if(v.getId() == R.id.multiply){
            Log.i("sammie", "multiply");
            operator = "multiply";
        }
        else{
            Log.i("sammie", "divide")
            operator = "divide";
        }
    }
}