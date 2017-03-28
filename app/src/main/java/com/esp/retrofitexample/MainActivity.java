package com.esp.retrofitexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnGetList).setOnClickListener(this);
        findViewById(R.id.btnUploadData).setOnClickListener(this);
        findViewById(R.id.btnUploadDataWithFile).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnGetList:
                intent = new Intent(MainActivity.this, GetListActivity.class);
                startActivity(intent);
                break;
            case R.id.btnUploadData:
                break;
            case R.id.btnUploadDataWithFile:
                break;
        }
    }
}
