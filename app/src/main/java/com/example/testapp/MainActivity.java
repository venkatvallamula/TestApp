package com.example.testapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testapp.adapter.UserAdapter;
import com.example.testapp.model.Data;
import com.example.testapp.model.UserResponse;
import com.example.testapp.services.ServiceFactory;
import com.example.testapp.services.StackExchangeService;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    UserAdapter userAdapter;

    public MainActivity() {
        userAdapter = null;
    }

    TextView toolbarTitle;
    Button btnSearch;
    EditText edtSearch;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressDialog = new ProgressDialog(MainActivity.this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.app_name);
        btnSearch = (Button)findViewById(R.id.btn_search);
        edtSearch = (EditText)findViewById(R.id.edt_search);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setNestedScrollingEnabled(false);
        userAdapter = new UserAdapter();
        mRecyclerView.setAdapter(userAdapter);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiCall(edtSearch.getText().toString());
            }
        });
    }

    private void apiCall(String name) {
        progressDialog.show();
        StackExchangeService service = ServiceFactory.createRetrofitService(StackExchangeService.class, StackExchangeService.SERVICE_ENDPOINT);
        Map<String, String> params = new HashMap<String, String>();
        params.put("page", "1");
        params.put("pagesize", "20");
        params.put("fromdate", "1298764800");
        params.put("todate", "1298851200");
        params.put("order", "desc");
        params.put("sort", "reputation");
        params.put("inname",name);
        params.put("site", "stackoverflow");

        service.getUser(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserResponse>() {

                    @Override
                    public final void onCompleted() {
                        // do nothing
                        progressDialog.cancel();
                    }

                    @Override
                    public final void onError(Throwable e) {
                        Log.e("GithubDemo", e.getMessage());
                    }

                    @Override
                    public final void onNext(UserResponse response) {
                        userAdapter.addData(response, MainActivity.this);
                    }
                });

    }

}

