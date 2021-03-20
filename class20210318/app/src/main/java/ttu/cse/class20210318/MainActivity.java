package ttu.cse.class20210318;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton age_1, age_2, age_3;
    RadioGroup title_sex, title_age;
    Button send;
    TextView title_seg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set RadioButton
        age_1 = (RadioButton) findViewById(R.id.age_1);
        age_2 = (RadioButton) findViewById(R.id.age_2);
        age_3 = (RadioButton) findViewById(R.id.age_3);
        // set RadioGroup
        title_sex = (RadioGroup) findViewById(R.id.sex);
        title_age = (RadioGroup) findViewById(R.id.age);
        // set Button
        send = (Button) findViewById(R.id.send);
        // set TextView
        title_seg = (TextView) findViewById(R.id.title_seg);

        title_sex.setOnCheckedChangeListener(radGrpGenderOnCheckedChange);
        title_age.setOnCheckedChangeListener(ageGrpGenderOnCheckedChange);
        send.setOnClickListener(this);
    }

    private RadioGroup.OnCheckedChangeListener radGrpGenderOnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            if(checkedId == R.id.sex_woman){
                age_1.setText(getString(R.string.womanAge_1));
                age_2.setText(getString(R.string.womanAge_2));
                age_3.setText(getString(R.string.womanAge_3));
            }
            else{
                age_1.setText(getString(R.string.manAge_1));
                age_2.setText(getString(R.string.manAge_2));
                age_3.setText(getString(R.string.manAge_3));
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener ageGrpGenderOnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            String strSug = getString(R.string.suggestion);

            switch (title_age.getCheckedRadioButtonId()) {
                case R.id.age_1:
                    strSug += getString(R.string.not_hurry);
                    break;
                case R.id.age_2:
                    strSug += getString(R.string.find_couple);
                    break;
                case R.id.age_3:
                    strSug += getString(R.string.get_married);
                    break;
            }

            // 把結果顯示在mTxtResult元件中
            title_seg.setText(strSug);
        }
    };

    @Override
    public void onClick(View v) {
        // 取得使用者輸入的性別和年齡
//            String strSex = mEdtGender.getText().toString();
//            int iAge = Integer.parseInt(mEdtAge.getText().toString());

        // 從字串資源取出預先定義好的suggestion字串
        String strSug = getString(R.string.suggestion);

        switch (title_age.getCheckedRadioButtonId()) {
            case R.id.age_1:
                strSug += getString(R.string.not_hurry);
                break;
            case R.id.age_2:
                strSug += getString(R.string.find_couple);
                break;
            case R.id.age_3:
                strSug += getString(R.string.get_married);
                break;
        }

        // 把結果顯示在mTxtResult元件中
        title_seg.setText(strSug);
    }
}