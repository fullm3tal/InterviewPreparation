package com.fullm3tal.interviewpreparation;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
public class Activity_D extends BaseActivity {

    private static final String TAG=Activity_D.class.getSimpleName();
    private static int instanceCounter=0;
    private int currentInstanceValue;

    private Button buttonStartActivityA,buttonStartActivityB,buttonStartActivityC,buttonStartActivityD;
    private TextView textViewTaskInfo,textViewInstanceValue;

    public Activity_D(){
        super();
        instanceCounter++;
        currentInstanceValue=instanceCounter;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        buttonStartActivityA=(Button)findViewById(R.id.buttonStartActivityA);
        buttonStartActivityB=(Button)findViewById(R.id.buttonStartActivityB);
        buttonStartActivityC=(Button)findViewById(R.id.buttonStartActivityC);
        buttonStartActivityD=(Button)findViewById(R.id.buttonStartActivityD);

        textViewTaskInfo=(TextView)findViewById(R.id.textViewTaskInfo);
        textViewInstanceValue=(TextView)findViewById(R.id.textViewInstanceValue);
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
