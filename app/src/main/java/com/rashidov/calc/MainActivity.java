package com.rashidov.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnD, btnE, btnP, btnM, btnU, btnL, btnC;
    int var_, oper;
    float var;
    private EditText field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field= (EditText) findViewById(R.id.editTextNumberDecimal);
        field.setShowSoftInputOnFocus(false);
        field.setFocusable(false);
    }
    public void Click (View v) {

        Button btn=(Button) findViewById(v.getId());
        switch (btn.getText().toString()) {
            case "0": case  "1": case "2": case  "3":
            case "4": case  "5": case "6": case  "7":
            case "8": case  "9": case  ".":
                if (var_==1) {
                    var = Float.parseFloat(field.getText().toString());
                    field.setText("");
                    var_=0;
                }
                field.append(btn.getText().toString());
                break;
            case "C": var_=0; var=0; oper=0; field.setText(""); break;
            case "–": oper=1; var_=1; break;
            case "+": oper=2; var_=1; break;
            case "×": oper=3; var_=1; break;
            case "÷": oper=4; var_=1; break;
            case "=":
                if (oper==2) var=var+Float.parseFloat(field.getText().toString()); else
                if (oper==1) var=var-Float.parseFloat(field.getText().toString()); else
                if (oper==3) var=var*Float.parseFloat(field.getText().toString()); else
                if (oper==4) {

                    try {
                        var = var / Float.parseFloat(field.getText().toString());
                    }
                    catch(Exception e) {
                        //  Block of code to handle errors
                    }
                }
                if(var == (long) var)
                    field.setText(String.format("%d",(long)var));
                else
                    field.setText(String.format("%s",var));
                //field.setText(Float.toString(var));
        }
        /*
        switch (v.getId()) {
            case
            // бутон 0
            case R.id.button20:  field.append("0");
                break;
            // бутон 1
            case R.id.button16:  field.setText(field.getText()+"1");
                break;
        }
         */
        //if (v.getId()==R.id.button20)

    }
}