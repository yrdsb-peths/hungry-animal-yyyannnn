import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    Label levelLabel;
    int level = 1;
    int numEggs = 0;
    
    /**
     * Constructor
     */
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);        
        create();
        
    }
    
    // Create game objects
    public void create()
    {
        // Create the fish object
        Penguin linux = new Penguin();
        addObject(linux,300,300);
        
        // Create a labal
        scoreLabel = new Label("Score: " + score,50);
        addObject(scoreLabel,90,38);
        
        levelLabel = new Label("Level: " + level,50);
        addObject(levelLabel,90,77);
        
        
        createFish();
    }
    
    /**
     * Go to game over world
     */
    public void gameOver()
    {
        Greenfoot.delay(5);
        World world = new GameOver();
        Greenfoot.setWorld(world);
    }
    
    /**
     * Increases score and level
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue("Score: " + score);
        
        if (score % 5 == 0)
        {
            level++;
            levelLabel.setValue("Level: " + level);
            numEggs++;
            
            for(int i = 0; i < numEggs; i++)
            {
                createEgg();
            }
        }
    }
    
    // Create fish anywhere at the top of the screen
    public void createFish(){
        Fish fish = new Fish();
        fish.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(fish,x,y);
    }
    
    public void createEgg(){
        Egg egg = new Egg();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(egg,x,y);
    }
    
    /**
     * Let game restart 
     */
    public void restart(){
        score = 0;
        level = 2;
        numEggs = 0;
    }
}
