import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 2;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);        
        create();
        
    }
    
    //create game objects
    public void create()
    {
        // Create the fish object
        Penguin linux = new Penguin();
        addObject(linux,300,300);
        
        // Create a labal
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        createFish();
    }
    
    //End the game
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,300,200);
    }
    
    // Increase score
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if (score % 5 == 0)
        {
            level++;
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
}
