//Adrian Traczewski
package pl.edu.pw.fizyka.pojava.tras�o;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import pl.edu.pw.fizyka.pojava.tras�o.MakePlanet.ButtonReturnListener;

public class AddFinishedPlanet extends JFrame {

	JButton buttonCancel, buttonAddPlanet, buttonReturn;
	JComboBox<String> listPlanets;
	JPanel panelMain, panelTop1, panelTop2, panelList, panelListAndPicture, panelBottom;
	PicturesPlanets panelPicture; 
	JLabel labelAddFinishedPlanet, labelList;
	JTextArea textArea;
	String planets[]= {"Merkury","Wenus","Ziemia","Mars","Jowisz","Saturn","Uran","Neptun"};
	List<Planet> planet = new ArrayList<Planet>();
	
	int x0=805,y0=790;
	
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
		labelAddFinishedPlanet = new JLabel("<html><font color=purple>Dodaj gotow� planet�!!</font>");
		labelAddFinishedPlanet.setHorizontalAlignment(JLabel.CENTER);
		panelTop1.add(labelAddFinishedPlanet);
		panelMain.add(panelTop1);
		
		panelTop2 = new JPanel();
		panelTop2.setLayout(new BoxLayout(panelTop2, BoxLayout.X_AXIS));
		buttonReturn = new JButton("Powr�t");
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
		
