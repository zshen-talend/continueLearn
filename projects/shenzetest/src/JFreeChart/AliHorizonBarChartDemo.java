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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class AliHorizonBarChartDemo extends ApplicationFrame {

    public static final int[][] COLORS = { { 244, 147, 32 }, { 128, 119, 178 }, { 190, 213, 48 }, { 35, 157, 190 },
            { 250, 212, 16 }, { 234, 28, 36 }, { 192, 131, 91 }, { 236, 23, 133 }, { 164, 155, 100 }, { 244, 120, 30 },
            { 128, 168, 201 }, { 190, 169, 42 }, { 37, 126, 175 }, { 250, 174, 15 }, { 250, 212, 16 }, { 235, 104, 47 },
            { 234, 28, 36 }, { 58, 53, 79 } };

    private static java.awt.Color[] awtColors;

    public AliHorizonBarChartDemo(String s) {
        // 这里是继承自ApplicationFrame
        super(s);
        // 创建Dataset
        CategoryDataset categoryDataset = createDataset();
        // 创建jfreechart
        JFreeChart jfreechart = createChart(categoryDataset);
        // 创建容器
        ChartPanel chartPanel = createPanel();
        // 设置容器的初始大小(Dimension是用来设置尺寸的)
        chartPanel.setPreferredSize(new Dimension(400, 200));// 尤其注意的是panel的高度会严重影响柱体的宽度
        // 下面这句是关键,控制是否显示，也就是将整个组件放入到组件中去
        /**
         * 对JFrame添加组件有两种方式： 　　 1)用getContentPane()方法获得JFrame的内容面板，再对其加入组件：frame.getContentPane().add(childComponent) 　
         * 　2)建立一个Jpanel或JDesktopPane之类的中间容器，把组件添加到容器中，用setContentPane()方法把该容器置为JFrame的内容
         * 
         * 面板： 　 　　　JpanelcontentPane=newJpanel();//把其它组件添加到Jpanel中; 　　　
         * 　frame.setContentPane(contentPane);　//把contentPane对象设置成为frame的内容面板
         */
        setContentPane(chartPanel);
    }

    public CategoryDataset createDataset() {
        System.out.println("========createDataSet========");
        // 创建Dataset
        DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();
        // 创建分类
        defaultDataset.addValue(100d, "S1", "Apple");
        defaultDataset.addValue(101d, "S1", "banana");
        defaultDataset.addValue(150d, "S1", "grape");
        defaultDataset.addValue(12d, "S1", "pear");

        return defaultDataset;

    }

    public JFreeChart createChart(CategoryDataset dataset) {
        System.out.println("===========createJfreechart========");
        // 3D高亮效果
        // ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
        // 创建jfreechart
        JFreeChart jfreechart = ChartFactory.createBarChart("Ali's fruits", "type", "number", dataset, PlotOrientation.VERTICAL,
                false, true, false);
        // 设置jfreechart的背景
        System.out.println("jfreechart=" + jfreechart);
        jfreechart.setBackgroundPaint(Color.yellow);

        // 创建plot
        CategoryPlot categoryPlot = (CategoryPlot) jfreechart.getPlot();
        System.out.println("categoryPlot=" + categoryPlot);
        // 设置场景的背景色
        categoryPlot.setBackgroundPaint(Color.gray);
        // 还可以设置场景的横向网格
        categoryPlot.setDomainGridlinePaint(Color.red);
        // 设置场景横向网格的可见性，如果不设置的话则不可见
        categoryPlot.setDomainGridlinesVisible(true);
        // 设置场景的竖向网格
        categoryPlot.setRangeGridlinePaint(Color.green);
        // 设置最长的说明标签的显示比例
        System.out.println(categoryPlot.getDomainAxis());
        categoryPlot.getDomainAxis().setMaximumCategoryLabelWidthRatio(0.8F);

        // 设置轴
        NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
        // 设置轴的单位
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // //////////////////////////////////////////////////////////////////
        // CustomRenderer customrenderer = new CustomRenderer(getColorsForAwt());
        // customrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        // customrenderer.setBaseItemLabelsVisible(true);
        // // remove the shadow
        // customrenderer.setShadowVisible(Boolean.FALSE);
        // customrenderer.setAutoPopulateSeriesFillPaint(false);
        // categoryPlot.setRenderer(customrenderer);

        // /////////////////////////////////////////////////////////////////

        // 添加额外的效果(表示器)
        BarRenderer barrender = (BarRenderer) categoryPlot.getRenderer();
        // 设置是否显示外框
        barrender.setDrawBarOutline(true);
        // 显示每个柱子的具体值
        // 下面这两句缺一不可
        barrender.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barrender.setSeriesItemLabelsVisible(0, Boolean.TRUE);
        // 添加渐变色
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255), 0.0f, 0.0f,
                new Color(170, 170, 255));
        // 给柱体上色
        barrender.setSeriesPaint(0, gradientPaint);
        return jfreechart;
    }

    public ChartPanel createPanel() {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);

    }

    public static void main(String[] args) {
        AliHorizonBarChartDemo demo = new AliHorizonBarChartDemo("ALI's bar chart");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        demo.setDefaultCloseOperation(1);

    }

    public static java.awt.Color[] getColorsForAwt() {
        if (null == awtColors) {
            awtColors = new java.awt.Color[COLORS.length];
            for (int i = 0; i < COLORS.length; i++) {
                awtColors[i] = new java.awt.Color(COLORS[i][0], COLORS[i][1], COLORS[i][2]);
            }
        }
        return awtColors;

    }

    /**
     * DOC yyi DataChart class global comment. Detailled comment
     */
    class CustomRenderer extends BarRenderer {

        private Paint[] colors;

        public CustomRenderer(Paint[] apaint) {
            colors = apaint;
        }

        @Override
        public Paint getItemPaint(int i, int j) {
            CategoryDataset categorydataset = getPlot().getDataset();
            int m = Integer.parseInt(categorydataset.getColumnKeys().get(j).toString());
            return colors[m % colors.length];
        }
    }
}
