import java.awt.Rectangle;
import java.util.Random;

/**
 * A grass type pokemon
 *
 * @author cproenza3
 * @version 2
 */
public abstract class GrassType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of the Grass type Pokemon
     * @param y The Y position of the Grass type Pokemon
     * @param bounds The bounding Rectangle
     */
    public GrassType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    @Override
    public void move() {
        //random number between -1 and 1 is picked and then multiplied by 10
        //this random number is then how much the pokemon moves by in x and y
        Random r = new Random();
        int num = 10 * (r.nextInt(3) - 1);
        setXPos(getXPos() + num);
        setYPos(getYPos() + num);
        setLevel(getLevel() + 1);
        //movement inside the map
        if (getXPos() < (getBounds().getWidth() / 2)
            && getYPos() < (getBounds().getHeight() / 2)) {
            setHealth(getHealth() + 1);
        } else {
            setHealth(getHealth() - 1);
        }

        //handles outside of the map
        if (getXPos() >= getBounds().getWidth() - 90) {
            setXPos((int) getBounds().getWidth() - 90);
        }
        if (getXPos() <= 0) {
            setXPos(0);
        }
        if (getYPos() >= getBounds().getHeight() - 90) {
            setYPos((int) getBounds().getHeight() - 90);
        }
        if (getYPos() <= 0) {
            setYPos(0);
        }
    }

    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (collidesWithPokemon(otherPokemon)) {
            Random r = new Random();
            int num = r.nextInt(100);
            if (otherPokemon instanceof WaterType && num < 50) {
                return true;
            } else if (otherPokemon instanceof FireType && num < 30) {
                return true;
            } else if (otherPokemon instanceof GrassType && num < 40) {
                return true;
            } else if (otherPokemon instanceof SpecialType && num < 15) {
                return true;
            }
        }
        return false;
    }
}
