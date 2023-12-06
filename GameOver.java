import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tell user game is over
 * 
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,getWidth()/2,200);
        
        Label restartLabel = new Label("Click to restart", 30);
        addObject(restartLabel,getWidth()/2,300);
        
    }
    
    public void act(){
       if(Greenfoot.mouseClicked(null)){
            Greenfoot.setWorld(new TitleScreen());
        }  
    }
}
