import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;


public class Plot {

	public XYSeriesCollection dataset;
	
	public static void main (String[] args) {
		XYSeries d = new XYSeries("moop");
		d.add(1,2);
		d.add(2,3);
		d.add(4,5);
        new Plot(d);
    }
	
	public Plot (XYSeries d) {
		dataset = new XYSeriesCollection();		
		dataset.addSeries(d);
		showGraph();
	}
	public Plot (XYSeriesCollection d) {
		dataset = d;		
		showGraph();
	}
	
	
	public void showGraph() {
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        final ApplicationFrame frame = new ApplicationFrame("Title");
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
	}
	
	
	 public JFreeChart createChart(final XYDataset dataset) {
	        final JFreeChart chart = ChartFactory.createScatterPlot(
	            "Title",                  // chart title
	            "X",                      // x axis label
	            "Y",                      // y axis label
	            dataset,                  // data
	            PlotOrientation.VERTICAL,
	            true,                     // include legend
	            true,                     // tooltips
	            false                     // urls
	        );
	        XYPlot plot = (XYPlot) chart.getPlot();
	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesLinesVisible(0, true);
	        plot.setRenderer(renderer);
	        return chart;
	    }
}
