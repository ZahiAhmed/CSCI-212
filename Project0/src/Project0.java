//Zahi Ahmed Lab Section 11E
import javax.swing.JOptionPane;

public class Project0 {

	public static void main (String[] args) {
		int lower, upper;
		String e;
		while(true) {
			lower=0;
			upper=0;
			e = JOptionPane.showInputDialog(null,"Please enter a sentence. ");
			if (e.equalsIgnoreCase("STOP")) System.exit(0);
			for (int i=0; i<e.length(); i++) {
				if(e.charAt(i)=='E') upper++;
				if(e.charAt(i)=='e') lower++;
			}
			JOptionPane.showMessageDialog(null,"Number of lower case e's: " + lower + "\n" + "Number of upper case e's: " + upper);
		}
	
	}
}