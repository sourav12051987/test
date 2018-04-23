package com.vdopia.sdk21;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.vdopia.ads.lw.LVDOAdRequest;
import com.vdopia.ads.lw.LVDOConstants;
import com.vdopia.ads.lw.RewardedAdListener;
import com.vdopia.ads.lw.LVDORewardedAd;




public class MainActivity extends RequestPermissionActivity implements RewardedAdListener {
    private static final String TAG = "RewardedActivity";
    private LVDORewardedAd mRewardedAd;


    private enum CURRENT_AD_STATUS {
        NO_FILL("No Ad Found."),
        AD_LOADED("Ad is ready!"),
        IN_PROCESS("Pinging Demand Sources");

        private String statusDesc;

        CURRENT_AD_STATUS(String description) {
            this.statusDesc = description;
        }

        @Override
        public String toString() {
            return statusDesc;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //LinearLayout sc=(LinearLayout) findViewById(R.id.sc);
        //sc.setVisibility(View.INVISIBLE);
        mRewardedAd = LVDORewardedAd.getInstance();
        LVDOAdRequest adRequest = new LVDOAdRequest(this);

        //LocationData locationData = new LocationData(AdListActivity.this);
        //adRequest.setLocation(locationData.getDeviceLocation());

        adRequest.setAge("27");
        adRequest.setDmaCode("807");
        adRequest.setEthnicity("Asian");
        adRequest.setPostalCode("110096");
        adRequest.setCurrPostal("201301");
        adRequest.setMaritalStatus(LVDOAdRequest.LVDOMartialStatus.Single);
        //adRequest.setBirthday(Utils.getDate());
        adRequest.setGender(LVDOAdRequest.LVDOGender.MALE);

        adRequest.setRequester("Vdopia");
        adRequest.setAppBundle("chocolateApp");
        adRequest.setAppDomain("vdopia.com");
        adRequest.setAppName("VdopiaSampleApp");
        adRequest.setAppStoreUrl("play.google.com");
        adRequest.setCategory("prerollad");
        adRequest.setPublisherDomain("vdopia.com");
        mRewardedAd.fetchRewardAd(this,"p0XmSW", adRequest, this);
        Toast.makeText(getBaseContext(), "LOAD AD event called", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onPermissionsGranted(int requestCode) {
        Log.v(TAG, "On Permissions Granted");
        //getAdRequest();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void click(View v){

        Toast.makeText(getBaseContext(), "SHOW AD event called", Toast.LENGTH_SHORT).show();
        //LinearLayout sc=(LinearLayout) findViewById(R.id.sc);
        //sc.setVisibility(View.VISIBLE);
        //Intent toy=new Intent(MainActivity.this,Main2Activity.class);
        //startActivity(toy);

        //mRewardedAd.setAdRequest(adRequest);
        mRewardedAd.setRewardAdListener(MainActivity.this);
        mRewardedAd.showRewardAd("jq4glYbZqSRYB0Oz", "Chocolate1", "coin", "30");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onRewardedVideoLoaded(LVDORewardedAd rewardedAd) {
        Log.v(TAG, "Rewarded Video Loaded");
        /*runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setupUI(false);
            }
        });*/
    }

    @Override
    public void onRewardedVideoFailed(LVDORewardedAd rewardedAd, LVDOConstants.LVDOErrorCode errorCode) {
        Log.e(TAG, "Rewarded Video Failed with error" + errorCode);
        /*runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setupUI(false);
            }
        });*/
    }

    @Override
    public void onRewardedVideoShown(LVDORewardedAd rewardedAd) {
        Log.v(TAG, "Rewarded Video Shown");
    }

    @Override
    public void onRewardedVideoShownError(LVDORewardedAd rewardedAd, LVDOConstants.LVDOErrorCode errorCode) {
        Log.e(TAG, "Rewarded Video Shown Error : " + errorCode);
    }

    @Override
    public void onRewardedVideoDismissed(LVDORewardedAd rewardedAd) {
        Log.v(TAG, "Rewarded Video Dismissed");
    }

    @Override
    public void onRewardedVideoCompleted(LVDORewardedAd rewardedAd) {
        Log.v(TAG, "Rewarded Video Completed");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Thanks! You have earned 30 virtual coins.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


