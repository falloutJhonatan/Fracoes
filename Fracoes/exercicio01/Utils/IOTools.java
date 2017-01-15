package Utils;

import javax.swing.JOptionPane;

public class IOTools {
	
	public static void getString(String msg) {
		JOptionPane.showInputDialog(msg);
	}
	
	public static int getInt(String msg) {
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
	} 
	
	public static double getReal(String msg){
		return Double.valueOf(JOptionPane.showInputDialog(msg));
	}
	
	public static void showMessage(String msg){
		JOptionPane.showMessageDialog(null, msg);;
	}
}
