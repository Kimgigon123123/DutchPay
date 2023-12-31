package com.example.dutch_pay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_money;
    TextView tv_person, tv_money;
    Button btn_calculate, btn_plus, btn_minus, btn_reset;

    int person, money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt_money = findViewById(R.id.edt_money);
        tv_person = findViewById(R.id.tv_person);
        tv_money = findViewById(R.id.tv_money);
        btn_calculate = findViewById(R.id.btn_calculate);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_reset = findViewById(R.id.btn_reset);

        btn_calculate.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_calculate){
            try {
       

                if(Integer.parseInt(edt_money.getText().toString())%10 == 0) {
                    money = Integer.parseInt(edt_money.getText().toString());
                }else{
                    Toast.makeText(this, "올바른 금액을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }

            tv_money.setText(money/person+"");

        else if (v.getId() == R.id.btn_plus) {
            tv_person.setText(++person + "");
        } else if (v.getId() == R.id.btn_minus) {
            if (person <= 1) {
                Toast.makeText(this, "최소 1명 이상 있어야합니다.", Toast.LENGTH_SHORT).show();
            } else {
                tv_person.setText(--person + "");
            }
        }
         else if(v.getId()==R.id.btn_reset){

            person = 0;
            money =  0;
            tv_person.setText(person+"");
            tv_money.setText(money+"");
            edt_money.setText("");
        }
    }
}