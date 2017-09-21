package GenericLinkList;


public class GenericStack implements DataStructure{
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
		
	public void Push(Object data){
		add(data);
	}
	
	public void Pop(){
		remove();
	}
	
	public Object Peek(){
		return l.getLast();
	}
}
