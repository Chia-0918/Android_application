package com.example.hobbyselection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox mChkBoxMusic, mChkBoxSing, mChkBoxDance,
            mChkBoxTravel, mChkBoxReading, mChkBoxWriting,
            mChkBoxClimbing, mChkBoxSwim, mChkBoxExercise,
            mChkBoxFitness, mChkBoxPhoto, mChkBoxFood,
            mChkBoxPainting;
    private Button mBtnOK;
    private TextView mTxtHobby;
    private int hobby_array[] ={R.id.chkBoxMusic, R.id.chkBoxSing, R.id.chkBoxDance,
            R.id.chkBoxTravel, R.id.chkBoxReading, R.id.chkBoxWriting,
            R.id.chkBoxClimbing, R.id.chkBoxSwim, R.id.chkBoxExercise,
            R.id.chkBoxFitness, R.id.chkBoxPhoto, R.id.chkBoxFood,
            R.id.chkBoxPainting};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 從介面佈局檔取得介面元件
        mChkBoxMusic = findViewById(R.id.chkBoxMusic);
        mChkBoxSing = findViewById(R.id.chkBoxSing);
        mChkBoxDance = findViewById(R.id.chkBoxDance);
        mChkBoxTravel = findViewById(R.id.chkBoxTravel);
        mChkBoxReading = findViewById(R.id.chkBoxReading);
        mChkBoxWriting = findViewById(R.id.chkBoxWriting);
        mChkBoxClimbing = findViewById(R.id.chkBoxClimbing);
        mChkBoxSwim = findViewById(R.id.chkBoxSwim);
        mChkBoxExercise = findViewById(R.id.chkBoxExercise);
        mChkBoxFitness = findViewById(R.id.chkBoxFitness);
        mChkBoxPhoto = findViewById(R.id.chkBoxPhoto);
        mChkBoxFood = findViewById(R.id.chkBoxFood);
        mChkBoxPainting = findViewById(R.id.chkBoxPainting);
        mBtnOK = findViewById(R.id.btnOk);
        mTxtHobby = findViewById(R.id.txtHobby);

        // 設定Button的事件listener
        mBtnOK.setOnClickListener(btnOkOnClick);
        //
        mChkBoxMusic.setOnCheckedChangeListener(this);
        mChkBoxSing.setOnCheckedChangeListener(this);
        mChkBoxDance.setOnCheckedChangeListener(this);
        mChkBoxTravel.setOnCheckedChangeListener(this);
        mChkBoxReading.setOnCheckedChangeListener(this);
        mChkBoxWriting.setOnCheckedChangeListener(this);
        mChkBoxClimbing.setOnCheckedChangeListener(this);
        mChkBoxSwim.setOnCheckedChangeListener(this);
        mChkBoxExercise.setOnCheckedChangeListener(this);
        mChkBoxFitness.setOnCheckedChangeListener(this);
        mChkBoxPhoto.setOnCheckedChangeListener(this);
        mChkBoxFood.setOnCheckedChangeListener(this);
        mChkBoxPainting.setOnCheckedChangeListener(this);
    }

    private View.OnClickListener btnOkOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String s = getString(R.string.your_hobby);

            // 逐一檢查所有的CheckBox元件，記下使用者勾選的項目
            for(int i : hobby_array){
                CheckBox tmp;
                tmp = findViewById(i);
                if (tmp.isChecked()) {
                    if(s.length()==5)
                        s += tmp.getText().toString();
                    else
                        s += (", " + tmp.getText().toString());
                }
            }

            // 顯示勾選的興趣項目
            mTxtHobby.setText(s);
        }
    };

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String s = getString(R.string.your_hobby);

        // 逐一檢查所有的CheckBox元件，記下使用者勾選的項目
        for(int i : hobby_array){
            CheckBox tmp;
            tmp = findViewById(i);
            if (tmp.isChecked()) {
                if(s.length()==5)
                    s += tmp.getText().toString();
                else
                    s += (", " + tmp.getText().toString());
            }
        }

        // 顯示勾選的興趣項目
        mTxtHobby.setText(s);
    }
}
