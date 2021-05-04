package pl.edu.pw.fizyka.pojava.tras³o;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AnimationPanel extends JPanel {
	
	List<Planet> planets = new ArrayList<Planet>();
	BufferedImage imageSun=null, imageBackground=null;
	public AnimationPanel() {
		
	}
	/*public void addPlanet(int r, int t,BufferedImage im) {
		Planet pl = new Planet();
		pl.setRadius(r);
		pl.addImage(im);
		pl.setPeriod(t);
		
		planets.add(pl);
	}*/
	public void addPlanet(List<Planet> pl) {
		planets=pl;
		repaint();
	}
	public int width() {
		return this.getWidth();
	}
	public int height() {
		return this.getHeight();
	}
	void start() {

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate((new Runnable() {
			public void run() {
				
				repaint();
			}
		}), 0, 10,SECONDS);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		URL resource = getClass().getResource("obrazki/slonce.png");
		try {
            imageSun = ImageIO.read(resource);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
		URL resource2 = getClass().getResource("obrazki/galaktyka2.jpg");
		try {
            imageBackground = ImageIO.read(resource2);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        g.drawImage(imageBackground, 0, 0,this.getWidth(),this.getHeight(), this);
		g.drawImage(imageSun, this.getWidth()/2, this.getHeight()/2, 20, 20, this);
		for(Planet pl: planets) {
			pl.paint(g);
		}
	}
}
