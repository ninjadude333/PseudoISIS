import java.io.IOException;

import javax.swing.JOptionPane;


public class MapDrive {
	
	public MapDrive(String driveLetter)
	{

		String command = "c:\\windows\\system32\\net.exe use " + driveLetter + ": \"\\\\NLSERVERMTVS\\Bollywood GELEM\" /user:bollywood BLgelem2014";
		try {
			@SuppressWarnings("unused")
			Process p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Drive " + driveLetter.toUpperCase() + " is now Mounted !");
		String command2 = "c:\\windows\\explorer.exe " + driveLetter + ":\\";
		try {
			@SuppressWarnings("unused")
			Process p = Runtime.getRuntime().exec(command2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MapDrive(String driveLetter, String unmap)
	{
		int i = JOptionPane.showConfirmDialog(null, "Do you want to unMount drive " + driveLetter + ": ?", null, JOptionPane.YES_NO_OPTION);
		if (i == JOptionPane.YES_OPTION) 
		{
		String command = "c:\\windows\\system32\\net.exe use " + driveLetter + ": /delete";
		try {
			@SuppressWarnings("unused")
			Process p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Drive " + driveLetter.toUpperCase() + " was removed !");
		
		}

		
	}
}
