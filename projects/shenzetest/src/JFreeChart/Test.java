// ============================================================================
//
// Copyright (C) 2006-2009 Talend Inc. - www.talend.com
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
 * DOC Administrator class global comment. Detailled comment
 */

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Test {

    public static void main(String[] args) throws IOException {
        CategoryDataset dataset = getDataSet2();
        JFreeChart chart = ChartFactory.createBarChart("水果产量图", // 图表标题
                "abcd", // 目录轴的显示标签
                "efg", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                false, // 是否显示图例(对于简单的柱状图必须是false)
                false, // 是否生成工具
                false // 是否生成URL链接
                );
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        CategoryAxis domainAxis = categoryplot.getDomainAxis();
        TextTitle textTitle = chart.getTitle();

        textTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));

        domainAxis.setLabelFont(new Font("Tahoma", Font.PLAIN, 12));

        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

        numberaxis.setLabelFont(new Font("Tahoma", Font.PLAIN, 12));

        // chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("D:\\fruit4.jpg");
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1, chart, 400, 300, null);
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * 获取一个演示用的简单数据集对象
     * 
     * @return
     */
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "成都", "苹果");
        dataset.addValue(200, "成都", "梨子");
        dataset.addValue(300, "成都", "葡萄");
        dataset.addValue(400, "成都", "香蕉");
        dataset.addValue(500, "西昌", "苹果");
        dataset.addValue(200, "西昌", "梨子");
        dataset.addValue(300, "西昌", "葡萄");
        dataset.addValue(400, "西昌", "香蕉");
        return dataset;
    }

    /**
     * 获取一个演示用的组合数据集对象
     * 
     * @return
     */
    private static CategoryDataset getDataSet2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "北京", "苹果");
        dataset.addValue(100, "上海", "苹果");
        dataset.addValue(100, "广州", "苹果");
        dataset.addValue(200, "北京", "梨子");
        dataset.addValue(200, "上海", "梨子");
        dataset.addValue(200, "广州", "梨子");
        dataset.addValue(300, "北京", "葡萄");
        dataset.addValue(300, "上海", "葡萄");
        dataset.addValue(300, "广州", "葡萄");
        dataset.addValue(400, "北京", "香蕉");
        dataset.addValue(400, "上海", "香蕉");
        dataset.addValue(400, "广州", "香蕉");
        dataset.addValue(500, "北京", "荔枝");
        dataset.addValue(500, "上海", "荔枝");
        dataset.addValue(500, "广州", "荔枝");
        return dataset;
    }
}
