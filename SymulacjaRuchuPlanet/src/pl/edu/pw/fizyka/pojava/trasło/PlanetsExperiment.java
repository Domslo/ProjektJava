//Dominika S³oma
package pl.edu.pw.fizyka.pojava.tras³o;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import java.awt.Graphics2D;

public class PlanetsExperiment extends JFrame {
	
	JPanel p1;
	AnimationPanel p2;
	JPanel p3;
	AddFinishedPlanet frame1;
	MakePlanet frame2;
	
	Object selectedValue;
	Color wybranyKolor;
	
	List<Planet> planets = new ArrayList<Planet>();
	
	public PlanetsExperiment() throws HeadlessException {
		
		super(" Symulacja ruchu planetarnego ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1150,800);
 		this.setLocation(200,0);
 		
		JPanel p1 = new JPanel();
		AnimationPanel p2 = new AnimationPanel();
		JPanel p3 = new JPanel();
		
		add(BorderLayout.WEST, p1);
		add(BorderLayout.CENTER, p2);
		add(BorderLayout.EAST, p3);
		
		p1.setBackground(Color.white);
		p2.setBackground(Color.black);
		p3.setBackground(Color.white);
		
		p1.setLayout(new BorderLayout());
		p3.setLayout(new GridLayout(9,1));

		 JButton  exitButton1 = new JButton(" Dowiedz siê wiêcej...");
		 ActionListener exitListener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FindOutMore frame1 = new FindOutMore();
				frame1.setVisible(true);
			}
		 };
		 exitButton1.addActionListener(exitListener1);
		 p1.add(exitButton1,BorderLayout.SOUTH);
		 p3.add(new JLabel());

		 JButton  exitButton2 = new JButton(" Dodaj planetê ");
		 ActionListener exitListener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] wartosciWyboru =  { "Stwórz w³asn¹ planetê", "Dodaj gotow¹ planetê",  };
				selectedValue = JOptionPane.showInputDialog( PlanetsExperiment.this, 
						"Wybierz jedna opcje:", 
						"Dodaj planetê ",
						JOptionPane.INFORMATION_MESSAGE, null, wartosciWyboru, wartosciWyboru[0]);	
				if(selectedValue==wartosciWyboru[0]) {
					frame2 = new MakePlanet();
					frame2.setVisible(true);
					frame2.setX0Y0(p2.width(), p2.height());
				}
				else if(selectedValue==wartosciWyboru[1]) {
					frame1 = new AddFinishedPlanet();
					frame1.setVisible(true);
					frame1.setX0Y0(p2.width(), p2.height());
				}
			}
		 };
		 exitButton2.addActionListener(exitListener2);
		 JButton addSelectedPlanets = new JButton ("Rysuj wybrane planety");
		 addSelectedPlanets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frame1!=null) {
					for(Planet pl: frame1.getPlanets()) {
						planets.add(pl);
					}
				}
				if(frame2!=null) {
					for(Planet pl: frame2.getPlanets()) {
						planets.add(pl);
					}
				}
				if(frame1==null && frame2==null) {
					JOptionPane.showMessageDialog(null, "Nie dodano ¿adnych planet", "Uwaga", JOptionPane.ERROR_MESSAGE);
				}
				p2.addPlanet(planets);
			}
		 });
		 p3.add(exitButton2,BorderLayout.NORTH);
		 p3.add(addSelectedPlanets);
		 p3.add(new JLabel());
		 p3.add(new JLabel());
		 p3.add(new JLabel());
		 
		 JButton  exitButton3 = new JButton(" Informacje szczegó³owe ");
		 ActionListener exitListener3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DetailedInformation frame2 = new DetailedInformation();
				frame2.setVisible(true);
			}
		 };
		 exitButton3.addActionListener(exitListener3);
		 p3.add(exitButton3);
		 p3.add(new JLabel());
		
		 JButton  exitButton4 = new JButton(" ON / OFF ");
		 ActionListener exitListener4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p2.getControlOnOff()==0) {
					p2.start();
				}
				else {
					p2.stop();
				}
			}
		 };
		 exitButton4.addActionListener(exitListener4);
		p3.add(exitButton4, BorderLayout.SOUTH);
		 
		 JMenuBar menuBar = new JMenuBar();
		 JMenu menu = new JMenu("Menu glowne");
		 menuBar.add(menu); 
		 setJMenuBar(menuBar);
		 JMenuItem nowy = new JMenuItem(" Nowy ");
		 menu.add(nowy);
		 JMenuItem save = new JMenuItem(" Zapisz ");
		 menu.add(save);
		 JMenuItem color = new JMenuItem(" Zmieñ kolor t³a ");
		 menu.add(color);
		 JMenuItem exit = new JMenuItem(" Zakoñcz ");
		 menu.add(exit);
		 
		 nowy.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					planets.clear();
					p2.clearPlanet();
					if(frame1!=null) {
						frame1.clearPlanets();
					}
					if(frame2!=null) {
						frame2.clearPlanets();
					}
				}	
			});
		 save.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser chooser = new JFileChooser();
					chooser.setDialogTitle("Zapisz plik");

					int result = chooser.showDialog(null, "Zapisz jako");
					@SuppressWarnings("unused")
					File currentFile;
					if (JFileChooser.APPROVE_OPTION == result) {

					if (result != JFileChooser.APPROVE_OPTION) {
							return;
							}
					try {
						currentFile = chooser.getSelectedFile();
						String fileName = chooser.getSelectedFile().getAbsolutePath();
								if (!fileName.endsWith(".png")) {
										fileName += ".png";
										currentFile = new File(fileName);
									}
									BufferedImage image = new BufferedImage(p2.getWidth(), p2.getHeight(), BufferedImage.TYPE_INT_ARGB);
									Graphics2D g2d = image.createGraphics();
									p2.paintAll(g2d);
									File outputfile = new File(fileName);
								    ImageIO.write(image, "png", outputfile);
										
					} 
					catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
					}	
				}	
			});
		
		 color.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					wybranyKolor = JColorChooser.showDialog(null, "Wybór koloru t³a", Color.WHITE);
					p1.setBackground(wybranyKolor);
					p3.setBackground(wybranyKolor);
				}	
			});
		 
		  exit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
						System.exit(0);	
				}	
			});
	}
	public PlanetsExperiment(GraphicsConfiguration gc) {
		super(gc);
	}
	public PlanetsExperiment(String title) throws HeadlessException {
		super(title);
	}
	public PlanetsExperiment(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PlanetsExperiment frame = new PlanetsExperiment();
				frame.setVisible(true);
			}
		});
	}
}
