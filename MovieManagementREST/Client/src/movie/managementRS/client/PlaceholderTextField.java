package movie.managementRS.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;

/**
 * Class that allow us to put a placeholder on a JTextField.
 * 
 * @author Maxime PINNA and Micaël DUPUIS
 *
 */
public class PlaceholderTextField extends JTextField {

	private static final long serialVersionUID = 1L;
	
	private String placeholder;

    public PlaceholderTextField(int columns) {
        super(columns);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        Graphics2D gd = (Graphics2D) g;
        
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setColor(Color.GRAY);
        gd.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
    }

    /**
     * Initialize the text of the placeholder in the JTextField.
     * 
     * @param s. The text of the placeholder.
     */
    public void setPlaceholder(String s) {
        placeholder = s;
    }

}