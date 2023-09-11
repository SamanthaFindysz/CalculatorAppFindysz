package com.example.calculatorappfindysz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String operator = "none";
    private EditText value1ET;
    private EditText value2ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the EditText fields here
        value1ET = findViewById(R.id.value1);
        value2ET = findViewById(R.id.value2);

        // Create a single OnEditorActionListener for both EditText fields (Chat GPT)
        TextView.OnEditorActionListener editorActionListener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // User pressed the "Done" key on the keyboard
                    hideKeyboard(v); // Hide the keyboard for the EditText that triggered the event
                    return true; // Return true to indicate you've handled the event
                }
                return false; // Return false to allow further processing
            }
        };

        // Set the same OnEditorActionListener for both EditText fields (Chat GPT)
        value1ET.setOnEditorActionListener(editorActionListener);
        value2ET.setOnEditorActionListener(editorActionListener);
    }

    //This method hides the keyboard. I sourced it from Chat GPT.
    private void hideKeyboard(View view) {
        //receives a system service in Android studio that handles input methods
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //the keyboard is hidden with no alternatives (0)
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public void calculate(View v){
            //first we make a reference to the EditText by locating it with its id
            TextView outputTv = findViewById(R.id.output);
            try {
                EditText value1ET = findViewById(R.id.value1);
                //converts the string value of the input to a double
                //https://developer.android.com/reference/java/lang/Double
                double value1 = Double.valueOf(value1ET.getText().toString());

                EditText value2ET = findViewById(R.id.value2);
                double value2 = Double.valueOf(value2ET.getText().toString());

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
                    outputTv.setText("" + (value1 - value2));
                }
                else if(operator.equals("multiply")){
                    outputTv.setText("" + (value1 * value2));
                }
                else if(operator.equals("divide")){
                    outputTv.setText("" + (value1 / value2));
                }
                else if(operator.equals("exponent")){
                    //this raises value 1 to the power of value 2
                    //I found how to do this here:
                    //https://blog.gitnux.com/code/java-exponent/#:~:text=Calculating%20exponents%20in%20Java%20is,to%20the%20power%20of%20b'
                    outputTv.setText("" + (Math.pow(value1, value2)));
                }
                else{
                    //this finds the logarithm of value 1 base value 2
                    //I found how to do this here:
                    //https://www.scaler.com/topics/log-in-java/
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