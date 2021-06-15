package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class TexturePlanets extends JPanel {
	
	BufferedImage image;
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, 0,0,this.getWidth(),this.getHeight(), this);
    }
	
	public void setBackgroundImage(BufferedImage i) {
		image=i;
        repaint();
	}
}
