import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Penguin extends Actor
{
     //GreenfootSound penguinSound = new GreenfootSound("filename");
    GreenfootImage idle = new GreenfootImage("images/penguin_move/idle0.png");
    
    //Constructor 
    public Penguin()
    {
        setImage(idle);
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
