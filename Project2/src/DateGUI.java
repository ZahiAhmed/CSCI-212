//Ahmed, Zahi Lab 11E
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;

public class DateGUI extends JFrame implements ActionListener {
	UnsortedDateList unsort;
	SortedDateList sort;
	JFrame frame;
    Container myContentPane;
    TextArea Unsorted = new TextArea();
    TextArea Sorted = new TextArea();
    
    //creating gui
    public DateGUI(String title){
    	setTitle(title);
    	setSize(400, 300);
    	setLocation(600, 400);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	myContentPane = getContentPane();
    	myContentPane.setLayout(new GridLayout(1,2));
    	myContentPane.add(Unsorted);
    	myContentPane.add(Sorted);
    	Unsorted.setEditable(false);
    	Sorted.setEditable(false);
   
    	//creating menu 
    	JMenuItem item;
    	JMenuBar menuBar = new JMenuBar();
    	JMenu fileMenu = new JMenu("File");
    	item = new JMenuItem("Open");
    	item.addActionListener(this);
    	fileMenu.add(item);
    	item = new JMenuItem("Quit");
    	item.addActionListener(this);
    	fileMenu.add(item);
    	setJMenuBar(menuBar);
    	menuBar.add(fileMenu);		
    	setVisible(true);
    }
	
    //setting up action listener
    public void actionPerformed(ActionEvent e) {

		String menuName = e.getActionCommand();
		if(menuName.equals("Open")){
			openFile();
		}
		else if(menuName.equals("Quit"))
			System.exit(0);
	}
	
    private void openFile(){
		JFileChooser chooser;
		int status;
		chooser=new JFileChooser();
		status=chooser.showOpenDialog(null);
		if(status==JFileChooser.APPROVE_OPTION){
			readFile(chooser.getSelectedFile());
		}
	}
    
    //reads text file
    private void readFile(File chosenFile){
		
        sort = new SortedDateList();
        unsort = new UnsortedDateList();
               
        //read file,put data into datelist. 
		String filename = chosenFile.getAbsolutePath();
	    TextFileInput input = new TextFileInput(filename);
	    
	    String line = input.readLine();
		while(line!=null){
			StringTokenizer date = new StringTokenizer(line,",");
			while(date.hasMoreTokens()){
				String token=date.nextToken();
				try{
		        	Date212 myDate = new Date212(token);	
		        	unsort.add(myDate);
		            sort.add(myDate);
				}
				catch(IllegalArgumentException e){
					System.out.println(token);
				}
			}
			line = input.readLine();
		}
		input.close();
        
		//read data from datelist and put data into textarea.
        DateNode node1=sort.getFirst().Next;
        DateNode node2=unsort.getFirst().Next;
        
        Sorted.setText("");
        Unsorted.setText("");
        
        while(node1 != null&&node2 != null){
        	Sorted.append(node1.Data+"\n");
        	Unsorted.append(node2.Data+"\n");
        	node2 = node2.Next;
        	node1 = node1.Next;       	
        }
        setVisible(true);
	}
}
