import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.Random;

/**
* Venusaur
* @author cproenza3
* @version 2
*/
public class Venusaur extends GrassType {

    /**
     * Constructor
     * @param x The X position of Venusaur
     * @param y The Y position of Venusaur
     * @param bounds The bounding Rectangle
     */
    public Venusaur(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/venusaur.png"));
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (otherPokemon instanceof Venusaur) {
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
            return new Venusaur(getXPos(), getYPos(), getBounds());
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (getLevel() > 100) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (collidesWithPokemon(otherPokemon)) {
            Random r = new Random();
            int num = r.nextInt(100);
            if (otherPokemon instanceof WaterType) {
                if (otherPokemon instanceof Poliwhirl && num < 70) {
                    return true;
                } else if (num < 50) {
                    return true;
                }
            } else if (otherPokemon instanceof FireType && num < 33) {
                //10% higher chance
                return true;
            } else if (otherPokemon instanceof GrassType && num < 40) {
                return true;
            }
        }
        return false;
    }
}
