package ttu.cse.a20210311;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button clear_1;
    String text;
    EditText textMessage = (EditText)findViewById(R.id.textMessage);
    EditText textTO = (EditText)findViewById(R.id.textTO);
    EditText textSubject = (EditText)findViewById(R.id.textSubject);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        clear_1 = (Button) findViewById(R.id.clear_button_1);
//        clear_1.setOnClickListener(new view.OnClick);
    }

    public void clearAll(View view) {
        textTO.setText("");
        textMessage.setText("");
        textSubject.setText("");
    }
}