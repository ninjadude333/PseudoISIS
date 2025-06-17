import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class IsisMainPanel extends JPanel {
	
	final int WIDTH=220;
	final int HEIGHT=240;
	JTextField user;
	JPasswordField pass;
	JButton logout;
	@SuppressWarnings("rawtypes")
	JComboBox driveList ;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IsisMainPanel () {
		  
				setPreferredSize(new Dimension(WIDTH,HEIGHT));
				setMinimumSize(new Dimension(WIDTH, HEIGHT));
				setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
				setBackground(Color.BLACK);
				
				JLabel label = new JLabel("Bolywood Gelem LOGIN", JLabel.CENTER);
				label.setFont(new Font("Ariel",Font.PLAIN , 14));
				label.setForeground(Color.white);
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				JLabel userLabel  = new JLabel("Login Name:", JLabel.CENTER);
				userLabel.setFont(new Font("Ariel",Font.PLAIN , 12));
				userLabel.setForeground(Color.white);
				userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				JLabel passLabel  = new JLabel("Password:", JLabel.CENTER);
				passLabel.setFont(new Font("Ariel",Font.PLAIN , 12));
				passLabel.setForeground(Color.white);
				passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				JLabel driveLabel  = new JLabel("Drive letter to mount:", JLabel.CENTER);
				driveLabel.setFont(new Font("Ariel",Font.PLAIN , 12));
				driveLabel.setForeground(Color.white);
				driveLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				
				user = new JTextField("bollywood");
				pass = new JPasswordField()
				{
				    public void addNotify()             
				    {                 
				        super.addNotify();
				        requestFocusInWindow();             
				    }         
				}; 
;
				JButton login = new JButton("Login");
				login.setFont(new Font("Ariel",Font.PLAIN , 16));
				login.setBackground((Color.BLACK));
				login.setForeground((Color.GRAY));
				login.setPreferredSize(new Dimension(100,25));
				login.setAlignmentX(Component.CENTER_ALIGNMENT);
				login.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if ((user.getText().equals("bollywood")) && isPasswordCorrect(pass.getPassword()))
								{
								new MapDrive(driveList.getSelectedItem().toString());
								}
							else
								JOptionPane.showMessageDialog(null, "WRONG PASSWORD !!!");
					}
					});
				logout = new JButton("Logout");
				logout.setFont(new Font("Ariel",Font.PLAIN , 12));
				logout.setBackground((Color.BLACK));
				logout.setForeground((Color.GRAY));
				logout.setPreferredSize(new Dimension(80,25));
				logout.setAlignmentX(Component.CENTER_ALIGNMENT);
				logout.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						new MapDrive(driveList.getSelectedItem().toString(),"unmap");
					}
					});
				
				
					
			    user.setMaximumSize(new Dimension(100, 20));
				pass.setMaximumSize(new Dimension(100, 20));
				pass.setFocusable(true);
								
				JPanel buttons = new JPanel();
				buttons.isOpaque();
				buttons.setSize(WIDTH, 20);
				buttons.setBackground(Color.black);
				buttons.add(login);
				buttons.add(logout);
				
				driveList = new JComboBox(listAvailableDrives());
				driveList.setSelectedIndex(0);
				driveList.setMaximumSize(new Dimension(40, 20));
//				driveList.addActionListener();
				
				add(Box.createRigidArea(new Dimension(100, 10)));
				add(label);
				add(Box.createRigidArea(new Dimension(100, 20)));
				add(userLabel);
				add(user);
				add(Box.createRigidArea(new Dimension(100, 10)));
				add(passLabel);
				add(pass);
				add(Box.createRigidArea(new Dimension(100, 10)));
				add(driveLabel);
				add(driveList);
				add(Box.createRigidArea(new Dimension(100, 20)));
				add(buttons);
				
				
				setOpaque(true);
						
	}
	private static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword = { 'B', 'L', 'g', 'e', 'l', 'e', 'm', '2', '0', '1', '4' };

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
	
	public String[] listAvailableDrives()
	{
		ArrayList<String> availableDrivesToMount = new ArrayList<String>(
				Arrays.asList("C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
	
	File[] roots = File.listRoots();
	
	
	for(int i = 0 ; i < roots.length ; i++)
	{
		availableDrivesToMount.remove(roots[i].toString().replace(":\\", ""));
	}
	
	System.out.println(availableDrivesToMount.toString());
	return availableDrivesToMount.toArray(new String[availableDrivesToMount.size()]);
	}
	

		
}
