//START
package swtTest.tooltip;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ToolTipDemo extends JFrame {

    private JLabel lblTest;
    private JTextField textTest;
    private JButton btnTest;
    private String[] tipsArray = {"第一行","第二行","第三行"};
    
    /**构造方法*/
    public ToolTipDemo(){
        
        CreateContence();
    }
    
    /*创建控件*/
    public void CreateContence(){
        
        String strDestTips = new String();
        
        setSize(450, 300);
        this.setLocation(this.getToolkit().getScreenSize().width / 2- this.getWidth() / 2,
                         this.getToolkit().getScreenSize().height/ 2 - this.getHeight() / 2);
        
        this.setLayout(null);
        
        lblTest = new JLabel("This is a ToolTipsText Wrap Test Label");
        lblTest.setBounds(new Rectangle(100,50, 260,30));
        lblTest.setToolTipText(getTips(false));// 最终要显示提示信息
        getContentPane().add(lblTest);
        
    
        textTest = new JTextField("This is a ToolTipsText Wrap Test Text");
        textTest.setBounds(new Rectangle(100,100, 260,30));
        textTest.setToolTipText(getTips(false));
        getContentPane().add(textTest);
        
        btnTest = new JButton("This is a ToolTipsText Wrap Test Button");
        btnTest.setBounds(new Rectangle(100,150, 260,30));
        btnTest.setToolTipText(getTips(true));
        getContentPane().add(btnTest);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    /*获取提示信息*/
    public String getTips(boolean isHtml) {
        String strtemp = new String();
        if (isHtml) {
        HtmlMultiLineControl hmlc = new HtmlMultiLineControl();
        

        for(int i=0; i<tipsArray.length; i++){
            
            if(i!= 0){
                strtemp = strtemp + "<br>" ;//br：换行（HTML）
            }
            
            strtemp = strtemp + tipsArray[i];
        }
        
        //添加HTML格式控制
        strtemp = hmlc.CovertDestionString(strtemp);
        
        return strtemp;
        } else {
            String sReturn = System.getProperty("line.separator");
            for (int i = 0; i < tipsArray.length; i++) {

                if (i != 0) {
                    strtemp = strtemp + sReturn + "\n";// br：换行（HTML）
                }

                strtemp = strtemp + tipsArray[i];
            }
            return strtemp;
        }
    }
    public static void main(String[] args) {
        
        
        ToolTipDemo tooltip = new ToolTipDemo();
    }

}
//End 