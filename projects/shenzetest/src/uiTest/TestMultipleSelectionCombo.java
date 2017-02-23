package uiTest;




import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TestMultipleSelectionCombo {

	public TestMultipleSelectionCombo(){
		
	}
	
	public void build(){
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(2,false));
		
		Label label=new Label(shell,SWT.NONE);
		label.setText("Name:");
		
		MultipleSelectionCombo combo=new MultipleSelectionCombo(shell,new String[]{"item 1","item 2","item 3","item 4","item 5","item 6"},new int[]{2,4}, SWT.NONE);
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				
		Text t2 =new Text(shell, SWT.BORDER | SWT.MULTI );
		GridData gd=new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan=2;
		t2.setLayoutData(gd);
		t2.setText("example...");
		 
		shell.setSize(500,500);
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	public static void main(String[] args){
		TestMultipleSelectionCombo sa=new TestMultipleSelectionCombo();
		sa.build();
	}
}

