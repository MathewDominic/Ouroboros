package com.cutlitstudios.snake;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

public class MyApplication extends Application{

    private static Context context;
	//Context context;

    public void onCreate(){
        super.onCreate();
        MyApplication.context = getApplicationContext();
        //MyApplication.mCurrentActivity =  
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
    private static Activity mCurrentActivity = null;
    public static Activity getCurrentActivity(){
          return mCurrentActivity;
    }
    public void setCurrentActivity(Activity mCurrentActivity){
          MyApplication.mCurrentActivity = mCurrentActivity;
    }
}