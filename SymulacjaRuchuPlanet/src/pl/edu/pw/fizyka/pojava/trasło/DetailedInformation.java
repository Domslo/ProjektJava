package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DetailedInformation  extends JFrame {
	
	JPanel panelMain, panelTop1, panelTop2, panelTop3;
	JLabel label1, label2, label3;
	JButton buttonReturn;
	JTextArea text;
	
	public DetailedInformation() throws HeadlessException {
		super("Informacje szczegó³owe");
		this.setSize(800,400);
		this.setLocation(370,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panelMain = new JPanel();
		panelMain.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		this.add(panelMain);
		panelTop1 = new JPanel();
		panelTop1.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.blue));
		String tekst = "Dodane do symulacji planety to: \n";
		tekst += AddFinishedPlanet.str();
		tekst += MakePlanet.str();
		text = new JTextArea(tekst);
		
		text.setAlignmentX(CENTER_ALIGNMENT);
		panelTop1.add(text);
		panelMain.add(panelTop1);
		
		panelTop2 = new JPanel();
	
		buttonReturn = new JButton("Powrót");
		buttonReturn.setAlignmentX(LEFT_ALIGNMENT);
		buttonReturn.addActionListener(new ButtonReturnListener());
		panelTop2.add(buttonReturn);

		panelMain.add(panelTop2);

		panelTop3 = new JPanel();
		panelTop3.setLayout(new GridLayout(1,1));
		
		panelTop3 = new JPanel();
		label2 = new JLabel("Autorzy aplikacji: Dominika S³oma, Adrian Traczewski");
		label2.setAlignmentX(RIGHT_ALIGNMENT);
		
		panelTop3.add(label2);

		panelMain.add(panelTop3, BorderLayout.SOUTH);
		
	}
	public class ButtonReturnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}

}
