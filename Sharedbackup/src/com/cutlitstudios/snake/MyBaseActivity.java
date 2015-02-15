package com.cutlitstudios.snake;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;

import android.app.Activity;
import android.os.Bundle;

public class MyBaseActivity extends Activity {
    protected MyApplication mMyApp;
    

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyApp = (MyApplication)this.getApplicationContext();
        AdBuddiz.setPublisherKey("57866925-4555-4ac4-a05d-7d518ace775f");
        AdBuddiz.cacheAds(this); // this = current Activity
    }
    protected void onResume() {
        super.onResume();
        AdBuddiz.showAd(this);
        mMyApp.setCurrentActivity(this);
    }
    protected void onPause() {
        clearReferences();
        super.onPause();
    }
    protected void onDestroy() {        
        clearReferences();
        super.onDestroy();
    }

    private void clearReferences(){
        Activity currActivity = mMyApp.getCurrentActivity();
        if (currActivity != null && currActivity.equals(this))
            mMyApp.setCurrentActivity(null);
    }
    public Activity adHelper()
    {
    	return this;
    }
    
}