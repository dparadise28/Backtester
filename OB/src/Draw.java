import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;
import org.jquantlib.exercise.EuropeanExercise;

public class Draw{  
	private JPanel Candle=new JPanel();
	private LinkedHashMap<String, ArrayList<String[]>> gData;
	
        public Draw(){
            super();
        }
        public Draw(LinkedHashMap<String, ArrayList<String[]>> gdata){
            super();
            gData = gdata; 
	}
    
    //String[] gData = {date,open, high, low, adjClose, volume}
    public Component Price_Chart(String symbol) throws ParseException{
        ArrayList dataItems = new ArrayList();
        SimpleDateFormat df= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss",Locale.ENGLISH);

        for(String[] values: gData.get(symbol)){
            //date,open, high, low, adjClose, volume
            double open = Double.parseDouble(values[1]),
                   high = Double.parseDouble(values[2]),
                   low = Double.parseDouble(values[3]),
                   adjClose = Double.parseDouble(values[4]),
                   volume = Double.parseDouble(values[5]);

                   Date date = df.parse(values[0]);
            OHLCDataItem item = new OHLCDataItem(date, open, high, low, adjClose, volume);
            dataItems.add(item);
        }
        
        Collections.reverse(dataItems);
        OHLCDataItem[] data = (OHLCDataItem[]) dataItems.toArray(new OHLCDataItem[dataItems.size()]);
        OHLCDataset dataset = new DefaultOHLCDataset("MSFT", data);

        JFreeChart chart=ChartFactory.createCandlestickChart("MSFT", "Time", "Price", dataset, false);
        chart.setBackgroundPaint(Color.black);
        chart.setBorderPaint(Color.green);
        chart.setBorderVisible(true);
        XYPlot plot=(XYPlot)chart.getPlot();

        plot.setBackgroundPaint(Color.black);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.CYAN);
        plot.setRangeGridlinePaint(Color.CYAN);

        ((NumberAxis)plot.getRangeAxis()).setAutoRangeIncludesZero(false);
        ((DateAxis)plot.getDomainAxis()).setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
        ((CandlestickRenderer)plot.getRenderer()).setDrawVolume(true);
        Candle.setLayout(new GridLayout(1,0));
        Candle.add(new ChartPanel(chart), BorderLayout.WEST);
        Candle.add(new ChartPanel(chart), BorderLayout.EAST);

        return Candle;
    }
}