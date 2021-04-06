//Adrian Traczewski
package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CreatePlanet extends JPanel {

	JPanel panelTop, panelMain, planet1, planet2, planet3, planet4, planetRandom;
	JLabel labelCreatePlanet;
	public CreatePlanet() {
		
		this.setLayout(new BorderLayout());
		//panelTop
		panelTop = new JPanel();
		labelCreatePlanet = new JLabel("Stwórz wygl¹d swojej planety");
		panelTop.add(labelCreatePlanet);
		
		//panelMain
		panelMain = new JPanel(new GridLayout(1,5,30,0));
		planet1 = new JPanel();
		planet1.setBorder(BorderFactory.createLoweredBevelBorder());
		planet2 = new JPanel();
		planet2.setBorder(BorderFactory.createLoweredBevelBorder());
		planet3 = new JPanel();
		planet3.setBorder(BorderFactory.createLoweredBevelBorder());
		planet4 = new JPanel();
		planet4.setBorder(BorderFactory.createLoweredBevelBorder());
		planetRandom = new JPanel();
		planetRandom.setBorder(BorderFactory.createLoweredBevelBorder());
		panelMain.add(planet1);
		panelMain.add(planet2);
		panelMain.add(planet3);
		panelMain.add(planet4);
		panelMain.add(planetRandom);
		
		this.add(panelTop,BorderLayout.NORTH);
		this.add(panelMain);
	}
}
