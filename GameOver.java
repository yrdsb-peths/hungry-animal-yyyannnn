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
        addObject(gameOverLabel,300,200);
        
        if(Greenfoot.mouseClicked(null)){
            World world = new TitleScreen();
            Greenfoot.setWorld(world);
        }
    }
}
