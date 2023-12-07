import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a sound button that allows player to mute/unmute the sound
 */
public class SoundButton extends Actor
{
    GreenfootImage soundOn = new GreenfootImage("images/soundOn.png");
    GreenfootImage soundOff = new GreenfootImage("images/soundOff.png");
    boolean isSound = true;
    
    /**
     * Contructor
     */
    public SoundButton(){
        soundOn.scale(30,50);
        soundOff.scale(40,55);
        setImage(soundOn);
    }
    
    /**
     * Always check if mouse is clicked
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            isSound();
        }
    }
    
    /**
     * Sets the volume of the sound
     */
    public void isSound()
    {
        isSound = !isSound;  
        
        if(isSound)
        {
           Penguin.setVolume(100);
           setImage(soundOn); 
        }else
        {
           Penguin.setVolume(0);
           setImage(soundOff); 
        }
    }
}
