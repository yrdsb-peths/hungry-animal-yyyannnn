import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Bubble bubble = new Bubble();
    Label titleLabel = new Label("Hungry Penguin",60);

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(bubble, getWidth()/2, 92);
        addObject(titleLabel,getWidth()/2,92);
        prepare();
        act();
    }

    // The main world act loop
    public void act()
    {
        // Start the game if user presses the space bar
        if (Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Penguin penguin = new Penguin();
        addObject(penguin,68,189);
        
        Label label = new Label("Use \u2190 and \u2192 to move", 30);
        addObject(label,getWidth()/2,283);
        
        Label label2 = new Label("Press 'space' to start game", 30);
        addObject(label2,getWidth()/2,328);
        
    }
}
