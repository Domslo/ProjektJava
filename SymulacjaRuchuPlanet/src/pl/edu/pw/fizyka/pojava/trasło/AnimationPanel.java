package pl.edu.pw.fizyka.pojava.tras³o;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

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
	int width=805;
	int height=740;
	int controlOnOff=0;
	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	double dt =0.0000001;
	int x,y;
	
	public AnimationPanel() {
		
	}
	public void addPlanet(List<Planet> pl) {
		planets=pl;
		repaint();
	}
	public void clearPlanet() {
		planets.clear();
		repaint();
	}
	public int width() {
		return this.getWidth();
	}
	public int height() {
		return this.getHeight();
	}
	public int getControlOnOff() {
		return controlOnOff;
	}
	void start() {
		controlOnOff=1;
		scheduler.execute(new Runnable() {
			public void run() {
				while(controlOnOff==1) {
					for(Planet pl: planets) {
						pl.setAngle(pl.getAngle()+pl.getSpeed()*dt);
					}
					for(Planet pl: planets) {
						
						x = (int) (pl.getRadiusOrb()*Math.cos(-pl.getAngle())+width/2- pl.getRadiusPl());
						y = (int) (pl.getRadiusOrb()*Math.sin(-pl.getAngle())+height/2- pl.getRadiusPl());
						
						pl.setX(x);
						pl.setY(y);
					}
					repaint();
				}
			}
		});
		/*scheduler.scheduleAtFixedRate((new Runnable() {
			//int angle = 0;
			public void run() {
				while(controlOnOff==1) {
					for(Planet pl: planets) {
						int speed=(int) (2*Math.PI/pl.getPeriod());
						int x = (int) (pl.getRadiusOrb()*Math.cos(pl.getAngle())+width/2);
						int y = (int) (pl.getRadiusOrb()*Math.sin(pl.getAngle())+height/2);
						pl.setAngle(pl.getAngle()+speed);
						pl.setX(x);
						pl.setY(y);
					}
					repaint();
				}
			}
		}), 0, 1,MILLISECONDS);*/

	}
	void stop(){
		controlOnOff=0;
	}
	void close() {
		scheduler.shutdown();
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
		g.drawImage(imageSun, width/2-10, height/2-10, 20, 20, this);
		for(Planet pl: planets) {
			pl.paint(g);
		}
	}
}
