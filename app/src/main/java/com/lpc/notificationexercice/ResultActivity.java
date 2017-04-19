package com.lpc.notificationexercice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.d("Hola","Hola desde ResultActivity");
        TextView textView1=(TextView)findViewById(R.id.textView1);
        TextView textView2=(TextView)findViewById(R.id.textView2);
        Bundle bundle=this.getIntent().getExtras();
        String messageInfo="";
        for (String key : bundle.keySet()){
            messageInfo+=""+key+" =>"+bundle.get(key)+";";
        }
        String nom=bundle.getString("Nom");
        String cognom=bundle.getString("Cognom");
        String edat=bundle.getString("Edat");
        textView1.setText("Hello "+nom+" "+cognom+". Welcome to the Result Activity");
        Log.d("Proba","Proba desde Result Activity");
        textView2.setText(messageInfo);
    }

}
