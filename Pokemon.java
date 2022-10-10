import java.util.Random;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Graphics;

/**
 * The abstract Pokemon for the PokeBattle Simulation
 *
 * @author cproenza3
 * @version 2
 */
public abstract class Pokemon {

    private Rectangle bounds;
    private int xPos;
    private int yPos;
    private ImageIcon image;
    private int level = 1;
    private int health = 100;

    /**
     * Constructor
     *
     * Represents a Pokemon in the PokeWorld. Each Pokemon
     * has a location in the world and attributes which help
     * it reproduce and thrive.
     * @param xPos The X position of this Pokemon
     * @param yPos The Y position of this Pokemon
     * @param bounds The boundaries of the PokeWorld where
     *               the Pokemon can exist
     */
    public Pokemon(int xPos, int yPos, Rectangle bounds) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bounds = bounds;
    }

    /**
    * sets the x position
    * @param newXPos dummy variable for x position
    */
    public void setXPos(int newXPos) {
        this.xPos = newXPos;
    }

    /**
     * @return the X position of this Pokemon
     */
    public int getXPos() {
        return xPos;
    }

    /**
    * sets the y position
    * @param newYPos dummy variable for y position
    */
    public void setYPos(int newYPos) {
        this.yPos = newYPos;
    }

    /**
     * @return the Y position of this Pokemon
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * @return the bounding rectangle of the PokeWorld
     *             that this Pokemon exists in
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
    * sets the health
    * @param health is the health
    */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
    * getter for the health
    * @return the health
    */
    public int getHealth() {
        return health;
    }

    /**
    * sets the health
    * @param level is the level
    */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
    * getter for the health
    * @return the level
    */
    public int getLevel() {
        return level;
    }

    /**
    * Sets the image attribute for this pokemon
    * @param image the ImageIcon to use to represent this Pokemon
    */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * Should draw the Pokemon at its location.
     * @param g object for drawing use
     */
    public void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }

    /**
    * determines how a defalut pokemon with no overidden move method moves
    */
    public void move() {
        Random r = new Random();
        int num = 10 * (r.nextInt(3) - 1);
        xPos += num;
        yPos += num;
        level++;
        health--;
        if (xPos >= getBounds().getWidth() - 90) {
            xPos = (int) getBounds().getWidth() - 90;
        }
        if (xPos <= 0) {
            xPos = 0;
        }
        if (yPos >= getBounds().getHeight() - 90) {
            yPos = (int) getBounds().getHeight() - 90;
        }
        if (yPos <= 0) {
            yPos = 0;
        }
    }

    /**
    * determines the condition for collision with other pokemon
    * @param otherPokemon is the pokemon being collided with
    * @return if two pokemon collide
    */
    public boolean collidesWithPokemon(Pokemon otherPokemon) {
        if (Math.abs(this.xPos - otherPokemon.xPos) <= 90
            && Math.abs(this.yPos - otherPokemon.yPos) <= 90) {
            return true;
        }
        return false;
    }

    /**
    * determines the condition for reproduction
    * @param otherPokemon is the pokemon being reproduced with
    * @return is whether or not it can reproduce
    */
    public abstract boolean canReproduceWithPokemon(Pokemon otherPokemon);

    /**
    * determines if they reproduce
    * @param otherPokemon is the pokemon being reproduced with
    * @return is the pokemon that is created
    */
    public abstract Pokemon reproduceWithPokemon(Pokemon otherPokemon);

    /**
    * determines if the max level is reached. 50 is the default if it isn't
    * overidden in a subclass
    * @return if the boolean is true or false
    */
    public boolean isOld() {
        if (level > 50) {
            return true;
        }
        return false;
    }

    /**
    * determines if a pokemon can harm another
    * @param otherPokemon is the pokemon being fought
    * @return if the pokemon harms another
    */
    public abstract boolean canHarmPokemon(Pokemon otherPokemon);

    /**
    * takes 10 away from health if canHarmPokemon is true
    * @param otherPokemon is the pokemon being harmed
    */
    public void harmPokemon(Pokemon otherPokemon) {
        if (canHarmPokemon(otherPokemon)) {
            health -= 10;
        }
    }

    /**
    * sets health to 0 and makes the pokemon faint
    */
    public void faint() {
        health = 0;
    }

    /**
    * determines if the pokemon faints
    * @return if the pokemon faints
    */
    public boolean hasFainted() {
        if (isOld()) {
            return true;
        } else if (health <= 0) {
            return true;
        }
        return false;
    }

}
