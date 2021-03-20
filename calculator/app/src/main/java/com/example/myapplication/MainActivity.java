package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView expression, result;
    String string_tmp="", tmp = "";
    float ans = 0, num1 = 0, num2 = 0;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6,
            button_7, button_8, button_9, button_add, button_sub, button_div,
            button_multi, button_pot, button_C, button_equal, button_sign;

    public void calculate(){ //未完成
//        String[] ary = string_tmp.split("");
        List<String> num = new ArrayList<>(),sign = new ArrayList<>();
        int string_len = string_tmp.length();
        int f = 0;
        boolean flag = false;
        result.setText("a");
        for(int i = 0; i<string_len; i++){
            if (!Character.isDigit(string_tmp.charAt(i))){
                num.add(tmp);
                sign.add(Character.toString(string_tmp.charAt(i)));
            }
            else{
                tmp += string_tmp.charAt(i);
            }
//            result.setText(String.valueOf(f++));
        }

        int list_len = sign.size();
        while(true){
            list_len = sign.size();
            if(sign.size()<=0)break;
            flag = false;
            result.setText("b");
            for(int i = 0; i<list_len; i++){
                if(sign.get(i)=="*" || sign.get(i)=="÷"){
                    flag=true;
                    break;
                }
//                result.setText(num.get(0));
            }
            result.setText("ok");
            if(flag==true){
                for(int i = 0; i<list_len; i++){
                    if(sign.get(i)=="*"){
                        float a = Float.parseFloat(num.get(i)) * Float.parseFloat(num.get(i+1));
                        num.remove(i);
                        num.remove(i+1);
                        num.add(i, Float.toString(a));
                        sign.remove(i);
                        result.setText(Float.toString(a));
                        break;
                    }
                    else if(sign.get(i)=="÷"){
                        float a = Float.parseFloat(num.get(i)) / Float.parseFloat(num.get(i+1));
                        num.remove(i);
                        num.remove(i+1);
                        num.add(i, Float.toString(a));
                        sign.remove(i);
                        result.setText(Float.toString(a));
                        break;
                    }
                }
            }
            else{
                for(int i = 0; i<list_len; i++){
                    if(sign.get(i)=="+"){
                        float a = Float.parseFloat(num.get(i)) + Float.parseFloat(num.get(i+1));
                        num.remove(i);
                        num.remove(i+1);
                        num.add(i, Float.toString(a));
                        sign.remove(i);
                        result.setText(Float.toString(a));
                        break;
                    }
                    else if(sign.get(i)=="-"){
                        float a = Float.parseFloat(num.get(i)) - Float.parseFloat(num.get(i+1));
                        num.remove(i);
                        num.remove(i+1);
                        num.add(i, Float.toString(a));
                        sign.remove(i);
                        result.setText(Float.toString(a));
                        break;
                    }
                }
            }
        }
//        result.setText(num.get(0));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expression = (TextView) findViewById(R.id.expression);
        result = (TextView) findViewById(R.id.result);

        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_add = (Button) findViewById(R.id.button_add);
        button_sub = (Button) findViewById(R.id.button_sub);
        button_div = (Button) findViewById(R.id.button_div);
        button_multi = (Button) findViewById(R.id.button_multi);
        button_pot = (Button) findViewById(R.id.button_pot);
        button_C = (Button) findViewById(R.id.button_C);
        button_equal = (Button) findViewById(R.id.button_equal);
        button_sign = (Button) findViewById(R.id.button_sign);

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp += "0";
                expression.setText(string_tmp);
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "1";
                expression.setText(string_tmp);
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "2";
                expression.setText(string_tmp);
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "3";
                expression.setText(string_tmp);
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "4";
                expression.setText(string_tmp);
            }
        });
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "5";
                expression.setText(string_tmp);
            }
        });
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "6";
                expression.setText(string_tmp);
            }
        });
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "7";
                expression.setText(string_tmp);
            }
        });
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "8";
                expression.setText(string_tmp);
            }
        });
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string_tmp == "0") {string_tmp = "";}
                string_tmp += "9";
                expression.setText(string_tmp);
            }
        });
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp += "+";
                expression.setText(string_tmp);
            }
        });
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp += "-";
                expression.setText(string_tmp);
            }
        });
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp += "÷";
                expression.setText(string_tmp);
            }
        });
        button_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp += "x";
                expression.setText(string_tmp);
            }
        });
        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp = "";
                expression.setText(string_tmp);
                result.setText(string_tmp);
            }
        });
        button_pot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp += ".";
                expression.setText(string_tmp);
            }
        });
        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp += ".";
                expression.setText(string_tmp);
//                calculate();
            }
        });
        button_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_tmp += "-";
                expression.setText(string_tmp);
            }
        });
    }
}