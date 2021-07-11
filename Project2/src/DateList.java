//Ahmed, Zahi Lab 11E
public abstract class DateList {

	private DateNode first;
	private DateNode last;
	private int length;
	
	public DateList(){
		DateNode head = new DateNode(null);
		first = head;
		last = head;
		length = 0;
	}
	
	public void append(DateNode d){
		last.Next = d;
		last = d;
		length++;
	}
	
	public int getLength(){
		return length;
	}
	
	public DateNode getFirst(){
		return first;
	}
	
	public DateNode getLast(){
		return last;
	}
}
