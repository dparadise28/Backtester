import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Logs {
	private static JScrollPane logs, risk;
	private static JPanel      panel=  new JPanel();
	private static JTextArea   logsTXT=new JTextArea(),
							   riskTXT=new JTextArea();
	
	public Component Trade_Log(){
		initPanel(); initLogs(); initRisk();
		
		panel.add(logs); panel.add(risk);
	    
	    return panel;		
	}
	
	public void update(String a){
		logsTXT.append(a);
	}
	
	public void initPanel(){
		panel.setBackground(Color.black);
		panel.setLayout(new GridLayout(1,0));		
	}
	
	public void initLogs(){
		logsTXT.setEditable(false);
		logsTXT.setBackground(Color.BLACK);
		
		logsTXT.append("\t\t\tCompleted Trades\n\n");
		logsTXT.setFont(new Font("Arial", 0, 13));
		logsTXT.append("Ticker      Opt         Date         Ex Date      "
				   	 + "volume      price       Ex.Price     Position     "
				   	 + "Profit       %Return");
		
		logs=new JScrollPane(logsTXT);		
	}
	
	public void initRisk(){
		riskTXT.setEditable(false);
		riskTXT.setBackground(Color.BLACK);
		riskTXT.setFont(new Font("Arial", 0, 13));
		
		riskTXT.append("\t\t\tOpen Trades\n\n");
		riskTXT.append("Ticker     Opt      Date      Ex Date      "
				     + "stock      strike     vol       delta        "
				     + "gamma      vega       theta");
		
		risk=new JScrollPane(riskTXT);
	}

}