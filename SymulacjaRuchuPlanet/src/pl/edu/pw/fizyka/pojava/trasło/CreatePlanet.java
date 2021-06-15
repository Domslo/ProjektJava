package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreatePlanet extends JPanel {

	TexturePlanets planet1, planet2, planet3, planet4;
	JPanel panelTop, panelMain;
	JLabel labelCreatePlanet;
	public CreatePlanet() {
		
		BufferedImage image1 = null;
		BufferedImage image2 = null;
		BufferedImage image3 = null;
		BufferedImage image4 = null;
		
		URL resource1 = null;
		URL resource2;
		URL resource3;
		URL resource4;
			
		resource1 = getClass().getResource("obrazki/tekstura1.jpg"); 
		resource2 = getClass().getResource("obrazki/tekstura2.jpg"); 
		resource3 = getClass().getResource("obrazki/tekstura3.jpg"); 
		resource4 = getClass().getResource("obrazki/tekstura4.jpg"); 
		
		try {
            image1 = ImageIO.read(resource1);
            image2 = ImageIO.read(resource2);
            image3 = ImageIO.read(resource3);
            image4 = ImageIO.read(resource4);
            
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

		this.setLayout(new BorderLayout());
		//panelTop
		panelTop = new JPanel();
		labelCreatePlanet = new JLabel("Stwórz wygl¹d swojej planety");
		panelTop.add(labelCreatePlanet);
		
		//panelMain
		panelMain = new JPanel(new GridLayout(1,1,5,70));
		
		planet1 = new TexturePlanets();
		planet1.setBorder(BorderFactory.createLoweredBevelBorder());
		planet1.setBackgroundImage(image1);
		
		planet2 = new TexturePlanets();
		planet2.setBorder(BorderFactory.createLoweredBevelBorder());
		planet2.setBackgroundImage(image2);
		
		planet3 = new TexturePlanets();
		planet3.setBorder(BorderFactory.createLoweredBevelBorder());
		planet3.setBackgroundImage(image3);
		
		planet4 = new TexturePlanets();
		planet4.setBorder(BorderFactory.createLoweredBevelBorder());
		planet4.setBackgroundImage(image4);
		
		panelMain.add(planet1);
		panelMain.add(planet2);
		panelMain.add(planet3);
		panelMain.add(planet4);
		
		this.add(panelTop,BorderLayout.NORTH);
		this.add(panelMain);
	}
}
