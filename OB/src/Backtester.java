import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;


public class Backtester {
	public static Draw charts=new Draw();
	public static Logs log=   new Logs();
	
	public static JFrame mainFrame=new JFrame();
	public static JPanel chart=    (JPanel) charts.Price_Chart(),
						 logs=     (JPanel) log.Trade_Log();

	public static void main(String[] args) {
		menu();
		initMainFrame();
	}
	
	public static void update(String i){
		log.update(i);
		
		mainFrame.repaint();
	}
	
	public static void initMainFrame(){
		chart.setBackground(Color.BLACK);
		
		mainFrame.getContentPane().add(chart);
		mainFrame.getContentPane().add(logs);
		mainFrame.setLayout(new GridLayout(2,1));
		mainFrame.setMinimumSize(new Dimension(800, 500));
		mainFrame.getContentPane().setBackground(Color.BLACK);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static void menu(){
		JMenuBar menuBar=new JMenuBar();
		JMenu File = new JMenu("File");
		JMenu algos = new JMenu("Algo");
		JMenu Chart = new JMenu("Charts");
		JMenu Risk = new JMenu("Risk Parameters");
		JMenu Greeks = new JMenu("Greeks");
		JMenu Surfaces = new JMenu("Surfaces");
		File.setMnemonic(KeyEvent.VK_F);
		
		menuBar.add(File);     menuBar.add(Chart);
		menuBar.add(Risk);     menuBar.add(Greeks);
		menuBar.add(Surfaces); menuBar.add(algos);
		
		mainFrame.setJMenuBar(menuBar);
		// Open
		/*
		JMenuItem menuOpen = new JMenuItem("Open",iconOpen);
		menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
		ActionEvent.CTRL_MASK));
		menuOpen.setToolTipText("Open Application");
		menuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null,
						"Open Command");
			}
		}); 
		*/
		// Exit
		/*
		ImageIcon iconExit = new ImageIcon(getClass().getResource("exit.gif"));
		JMenuItem menuExit = new JMenuItem("Exit",iconExit);
		menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
		ActionEvent.CTRL_MASK));
		menuExit.setToolTipText("Exit Application");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		*/
	}
	
}