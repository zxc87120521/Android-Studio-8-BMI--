package com.example.android_num8_bmiabnormal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bmi_Answer();
    }
    //返回上一頁
    public void back_pageA(View v){
        finish();
    }
    private void bmi_Answer(){

        double height;
        double weight;
        double bmi ;
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null){
            DecimalFormat nf = new DecimalFormat("0.00");
            height = Double.parseDouble(bundle.getString("Height")) / 100;
            weight = Double.parseDouble(bundle.getString("Weight"));

            bmi = weight / (height * height);

            TextView bmitit = (TextView)findViewById(R.id.BMI_value);
            bmitit.setText(nf.format(bmi));
            TextView abnormal = (TextView)findViewById(R.id.Ans);
            //判斷式
            if (bmi < 18){
                abnormal.setText("Abnormal(Weight to thin)");
            }
            else if (bmi > 24){
                abnormal.setText("Abnormal(Weight to Heavy)");
            }
            else
                abnormal.setText("Normal(Weight Normal)");
        }
    }
}