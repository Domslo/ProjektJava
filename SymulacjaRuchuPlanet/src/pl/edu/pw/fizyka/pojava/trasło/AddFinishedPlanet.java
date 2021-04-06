//Adrian Traczewski
package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import pl.edu.pw.fizyka.pojava.tras³o.MakePlanet.ButtonReturnListener;

public class AddFinishedPlanet extends JFrame {

	JButton buttonCancel, buttonAddPlanet, buttonReturn;
	JComboBox<String> listPlanets;
	JPanel panelMain, panelTop1, panelTop2, panelPicture, panelList, panelListAndPicture, panelBottom;
	JLabel labelAddFinishedPlanet, labelList;
	JTextField textFieldDescription;
	String planets[]= {"Merkury","Wenus","Ziemia","Mars","Jowisz","Saturn","Uran","Neptun"};
	
	public AddFinishedPlanet() throws HeadlessException {
		super(" Symulacja ruchu planetarnego ");
		this.setSize(800,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panelMain = new JPanel();
		panelMain.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		this.add(panelMain);
		
		//panele panelTop1 i panelTop2, przycisk buttonReturn, etykieta labelMakePlanet;
		panelTop1 = new JPanel();
		panelTop1.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.blue));
		labelAddFinishedPlanet = new JLabel("<html><font color=purple>Dodaj gotow¹ planetê!!</font>");
		labelAddFinishedPlanet.setHorizontalAlignment(JLabel.CENTER);
		panelTop1.add(labelAddFinishedPlanet);
		panelMain.add(panelTop1);
		
		panelTop2 = new JPanel();
		panelTop2.setLayout(new BoxLayout(panelTop2, BoxLayout.X_AXIS));
		buttonReturn = new JButton("Powrót");
		buttonReturn.setAlignmentX(LEFT_ALIGNMENT);
		buttonReturn.addActionListener(new ButtonReturnListener());
		panelTop2.add(buttonReturn);
		panelTop2.add(Box.createRigidArea(new Dimension(3*this.getWidth(),0)));
		panelMain.add(panelTop2);
		
		//panelList i panelPicture
		panelListAndPicture = new JPanel(new GridLayout(1,2));
		
		panelList = new JPanel();
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.Y_AXIS));
		panelList.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		labelList = new JLabel("Wybierz z listy");
		listPlanets = new JComboBox<String>(planets);
		panelList.add(labelList);
		panelList.add(listPlanets);
		panelList.add(Box.createRigidArea(new Dimension(0,200)));
		panelListAndPicture.add(panelList);
		
		panelPicture = new JPanel();
		panelPicture.setPreferredSize(new Dimension(30,30));
		panelPicture.setBorder(BorderFactory.createLoweredBevelBorder());
		panelListAndPicture.add(panelPicture);
		panelMain.add(panelListAndPicture);
		
		//Opis planety
		panelMain.add(Box.createRigidArea(new Dimension(0,20)));
		textFieldDescription = new JTextField("Charakterystyka planety");
		textFieldDescription.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.blue));
		panelMain.add(textFieldDescription);
		
		//panel panelBottom
		panelBottom = new JPanel();
		panelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonCancel = new JButton("Anuluj");
		buttonAddPlanet = new JButton("Dodaj");
		panelBottom.add(buttonCancel);
		panelBottom.add(buttonAddPlanet);
		this.add(panelBottom,BorderLayout.SOUTH);
	}
	public class ButtonReturnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
