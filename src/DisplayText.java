import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
A program to display text in different fonts using setFont() method of Font class
 */

public class DisplayText extends JPanel{
    String[] type = { "Serif", "SansSerif"};
    int[] styles = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD};
    String[] stylenames = {"Plain", "Italic", "Bold", "Bold & Italic"};

    /*
    Overwritten method from JComponent, inherited by JPanel
     */
    public void paint(Graphics g) {
        for(int f = 0; f < type.length; f++) {
            for(int s = 0; s < styles.length; s++) {
                Font font = new Font(type[f], styles[s], 18);
                g.setFont(font);
                String name = type[f] + " " + stylenames[s];
                g.drawString(name, 20, (f * 4 + s + 1) * 20);
            }
        }
    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        f.setContentPane(new DisplayText());
        f.setSize(400, 400);
        f.setVisible(true);
    }
}
