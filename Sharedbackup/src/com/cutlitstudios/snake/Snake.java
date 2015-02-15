package com.cutlitstudios.snake;


import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;

import java.util.Random;

public class Snake{

	private int c = 10;
	public int centerX=500;
	public int centerY=400;
	public  int wx=25*randInt(2,30),wy=25*randInt(10,40);
	public int over=0;
	public int bf=0, rand, superMode=0,super1=0;
	public int score=0;
	public int flag=0;
	int[] multipleFoodX = new int[10];
	int[] multipleFoodY = new int[10];
	public int bx,by, superModex,superModey,wormMode=0,invincibleMode=0, multipleMode=0, shorteningMode=0,check=1,wormHole1=0,wormHole2=0;
	int[] wormHoleX1 = new int[10];
	public int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	public Snake() {
		x[0]=50;
		y[0]=50;
		x[1]=49;
		y[1]=50;
		x[2]=48;
		y[2]=50;
		x[3]=47;
		y[3]=50;
		x[4]=46;
		y[4]=50;
		x[5]=45;
		y[5]=50;
		x[6]=44;
		y[6]=50;
		x[7]=43;
		y[7]=50;
		x[8]=42;
		y[8]=50;
		x[9]=41;
		y[9]=50;
	}
	
	private int speedX = 25;
	private int speedY = 0;
	int[] x = new int[1000];
	int[] y = new int[1000];
    int[] wormX1={300,300,300,100};
    int[] wormX2={600,600,500,650};
    int[] wormY1={300,900,250,900};
    int[] wormY2={600,600,750,350};
	
