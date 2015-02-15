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
import com.purplebrain.adbuddiz.sdk.AdBuddiz;


public class MainMenuScreen extends Screen {
	Paint paint;
	int popUpHighScore=0;
    public MainMenuScreen(Game game) 
    {
        super(game);
        Context context1 = MyApplication.getAppContext();
        Typeface astro = Typeface.createFromAsset(context1.getAssets(),"ASTRONAU.TTF");
        
   	 	paint = new Paint();
   	 	paint.setTypeface(astro);
   	 	paint.setTextSize(95);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        
        
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics(); 
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        g.drawString("sdfeee", 200, 800, paint);
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {


                if (inBounds(event, 325, 561, 174, 169)) 
                {
                    //START GAME
                                game.setScreen(new GameScreen(game));               
                }
                if (inBounds(event, 500, 1000, 300, 300)) 
                {
                    //Settings
                        game.setScreen(new SettingsScreen(game));               
                }
                if (inBounds(event, 300, 1000, 200, 250)) 
                {
                    //High score
                	if(popUpHighScore==0)
                	popUpHighScore=1;
                	else
                		popUpHighScore=0;
                		//g.drawString("sdfeee", 300, 800, paint);
                	//game.setScreen(new SettingsScreen(game));
                }
                if (inBounds(event, 50, 1000, 200, 250)) 
                {
                    //Help
                    game.setScreen(new HelpScreen(game));               
                }
            }
        }
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
        g.drawImage(Assets.menu, 0, 0);
        if(popUpHighScore==1)
        	{
        	SharedPreferences mPrefs;
            Context context1=MyApplication.getAppContext();
            mPrefs = context1.getSharedPreferences("label", 0);
            //SharedPreferences.Editor mEditor = mPrefs.edit();
            int highScore = mPrefs.getInt("tag", 0);
            g.drawImage(Assets.hiscore, 0, 0);
            if(highScore>9)
            	g.drawString(String.valueOf(highScore), 364, 687, paint);
            else if(highScore>99)
            	g.drawString(String.valueOf(highScore), 345, 687, paint);
            else if(highScore>999)
            	g.drawString(String.valueOf(highScore), 327, 687, paint);
            else
            	g.drawString(String.valueOf(highScore), 385, 687, paint);
        	}
        
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
    	if(popUpHighScore==1) popUpHighScore=0;
    	else
    		System.exit(0);
    	


    }
    
    
}