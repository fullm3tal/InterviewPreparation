package com.fullm3tal.interviewpreparation;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
public class Activity_A extends BaseActivity {

    private static final String TAG=Activity_A.class.getSimpleName();
    private static int instanceCounter=0;
    private int currentInstanceValue;

    private Button buttonStartActivityA,buttonStartActivityB,buttonStartActivityC,buttonStartActivityD;
    private TextView textViewTaskInfo,textViewInstanceValue;

    public Activity_A(){
        super();
        instanceCounter++;
        currentInstanceValue=instanceCounter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        buttonStartActivityA= findViewById(R.id.buttonStartActivityA);
        buttonStartActivityB= findViewById(R.id.buttonStartActivityB);
        buttonStartActivityC= findViewById(R.id.buttonStartActivityC);
        buttonStartActivityD= findViewById(R.id.buttonStartActivityD);

        textViewTaskInfo= findViewById(R.id.textViewTaskInfo);
        textViewInstanceValue= findViewById(R.id.textViewInstanceValue);
        textViewInstanceValue.append(",Current instance: "+currentInstanceValue);

        buttonStartActivityA.setOnClickListener(v -> startActivity(this,Activity_A.class));
        buttonStartActivityB.setOnClickListener(v -> startActivity(this,Activity_B.class));
        buttonStartActivityC.setOnClickListener(v -> startActivity(this,Activity_C.class));
        buttonStartActivityD.setOnClickListener(v -> startActivity(this,Activity_D.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Instances: "+currentInstanceValue);
        textViewTaskInfo.setText(getAppTaskState());
    }
}
