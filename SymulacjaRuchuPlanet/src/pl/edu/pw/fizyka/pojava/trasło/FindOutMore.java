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


public class FindOutMore extends JFrame {
	
	JPanel panelMain, panelTop1, panelTop2, panelTop3;
	JLabel label1, label2, label3;
	JButton buttonReturn;
	JTextArea text;
	
	public FindOutMore() throws HeadlessException {
		
		super(" Dowiedz siê wiêcej");
		this.setSize(800,400);
		this.setLocation(370,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panelMain = new JPanel();
		panelMain.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		this.add(panelMain);
		
		panelTop1 = new JPanel();
		panelTop1.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.blue));
		label1= new JLabel("<html><font color=green>Uk³ad planetarny - symulacja ruchu planet!!</font>");
		label1.setHorizontalAlignment(JLabel.CENTER);
		panelTop1.add(label1);
		text = new JTextArea("Witaj! \n"
				+ "Korzystasz w³aœnie z interaktywnej symulacji pokazuj¹cej ruch planet wokó³ S³oñca."
				+ "Stwórz w³asny uk³ad planetarny i zobacz jak to dzia³a! \nPosiadasz dwie mo¿liwoœci -  wybór planet z gotowego zestawu "
				+ "lub stworzenie w³asnego cia³a niebieskiego. \n"
				+ "W celu stworzenia w³asnego cia³a podaj charakterystyczne parametry takie jak "
				+ "okres obiegu wokó³ S³oñca, odleg³oœæ od S³oñca oraz promieñ. \n"
				+ "Mo¿esz tak¿e wybraæ wygl¹d swojej planety!\n"
				+ "Masz mo¿liwoœæ zapisania swojej symulacji oraz wyczyszczenia wszystkich danych. "
				+ "Je¿eli chcesz, mo¿esz dokonaæ wyboru koloru t³a aplikacji. \n"
				+ "\n"
				+ "Wynik obliczeñ zostanie przedstawiony w formie animacji"
				+ "- wizualizacji po³o¿enia obiektów zmieniaj¹cego siê  w czasie. \r\n"
				+ "Dziêki programowi mo¿esz zobaczyæ jak zachowuje siê cia³o niebieskie w uk³adzie planetarnym. \n"
				+ "Zwróæ uwagê, ¿e niektóre planety s¹ bardzo ma³ych rozmiarów w porównaniu do innych! \n"
				);
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
		label2 = new JLabel("Projekt ma cele edukacyjne o charakterze fizycznym.");
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
