import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the main character of the game.
 */
public class Penguin extends Actor
{
    static GreenfootSound penguinSound = new GreenfootSound("penguinSound.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[9];
    GreenfootImage[] idleLeft = new GreenfootImage[9];
    
    // Direction the penguin is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor 
     */
    public Penguin()
    {
        for (int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] =  new GreenfootImage("images/penguin_move/idle" + i + ".png");
            idleRight[i].scale(80,80);
        }
        
        for (int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] =  new GreenfootImage("images/penguin_move/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80,80);
        }
        
        animationTimer.mark();
        
        // Initial penguin
        setImage(idleRight[0]);
    }
    
    /**
     * Animation for penguin
     */
    int imageIndex = 0;
    public void animatePenguin()
    {
        if(animationTimer.millisElapsed() < 90)
        {
           return; 
        }
        animationTimer.mark();
        
        if (facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    /**
     * Check if arrow keys are pressed and check if penguin will eat fish 
     */
    public void act()
    {
        
        if (Greenfoot.isKeyDown("left"))
        {
            move(-4);
            facing = "left";
            animatePenguin();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(4);
            facing = "right";
            animatePenguin();
        }
        
        eat();
    }
    
    /**
     * Will play sound and eat fish if touching and recreate it 
     */
    public void eat()
    {
        if (isTouching(Fish.class))
        {
            penguinSound.play();
            removeTouching(Fish.class);
            MyWorld world = (MyWorld) getWorld();
            world.createFish();
            world.increaseScore();            
        }
    }
    
    /**
     * Will crack egg if touching
     */
    public void touchingEgg()
    {
        if (isTouching(Egg.class))
        {
            removeTouching(Egg.class);
            MyWorld world = (MyWorld) getWorld();
            world.createFish();
            world.increaseScore();
        }
    }
    
    /**
     * A static method that will set the volume of sound
     */
    public static void setVolume(int volume){
        penguinSound.setVolume(volume);
    }
}
