//Adrian Traczewski
package pl.edu.pw.fizyka.pojava.tras³o;

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

import pl.edu.pw.fizyka.pojava.tras³o.MakePlanet.ButtonReturnListener;

public class AddFinishedPlanet extends JFrame {

	JButton buttonCancel, buttonAddPlanet, buttonReturn;
	JComboBox<String> listPlanets;
	JPanel panelMain, panelTop1, panelTop2, panelList, panelListAndPicture, panelBottom;
	PicturesPlanets panelPicture; 
	JLabel labelAddFinishedPlanet, labelList;
	JTextArea textArea;
	String planets[]= {"Merkury","Wenus","Ziemia","Mars","Jowisz","Saturn","Uran","Neptun"};
	List<Planet> planet = new ArrayList<Planet>();
	
	int x0=805,y0=740;
	static String ss = "";
	
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
	        		textArea.setText("Czeœæ jestem Merkury! Jestem najmniejsz¹ i najbli¿ej S³oñca po³o¿on¹ planet¹! \n"
	        				+ "Niestety jestem trudny do obserwacji, ale mimo tego widaæ mnie go³ym okiem! \n"
	        				+ "Wa¿ê 3,3*10^23 kg! Mój promieñ wynosi 2439,7 km!  "
	        				+ "Mój obieg wokó³ S³oñca trwa 88 dni!");
	        	}
	        	if(listPlanets.getSelectedIndex()==1) {
	        		resource = getClass().getResource("obrazki/wenus.png"); 
	        		textArea.setText("Czeœæ jestem Wenus! Jestem drug¹ wed³ug oddalenia od S³oñca planet¹ Uk³adu S³onecznego! \n" 
	        				+"Nazywaj¹ mnie tak¿e Jutrzenk¹! Jestem najjaœniejszym cia³em niebieskim zaraz po S³oñcu i Ksiê¿ycu! \n" 
	        				+"Wa¿ê 4,9*10^24 kg!  Mój promieñ wynosi 6051,8 km.  Mój obieg wokó³ S³oñca trwa 225 dni!");
	        	}
	        	if(listPlanets.getSelectedIndex()==2) {
	        		resource = getClass().getResource("obrazki/ziemia.gif"); 
	        		textArea.setText("Czeœæ jestem Ziemia! Jestem trzeci¹ wed³ug oddalenia od S³oñca planet¹ Uk³adu S³onecznego!\n"
	        				+"Jestem jedynym znanym miejscem we Wszechœwiecie, gdzie wystêpuje ¿ycie! \n"
	        				+"Jestem domem dla milionów gatunków, w tym nawet dla cz³owieka! \n"
	        				+"Obiegam S³oñce w ci¹gu 365 dni. Wiesz, ¿e wa¿ê 5,97*10^24 kg, a mój promieñ ma d³ugoœæ 6371 km? ");
	        	}
	        	if(listPlanets.getSelectedIndex()==3) {
	        		resource = getClass().getResource("obrazki/mars.png"); 
	        		textArea.setText("Witaj, jestem Mars! Jestem czwart¹ w kolejnoœci planet¹ Uk³adu S³onecznego. \n"
	        				+ "Nazwali mnie od imienia rzymskiego boga wojny Marsa. Jestem rdzawo-czerwony z powodu tlenków ¿elaza, "
	        				+ "które pokrywaj¹ moj¹ powierzchniê! \nObiegam S³oñce w ci¹gu 2 lat! "
	        				+ "Wa¿ê 6,4*10^23 kg! Mój promieñ wynosi  3389,5 km !");
	        	}
	        	if(listPlanets.getSelectedIndex()==4) {
	        		resource = getClass().getResource("obrazki/jowisz.png"); 
	        		textArea.setText("Hej, jestem Jowisz! Jestem pi¹t¹ wed³ug oddalenia od S³oñca planet¹ Uk³adu S³onecznego!\n"
	        				+ "Jestem najwiêkszy i najciê¿szy z moich przyjació³. Wa¿ê 1,9*10^27 kg.\n"
	        				+ "Mój promieñ osi¹ga d³ugoœæ 69 911 km! Wiesz, ¿e obieg S³oñca zajmuje mi a¿ 12 lat? ");
	        	}
	        	if(listPlanets.getSelectedIndex()==5) {
	        		resource = getClass().getResource("obrazki/saturn.png"); 
	        		textArea.setText("Czeœæ jestem Saturn! Jestem szóst¹ w kolejnoœci planet¹ Uk³adu S³onecznego.\n"
	        				+ "Zaraz po Jowiszu jestem drug¹ w kolejnoœci planet¹ pod wzglêdem wielkoœci oraz masy! \n"
	        				+ "Moj¹ charakterystyczn¹ cech¹ s¹ pierœcienie sk³adaj¹ce siê g³ównie z lodu! \n"
	        				+ "Wa¿ê 5,7*10^26 kg! Mój promieñ  wynosi 58 232 km! Obiegam S³oñce w ci¹gu 30 lat!!");
	        	}
	        	if(listPlanets.getSelectedIndex()==6) {
	        		resource = getClass().getResource("obrazki/uran.png"); 
	        		textArea.setText("Witaj! Jestem Uran! Jestem siódm¹ planet¹ w Uk³adzie S³onecznym. \n"
	        				+ "Jestem trzeci¹ pod wzglêdem wielkoœci i czwart¹ pod wzglêdem masy planet¹! \n"
	        				+ "Wiedzia³eœ, ¿e nazwali mnie na czeœæ Uranosa, greckiego boga? Wa¿ê 8,7*10^25 kg. \n"
	        				+ "Mój promieñ wynosi 25 362 km. Obiegam S³oñce w czasie 84 lat!");
	        	}
	        	if(listPlanets.getSelectedIndex()==7) {
	        		resource = getClass().getResource("obrazki/neptun.png"); 
	        		textArea.setText("Czeœæ! Jestem Neptun! Jestem ósm¹ planet¹ w Uk³adzie S³onecznym. \n"
	        				+ "Niestety jestem po³o¿ony najdalej od S³oñca. Jestem czwart¹ pod wzglêdem œrednicy i trzeci¹ pod wzglêdem masy planet¹! \n"
	        				+ "Wiedzia³eœ, ¿e moja nazwa pochodzi od rzymskiego boga mórz Neptuna? Wa¿ê 1,02*10^26 kg. \n"
	        				+ "Mój promieñ wynosi 24 622 km. Wiesz, ¿e mój obieg wokó³ S³oñca zajmujê 165 lat? ");
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
		
		//listener dodaj¹cy planety
		buttonAddPlanet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				BufferedImage image = null;
				int o=0, x=0, y=0, r=0, r0=1, o0=5;
				double t0=0.3,t=0;
	        	URL resource = null;
				if(listPlanets.getSelectedIndex()==0) {
	        		resource = getClass().getResource("obrazki/merkury.png");
	        		r = r0;
	        		t=t0;
	        		o = o0+10;
	        		x=x0/2+o-r;
	        		y=y0/2-r;
	        		ss += "Merkury - najmniejsza i po³o¿ona najbli¿ej S³oñca planeta \n"
	        				+ "Jest trudny do obserwacji, ale mimo tego widaæ go go³ym okiem!";
	        	}
	        	if(listPlanets.getSelectedIndex()==1) {
	        		resource = getClass().getResource("obrazki/wenus.png"); 
	        		r=(int) (r0*6051.8/2439.7);
	        		o = (int) (o0*108.141/57.740)+10;
	        		t = t0*224.701/87.969;
	        		x=x0/2+o-r;
	        		y=y0/2-r;
	        		ss += "Wenus - druga wed³ug oddalenia od S³oñca planeta Uk³adu S³onecznego \n"
	        				+ "Nazywaj¹ j¹ tak¿e Jutrzenk¹! Jest najjaœniejszym cia³em niebieskim zaraz po S³oñcu i Ksiê¿ycu! \n";
	        	}
	        	if(listPlanets.getSelectedIndex()==2) {
	        		resource = getClass().getResource("obrazki/ziemia.gif");
	        		r=(int) (r0*6371/2439.7);
	        		o =(int) (o0*149.504/57.740)+10;
	        		t =t0*365.256/87.969;
	        		x=x0/2+o-r;
	        		y=y0/2-r;
	        		ss += "Ziemia - jedyne znane miejsce we Wszechœwiecie, gdzie wystêpuje ¿ycie \n"
	        				+ "Jest domem dla milionów gatunków, w tym nawet dla cz³owieka! \n";
	        	}
	        	if(listPlanets.getSelectedIndex()==3) {
	        		resource = getClass().getResource("obrazki/mars.png"); 
	        		r=(int) (r0*3389.5/2439.7);
	        		o = (int) (o0*227.798/57.740)+10;
	        		t = t0*686.960/87.969;
	        		x=x0/2+o-r;
	        		y=y0/2-r;
	        		ss += "Mars - czwarta w kolejnoœci planeta Uk³adu S³onecznego \n"
	        				+ "Obiega S³oñce w ci¹gu 2 lat! \n";
	        	}
	        	if(listPlanets.getSelectedIndex()==4) {
	        		resource = getClass().getResource("obrazki/jowisz.png"); 
	        		r=(int) (r0*69911/2439.7);
	        		o = (int) (o0*777.840/57.740)+10;
	        		t = t0*4333.287/87.969;
	        		x=x0/2+o-r;
	        		y=y0/2-r;
	        		ss += "Jowisz - pi¹ta wed³ug oddalenia od S³oñca planeta Uk³adu \n"
		        			+ "Jest najwiêkszy i najciêszy ze swoich przyjació³. \n";
	        	}
	        	if(listPlanets.getSelectedIndex()==5) {
	        		resource = getClass().getResource("obrazki/saturn.png"); 
	        		r=(int) (r0*58232/2439.7);
	        		o = (int) (o0*1426.1/57.740)+10;
	        		t = t0*10756.200/87.969;
	        		x=x0/2+o-r;
	        		y=y0/2-r;
	        		ss += "Saturn - szósta w kolejnoœci planeta Uk³adu S³onecznego \n"
	        				+ "Jego charakterystyczn¹ cech¹ s¹ pierœcienie sk³adaj¹ce siê g³ównie z lodu! \n";
	        	
	        	}
	        	if(listPlanets.getSelectedIndex()==6) {
	        		resource = getClass().getResource("obrazki/uran.png");
	        		r=(int) (r0*25362/2439.7);
	        		o = (int) (o0*2867.8/57.740)+10;
	        		t = t0*30707.490/87.969;
	        		x=x0/2+o-r;
	        		y=y0/2-r;
	        		ss += "Uran - siódma planeta w Uk³adzie S³onecznym \n"
	        				+ "Jest trzeci¹ pod wzglêdem wielkoœci i czwart¹ pod wzglêdem masy planet¹! \n";
	        	}
	        	if(listPlanets.getSelectedIndex()==7) {
	        		resource = getClass().getResource("obrazki/neptun.png"); 
	        		r=(int) (r0*24622/2439.7);
	        		o = (int) (o0*4493.6/57.740)+10;
	        		t = t0*60223.353/87.969;
	        		x=x0/2+o-r;
	        		y=y0/2-r;
	        		ss += "Neptun - ósma planeta w Uk³adzie S³onecznym \n"
	        				+ "Jest po³o¿ony najdalej od S³oñca. \n";
	        	}
	        	try {
		            image = ImageIO.read(resource);
		        } catch (IOException e) {
		            System.err.println("Blad odczytu obrazka");
		            e.printStackTrace();
		        }
	        	
	        	Planet pl = new Planet();
	    		pl.setRadiusPl(r);
	    		pl.setRadiusOrb(o);
	    		pl.setX(x);
	    		pl.setY(y);
	    		pl.addImage(image);
	    		pl.setPeriod(t);
	    		pl.setIn(0);
	    		
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

