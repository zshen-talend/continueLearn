// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package swtTest.scrollBarEvent;


/**
 * DOC zshen  class global comment. Detailled comment
 */
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChangeScrollBarValue{
  JFrame frame;
  JPanel panel;
  JTextArea area;
  JTextField field;
  JScrollPane spane;
  public static void main(String[] args) {
  ChangeScrollBarValue v = new ChangeScrollBarValue();
  }

  public ChangeScrollBarValue(){
        String str = "Wellcome to RoseIndia.net. \n " + "This is a web site \ndevelopement company. \n "
                + "This is responsible for \nyour given tasks .\n " + "It always full- fill to \nyour requirements \n ";
  frame = new JFrame("Show the Value of Scroll Bar in Java Swing");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  panel = new JPanel();
  area = new JTextArea(str, 5, 7);
  spane = new JScrollPane(area);
  spane.getHorizontalScrollBar().addAdjustmentListener(new MyAction());
  spane.getVerticalScrollBar().addAdjustmentListener(new MyAction());
  field = new JTextField(10);
  panel.add(field);
  panel.add(spane);
  frame.add(panel);
  frame.setSize(400, 400);
  frame.setVisible(true);
  }

  public class MyAction implements AdjustmentListener{
  public void adjustmentValueChanged(AdjustmentEvent ae){

  int value = ae.getValue();
  String st = Integer.toString(value);
  field.setText(st);
  }
  }
} 
