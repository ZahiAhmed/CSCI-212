//Ahmed, Zahi Lab 11E

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;


public class Project1 {
	private static List<Date212> dates = new ArrayList<Date212>();
	static DateGUI gui = new DateGUI("Project 1", 500, 500);
	
	//main
	public static void main(String[] args) {
		populateGUI("input.txt");
	}
  
  //SelectionSort method modified to fit project
  private static void SelectionSort() {
    for(int i = 0; i < dates.size(); i++) {
      int p = i;
      for(int j = i; j < dates.size(); j++) {
        if(dates.get(j).compareTo(dates.get(p)) == -1) {
          p = j;
        }
      }
      Date212 m = dates.get(p);
      dates.set(p, dates.get(i));
      dates.set(i, m);
    }
  }
  //creating textareas and sorting dates
  private static void populateGUI(String file) {
    Container contentPane = gui.getContentPane();
    contentPane.setLayout(new GridLayout(1, 2));
    TextArea textarea1 = new TextArea();
    TextArea textarea2 = new TextArea();
    textarea1.setEditable(false);
    textarea2.setEditable(false);
    contentPane.add(textarea1);
    contentPane.add(textarea2);
    gui.setVisible(true);

    TextFileInput tfi = new TextFileInput(file);
    String line = tfi.readLine();
    
    //StringTokenizer separating the dates from input file
    StringTokenizer s;
    String list;
    while(line != null) {
      s = new StringTokenizer(line, ",");
      while(s.hasMoreTokens()) {
        list = s.nextToken();
        textarea1.append(list + "\n");
        dates.add(new Date212(list));
      }
      line = tfi.readLine();
    }

    SelectionSort();
    for(int i = 0; i < dates.size(); i++) {
      textarea2.append(dates.get(i).toString() + "\n");
    }
  }
}
