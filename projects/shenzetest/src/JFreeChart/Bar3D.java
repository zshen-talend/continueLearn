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
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Bar3D {

    public static void main(String[] args) {
        // 创建一个柱状图
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // 装载数据
        dataset.setValue(6, "Profit", "Jane");
        dataset.setValue(3, "Profit2", "Jane");
        dataset.setValue(7, "Profit", "Tom");
        dataset.setValue(6, "Profit2", "Tom");
        dataset.setValue(8, "Profit", "Jill");
        dataset.setValue(9, "Profit2", "Jill");
        dataset.setValue(5, "Profit", "John");
        dataset.setValue(8, "Profit2", "John");
        dataset.setValue(12, "Profit", "Fred");
        dataset.setValue(11, "Profit2", "Fred");

        // 产生柱状图
        // JFreeChart chart =
        // ChartFactory.createXYLineChart("标题"，"x轴标志","y轴标志","设置数据","设置图形显示方向",是否显示图形,是否进行提示,是否配置报表存放地址);
        // 图形显示方向：
        // (1)HORIZONTAL:横向显示图形
        // (2)VERTICAL:纵向显示图形
        // 3D柱状图
        JFreeChart chart = ChartFactory.createBarChart3D("销售统计图", "Salesman", "Profit", dataset, PlotOrientation.VERTICAL, true,
                true, false);

        try {
            // // 创建图形显示面板
            // ChartFrame cf = new ChartFrame("柱状图",chart);
            // cf.pack();
            // // 设置图片大小
            // cf.setSize(500,300);
            // // 设置图形可见
            // cf.setVisible(true);

            // 保存图片到指定文件夹
            ChartUtilities.saveChartAsJPEG(new File("C:\\BarChart.jpg"), chart, 500, 300);
        } catch (Exception e) {
            System.err.println("Problem occurred creating chart.");
        }
    }
}