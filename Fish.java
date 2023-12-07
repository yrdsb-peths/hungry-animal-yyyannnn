import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 */
public class Fish extends Actor
{
    public int speed = 1;
    
    /**
     * Contructor
     */
    public Fish(){
        GreenfootImage image = new GreenfootImage("images/fish.png");
        image.scale(80,80);
        setImage(image);
    }
    
    /**
     * Always falls downward and check if it fell out of the world 
     */
    public void act()
    {
        // Fish falls downwards
        int x = getX();
        int y = getY() + speed;
        setLocation(x,y);
        
        // Game over when it gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
        
    }
    
    /**
     * Sets the speed of moving downward 
     */
    public void setSpeed(int spd){
        speed = spd;
    }
}
