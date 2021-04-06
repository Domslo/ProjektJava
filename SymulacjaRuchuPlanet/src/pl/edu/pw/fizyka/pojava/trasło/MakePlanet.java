//Adrian Traczewski
package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MakePlanet extends JFrame {

	JLabel labelNamePlanet, labelMass, labelRadiusOrbit, labelOrbitalSpeed, labelMakePlanet;
	JTextField textFieldNamePlanet, textFieldMass, textFieldRadiusOrbit, textFieldOrbitalSpeed;
	JButton buttonCancel, buttonAddPlanet, buttonReturn;
	JPanel panelMain, panelCompleteData, panelCompleteDataLabel, panelCompleteDataTextField, panelCreateLook, panelTop1, panelTop2, panelBottom;
	
	public MakePlanet() throws HeadlessException {
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
		labelMakePlanet = new JLabel("<html><font color=purple>Stwórz w³asn¹ planetê!!</font>");
		labelMakePlanet.setHorizontalAlignment(JLabel.CENTER);
		panelTop1.add(labelMakePlanet);
		panelMain.add(panelTop1);
		
		panelTop2 = new JPanel();
		panelTop2.setLayout(new BoxLayout(panelTop2, BoxLayout.X_AXIS));
		buttonReturn = new JButton("Powrót");
		buttonReturn.setAlignmentX(LEFT_ALIGNMENT);
		buttonReturn.addActionListener(new ButtonReturnListener());
		panelTop2.add(buttonReturn);
		panelTop2.add(Box.createRigidArea(new Dimension(3*this.getWidth(),0)));
		panelMain.add(panelTop2);
		
		//panel panelCompleteData
		panelCompleteData = new JPanel();
		panelCompleteData.setLayout(new GridLayout(1,3));
		
		panelCompleteDataLabel = new JPanel();
		panelCompleteDataLabel.setLayout(new BoxLayout(panelCompleteDataLabel, BoxLayout.Y_AXIS));
		labelNamePlanet = new JLabel("Podaj nazwê planety:");
		labelNamePlanet.setAlignmentX(RIGHT_ALIGNMENT);
		labelMass = new JLabel("Podaj masê planety:");
		labelMass.setAlignmentX(RIGHT_ALIGNMENT);
		labelRadiusOrbit = new JLabel("Podaj promieñ orbity:");
		labelRadiusOrbit.setAlignmentX(RIGHT_ALIGNMENT);
		labelOrbitalSpeed = new JLabel("Podaj prêdkoœæ orbitaln¹:");
		labelOrbitalSpeed.setAlignmentX(RIGHT_ALIGNMENT);
		panelCompleteDataLabel.add(labelNamePlanet);
		panelCompleteDataLabel.add(Box.createGlue());
		panelCompleteDataLabel.add(labelMass);
		panelCompleteDataLabel.add(Box.createGlue());
		panelCompleteDataLabel.add(labelRadiusOrbit);
		panelCompleteDataLabel.add(Box.createGlue());
		panelCompleteDataLabel.add(labelOrbitalSpeed);
		panelCompleteDataLabel.add(Box.createGlue());
		
		panelCompleteDataTextField = new JPanel();
		panelCompleteDataTextField.setLayout(new BoxLayout(panelCompleteDataTextField,BoxLayout.Y_AXIS));
		textFieldNamePlanet = new JTextField("Nazwa planety");
		textFieldNamePlanet.setAlignmentX(LEFT_ALIGNMENT);
		textFieldMass = new JTextField("Masa planety");
		textFieldMass.setAlignmentX(LEFT_ALIGNMENT);
		textFieldRadiusOrbit = new JTextField("Promieñ orbity");
		textFieldRadiusOrbit.setAlignmentX(LEFT_ALIGNMENT);
		textFieldOrbitalSpeed  = new JTextField("Prêdkoœæ orbitalna");
		textFieldOrbitalSpeed.setAlignmentX(LEFT_ALIGNMENT);
		panelCompleteDataTextField.add(textFieldNamePlanet);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		panelCompleteDataTextField.add(textFieldMass);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		panelCompleteDataTextField.add(textFieldRadiusOrbit);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		panelCompleteDataTextField.add(textFieldOrbitalSpeed);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		
		panelCompleteData.add(panelCompleteDataLabel);
		panelCompleteData.add(panelCompleteDataTextField);
		panelCompleteData.add(Box.createRigidArea(new Dimension(3*this.getWidth(),0)));
		panelMain.add(panelCompleteData);
		
		//panel panelCreateLook
		panelCreateLook = new CreatePlanet();
		panelMain.add(panelCreateLook);
		
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
