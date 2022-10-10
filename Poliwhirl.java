import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.Random;

/**
* Poliwhirl
* @author cproenza3
* @version 2
*/
public class Poliwhirl extends WaterType {

    /**
     * Constructor
     * @param x The X position of Poliwhirl
     * @param y The Y position of Poliwhirl
     * @param bounds The bounding Rectangle
     */
    public Poliwhirl(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/poliwhirl.png"));
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (otherPokemon instanceof Poliwhirl) {
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
            return new Poliwhirl(getXPos(), getYPos(), getBounds());
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (getLevel() > 200) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (collidesWithPokemon(otherPokemon)) {
            Random r = new Random();
            int num = r.nextInt(100);
            if (otherPokemon instanceof FireType && num < 50) {
                return true;
            } else if (otherPokemon instanceof GrassType && num < 30) {
                return true;
            } else if (otherPokemon instanceof WaterType) {
                //12% lower chance
                if (otherPokemon instanceof Poliwhirl && num < 35.2) {
                    return true;
                } else if (num < 40) {
                    return true;
                }
            }
        }
        return false;
    }
}
