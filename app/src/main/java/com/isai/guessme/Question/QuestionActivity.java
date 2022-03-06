package com.isai.guessme.Question;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.isai.guessme.R;

import java.util.Timer;
import java.util.TimerTask;

public class QuestionActivity extends AppCompatActivity {
    EditText etCmt;
    Button btnSubmit;
    Handler handler = new Handler(Looper.getMainLooper());
    private int count ;
    TextView tvCount;
    CardView cvCount;
    private Button btnTry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        etCmt = findViewById(R.id.et_cmt);
        btnSubmit = findViewById(R.id.btn_submit);
        btnTry = findViewById(R.id.btn_try);
        tvCount = findViewById(R.id.tv_count);
        cvCount = findViewById(R.id.cv_count);
        init();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etCmt.getText().toString().isEmpty()){
                    showMessage("Field cannot be empty");
                    btnTry.setVisibility(View.VISIBLE);
                    etCmt.setEnabled(true);
                }else {
                    showMessage("Answer submitted");
                }
                btnSubmit.setVisibility(View.INVISIBLE);
            }
        });
        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });
    }
    public void showMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void init() {
        count=0;
        cvCount.setVisibility(View.VISIBLE);
        tvCount.setText(String.valueOf(count));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        count++;
                        tvCount.setText(String.valueOf(count));
                        if (count == 30) {
                            timer.cancel();
                            btnSubmit.setVisibility(View.VISIBLE);
                            cvCount.setVisibility(View.GONE);
                            etCmt.setEnabled(false);
                        }
                    }
                });
            }
        }, 1000, 1000);
    }
}
