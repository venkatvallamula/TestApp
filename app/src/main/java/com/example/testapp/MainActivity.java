package com.example.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(toolbar!=null){
            toolbar.setTitle("TestApp");
        }
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setNestedScrollingEnabled(false);
        userAdapter = new UserAdapter();
        mRecyclerView.setAdapter(userAdapter);

        apiCall();
    }

    private void apiCall() {
        StackExchangeService service = ServiceFactory.createRetrofitService(StackExchangeService.class, StackExchangeService.SERVICE_ENDPOINT);
        Map<String, String> params = new HashMap<String, String>();
        //fromdate=1298764800&todate=1298851200&order=desc&sort=reputation&site=stackoverflow
        params.put("fromdate", "1298764800");
        params.put("todate", "1298851200");
        params.put("order", "desc");
        params.put("sort", "reputation");
        params.put("site", "stackoverflow");
            service.getUser(params)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<UserResponse>() {
                        @Override
                        public final void onCompleted() {
                            // do nothing
                        }

                        @Override
                        public final void onError(Throwable e) {
                            Log.e("GithubDemo", e.getMessage());
                        }

                        @Override
                        public final void onNext(UserResponse response) {
                            userAdapter.addData(response,MainActivity.this);
                        }
                    });

    }

}

