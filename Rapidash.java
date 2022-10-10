import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.Random;

/**
* Rapidash
* @author cproenza3
* @version 2
*/
public class Rapidash extends FireType {

    /**
     * Constructor
     * @param x The X position of Rapidash
     * @param y The Y position of Rapidash
     * @param bounds The bounding Rectangle
     */
    public Rapidash(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/rapidash.png"));
    }

    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        if (otherPokemon instanceof Rapidash) {
            Random r = new Random();
            int num = r.nextInt(100);
            if (num < 30) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (canReproduceWithPokemon(otherPokemon)
            && collidesWithPokemon(otherPokemon)) {
            return new Rapidash(getXPos(), getYPos(), getBounds());
        }
        return null;
    }

    @Override
    public boolean isOld() {
        if (getLevel() > 150) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (collidesWithPokemon(otherPokemon)) {
            Random r = new Random();
            int num = r.nextInt(100);
            if (otherPokemon instanceof GrassType && num < 50) {
                return true;
            } else if (otherPokemon instanceof WaterType && num < 30) {
                return true;
            } else if (otherPokemon instanceof FireType) {
                if (this.getLevel() > otherPokemon.getLevel() && num < 90) {
                    return true;
                } else if (this.getLevel() <= otherPokemon.getLevel() && num
                    < 12) {
                    return true;
                }
            }
        }
        return false;
    }
}