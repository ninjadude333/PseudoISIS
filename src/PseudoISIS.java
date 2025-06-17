import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PseudoISIS extends JFrame{
	
	static Properties props = new Properties();
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		public void run() {
		JFrame f = new JFrame("\"PseudoISIS\" By:The_Dude");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
				
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	f.setLocation(dim.width/2-f.getSize().width/3, dim.height/3-f.getSize().height/3);
    	
		ImageIcon frameIcon = new ImageIcon(getClass().getResource("/mtvsicon.jpg"));
    	f.setIconImage(frameIcon.getImage());
    		    	
    	JPanel main = new IsisMainPanel();
		f.getContentPane().add(main,BorderLayout.CENTER);
		
		f.setResizable(false);
		f.pack();
		f.setVisible(true);
		
			}
		
	});
}
}