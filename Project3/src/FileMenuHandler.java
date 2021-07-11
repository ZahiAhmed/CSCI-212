//Ahmed, Zahi Lab 11E
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

public class FileMenuHandler implements ActionListener{
	
	DateGUI gui;
	UnsortedDateList unsort;
	SortedDateList sort;
    
    public FileMenuHandler(DateGUI gui){
    	this.gui = gui;
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
    
    //opens file
    private void openFile(){
		JFileChooser chooser;
		int status;
		chooser=new JFileChooser();
		status=chooser.showOpenDialog(null);
		if(status==JFileChooser.APPROVE_OPTION){
			readFile(chooser.getSelectedFile());
		}
    }
	
    //reads file
 public void readFile(File chosenFile){
		
        unsort = new UnsortedDateList();
        sort = new SortedDateList();       
        
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
					System.out.println("Invalid Date: " +token);
				}
			}
			line = input.readLine();
		}
		input.close();
        
		//read data from datelist and put data into textarea.
        DateNode node2=unsort.getFirst().Next;
        DateNode node1=sort.getFirst().Next;
        
        
        
        gui.Unsorted.setText("");
        gui.Sorted.setText("");
        
        while(node1 != null&&node2 != null){
        	gui.Unsorted.append(node2.Data+"\n");
        	gui.Sorted.append(node1.Data+"\n");
        	node2 = node2.Next;
        	node1 = node1.Next;       	
        }
        gui.setVisible(true);
	}
}
