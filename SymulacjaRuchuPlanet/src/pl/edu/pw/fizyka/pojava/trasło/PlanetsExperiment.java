//Dominika S³oma
package pl.edu.pw.fizyka.pojava.tras³o;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class PlanetsExperiment extends JFrame {
	
	JPanel p1;
	JPanel p2;
	JPanel p3;
	
	Object selectedValue;
	Color wybranyKolor;

	public PlanetsExperiment() throws HeadlessException {
		
		super(" Symulacja ruchu planetarnego ");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(900,600);
 		this.setLocation(350,100);
 		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
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
					MakePlanet frame = new MakePlanet();
					frame.setVisible(true);
				}
				else if(selectedValue==wartosciWyboru[1]) {
					AddFinishedPlanet frame = new AddFinishedPlanet();
					frame.setVisible(true);
				}
			}
		 };
		 exitButton2.addActionListener(exitListener2);
		 p3.add(exitButton2,BorderLayout.NORTH);
		 p3.add(new JLabel());
		 p3.add(new JLabel());
		 p3.add(new JLabel());
		 
		 JButton  exitButton3 = new JButton(" Informacje szczegó³owe ");
		 ActionListener exitListener3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Autorzy: Dominika S³oma, Adrian Traczewski.", "Informacje", JOptionPane.QUESTION_MESSAGE);
			}
		 };
		 exitButton3.addActionListener(exitListener3);
		 p3.add(exitButton3);
		 p3.add(new JLabel());
		
		 JButton  exitButton4 = new JButton(" ON / OFF ");
		 ActionListener exitListener4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
					
				}	
			});
		 save.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
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
		PlanetsExperiment frame = new PlanetsExperiment();
		frame.setVisible(true);
	}
}
