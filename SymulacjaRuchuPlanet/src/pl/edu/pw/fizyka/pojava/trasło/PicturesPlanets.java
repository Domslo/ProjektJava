package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PicturesPlanets extends JPanel {
	
	BufferedImage image;
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, 60,5,this.getWidth()-122,this.getHeight()-10, this);
    }
	public void setBackgroundImage(BufferedImage i) {
		image=i;
        repaint();
	}
}
