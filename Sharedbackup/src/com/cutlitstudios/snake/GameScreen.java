package com.cutlitstudios.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cutlitstudios.framework.Game;
import com.cutlitstudios.framework.Graphics;
import com.cutlitstudios.framework.Image;
import com.cutlitstudios.framework.Screen;
import com.cutlitstudios.framework.Input.TouchEvent;
import com.cutlitstudios.framework.implementation.AndroidGame;
import com.cutlitstudios.framework.implementation.OnSwipeTouchListener;
import com.cutlitstudios.snake.Assets;
import com.cutlitstudios.snake.MainMenuScreen;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class GameScreen extends Screen {
    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Ready;
    ImageView.OnTouchListener OnTouchListener;
    //OnSwipeTouchListener onSwipeTouchListener;

    // Variable Setup
    // You would create game objects here.

    int livesLeft = 1,i,rand;
    int x1=0,x2=0,y1=0,y2=0,dx=0,dy=0,tu=0;
    private static Snake robot;
    private static SettingsScreen settings;
    int sec=0, bs=0,superModeStart=0,multipleModeEnd=0,shorteningModeEnd=0, f=0, mode=0,highScore=0;
    Paint paint;
    int superFlag=0,wormFlag=0,wormModeEnd=0,invincibleFlag=0,invincibleModeEnd=0,multipleFlag=0,shorteningFlag=0;
    public GameScreen(Game game) {
        super(game);

        // Initialize game objects here
       // Typeface astro=Typeface.createFromFile("assets/Fonts/ASTRONAU.TTF");
        robot = new Snake();
        settings = new SettingsScreen(game);      // Defining a paint object
        
       // TextView tx = (TextView)findViewById(R.id.textview1);
       // Typeface custom_font = Typeface.createFromAsset(getAssets(), "Fonts/ASTRONAU.TTF");
      
        Context context1=MyApplication.getAppContext();
       Typeface astro = Typeface.createFromAsset(context1.getAssets(),"ASTRONAU.TTF");

        paint = new Paint();
      paint.setTypeface(astro);
        paint.setTextSize(70);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        //paint.setTypeface(astro);

    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        // We have four separate update methods in this example.
        // Depending on the state of the game, we call different update methods.
        // Refer to Unit 3's code. We did a similar thing without separating the
        // update methods.

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
        {
            updateGameOver(touchEvents);
        }
    }

    private void updateReady(List<TouchEvent> touchEvents) {
        
        // This example starts with a "Ready" screen.
        // When the user touches the screen, the game begins. 
        // state now becomes GameState.Running.
        // Now the updateRunning() method will be called!
        
      //  if (touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        
        //This is identical to the update() method from our Unit 2/3 game.
        
        
        // 1. All touch input is handled here:
        
    	
    	
    	
    	
    	
    	int len = touchEvents.size();
        Graphics g = game.getGraphics();
        
        for (int i = 0; i < len; i++) {

        	TouchEvent event = touchEvents.get(i);
            
        		
            if (event.type == TouchEvent.TOUCH_DOWN)
            {
            	x1=event.x;
            	y1=event.y;
            }
            if (event.type == TouchEvent.TOUCH_UP)
            {
            	x2=event.x;
            	y2=event.y;
            	dx=(x2-x1);
                dy=(y2-y1);
                tu=1;
            }
            
            if((tu==1) && (Math.abs(dx)>Math.abs(dy)))
            {
            		if(dx>0)
            		{
            			if(!(robot.getSpeedX()<0))
                    	{
                    	robot.stop();
                        robot.moveRight();
                    	}
            		}
            		else
            		{
            			if(!(robot.getSpeedX()>0))
                    	{
                    	robot.stop();
                        robot.moveLeft();
                    	}
            		}
            		tu=0;
            }
            if((tu==1) && (Math.abs(dx)<=Math.abs(dy)))
            {
            		if(dy>0)
            		{
            			if(!(robot.getSpeedY()<0))
                    	{
                    	robot.stop();
                        robot.moveDown();
                    	}
            		}
            		else
            		{
            			if(!(robot.getSpeedY()>0))
                    	{
                    	robot.stop();
                        robot.moveUp();
                    	}
            		}
            		tu=0;
            }
            
            
            
            	/*if (inBounds(event, 0, 1080, 250, 200))
            	{
                	
                	if(!(robot.getSpeedX()>0))
                	{
                	robot.stop();
                    robot.moveLeft();
                	}
                }

                else if (inBounds(event, 500, 1080, 250, 200)) {
                	if(!(robot.getSpeedX()<0))
                	{
                	robot.stop();
                    robot.moveRight();
                	}
                }
                
                else if (inBounds(event, 0, 880, 800, 200)) {
                	if(!(robot.getSpeedY()>0))
                	{
                	robot.stop();
                    robot.moveUp();
                	}
                }

                else if (inBounds(event, 250, 1080, 250, 200)) {
                	if(!(robot.getSpeedY()<0))
                	{
                	robot.stop();
                    robot.moveDown();
                	}
                }

            }*/
        	


            /*if (event.type == TouchEvent.TOUCH_UP) {

                if (event.x < 640) {
                    // Stop moving left.
                }

                else if (event.x > 640) {
                    // Stop moving right. }
                }
            }*/

            
        }
        
        // 2. Check miscellaneous events like death:
        
        if(robot.over==1 && robot.invincibleMode!=1) {
            state = GameState.GameOver;
            
        }
        
        
        // 3. Call individual update() methods here.
        // This is where all the game updates happen.
        // For example, robot.update();
        if(sec%(25-(3*settings.speed))==0)
        	robot.updatePos();
        robot.update();
        //View.invalidate();
    }
    private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

    private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) 
			{
				if (inBounds(event, 300, 1000, 200, 240))
				{
					resume();
				}
				if (inBounds(event, 500, 1000, 200, 240)) 
				{
					nullify();
					goToMenu();
				}
				if (inBounds(event, 100, 1000, 200, 240)) 
				{
					nullify();
					game.setScreen(new GameScreen(game)); 
				}
			}
		}
	}

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) 
            {
            	//if (event.y>1000)
            	if (inBounds(event, 301, 945, 200, 190))
            	{
            		nullify();
            		game.setScreen(new GameScreen(game));
            	}
            	/*else
                {
                    nullify();
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }*/
            }
        }

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        sec++;

        // First draw the game elements.

        // Example:
        // g.drawImage(Assets.background, 0, 0);
        // g.drawImage(Assets.character, characterX, characterY);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void nullify() {

        // Set all variables to null. You will be recreating them in the
        // constructor.
    	robot = null;
        paint = null;

        // Call garbage collector to clean up memory.
        System.gc();
    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 64, 64, 64);
        /*g.drawString("Tap each side of the screen to move in that direction.",
               640, 300, paint);*/

    }

    private void drawRunningUI() 
    {
        Graphics g = game.getGraphics();
        
        if(settings.mode==0)
        {
        	g.drawARGB(255, 37, 37, 37);
        	g.drawImage(Assets.retrobg, 0 , 0);
        	g.drawImage(Assets.modernscreen, 0 , 220);
        	
        }
        else
        {
        	//g.drawARGB(155, 98, 146, 151);
        	g.drawARGB(255, 32, 32, 32);
        	g.drawImage(Assets.modernscreen,0 , 220);
        }
        g.drawString(String.valueOf(robot.getCenterX()), 400,100,paint);
        g.drawString(String.valueOf(robot.getCenterY()), 400,200,paint);
        //g.drawString(String.valueOf(sec), 700,200,paint);
        g.drawString(String.valueOf(robot.score), 200,170,paint);
        g.drawString(String.valueOf(robot.getCheck()), 100,100,paint);
        //g.drawString("Check=" + String.valueOf(robot.getCheck()), 10,10,paint);
        //g.drawString(String.valueOf(settings.mode), 400,1250,paint);
        //g.drawString("Mode value    ----"+String.valueOf(settings.mode), 800,1250,paint);
        
        //g.drawString(String.valueOf(y1), 250,600,paint);
        //g.drawString(String.valueOf(x2), 60,700,paint);
        //g.drawString(String.valueOf(y2), 250,700,paint);
       // g.drawString(String.valueOf(dx), 60,800,paint);
      //  g.drawString(String.valueOf(dy), 250,800,paint);
        //g.drawString(String.valueOf(tu), 60,900,paint);
        
        /*if(robot.over==1 && robot.invincibleMode!=1)
		{
			g.drawString("GAME OVER", 35, 50,paint);
			g.drawString("Your score is "+(robot.score), 30, 70,paint);				
		}
        else
		{*/	
			 //BONUS FOOD
			
        	
			if((sec%2000)==0)
			{
				if(robot.bf==0)
				{
					robot.bf=1;
					bs=sec;
				}
			}
			if(sec>=bs && sec<=(bs+300) && robot.bf==1)
			{
				if(f==0)
				{
					robot.bx=25*robot.randInt(2,29);
					robot.by=25*robot.randInt(11,39);
					f=1;
				}
				if(settings.mode==0)
					g.drawImage(Assets.retbon, robot.bx , robot.by);
				if(settings.mode==1)
					g.drawImage(Assets.modbon, robot.bx , robot.by);
				//g.drawString(String.valueOf(robot.bx),50,50 ,paint);
				//*g.drawString(String.valueOf(robot.by),50,70 ,paint);
			}
			else
			{
				if((sec%500)!=0)
				{
					robot.bf=0;
					f=0;
				}
			} 
        	//	 		SUPER MODES
			
				
			if((robot.getCheck()%5)==0)
			{
				if(robot.superMode==0)
				{
					//robot.superMode=robot.randInt(1,3);
					robot.superMode=1;
					superModeStart=sec;
				}
			}
			if(sec>=superModeStart && sec<=(superModeStart+500) && robot.superMode>0)
			{
				if(superFlag==0)
				{
					robot.superModex=25*robot.randInt(2,29);
					robot.superModey=25*robot.randInt(11,39);
					for(int k=0;k<robot.getCnt();k++) 
					{
						if(robot.superModex==robot.x[k]&&robot.superModey==robot.y[k])
						{
							robot.superModex=25*robot.randInt(2,30);
							robot.superModey=25*robot.randInt(10,40);
							k=0;
						}
					}	
					superFlag=1;
				}
				if(robot.superMode==1)
				{
					if(settings.mode == 0)
						g.drawImage(Assets.sf1Ret, robot.superModex, robot.superModey);
					else
						g.drawImage(Assets.sf1Mod, robot.superModex, robot.superModey);
				}
				if(robot.superMode==2)
				{

					if(settings.mode == 0)
						g.drawImage(Assets.sf2Ret, robot.superModex, robot.superModey);
					else
						g.drawImage(Assets.sf2Mod, robot.superModex, robot.superModey);
					
				}
				if(robot.superMode==3)
				{

					if(settings.mode == 0)
						g.drawImage(Assets.sf3Ret, robot.superModex, robot.superModey);
					else
						g.drawImage(Assets.sf3Mod, robot.superModex, robot.superModey);
				}
				g.drawString(String.valueOf(superModeStart+500-sec), 700, 200,paint);
			}
			else
			{
				if((robot.getCheck()%5)!=0)
				{
					robot.superMode=0;
					superFlag=0;
				}
			}
			//		WORMHOLE
			if(sec%1000==0)
				robot.wormMode=1;
			if(robot.wormMode==1)
			{
				if(wormFlag==0)
				{
					wormFlag=1;
					wormModeEnd=sec+200;
					rand=robot.randInt(0,3);
					
				}
				if(settings.mode==1)
				{
					g.drawImage(Assets.wormholeMod, (robot.wormX1[rand]-9) , (robot.wormY1[rand]-9));
					g.drawImage(Assets.wormholeMod, (robot.wormX2[rand]-9) , (robot.wormY2[rand])-9);
				}
				else
				{
					g.drawImage(Assets.wormholeRet, robot.wormX1[rand] , robot.wormY1[rand]);
					g.drawImage(Assets.wormholeRet, robot.wormX2[rand] , robot.wormY2[rand]);
				}	
			}
			if(wormModeEnd<=sec)
			{
				robot.wormMode=0;
				wormFlag=0;
				wormModeEnd=1000000;
			}
			if(robot.wormMode==1)
			{   
				if(robot.centerX==robot.wormX1[rand] && robot.centerY==robot.wormY1[rand] && robot.wormHole2==0)
				{
					robot.centerX=robot.wormX2[rand];
					robot.centerY=robot.wormY2[rand];
					robot.wormHole1=1;
				}
			}
			if(robot.wormHole2==1)
				robot.wormHole2=0;
			if(robot.wormMode==1)
			{   
				if(robot.centerX==robot.wormX2[rand] && robot.centerY==robot.wormY2[rand] && robot.wormHole1==0)
				{
					robot.centerX=robot.wormX1[rand];
					robot.centerY=robot.wormY1[rand];
					robot.wormHole2=1;
				}
			}
			if(robot.wormHole1==1)
				robot.wormHole1=0;
			
			
			
			//		1.INVINCIBLE MODE
			
			if(robot.invincibleMode==1)
			{
				if(invincibleFlag==0)
				{
					invincibleFlag=1;
					invincibleModeEnd=sec+500;
				}
				g.drawString("INVINCIBLE", 400, 1250,paint);
				g.drawString(" "+(invincibleModeEnd-sec)+" ", 400, 1175,paint);
			}
			if(invincibleModeEnd<=sec)
			{
				robot.invincibleMode=0;
				invincibleFlag=0;
				invincibleModeEnd=1000000;
				robot.over=0;
			}
			
			
			//		2. MULTIPLE MODE
			
			
			if(robot.multipleMode==1)
			{
				if(multipleFlag==0)
				{
					multipleFlag=1;
					multipleModeEnd=sec+300;
					for(i=0;i<3;i++)
					{
						robot.multipleFoodX[i]=25*robot.randInt(1,16);
						robot.multipleFoodY[i]=25*robot.randInt(10,25);
					}	
					for(;i<5;i++)
					{
						robot.multipleFoodX[i]=25*robot.randInt(16,30);
						robot.multipleFoodY[i]=25*robot.randInt(10,25);
					}
					for(;i<7;i++)
					{
						robot.multipleFoodX[i]=25*robot.randInt(1,16);
						robot.multipleFoodY[i]=25*robot.randInt(25,40);
					}
					for(;i<10;i++)
					{
						robot.multipleFoodX[i]=25*robot.randInt(16,30);
						robot.multipleFoodY[i]=25*robot.randInt(25,40);
					}
				}
				for(i=0;i<10;i++)
				{
					if(settings.mode==1)
						g.drawImage(Assets.multFood,robot.multipleFoodX[i],robot.multipleFoodY[i]);
					else
						g.drawImage(Assets.multFoodRet,robot.multipleFoodX[i],robot.multipleFoodY[i]);
				}
				g.drawString("Multiple Food", 400, 1250,paint);
				g.drawString(" "+(multipleModeEnd-sec)+" ", 400, 1175,paint);
				
			}
			if(multipleModeEnd<=sec)
			{
				robot.multipleMode=0;
				multipleFlag=0;
				multipleModeEnd=1000000;
			}
			
			//		3. SHORTENING MODE
			
			
			if(robot.shorteningMode==1)
			{
				if(shorteningFlag==0)
				{
					shorteningFlag=1;
					shorteningModeEnd=sec+300;
					for(i=0;i<3;i++)
					{
						robot.multipleFoodX[i]=25*robot.randInt(1,16);
						robot.multipleFoodY[i]=25*robot.randInt(10,25);
					}	
					for(;i<5;i++)
					{
						robot.multipleFoodX[i]=25*robot.randInt(16,30);
						robot.multipleFoodY[i]=25*robot.randInt(10,25);
					}
					for(;i<7;i++)
					{
						robot.multipleFoodX[i]=25*robot.randInt(1,16);
						robot.multipleFoodY[i]=25*robot.randInt(25,40);
					}
					for(;i<10;i++)
					{
						robot.multipleFoodX[i]=25*robot.randInt(16,30);
						robot.multipleFoodY[i]=25*robot.randInt(25,40);
					}
				}
				for(i=0;i<10;i++)
				{
					if(settings.mode==1)
						g.drawImage(Assets.shortFood,robot.multipleFoodX[i],robot.multipleFoodY[i]);
					else
						g.drawImage(Assets.shortFoodRet,robot.multipleFoodX[i],robot.multipleFoodY[i]);
				}
				g.drawString("Shortening", 400, 1250,paint);
				g.drawString(" "+(shorteningModeEnd-sec)+" ", 400, 1175,paint);
				
			}
			if(shorteningModeEnd<=sec)
			{
				robot.shorteningMode=0;
				shorteningFlag=0;
				shorteningModeEnd=1000000;
			}
		int ColCheck;
		if(settings.mode==0)
			g.drawImage(Assets.retrofood, robot.wx , robot.wy);
		else
			g.drawImage(Assets.food, robot.wx , robot.wy);
			
		for(int i=1;i<robot.getCnt();i++) 
        {
        	
        	if(settings.mode==0)
        	{	if(robot.y[i]>220)
        		{
        				g.drawImage(Assets.block, robot.x[i] , robot.y[i]);
        		}
        	}
        	else if(settings.mode==1 && robot.invincibleMode!=1)
        	{
        		if(robot.y[i]>220)
        		{
        			ColCheck=i%7;
        			switch(ColCheck)
        			{
        				case 0:
        					g.drawImage(Assets.sv, robot.x[i] , robot.y[i]);
        					break;
        				case 1:
        					g.drawImage(Assets.si, robot.x[i] , robot.y[i]);
        					break;
        				case 2:
        					g.drawImage(Assets.sb, robot.x[i] , robot.y[i]);
        					break;
        				case 3:
        					g.drawImage(Assets.sg, robot.x[i] , robot.y[i]);
        					break;
        				case 4:
        					g.drawImage(Assets.sy, robot.x[i] , robot.y[i]);
        					break;
        				case 5:
        					g.drawImage(Assets.so, robot.x[i] , robot.y[i]);
        					break;
        				case 6:
        					g.drawImage(Assets.sr, robot.x[i] , robot.y[i]);
        					break;
        				default:
        					break;
        			}
        		}
        	}
        	else if(settings.mode==1 && robot.invincibleMode==1)
        	{
        		if(robot.y[i]>220)
        		{
        			
        			if((invincibleModeEnd-sec)<100)
        			{	
        				if(((invincibleModeEnd-sec)%10)<5)
        					g.drawImage(Assets.modglow, robot.x[i] , robot.y[i]);
        			}
        			else
        				g.drawImage(Assets.modglow, robot.x[i] , robot.y[i]);
        					
        		}
        	}
        	if(settings.mode==0 && robot.invincibleMode==1)
        	{
        		if(robot.y[i]>220)
        			g.drawImage(Assets.retglow, robot.x[i] , robot.y[i]);
        	}
        }
		if(settings.mode==0) 
		{
			 if(robot.getSpeedX()>0)
				g.drawImage(Assets.rhr, robot.x[0] , robot.y[0]);
			if(robot.getSpeedX()<0)
				g.drawImage(Assets.rhl, robot.x[0] , robot.y[0]);
			if(robot.getSpeedY()>0)
				g.drawImage(Assets.rhd, robot.x[0] , robot.y[0]);
			if(robot.getSpeedY()<0)
				g.drawImage(Assets.rhu, robot.x[0] , robot.y[0]);  
		}
		else if(settings.mode==1 && robot.invincibleMode==1) 
		{
			if(robot.getSpeedX()>0)
				g.drawImage(Assets.imhr, robot.x[0] , robot.y[0]);
			if(robot.getSpeedX()<0)
				g.drawImage(Assets.imhl, robot.x[0] , robot.y[0]);
			if(robot.getSpeedY()>0)
				g.drawImage(Assets.imhd, robot.x[0] , robot.y[0]);
			if(robot.getSpeedY()<0)
				g.drawImage(Assets.imhu, robot.x[0] , robot.y[0]);
		}
			
		else if(settings.mode==1) 
		{
			if(robot.getSpeedX()>0)
				g.drawImage(Assets.mhr, robot.x[0] , robot.y[0]);
			if(robot.getSpeedX()<0)
				g.drawImage(Assets.mhl, robot.x[0] , robot.y[0]);
			if(robot.getSpeedY()>0)
				g.drawImage(Assets.mhd, robot.x[0] , robot.y[0]);
			if(robot.getSpeedY()<0)
				g.drawImage(Assets.mhu, robot.x[0] , robot.y[0]);
		}
    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        // Darken the entire screen so you can display the Paused screen.
        g.drawARGB(55, 0, 0, 0);
        g.drawImage(Assets.pause, 0, 0);
        g.drawString(String.valueOf(robot.score), 400,700,paint);
        /*g.drawString("Resume", 400, 165, paint);
		g.drawString("Menu", 400, 360, paint);
		g.drawString("New Game", 400, 560, paint); */
        //g.drawString(String.valueOf(highScore), 515, 181, paint);
        

    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        g.drawARGB(55, 0, 0, 0);
        g.drawImage(Assets.gameover, 0, 0);
        g.drawString(String.valueOf(robot.score), 400,700,paint);

        //High Scores
        SharedPreferences mPrefs;
        Context context1=MyApplication.getAppContext();
        mPrefs = context1.getSharedPreferences("label", 0);
        SharedPreferences.Editor mEditor = mPrefs.edit();
        highScore = mPrefs.getInt("tag", 0);
        if(robot.score>highScore)
        	{
        		mEditor.putInt("tag", robot.score).commit();
        	}        
        highScore = mPrefs.getInt("tag", 0);
        g.drawString(String.valueOf(highScore), 515, 181, paint);
        // AndroidGame thing = new AndroidGame();
        // thing.showad();
       /* MyBaseActivity activ = new MyBaseActivity();
       AdBuddiz.showAd(activ.adHelper()); // this = current Activity  */
        
        
        
    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {
    	if (state == GameState.Paused)
			state = GameState.Running;

    }
    private void goToMenu() {
		// TODO Auto-generated method stub
		game.setScreen(new MainMenuScreen(game));

	}
    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
    	if(state == GameState.GameOver)
    	{	
			//nullify();
			goToMenu();
		}
    	else if(state == GameState.Paused)
    	{
    		resume();
    	}
    		
    	else
    		pause();
    }
    protected final static String PREFS_NAME = "PREF_GAME_SCORE";

    public static int GetBestScore(Context context, int no) 
    {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
        return settings.getInt("Score" + String.valueOf(no), 0); // # 0 is the default value if no data is found
    }

    public static void SetBestScore(Context context, int no, int score)
    {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Score" + String.valueOf(no), robot.score);
        editor.commit();
    }
}




