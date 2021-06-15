//Adrian Traczewski
package pl.edu.pw.fizyka.pojava.tras³o;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MakePlanet extends JFrame {

	int x0=805,y0=790;
	static String ss = "";
	List<Planet> planet = new ArrayList<Planet>();
	JComboBox<String> listPhotos;
	String photos[]= {"1","2","3","4"};
	JLabel labelNamePlanet, labelMass, labelOrbitalDistance, labelOrbitalSpeed, labelMakePlanet, labelRadiusPlanet, labelPeriod, labelPhoto;
	JTextField textFieldNamePlanet, textFieldMass, textFieldOrbitalDistance, textFieldOrbitalSpeed, textFieldRadiusPlanet, textFieldPeriod;
	JButton buttonCancel, buttonAddPlanet, buttonReturn;
	JPanel panelMain, panelCompleteData, panelCompleteDataLabel, panelCompleteDataTextField, panelCreateLook, panelTop1, panelTop2, panelBottom;
	BufferedImage image =null;
	
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
		//labelMass = new JLabel("Podaj masê planety:");
		//labelMass.setAlignmentX(RIGHT_ALIGNMENT);
		labelOrbitalDistance = new JLabel("Podaj odleg³oœæ od S³oñca [mln km]:");
		labelOrbitalDistance.setAlignmentX(RIGHT_ALIGNMENT);
		//labelOrbitalSpeed = new JLabel("Podaj prêdkoœæ orbitaln¹:");
		//labelOrbitalSpeed.setAlignmentX(RIGHT_ALIGNMENT);
		labelRadiusPlanet = new JLabel("Podaj promieñ planety [km]:");
		labelRadiusPlanet.setAlignmentX(RIGHT_ALIGNMENT);
		labelPeriod = new JLabel("Podaj okres obiegu wokó³ S³oñca[dni]:");
		labelPeriod.setAlignmentX(RIGHT_ALIGNMENT);
		labelPhoto = new JLabel("Wybierz wygl¹d (podaj numer obrazka):");
		labelPhoto.setAlignmentX(RIGHT_ALIGNMENT);
		panelCompleteDataLabel.add(labelNamePlanet);
		panelCompleteDataLabel.add(Box.createGlue());
		//panelCompleteDataLabel.add(labelMass);
		//panelCompleteDataLabel.add(Box.createGlue());
		panelCompleteDataLabel.add(labelOrbitalDistance);
		panelCompleteDataLabel.add(Box.createGlue());
		//panelCompleteDataLabel.add(labelOrbitalSpeed);
		//panelCompleteDataLabel.add(Box.createGlue());
		panelCompleteDataLabel.add(labelRadiusPlanet);
		panelCompleteDataLabel.add(Box.createGlue());
		panelCompleteDataLabel.add(labelPeriod);
		panelCompleteDataLabel.add(Box.createGlue());
		panelCompleteDataLabel.add(labelPhoto);
		panelCompleteDataLabel.add(Box.createGlue());
		
		panelCompleteDataTextField = new JPanel();
		panelCompleteDataTextField.setLayout(new BoxLayout(panelCompleteDataTextField,BoxLayout.Y_AXIS));
		textFieldNamePlanet = new JTextField("Nazwa planety");
		textFieldNamePlanet.setAlignmentX(LEFT_ALIGNMENT);
		//textFieldMass = new JTextField("Masa planety");
		//textFieldMass.setAlignmentX(LEFT_ALIGNMENT);
		textFieldOrbitalDistance = new JTextField("Odleg³oœæ od S³oñca");
		textFieldOrbitalDistance.setAlignmentX(LEFT_ALIGNMENT);
		//textFieldOrbitalSpeed = new JTextField("Prêdkoœæ orbitalna");
		//textFieldOrbitalSpeed.setAlignmentX(LEFT_ALIGNMENT);
		textFieldRadiusPlanet = new JTextField("Promieñ planety");
		textFieldRadiusPlanet.setAlignmentX(LEFT_ALIGNMENT);
		textFieldPeriod = new JTextField("Okres obiegu wokó³ S³oñca");
		textFieldPeriod.setAlignmentX(LEFT_ALIGNMENT);
		listPhotos = new JComboBox<String>(photos);	
		listPhotos.setAlignmentX(LEFT_ALIGNMENT);
		panelCompleteDataTextField.add(textFieldNamePlanet);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		//panelCompleteDataTextField.add(textFieldMass);
		//panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		panelCompleteDataTextField.add(textFieldOrbitalDistance);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		//panelCompleteDataTextField.add(textFieldOrbitalSpeed);
		//panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		panelCompleteDataTextField.add(textFieldRadiusPlanet);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		panelCompleteDataTextField.add(textFieldPeriod);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		panelCompleteDataTextField.add(listPhotos);
		panelCompleteDataTextField.add(Box.createRigidArea(new Dimension(0,this.getHeight()/20)));
		
		panelCompleteData.add(panelCompleteDataLabel);
		panelCompleteData.add(panelCompleteDataTextField);
		panelCompleteData.add(Box.createRigidArea(new Dimension(3*this.getWidth(),0)));
		panelMain.add(panelCompleteData);
		
		listPhotos.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0){
	        	URL resource = null;
	        	if(listPhotos.getSelectedIndex()==0) {
	        		resource = getClass().getResource("obrazki/tekstura1.jpg"); 
	        	}
	        	if(listPhotos.getSelectedIndex()==1) {
	        		resource = getClass().getResource("obrazki/tekstura2.jpg"); 
	        	}
	        	if(listPhotos.getSelectedIndex()==2) {
	        		resource = getClass().getResource("obrazki/tekstura3.jpg"); 
	        	}
	        	if(listPhotos.getSelectedIndex()==3) {
	        		resource = getClass().getResource("obrazki/tekstura4.jpg"); 
	        	}
	        	try {
		            image = ImageIO.read(resource);
		        } catch (IOException e) {
		            System.err.println("Blad odczytu obrazka");
		            e.printStackTrace();
		        }
	        }
	      });
		
		//panel panelCreateLook
		panelCreateLook = new CreatePlanet();
		panelMain.add(panelCreateLook);
		
		//panel panelBottom
		panelBottom = new JPanel();
		panelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonCancel = new JButton("Anuluj");
		buttonAddPlanet = new JButton("Dodaj");
		buttonAddPlanet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int o=0, x=0, y=0, r=0, r0=1, o0=5;
				double t0=0.3, t=0;
				
				float r1 = Float.parseFloat(textFieldRadiusPlanet.getText());
				r=(int) (r0*r1/2439.7);
				float o1 = Float.parseFloat(textFieldOrbitalDistance.getText());
				o = (int) (o0*o1/57.740)+10;
				float t1 = Float.parseFloat(textFieldPeriod.getText());
				t = t0*t1/87.969;
				x=x0/2+o-r;
				y=y0/2-r;
				ss += textFieldNamePlanet.getText();
        		ss += "- stworzona przez Ciebie planeta. \n";
        		ss += "Jej promieñ wynosi ";
        		ss += textFieldRadiusPlanet.getText();
        		ss += "\n";
        		
				Planet pl = new Planet();
				pl.setRadiusPl(r);
				pl.setRadiusOrb(o);
				pl.setX(x);
				pl.setY(y);
				pl.addImage(image);
				pl.setPeriod(t);
				pl.setIn(1);
				
				planet.add(pl);
			}
		});
		panelBottom.add(buttonCancel);
		panelBottom.add(buttonAddPlanet);
		this.add(panelBottom,BorderLayout.SOUTH);
	}
	public void setX0Y0(int xx0,int yy0) {
		x0=xx0;
		y0=yy0;
	}
	public List<Planet> getPlanets() {
		return planet;
	}
	public void clearPlanets() {
		planet.clear();
	}
	public static String str() {
		return ss;
    }
	public class ButtonReturnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
}
