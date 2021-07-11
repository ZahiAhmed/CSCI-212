//Ahmed, Zahi Lab 11E
import javax.swing.*;
import java.awt.*;


public class DateGUI extends JFrame {    
	UnsortedDateList unsort;
	SortedDateList sort;
    Container myContentPane;
    TextArea Unsorted = new TextArea();
    TextArea Sorted = new TextArea();
    JMenuBar menuBar = new JMenuBar();
	
	//creating gui
	public DateGUI(String title){
    	setTitle(title);
    	setLayout(new GridLayout(1,2));
    	setSize(500,500);
    	setLocation(600, 400);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	myContentPane = getContentPane();
    	myContentPane.add(Unsorted);
    	myContentPane.add(Sorted);
    	
    	unsort = new UnsortedDateList();
    	sort = new SortedDateList();
    	Unsorted.setEditable(false);
    	Sorted.setEditable(false);
    	
    	fileMenu(menuBar);
    	editMenu(menuBar);
    	setVisible(true);
	}
    	//create filemenu
    	private void fileMenu(JMenuBar menuBar){
    		JMenuItem item;
        	JMenu fileMenu = new JMenu("File");
        	FileMenuHandler fmh = new FileMenuHandler(this);
        	item = new JMenuItem("Open");
        	item.addActionListener(fmh);
        	fileMenu.add(item);
        	item = new JMenuItem("Quit");
        	item.addActionListener(fmh);
        	fileMenu.add(item);  
        	setJMenuBar(menuBar);
        	menuBar.add(fileMenu);
    	}
    	
    	//create editmenu
    	private void editMenu(JMenuBar menuBar){
    		JMenuItem item;
        	JMenu editMenu = new JMenu("Edit");
        	EditMenuHandler emh = new EditMenuHandler(this);
        	item = new JMenuItem("Insert");
        	item.addActionListener(emh);
        	editMenu.add(item);  
        	setJMenuBar(menuBar);
        	menuBar.add(editMenu);
    		
    	}
}
