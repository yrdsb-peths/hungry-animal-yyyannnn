import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Egg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Egg extends Actor
{
    
    public Egg(){
        GreenfootImage egg = new GreenfootImage("images/egg.png");
        egg.scale(30,50);
        setImage(egg);
    }   
    
    /**
     * Act - do whatever the Egg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Egg falls downwards
        int x = getX();
        int y = getY() + 2;
        setLocation(x,y);
        
        
        // Game over if touching penguin 
        MyWorld world = (MyWorld) getWorld();
        if (isTouching(Penguin.class))
        {
            crack();
            world.gameOver();
        }
    }
    
    public void crack()
    {
        GreenfootImage cookedEgg = new GreenfootImage("images/eggCooked.png");
        cookedEgg.scale(80,80);
        setImage(cookedEgg);
    }
}
