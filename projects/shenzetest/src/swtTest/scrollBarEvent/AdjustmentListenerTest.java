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
import javax.swing.JScrollBar;

/**
 * As you move the scrollbar, AdjustmentListener event is fired
 * @author Uma Maheswar
 *
 */
public class AdjustmentListenerTest extends JFrame implements AdjustmentListener {
    
    private JScrollBar scrollBar;
    
    public AdjustmentListenerTest() {
        setTitle("AdjustmentListener Test");
        // extent the width of bar
        scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 2, 0, 100);
        scrollBar.addAdjustmentListener(this);
        
        add(scrollBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
    }
    
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        
        System.out.println("Adjusted: " + ae.paramString());
        System.out.println("Adjusted Value: " + ae.getValue());
    }
    
    public static void main(String args[]) {
        AdjustmentListenerTest frame = new AdjustmentListenerTest();
        frame.setVisible(true);
    }

}
