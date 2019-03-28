package com.example.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.testapp.adapter.UserAdapter;
import com.example.testapp.model.Data;
import com.example.testapp.model.UserResponse;
import com.example.testapp.services.ServiceFactory;
import com.example.testapp.services.StackExchangeService;

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
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter();
        mRecyclerView.setAdapter(userAdapter);
        apiCall();
    }

    private void apiCall() {
        StackExchangeService service = ServiceFactory.createRetrofitService(StackExchangeService.class, StackExchangeService.SERVICE_ENDPOINT);
        for (String login : Data.githubList) {
            service.getUser(login)
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
                            userAdapter.addData(response);
                        }
                    });
        }
    }

}

