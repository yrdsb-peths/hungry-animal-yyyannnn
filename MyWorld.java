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
    
    /**
     * Create game objects
     */
    public void create()
    {
        // Create the penguin object
        Penguin penguin = new Penguin();
        addObject(penguin,300,300);
        
        // Create a labal
        scoreLabel = new Label("Score: " + score,50);
        addObject(scoreLabel,90,38);
        
        levelLabel = new Label("Level: " + level,50);
        addObject(levelLabel,90,77);
        
        
        createFish();
        createSound();
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
    /**
     * Create fish anywhere at the top of the screen
     */
    public void createFish(){
        Fish fish = new Fish();
        fish.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(fish,x,y);
    }
    
    /**
     * Create egg anywhere at the top of the screen
     */
    public void createEgg(){
        Egg egg = new Egg();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(egg,x,y);
    }
    
    /**
     * Create the sound button
     */
    public void createSound(){
        SoundButton soundButton = new SoundButton();
        addObject(soundButton,570,35);
    }
}
