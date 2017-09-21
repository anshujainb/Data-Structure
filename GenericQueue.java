package GenericLinkList;

public class GenericQueue implements DataStructure {
	 LinkList<Object> l= new LinkList<Object>();
	@Override
	public void add(Object data) {
		if (l.listIsEmpty()==true){
			l.InsertFirst(data);
		}
		else{
			l.addLast(data);
		}
		
	}

	@Override
	public void remove() {
		l.removeLast();
		
	}
	
	public void Enqueue(int data){
		add(data);
	}

	public void Dequeue(){
		remove();
	}

	public Object Peek(){
		return l.getFirst();
	}

}
