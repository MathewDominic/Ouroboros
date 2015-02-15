package com.cutlitstudios.snake;

import com.cutlitstudios.framework.Game;
import com.cutlitstudios.framework.Graphics;
import com.cutlitstudios.framework.Screen;
import com.cutlitstudios.framework.Graphics.ImageFormat;



public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("Main Menu-Recovered3.jpg", ImageFormat.RGB565);
        //Assets.block = g.newImage("Block2.png", ImageFormat.RGB565);
        Assets.block = g.newImage("Block2.png", ImageFormat.RGB565);
        Assets.head = g.newImage("Block2 - Copy.png", ImageFormat.RGB565);
        Assets.modbon = g.newImage("bonuswaffle.png", ImageFormat.RGB565);
        Assets.retbon = g.newImage("bonuswaffleretro.png", ImageFormat.RGB565);
        Assets.food = g.newImage("food.png", ImageFormat.RGB565);
        Assets.retrofood = g.newImage("retrofood.png", ImageFormat.RGB565);
        Assets.sf1Mod = g.newImage("inv (1).png", ImageFormat.RGB565);
        Assets.sf2Mod = g.newImage("multiple (1).png", ImageFormat.RGB565);
        Assets.sf3Mod = g.newImage("short (1).png", ImageFormat.RGB565);
        Assets.sf1Ret = g.newImage("invretro (1).png", ImageFormat.RGB565);
        Assets.sf2Ret = g.newImage("multipleretro (1).png", ImageFormat.RGB565);
        Assets.sf3Ret = g.newImage("shortretro (1).png", ImageFormat.RGB565);
        Assets.retroscreen = g.newImage("Middle.jpg", ImageFormat.RGB565);
        Assets.retrobg = g.newImage("retrobg.jpg", ImageFormat.RGB565);
        Assets.modernscreen = g.newImage("Middle3.png", ImageFormat.RGB565);
        Assets.sv = g.newImage("sv.png", ImageFormat.RGB565);
        Assets.si = g.newImage("si.png", ImageFormat.RGB565);
        Assets.sb = g.newImage("sb.png", ImageFormat.RGB565);
        Assets.sg = g.newImage("sg.png", ImageFormat.RGB565);
        Assets.sy = g.newImage("sy.png", ImageFormat.RGB565);
        Assets.so = g.newImage("so.png", ImageFormat.RGB565);
        Assets.sr = g.newImage("sr.png", ImageFormat.RGB565);
        Assets.mhd = g.newImage("modhd down (1).png", ImageFormat.RGB565);
        Assets.mhu = g.newImage("modhd up (1).png", ImageFormat.RGB565);
        Assets.mhl = g.newImage("modhd left (1).png", ImageFormat.RGB565);
        Assets.mhr = g.newImage("modhd right (1).png", ImageFormat.RGB565);
        Assets.imhd = g.newImage("gh down.png", ImageFormat.RGB565);
        Assets.imhu = g.newImage("gh up.png", ImageFormat.RGB565);
        Assets.imhl = g.newImage("gh left.png", ImageFormat.RGB565);
        Assets.imhr = g.newImage("gh right.png", ImageFormat.RGB565);
        Assets.rhd = g.newImage("rethd down.png", ImageFormat.RGB565);
        Assets.rhu = g.newImage("rethd up.png", ImageFormat.RGB565);
        Assets.rhl = g.newImage("rethd left.png", ImageFormat.RGB565);
        Assets.rhr = g.newImage("rethd right.png", ImageFormat.RGB565);
        Assets.modglow = g.newImage("glow.png", ImageFormat.RGB565);
        Assets.retglow = g.newImage("glowretro.png", ImageFormat.RGB565);
        /* Assets.settingsmodern = g.newImage("settingsmodern2.jpg", ImageFormat.RGB565);
        Assets.settingsretro = g.newImage("settingsretro2.jpg", ImageFormat.RGB565); */
        Assets.settingsmodern = g.newImage("settingsmodern2.jpg", ImageFormat.RGB565);
        Assets.settingsretro = g.newImage("settingsretro2.jpg", ImageFormat.RGB565);
        Assets.wormholeRet = g.newImage("wormholetretro.png", ImageFormat.RGB565);
        Assets.wormholeMod = g.newImage("wormhole.png", ImageFormat.RGB565);
        Assets.gameover = g.newImage("game over4.jpg", ImageFormat.RGB565);
        Assets.help = g.newImage("help2 (1).jpg", ImageFormat.RGB565);
        Assets.pause = g.newImage("pause 2.jpg", ImageFormat.RGB565);
        Assets.hiscore = g.newImage("high score.png", ImageFormat.RGB565);
        Assets.shortFood = g.newImage("shortfood.png", ImageFormat.RGB565);
        Assets.multFood = g.newImage("multiplefood.png", ImageFormat.RGB565);
        Assets.shortFoodRet = g.newImage("shortfoodretro.png", ImageFormat.RGB565);
        Assets.multFoodRet = g.newImage("multiplefoodretro.png", ImageFormat.RGB565);
        // Assets.click = game.getAudio().createSound("explode.ogg");  
        game.setScreen(new MainMenuScreen(game));


    }


    @Override
    public void paint(float deltaTime) {
    	


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


    }
}