		panelPicture = new PicturesPlanets();
		panelPicture.setPreferredSize(new Dimension(30,30));
		panelPicture.setBorder(BorderFactory.createLoweredBevelBorder());
		panelListAndPicture.add(panelPicture);
		panelMain.add(panelListAndPicture);
		//listener do listy
		listPlanets.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0){
	        	BufferedImage image = null;
	        	URL resource = null;
	        	if(listPlanets.getSelectedIndex()==0) {
	        		resource = getClass().getResource("obrazki/merkury.png"); 
	        		textArea.setText("Cze�� jestem Merkury! Jestem najmniejsz� i najbli�ej S�o�ca po�o�on� planet�! \n"
	        				+ "Niestety jestem trudny do obserwacji, ale mimo tego wida� mnie go�ym okiem! \n"
	        				+ "Wa�� 3,3*10^23 kg! M�j promie� wynosi 2439,7 km!  "
	        				+ "M�j obieg wok� S�o�ca trwa 88 dni!");
	        	}
	        	if(listPlanets.getSelectedIndex()==1) {
	        		resource = getClass().getResource("obrazki/wenus.png"); 
	        		textArea.setText("Cze�� jestem Wenus! Jestem drug� wed�ug oddalenia od S�o�ca planet� Uk�adu S�onecznego! \n" 
	        				+"Nazywaj� mnie tak�e Jutrzenk�! Jestem najja�niejszym cia�em niebieskim zaraz po S�o�cu i Ksi�ycu! \n" 
	        				+"Wa�� 4,9*10^24 kg!  M�j promie� wynosi 6051,8 km.  M�j obieg wok� S�o�ca trwa 225 dni!");
	        	}
	        	if(listPlanets.getSelectedIndex()==2) {
	        		resource = getClass().getResource("obrazki/ziemia.gif"); 
	        		textArea.setText("Cze�� jestem Ziemia! Jestem trzeci� wed�ug oddalenia od S�o�ca planet� Uk�adu S�onecznego!\n"
	        				+"Jestem jedynym znanym miejscem we Wszech�wiecie, gdzie wyst�puje �ycie! \n"
	        				+"Jestem domem dla milion�w gatunk�w, w tym nawet dla cz�owieka! \n"
	        				+"Obiegam S�o�ce w ci�gu 365 dni. Wiesz, �e wa�� 5,97*10^24 kg, a m�j promie� ma d�ugo�� 6371 km? ");
	        	}
	        	if(listPlanets.getSelectedIndex()==3) {
	        		resource = getClass().getResource("obrazki/mars.png"); 
	        		textArea.setText("Witaj, jestem Mars! Jestem czwart� w kolejno�ci planet� Uk�adu S�onecznego. \n"
	        				+ "Nazwali mnie od imienia rzymskiego boga wojny Marsa. Jestem rdzawo-czerwony z powodu tlenk�w �elaza, "
	        				+ "kt�re pokrywaj� moj� powierzchni�! \nObiegam S�o�ce w ci�gu 2 lat! "
	        				+ "Wa�� 6,4*10^23 kg! M�j promie� wynosi  3389,5 km !");
	        	}
	        	if(listPlanets.getSelectedIndex()==4) {
	        		resource = getClass().getResource("obrazki/jowisz.png"); 
	        		textArea.setText("Hej, jestem Jowisz! Jestem pi�t� wed�ug oddalenia od S�o�ca planet� Uk�adu S�onecznego!\n"
	        				+ "Jestem najwi�kszy i najci�szy z moich przyjaci�. Wa�� 1,9*10^27 kg.\n"
	        				+ "M�j promie� osi�ga d�ugo�� 69 911 km! Wiesz, �e obieg S�o�ca zajmuje mi a� 12 lat? ");
	        	}
	        	if(listPlanets.getSelectedIndex()==5) {
	        		resource = getClass().getResource("obrazki/saturn.png"); 
	        		textArea.setText("Cze�� jestem Saturn! Jestem sz�st� w kolejno�ci planet� Uk�adu S�onecznego.\n"
	        				+ "Zaraz po Jowiszu jestem drug� w kolejno�ci planet� pod wzgl�dem wielko�ci oraz masy! \n"
	        				+ "Moj� charakterystyczn� cech� s� pier�cienie sk�adaj�ce si� g��wnie z lodu! \n"
	        				+ "Wa�� 5,7*10^26 kg! M�j promie�  wynosi 58 232 km! Obiegam S�o�ce w ci�gu 30 lat!!");
	        	}
	        	if(listPlanets.getSelectedIndex()==6) {
	        		resource = getClass().getResource("obrazki/uran.png"); 
	        		textArea.setText("Witaj! Jestem Uran! Jestem si�dm� planet� w Uk�adzie S�onecznym. \n"
	        				+ "Jestem trzeci� pod wzgl�dem wielko�ci i czwart� pod wzgl�dem masy planet�! \n"
	        				+ "Wiedzia�e�, �e nazwali mnie na cze�� Uranosa, greckiego boga? Wa�� 8,7*10^25 kg. \n"
	        				+ "M�j promie� wynosi 25 362 km. Obiegam S�o�ce w czasie 84 lat!");
	        	}
	        	if(listPlanets.getSelectedIndex()==7) {
	        		resource = getClass().getResource("obrazki/neptun.png"); 
	        		textArea.setText("Cze��! Jestem Neptun! Jestem �sm� planet� w Uk�adzie S�onecznym. \n"
	        				+ "Niestety jestem po�o�ony najdalej od S�o�ca. Jestem czwart� pod wzgl�dem �rednicy i trzeci� pod wzgl�dem masy planet�! \n"
	        				+ "Wiedzia�e�, �e moja nazwa pochodzi od rzymskiego boga m�rz Neptuna? Wa�� 1,02*10^26 kg. \n"
	        				+ "M�j promie� wynosi 24 622 km. Wiesz, �e m�j obieg wok� S�o�ca zajmuj� 165 lat? ");
	        	}
	        	try {
		            image = ImageIO.read(resource);
		        } catch (IOException e) {
		            System.err.println("Blad odczytu obrazka");
		            e.printStackTrace();
		        }
	        	panelPicture.setBackgroundImage(image);
	        }
	      });

		
		//Opis planety
		panelMain.add(Box.createRigidArea(new Dimension(0,20)));
		textArea = new JTextArea("Charakterystyka planety");
		textArea.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.blue));
		panelMain.add(textArea);

		
		//panel panelBottom
		panelBottom = new JPanel();
		panelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonCancel = new JButton("Anuluj");
		buttonAddPlanet = new JButton("Dodaj");
		panelBottom.add(buttonCancel);
		panelBottom.add(buttonAddPlanet);
		this.add(panelBottom,BorderLayout.SOUTH);
		
		//listener dodaj�cy planety
		buttonAddPlanet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				BufferedImage image = null;
				int o=0, t=0, x=0, y=0, r=0, r0=2, o0=4;
	        	URL resource = null;
				if(listPlanets.getSelectedIndex()==0) {
	        		resource = getClass().getResource("obrazki/merkury.png");
	        		r = r0;
	        		o = o0+10;
	        		x=x0/2+o;
	        		y=y0/2+o;
	        	}
	        	if(listPlanets.getSelectedIndex()==1) {
	        		resource = getClass().getResource("obrazki/wenus.png"); 
	        		r=(int) (r0*6051.8/2439.7);
	        		o = (int) (o0*108.141/57.740)+10;
	        		x=x0/2+o;
	        		y=y0/2+o;
	        	}
	        	if(listPlanets.getSelectedIndex()==2) {
	        		resource = getClass().getResource("obrazki/ziemia.gif");
	        		r=(int) (r0*6371/2439.7);
	        		o =(int) (o0*149.504/57.740)+10;
	        		x=x0/2+o;
	        		y=y0/2+o;
	        	}
	        	if(listPlanets.getSelectedIndex()==3) {
	        		resource = getClass().getResource("obrazki/mars.png"); 
	        		r=(int) (r0*3389.5/2439.7);
	        		o = (int) (o0*227.798/57.740)+10;
	        		x=x0/2+o;
	        		y=y0/2+o;
	        	}
	        	if(listPlanets.getSelectedIndex()==4) {
	        		resource = getClass().getResource("obrazki/jowisz.png"); 
	        		r=(int) (r0*69911/2439.7);
	        		o = (int) (o0*777.840/57.740)+10;
	        		x=x0/2+o;
	        		y=y0/2+o;
	        	}
	        	if(listPlanets.getSelectedIndex()==5) {
	        		resource = getClass().getResource("obrazki/saturn.png"); 
	        		r=(int) (r0*58232/2439.7);
	        		o = (int) (o0*1426.1/57.740)+10;
	        		x=x0/2+o;
	        		y=y0/2+o;
	        	}
	        	if(listPlanets.getSelectedIndex()==6) {
	        		resource = getClass().getResource("obrazki/uran.png");
	        		r=(int) (r0*25362/2439.7);
	        		o = (int) (o0*2867.8/57.740)+10;
	        		x=x0/2+o;
	        		y=y0/2+o;
	        	}
	        	if(listPlanets.getSelectedIndex()==7) {
	        		resource = getClass().getResource("obrazki/neptun.png"); 
	        		r=(int) (r0*24622/2439.7);
	        		o = (int) (o0*4493.6/57.740)+10;
	        		x=x0/2+o;
	        		y=y0/2+o;
	        	}
	        	try {
		            image = ImageIO.read(resource);
		        } catch (IOException e) {
		            System.err.println("Blad odczytu obrazka");
		            e.printStackTrace();
		        }
	        	
	        	Planet pl = new Planet();
	    		pl.setRadius(r);
	    		pl.setX(x);
	    		pl.setY(y);
	    		pl.addImage(image);
	    		pl.setPeriod(t);
	    		
	    		planet.add(pl);
			}
		});
	}
	public void setX0Y0(int xx0,int yy0) {
		x0=xx0;
		y0=yy0;
	}
	public List<Planet> getPlanets() {
		return planet;
	}
	
	public class ButtonReturnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}

