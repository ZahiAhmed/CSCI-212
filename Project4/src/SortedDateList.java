//Ahmed, Zahi Lab 11E
public class SortedDateList extends DateList {

	public SortedDateList(){
		super();
	}

	public void add(Date212 d){
		DateNode newNode = new DateNode(d);
		DateNode temp = getFirst();
		while(temp.Next != null&&newNode.Data.compareTo(temp.Next.Data)>0)
			temp = temp.Next;

		if(temp.Next == null){
			newNode.Next = temp.Next;
			temp.Next = newNode;
			append(newNode);
		}
		else {
			newNode.Next = temp.Next;
			temp.Next=newNode;
		}		
	}

}

