import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
*This is the class that will run the Pokemon Battle.
*
*@author cproenza3
*@version 2
*/

public class PokeBattle {
    /**
    * Creates the Poke Battle
    * @param args does nothing in this class
    */
    public static void main(String[] args) {
        JFrame frame = new JFrame("PokeWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.WEST);
        frame.add(new PokeWorld(control)); //defaults to CENTER
        frame.pack();
        frame.setVisible(true);
    }
}