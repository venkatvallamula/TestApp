package com.example.testapp.activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp.R;
import com.example.testapp.model.Item;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserDetails extends AppCompatActivity {
    private static final String TAG =UserDetails.class.getSimpleName() ;
    private Item item;
    TextView tvName;
    TextView tvReputation;
    TextView tvLocation;
    TextView tvAge;
    TextView tvDate;
    TextView tvBronze;
    TextView tvSilver;
    TextView tvGold;
    TextView toolbarTitle;

    ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        item = getIntent().getParcelableExtra("userDetails");
        toolbarTitle = (TextView)findViewById(R.id.toolbar_title);
        toolbarTitle.setText("User Details");
        tvName = (TextView)findViewById(R.id.tv_name);
        tvReputation = (TextView)findViewById(R.id.tv_reputation);
        tvLocation = (TextView)findViewById(R.id.tv_location);
        tvAge = (TextView)findViewById(R.id.tv_age);
        tvDate = (TextView)findViewById(R.id.tv_date);
        tvBronze = (TextView)findViewById(R.id.tv_bronze);
        tvSilver = (TextView)findViewById(R.id.tv_silver);
        tvGold = (TextView)findViewById(R.id.tv_gold);
        ivProfile = (ImageView)findViewById(R.id.iv_profile);

        tvName.setText(item.getDisplayName());
        tvReputation.setText(String.valueOf(item.getReputation()));
        tvLocation.setText(item.getLocation());
        SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = timeStampFormat.format(item.getCreationDate());
        tvAge.setText(getAge(item.getCreationDate()));
        tvDate.setText(date);
        tvBronze.setText("Bronze :"+String.valueOf(item.getBadgeCounts().getBronze()));
        tvSilver.setText("Silver :"+String.valueOf(item.getBadgeCounts().getSilver()));
        tvGold.setText("Gold :"+String.valueOf(item.getBadgeCounts().getGold()));
        Picasso.with(UserDetails.this)  //Here, this is context.
                .load(item.getProfileImage())  //Url of the image to load.
            .into(ivProfile);

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // onBackPressed();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private String getAge(int creationDate){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = timeStampFormat.format(creationDate);
        String [] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        dob.set(year, month, day);
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }
}
