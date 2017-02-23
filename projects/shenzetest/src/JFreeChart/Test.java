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
        JFreeChart chart = ChartFactory.createBarChart("ˮ������ͼ", // ͼ�����
                "abcd", // Ŀ¼�����ʾ��ǩ
                "efg", // ��ֵ�����ʾ��ǩ
                dataset, // ���ݼ�
                PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                false, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                false, // �Ƿ����ɹ���
                false // �Ƿ�����URL����
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

        // chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));
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
     * ��ȡһ����ʾ�õļ����ݼ�����
     * 
     * @return
     */
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "�ɶ�", "ƻ��");
        dataset.addValue(200, "�ɶ�", "����");
        dataset.addValue(300, "�ɶ�", "����");
        dataset.addValue(400, "�ɶ�", "�㽶");
        dataset.addValue(500, "����", "ƻ��");
        dataset.addValue(200, "����", "����");
        dataset.addValue(300, "����", "����");
        dataset.addValue(400, "����", "�㽶");
        return dataset;
    }

    /**
     * ��ȡһ����ʾ�õ�������ݼ�����
     * 
     * @return
     */
    private static CategoryDataset getDataSet2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "����", "ƻ��");
        dataset.addValue(100, "�Ϻ�", "ƻ��");
        dataset.addValue(100, "����", "ƻ��");
        dataset.addValue(200, "����", "����");
        dataset.addValue(200, "�Ϻ�", "����");
        dataset.addValue(200, "����", "����");
        dataset.addValue(300, "����", "����");
        dataset.addValue(300, "�Ϻ�", "����");
        dataset.addValue(300, "����", "����");
        dataset.addValue(400, "����", "�㽶");
        dataset.addValue(400, "�Ϻ�", "�㽶");
        dataset.addValue(400, "����", "�㽶");
        dataset.addValue(500, "����", "��֦");
        dataset.addValue(500, "�Ϻ�", "��֦");
        dataset.addValue(500, "����", "��֦");
        return dataset;
    }
}
