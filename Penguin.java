import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Penguin extends Actor
{
    public void act()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(2);
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
