package pl.edu.pw.fizyka.pojava.tras�o;

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
		
		super(" Dowiedz si� wi�cej");
		this.setSize(800,400);
		this.setLocation(370,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panelMain = new JPanel();
		panelMain.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		this.add(panelMain);
		
		panelTop1 = new JPanel();
		panelTop1.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.blue));
		label1= new JLabel("<html><font color=green>Uk�ad planetarny - symulacja ruchu planet!!</font>");
		label1.setHorizontalAlignment(JLabel.CENTER);
		panelTop1.add(label1);
		text = new JTextArea("Witaj! \n"
				+ "Korzystasz w�a�nie z interaktywnej symulacji pokazuj�cej ruch planet wok� S�o�ca."
				+ "Stw�rz w�asny uk�ad planetarny i zobacz jak to dzia�a! \nPosiadasz dwie mo�liwo�ci -  wyb�r planet z gotowego zestawu "
				+ "lub stworzenie w�asnego cia�a niebieskiego. \n"
				+ "W celu stworzenia w�asnego cia�a podaj charakterystyczne parametry takie jak "
				+ "okres obiegu wok� S�o�ca, odleg�o�� od S�o�ca oraz promie�. \n"
				+ "Mo�esz tak�e wybra� wygl�d swojej planety!\n"
				+ "Masz mo�liwo�� zapisania swojej symulacji oraz wyczyszczenia wszystkich danych. "
				+ "Je�eli chcesz, mo�esz dokona� wyboru koloru t�a aplikacji. \n"
				+ "\n"
				+ "Wynik oblicze� zostanie przedstawiony w formie animacji"
				+ "- wizualizacji po�o�enia obiekt�w zmieniaj�cego si�  w czasie. \r\n"
				+ "Dzi�ki programowi mo�esz zobaczy� jak zachowuje si� cia�o niebieskie w uk�adzie planetarnym. \n"
				+ "Zwr�� uwag�, �e niekt�re planety s� bardzo ma�ych rozmiar�w w por�wnaniu do innych! \n"
				);
		text.setAlignmentX(CENTER_ALIGNMENT);
		panelTop1.add(text);
		panelMain.add(panelTop1);
		
		panelTop2 = new JPanel();
	
		buttonReturn = new JButton("Powr�t");
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
