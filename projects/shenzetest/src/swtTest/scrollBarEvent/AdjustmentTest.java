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
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class AdjustmentTest {
  public static void main(String args[]) {
    JFrame frame = new JFrame();
    Container contentPane = frame.getContentPane();
    Icon icon = new ImageIcon("java2s.gif");
    JButton b = new JButton(icon);
    JScrollPane pane = new JScrollPane(b);
    AdjustmentListener hListener = new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println("Horizontal: ");
        dumpInfo(e);
      }
    };
    JScrollBar hBar = pane.getHorizontalScrollBar();
    hBar.addAdjustmentListener(hListener);
    AdjustmentListener vListener = new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println("Vertical: ");
        dumpInfo(e);
      }
    };
    JScrollBar vBar = pane.getVerticalScrollBar();
    vBar.addAdjustmentListener(vListener);
    contentPane.add(pane, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.show();
  }

  private static void dumpInfo(AdjustmentEvent e) {
    System.out.println("\tValue: " + e.getValue());
    String type = null;
    switch (e.getAdjustmentType()) {
    case AdjustmentEvent.TRACK:
      type = "Track";
      break;
    case AdjustmentEvent.BLOCK_DECREMENT:
      type = "Block Decrement";
      break;
    case AdjustmentEvent.BLOCK_INCREMENT:
      type = "Block Increment";
      break;
    case AdjustmentEvent.UNIT_DECREMENT:
      type = "Unit Decrement";
      break;
    case AdjustmentEvent.UNIT_INCREMENT:
      type = "Unit Increment";
      break;
    }
    System.out.println("\tType: " + type);
  }
}

