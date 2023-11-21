import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Penguin extends Actor
{
    public void act()
    {
        if (Greenfoot.isKeyDown("a"))
        {
            move(-2);
        }
        if (Greenfoot.isKeyDown("d"))
        {
            move(2);
        }
    }
}
