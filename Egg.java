import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When penguin touches egg, game is over. 
 */
public class Egg extends Actor
{
    GreenfootImage egg = new GreenfootImage("images/egg.png");
    GreenfootImage cookedEgg = new GreenfootImage("images/eggCooked.png");
    public int speed = 1;
    public Egg(){
        egg.scale(30,50);
        cookedEgg.scale(80,80);
        setImage(egg);
    }   
    
    /**
     * Always move downward and check if the object(s) is touching the penguin
     */
    public void act()
    {
        // Egg falls downwards
        int x = getX();
        int y = getY() + speed;
        setLocation(x,y);
        
        
        // Game over if touching penguin 
        MyWorld world = (MyWorld) getWorld();
        if (isTouching(Penguin.class))
        {
            crack();
            world.gameOver();
        }
        
        if(getY() >= world.getHeight()){
            world.removeObject(this);
        }
    }
    
    /**
     * Change the image of the egg
     */
    public void crack()
    {
        setImage(cookedEgg);
    }
    
    public void setSpeed(int spd){
        speed = spd;
    }
}
