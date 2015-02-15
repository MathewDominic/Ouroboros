package com.cutlitstudios.snake;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.cutlitstudios.framework.Game;
import com.cutlitstudios.framework.Graphics;
import com.cutlitstudios.framework.Screen;
import com.cutlitstudios.framework.Input.TouchEvent;


public class SettingsScreen extends Screen {
    int speed=2,mode=1;
    Context context1 = MyApplication.getAppContext();
    SharedPreferences mPrefs1 = context1.getSharedPreferences("label1", 3);
    SharedPreferences.Editor mEditor = mPrefs1.edit();
    Paint paint;
    
	public SettingsScreen(Game game) 
    {
    	 super(game);
    	 speed = mPrefs1.getInt("speed", 3);
    	 mode = mPrefs1.getInt("mode", 3);
    	 Typeface astro = Typeface.createFromAsset(context1.getAssets(),"ASTRONAU.TTF");

    	 paint = new Paint();
    	 paint.setTypeface(astro);
         paint.setTextSize(95);
         paint.setTextAlign(Paint.Align.CENTER);
         paint.setAntiAlias(true);
         paint.setColor(Color.WHITE);
       
     }


    @Override
    public void update(float deltaTime) 
    {
        Graphics g = game.getGraphics(); 
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) 
        {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN)
            {
            	if (inBounds(event, 40, 280, 320, 350))
                {
                    mode=0;    
                }
            	if (inBounds(event, 440, 280, 320, 350))
                {
                    mode=1;    
                }
            	if (inBounds(event, 500, 900, 100, 100))
                {
                    if(speed<=7)
                    	speed++;    
                    
                }
                if (inBounds(event, 200, 900, 100, 100))
                {
                    if(speed>1)
                    	speed--;               
             
                }
                

            }
        }
        mEditor.putInt("speed", speed).commit();
        mEditor.putInt("mode", mode).commit();
        
       // g.drawString(String.valueOf(speed), 350, 865, paint);
    }


    private boolean inBounds(TouchEvent event, int x, int y, int width,
            int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        if(mode==0)
        	g.drawImage(Assets.settingsretro, 0, 0);
        else
        	g.drawImage(Assets.settingsmodern, 0, 0);
        g.drawString(String.valueOf(speed), 385, 950, paint);
    }


    @Override
    public void pause() {
    }


    @Override
    public void resume() {


    }


    @Override
    public void dispose() {


    }


    @Override
    public void backButton() {
        //Display "Exit Game?" Box
    	
    	game.setScreen(new MainMenuScreen(game));
    	


    }    
}