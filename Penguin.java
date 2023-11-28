import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Penguin extends Actor
{
     //GreenfootSound penguinSound = new GreenfootSound("filename");
    GreenfootImage[] idleRight = new GreenfootImage[9];
    GreenfootImage[] idleLeft = new GreenfootImage[9];
    
    // Direction the penguin is facing
    String facing = "right";
    
    // Constructor 
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
        
        // Initial penguin
        setImage(idleRight[0]);
    }
    
    // Animation
    int imageIndex = 0;
    public void animatePenguin()
    {
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
    
    public void act()
    {
        
        if (Greenfoot.isKeyDown("left"))
        {
            move(-5);
            facing = "left";
            animatePenguin();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(5);
            facing = "right";
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
