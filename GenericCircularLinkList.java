package GenericLinkList;


public class GenericCircularLinkList<T> {
	GenericNode<T> Head;
	GenericNode<T> LinkNode;
	GenericNode<T> Previous;
	GenericNode<T> NextNode;
	GenericNode<T> current;
	GenericNode<T> temp;
	int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean listIsEmpty(){
		 if (Head==null){
			 return true;
		 }
		 	return false;
	}
	
	public void InsertFirst(T data){
		 LinkNode=new GenericNode<T>(data);
		 Head=LinkNode;
		 LinkNode.setNode(Head);
		 size++;
	}
	
	public void addLast(T data){
		temp = new GenericNode<T>(data);
		temp.setNode(Head);
		LinkNode.setNode(temp);
		LinkNode=temp;
		size++;
	}
	
	public  GenericNode<T> getLastNode(){
		current=Head;
		for(int i=1;i<=getSize();i++){
			if(i==getSize()){
				return current.getNode();
			}
			current=current.getNode();
		}
		return null;
	}
	
	
	public  T getLastValue(){
		current=Head;
		for(int i=1;i<=getSize();i++){
			if(i==getSize()){
				return current.getValue();
			}
			current=current.getNode();
		}
		return null;
	}
	
	public T getFirstValue(){
		if(Head!=null){
		return  Head.getValue();
		}
		return null;
	}
	
	
	public int getIndexOf(T data){
		current =Head;
		int index=-1;
		for(int i=1;i<=getSize();i++){
			if(current.getValue()==data){
				index=i;
			}
			
		current=current.getNode();
		}
		
		return index;
	}
	
	public void removeWithIndex(int index){
			current =Head;
			if(Head!=null){
			for(int i=1;i<=getSize();i++){
				if(index==i){
					Previous.setNode(current.getNode());
					current=Previous;
					size--;
				}
				Previous=current;
				if(current.getNode()!=Head){
				current=current.getNode();
				}
			}
			}
		}
	
	public void addFirst(T data){
		Previous=Head.getNode();
		temp=new GenericNode<T>(data);
		temp.setNode(LinkNode);
		Head=temp;
		getLastNode().setNode(Head);
		LinkNode=temp;
		size++;
	}
	
	public void add(T data){
		if (listIsEmpty()==true){
			InsertFirst(data);
		}
		else{
			addFirst(data);
		}
	}
	
	public void Delete(){
		if(Head==null){
			System.out.println("emptyList");
		}
		else{
			current = Head;
			for(int i=0;i<getSize();i++){
				if(current.getNode()==Head){
					Previous.setNode(Head);
					size--;
				}
				Previous=current;
				current = current.getNode();  // i=i+1
			}
		}
	}
	
	public void deleteAll(){
		Head=null;
	}

	public void showList(){
		if(Head==null){
			System.out.println("empty List");
		}
		else{
			current = Head;
			for(int i=0;i<getSize();i++){
				System.out.println("Data: "+current.getValue()+" "+"ptr of next Node:"+current.getNode().getValue());
				current = current.getNode();  // i=i+1
			}
		}
	}

}
