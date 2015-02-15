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


public class HelpScreen extends Screen {
    
	public HelpScreen(Game game) 
    {
    	 super(game);       
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
            	if (inBounds(event, 300, 1100, 200, 180))
				{
					game.setScreen(new GameScreen(game));
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
        g.drawImage(Assets.help, 0, 0);
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