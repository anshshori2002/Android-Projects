package com.example.multitask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Fourth extends AppCompatActivity {

    ImageView btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,back_btn;
    ImageView btn_dot,btn_divide,btn_mul,btn_plus,btn_minus,btn_equal,btn_start_bracket,btn_end_bracket,btn_ac;

    TextView inputTxt,outTxt;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        back_btn = findViewById(R.id.back);

        btn_dot = findViewById(R.id.btn_dot);
        btn_divide = findViewById(R.id.btn_divide);
        btn_mul = findViewById(R.id.btn_mul);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_equal = findViewById(R.id.btn_equal);
        btn_start_bracket = findViewById(R.id.btn_start);
        btn_end_bracket = findViewById(R.id.btn_end_bracket);
        btn_ac = findViewById(R.id.btn_ac);

        inputTxt = findViewById(R.id.inputTxt);
        outTxt = findViewById(R.id.Outputtxt);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 =new Intent(Fourth.this,Third.class);
                startActivity(i1);
                finish();
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data= inputTxt.getText().toString();
                inputTxt.setText(data+"3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"9");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+".");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.setText("");
                outTxt.setText("");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"-");
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"×");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"/");
            }
        });

        btn_start_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data+"(");
            }
        });

        btn_end_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+")");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                data=data.replaceAll("×","*");
                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalresult="";

                Scriptable scriptable=rhino.initStandardObjects();
                finalresult=rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();
                outTxt.setText(finalresult);
            }
        });
    }
}