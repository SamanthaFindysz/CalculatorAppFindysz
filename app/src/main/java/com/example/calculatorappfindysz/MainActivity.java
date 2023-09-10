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
        TextView outputTv = findViewById(R.id.output);
        try {
            EditText value1ET = findViewById(R.id.value1);
            //converts the string value of the input to a double
            //https://developer.android.com/reference/java/lang/Double
            int value1 = Integer.parseInt(value1ET.getText().toString());

            EditText value2ET = findViewById(R.id.value2);
            int value2 = Integer.parseInt(value2ET.getText().toString());

            String fullText = value1 + ", " + operator + ", " + value2 ;
            // first param is a searchable tag, the second is what you are logging
            Log.i("sammie", "First screen: " + fullText);


            //this try code checks to see if the values can be computed.
            //I had to use the resource below to remind me of the syntax.
            //https://www.w3schools.com/java/java_try_catch.asp
            if(operator.equals("add")){
                Log.i("sammie", "" + (value1 + value2));
                outputTv.setText("" + (value1 + value2));
            }
            else if(operator.equals("subtract")){
                outputTv.setText("" + (value1 -value2));
            }
            else if(operator.equals("multiply")){
                outputTv.setText("" + (value1 * value2));
            }
            else if(operator.equals("divide")){
                outputTv.setText("" + (value1 / value2));
            }
            else if(operator.equals("exponent")){
                outputTv.setText("" + (Math.pow(value1, value2)));
            }
            else{
                outputTv.setText("" + ((Math.log(value1) / Math.log(value2))));
            }
        } catch (Exception e){
            outputTv.setText("error");
        }
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
        else if(v.getId() == R.id.divide){
            Log.i("sammie", "divide");
            operator = "divide";
        }
        else if(v.getId() == R.id.exponent){
            Log.i("sammie", "exponent");
            operator = "exponent";
        }
        else {
            Log.i("sammie", "log");
            operator = "log";
        }
    }

    public void clear(View v){
        operator = "none";

        EditText value1ET = findViewById(R.id.value1);
        value1ET.setText("");
        EditText value2ET = findViewById(R.id.value2);
        value2ET.setText("");

        TextView outputTv = findViewById(R.id.output);
        outputTv.setText("");

    }
}