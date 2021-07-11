//Ahmed, Zahi Lab 11E

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class EditMenuHandler implements ActionListener {
	DateGUI gui;
	UnsortedDateList unsort;
	SortedDateList sort;

	public EditMenuHandler(DateGUI gui) {
		this.gui = gui;
	}
	//sets up action listener
	public void actionPerformed(ActionEvent e) {
		String menuName = e.getActionCommand();
		sort = new SortedDateList();
		String i = null;
		if (menuName.equals("Insert"))
			i = JOptionPane.showInputDialog(null, "Enter a new date.");
		TreeMap<Date212, Integer> treeMap = new TreeMap<>(new Date212Comparator());
		Date212 d = new Date212(i);
		gui.Unsorted.append(d + "\n");// prints new date at bottom of unsorted side
		String store = gui.Sorted.getText() + d;
		int count = store.length() - store.replaceAll("[.]", "").length();
		gui.Sorted.setText("");
		String[] dates = store.split("[.]");

		for (int x = 0; x < count; x++) {
			String temp = dates[x].trim();
			String text = convertBack(temp);
			Date212 myDate = new Date212(text);
			treeMap.put(myDate, x);
		}

		Set<Date212> keys = treeMap.keySet();
		for(Date212 key: keys){
			sort.add(key); //sort using treeMap 
		}

		DateNode node = sort.getFirst().Next;
		while (node != null) {
			gui.Sorted.append(node.Data + "\n");
			node = node.Next;
		}
		gui.setVisible(true);
	}

	//allows date212 to be used after storing the dates 
	public String convertBack(String ymd) {
		String[] parts = ymd.split(" ");
		String month = parts[0];
		String day = parts[1].substring(0,2);
		day=day.replaceAll(",", "");
		if (Integer.valueOf(day)<10) {
			day = "0"+day;
		}
		String year = parts[2].substring(0,4);

		if (month.equals ("January"))
			month = "01";
		if (month.equals ("February")) 
			month = "02";
		if (month.equals ("March")) 
			month = "03";
		if (month.equals ("April")) 
			month = "04";
		if (month.equals ("May")) 
			month = "05";
		if (month.equals ("June")) 
			month = "06";
		if (month.equals ("July")) 
			month = "07";
		if (month.equals ("August")) 
			month = "08";
		if (month.equals ("September")) 
			month = "09";
		if (month.equals ("October")) 
			month = "10";
		if (month.equals ("November")) 
			month = "11";
		if (month.equals ("December")) 
			month = "12";

		return ymd =  year + month + day;
	}
}
