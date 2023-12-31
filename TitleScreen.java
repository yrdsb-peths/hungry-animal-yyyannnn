import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * What player will see when in the beginning.
 */
public class TitleScreen extends World
{
    Bubble bubble = new Bubble();
    Label titleLabel = new Label("Hungry Penguin",60);
    Label author = new Label("By Yan", 25);

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
        addObject(author, 155, 130);
    }

    /**
     * The main world act loop
     */
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

        Label label3 = new Label("Don't touch the egg", 30);
        addObject(label3,461,157);
    }
}
