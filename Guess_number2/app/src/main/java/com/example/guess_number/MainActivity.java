package com.example.guess_number;

import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNum = 0, times = 0;
    Random random = new Random();
    TextView result;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        result = (TextView)findViewById(R.id.result);
        answer = (EditText)findViewById(R.id.answer);
        answer.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
//                    result.setText("Enter！");
                    checkAns(answer);
                }
                return false;
            }
        });
        //遊戲開始
        startGame();
    }

    public void checkAns(View v) {
        switch(v.getId()){
            case R.id.answer:
                int ansInt = Integer.valueOf(String.valueOf(answer.getText()));
                if(ansInt < randomNum){
                    result.setText("太小了，再試一次！");
                    times++;
                }
                else if(ansInt > randomNum){
                    result.setText("太大了，再試一次！");
                    times++;
                }
                else{
                    times++;
                    result.setText("正確答案，你總共猜了" + String.valueOf(times) + "次");
                }
        }
    }

    public void startGame(){
        randomNum = 1 + random.nextInt(100);//產生隨機數字
        times = 0;
    }

    public void playAgain(View view) {
        startGame();
        result.setText("你猜測的結果漿將顯示於此");
        answer.setText("");
    }
}