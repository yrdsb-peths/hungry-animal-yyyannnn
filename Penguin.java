import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Penguin extends Actor
{
     //GreenfootSound penguinSound = new GreenfootSound("filename");
    GreenfootImage[] idle = new GreenfootImage[9];
    
    // constructor 
    public Penguin()
    {
        for (int i = 0; i < idle.length; i++)
        {
            idle[i] =  new GreenfootImage("images/penguin_move/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    
    // animation
    int imageIndex = 0;
    public void animatePenguin()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        
        if (Greenfoot.isKeyDown("left"))
        {
            move(-5);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(5);
            animatePenguin();
        }
        
        eat();
    }
    
    //Will eat fish if touching and recreate it
    public void eat()
    {
        if (isTouching(Fish.class))
        {
            removeTouching(Fish.class);
            MyWorld world = (MyWorld) getWorld();
            world.createFish();
            world.increaseScore();
        }
    }
}
