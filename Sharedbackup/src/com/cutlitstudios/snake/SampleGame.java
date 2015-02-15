package com.cutlitstudios.snake;

import com.cutlitstudios.framework.Screen;
import com.cutlitstudios.framework.implementation.AndroidGame;

public class SampleGame extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this); 
    }
        
    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }
    
    
}