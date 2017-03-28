package com.esp.retrofitexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.esp.retrofitexample.API.GetList;
import com.esp.retrofitexample.Bean.Contact;
import com.esp.retrofitexample.Bean.GetListBean;
import com.esp.retrofitexample.Utils.Configs;
import com.esp.retrofitexample.Utils.ResponseListener;

import java.util.ArrayList;

public class GetListActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private GetListBean myBean;
    private GetList getList;
    private ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getlist);
        lvList = (ListView) findViewById(R.id.lvList);
        progressDialog = new ProgressDialog(GetListActivity.this);
        progressDialog.show();
        getList = new GetList(responseListener);

    }

    public ResponseListener responseListener = new ResponseListener() {
        @Override
        public void onResponce(String tag, int result, Object obj) {
            progressDialog.dismiss();
            if (tag.equals(Configs.TAG_USERLOGIN) && result == Configs.RESULT_OK) {
                myBean = (GetListBean) obj;
                if (myBean.contacts != null) {
                    ArrayList<String> stringArrayList = new ArrayList<>();
                    for (Contact contact : myBean.contacts) {
                        stringArrayList.add(contact.id + "\n" + contact.name);
                    }
                    lvList.setAdapter(new ArrayAdapter<String>(GetListActivity.this, android.R.layout.simple_list_item_1, stringArrayList));
                }
            } else {
                System.out.println("=====" + obj.toString());
            }
            getList = null;
        }
    };

}