	public void updatePos()
	{
		if (centerX + speedX > 774) 
		{
			centerX = ((centerX + speedX)%775);
		}
		
		if(centerX + speedX < 24)
		{
			//centerX = (centerX + speedX)+775;
			centerX = (centerX + speedX)+750;
		}
		else
		{                        
                        centerX += speedX;
                        
        }

		// Updates Y Position
	
		if (centerY + speedY > 1025) {
			centerY = ((centerY + speedY)%1025)+175;
		}
		if(centerY + speedY < 201) {
			centerY = (centerY + speedY)+825;
		}
		else
		{                        
                        centerY += speedY;
        }
		
		for(int i=(c-1);i>0;i--)
		{
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		x[0]=centerX;
		y[0]=centerY;
		for(int i=1;i<c;i++)
		{
			if((centerX==x[i]) && (centerY==y[i]))
				over=1;
				
		}
	}

	public void update() {
	


		//			ordinary food check
		
		
		if((centerX==wx && centerY==wy) || (centerX==(wx-5) && centerY==(wy-5))
				|| (centerX==wx && centerY==wy-5) || (centerX==wx+5 && centerY==wy-5)
				|| (centerX==wx-5 && centerY==wy) || (centerX==wx+5 && centerY==wy)
				|| (centerX==wx-5 && centerY==wy+5) || (centerX==wx && centerY==wy+5)
				|| (centerX==wx+5 && centerY==wy+5))
		{
			
			c=c+3;
			//for(int j=1; j<=c;j++)
			
		
			check+=1;	
			if(invincibleMode==1)
				score+=10;
			score+=10;
			wx=25*randInt(2,30);
			wy=25*randInt(10,40);
			for(int k=0;k<getCnt();k++) 
			{
				if(wx==x[k]&&wy==y[k])
				{
					wx=25*randInt(2,30);
					wy=25*randInt(10,40);
					k=0;
				}
			}
			}	
		
		
		// 		bonus food check
		
		
		
		if(bf==1)
		{
		if((centerX==bx && centerY==by) || (centerX==(bx+25) && centerY==(by))
				|| (centerX==bx && centerY==by+25) || (centerX==bx+25 && centerY==by+25))
		{
			c=c+3;
			bf=0;
			score+=50;
		}
		}
		
		
		
		//		super mode food check
		
		
		/* if(superMode==1 && ((centerX==superModex && centerY==superModey) || (centerX==(superModex+1) && centerY==(superModey-1))
				|| (centerX==superModex+2 && centerY==superModey-2) || (centerX==superModex+3 && centerY==superModey-3)
				|| (centerX==superModex+4 && centerY==superModey-4) || (centerX==superModex+5 && centerY==superModey-5)
				|| (centerX==superModex+6 && centerY==superModey-6) || (centerX==superModex+7 && centerY==superModey-7)
				|| (centerX==superModex-1 && centerY==superModey+1)))  */
		
		if(superMode>0)
		{
		if(((centerX==superModex && centerY==superModey) || (centerX==superModex && centerY==superModey+25)
				|| (centerX==superModex+25 && centerY==superModey) || (centerX==superModex+25 && centerY==superModey+25)))
		{
			if(superMode==1)
				invincibleMode=1;
			else if(superMode==2)
				multipleMode=1;
			else if(superMode==3)
				shorteningMode=1;
			superMode=0;
			check++;
		}
		}
		if(multipleMode==1)
		{
			for(int i=0;i<10;i++)
			{
				if((centerX==multipleFoodX[i] && centerY==multipleFoodY[i]) || (centerX==multipleFoodX[i]-1 && centerY==multipleFoodY[i]-5)
						|| (centerX==multipleFoodX[i] && centerY==multipleFoodY[i]-5) || (centerX==multipleFoodX[i]+1 && centerY==multipleFoodY[i]-5)
						|| (centerX==multipleFoodX[i]-1 && centerY==multipleFoodY[i]) || (centerX==multipleFoodX[i]+1 && centerY==multipleFoodY[i])
						|| (centerX==multipleFoodX[i]-1 && centerY==multipleFoodY[i]+5) || (centerX==multipleFoodX[i] && centerY==multipleFoodY[i]+5)
						|| (centerX==multipleFoodX[i]+1 && centerY==multipleFoodY[i]+5))
				{
					multipleFoodY[i]=2000;
					multipleFoodX[i]=2000;
					score+=10;
					check+=1;
				}
			}
		}
		if(shorteningMode==1)
		{
			for(int i=0;i<10;i++)
			{
				if((centerX==multipleFoodX[i] && centerY==multipleFoodY[i]) || (centerX==multipleFoodX[i]-1 && centerY==multipleFoodY[i]-5)
						|| (centerX==multipleFoodX[i] && centerY==multipleFoodY[i]-5) || (centerX==multipleFoodX[i]+1 && centerY==multipleFoodY[i]-5)
						|| (centerX==multipleFoodX[i]-1 && centerY==multipleFoodY[i]) || (centerX==multipleFoodX[i]+1 && centerY==multipleFoodY[i])
						|| (centerX==multipleFoodX[i]-1 && centerY==multipleFoodY[i]+5) || (centerX==multipleFoodX[i] && centerY==multipleFoodY[i]+5)
						|| (centerX==multipleFoodX[i]+1 && centerY==multipleFoodY[i]+5))
				{
					multipleFoodY[i]=2000;
					multipleFoodX[i]=2000;
					//score+=10;
					if(c>10)
					{
						for(int j=1; j<=10;j++)
						{
							x[c-j]=-50;
							y[c-j]=-50;
						}
						c-=3;	
					}
					check+=1;
				}
			}
		}
	
	}

	public void moveRight() {
		speedX = 25;
		
	}
	public void moveUp() {
		speedY = -25;
	}
	public void moveDown() {
		speedY = 25;
	}

	public void moveLeft() {
		speedX = -25;
	}

	public void stop() {
		speedX = 0;
		speedY = 0;
	}

	/*public void jump() {
		if (jumped == false) {
			speedY = -15;
			jumped = true;
		}

	}*/
	public Integer getCnt() {
		return c;
	}
	public Integer getCheck() {
		return check;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	/*public boolean isJumped() {
		return jumped;
	}*/

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	/*public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}*/

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	 
}