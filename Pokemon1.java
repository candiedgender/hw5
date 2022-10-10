import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.Random;

/**
* Venusaur
* @author cproenza3
* @version 2
*/
public class Pokemon1 extends SpecialType {

    /**
     * Constructor
     * @param x The X position of Venusaur
     * @param y The Y position of Venusaur
     * @param bounds The bounding Rectangle
     */
    public Pokemon1(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        Random h = new Random();
        int i = h.nextInt(2);
        //this if statement gives it a 50% chance of using the mew or pikachu
        //image when you click
        if (i == 0) {
            setImage(new ImageIcon("../resources/mew.png"));
        } else {
            setImage(new ImageIcon("../resources/pikachu.png"));
        }

    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (otherPokemon instanceof Pokemon1) {
            Random r = new Random();
            int num = r.nextInt(100);
            if (num < 20) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (canReproduceWithPokemon(otherPokemon)
            && collidesWithPokemon(otherPokemon)) {
            return new Pokemon1(getXPos(), getYPos(), getBounds());
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (getLevel() > 125) {
            return true;
        }
        return false;
    }
}