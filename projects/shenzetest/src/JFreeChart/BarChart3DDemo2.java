// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package JFreeChart;

/**
 * created by zshen on Sep 24, 2013 Detailled comment
 * 
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Log;
import org.jfree.util.PrintStreamLogTarget;

/**
 * A simple demonstration application showing how to create a horizontal 3D bar chart using data from a
 * {@link CategoryDataset}.
 * 
 */
public class BarChart3DDemo2 extends ApplicationFrame {

    /**
     * Creates a new demo.
     * 
     * @param title the frame title.
     */
    public BarChart3DDemo2(final String title) {
        super(title);
        // create the chart...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(23.0, "Series 1", "London");
        dataset.addValue(14.0, "Series 1", "New York");
        dataset.addValue(14.0, "Series 1", "Istanbul");
        dataset.addValue(14.0, "Series 1", "Cairo");
        dataset.addValue(13.0, "Series 2", "London");
        dataset.addValue(19.0, "Series 2", "New York");
        dataset.addValue(19.0, "Series 2", "Istanbul");
        dataset.addValue(19.0, "Series 2", "Cairo");
        dataset.addValue(7.0, "Series 3", "London");
        dataset.addValue(9.0, "Series 3", "New York");
        dataset.addValue(9.0, "Series 3", "Istanbul");
        dataset.addValue(9.0, "Series 3", "Cairo");
        final JFreeChart chart = createChart(dataset);
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Creates a chart.
     * 
     * @param dataset the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D("3D Bar Chart Demo 2", // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.HORIZONTAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
                );
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setForegroundAlpha(1.0f);
        // left align the category labels...
        final CategoryAxis axis = plot.getDomainAxis();
        final CategoryLabelPositions p = axis.getCategoryLabelPositions();
        final CategoryLabelPosition left = new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT,
                TextAnchor.CENTER_LEFT, 0.0, CategoryLabelWidthType.RANGE, 0.30f);
        axis.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(p, left));
        return chart;
    }

    /**
     * Starting point for the demonstration application.
     * 
     * @param args ignored.
     */
    public static void main(final String[] args) {
        Log.getInstance().addTarget(new PrintStreamLogTarget());
        final BarChart3DDemo2 demo = new BarChart3DDemo2("3D Bar Chart Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}