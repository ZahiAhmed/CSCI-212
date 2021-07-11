//Ahmed, Zahi Lab 11E
public class UnsortedDateList extends DateList {

	public UnsortedDateList(){
		super();
	}
	
	public void add(Date212 d){
		DateNode newNode = new DateNode(d);
		this.append(newNode);
	}
	
}
