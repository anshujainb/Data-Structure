package GenericLinkList;

public class LinkList<T>{
	private GenericNode<T> Head;
	private GenericNode<T> LinkNode; //CurrentNode
	private GenericNode<T> nextNode;
	private GenericNode<T> temp;
	private int size;
	GenericNode<T> previous;
	GenericNode<T> Current;
	
	public GenericNode<T> getHead() {
		return Head;
	}
	public void setHead(GenericNode<T> head) {
		Head = head;
	}
	public GenericNode<T> getLinkNode() {
		return LinkNode;
	}
	public void setLinkNode(GenericNode<T> linkNode) {
		LinkNode = linkNode;
	}
	public GenericNode<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(GenericNode<T> nextNode) {
		this.nextNode = nextNode;
	}
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
	
	public void InsertFirst(T value){
		 LinkNode=new GenericNode<T>(value);
		 size++;
		 Head=LinkNode;
	}
	
	public void addFirst(T value){
		temp = new GenericNode<T>(value);	
		temp.setNode(Head);
		this.Head = temp;
		this.size++;
		LinkNode = temp;
	}
	
	public void addLast(T value){
		temp =  new GenericNode<T>(value);	
		LinkNode.setNode(temp);
		LinkNode=temp;
		size++;
	}
	
	public void add(T value){
		if (listIsEmpty()==true){
			InsertFirst(value);
		}
		else{
			addLast(value);
		}
	}
	
	public void add(int index,T value){
		Current =Head;
			for(int i=1;i<=getSize();i++){
				if(index==i){
					if(index==1){
						addFirst(value);
					}
					else
					temp=new GenericNode(value);
					nextNode= Current;
					temp.setNode(nextNode);
					if(previous!=null){
					previous.setNode(temp);
					}
					size++;
				}
				previous=Current;
				if(Current.getNode()!=null){
					Current=Current.getNode();
				}
			}
		}
	
	public T getFirst(){
		return Head.getValue();
	}
	
	public  T getLast(){
		Current=Head;
		for(int i=1;i<=getSize();i++){
			if(i==getSize()){
				return Current.getValue();
			}
			Current=Current.getNode();
		}
		return null;
	}
	
	public void removeWithIndex(int index){
		
		Current =Head;
			if(Head!=null){
			for(int i=1;i<=getSize();i++){
				if(index==i){
					previous.setNode(Current.getNode());
					Current=previous;
					size--;
				}
				previous=Current;
				if(Current.getNode()!=null){
					Current=Current.getNode();
				}
			}
			}
		}
	
	public void deleteAll(){
		Head=null;
	}
	
	public void removeLast(){
		temp=Head;
		for(int i=0;i<getSize();i++){
			if(Head!=null){
				if(temp.getNode()!=null){
					Current=temp.getNode();
					temp=temp.getNode();	
				}
				else{
					if(Current!=null){
						Current.setNode(null);
						size--;
					}
					else{
						temp=null;
						size--;
					}
				}
			}
		}
	}
	
	public int getIndexOf(T value){
		Current =Head;
		int index=-1;
		for(int i=1;i<=getSize();i++){
				if(Current.getValue()==value){
					index=i;
				}
				Current=Current.getNode();
		}
		return index;
	}
	
	public T getValueAt(int index){
		try{
			if(index>getSize()||index<=0){
				throw new IndexOutOfBoundException("index out of bound");
			}
			Current =Head;
			for(int i=1;i<=getSize();i++){
				if(i==index){
					index=i;
					return Current.getValue();
				}
			Current=Current.getNode();
			}
		}
			catch(IndexOutOfBoundException e){
				e.getMessage();
			}
		return null;
	}
	
	
	public void showList(){
		if(Head==null){
			System.out.println("empty List");
		}
		else{
			Current = Head;
			for(int i=0;i<getSize();i++){
				if(Current!=null){
				System.out.println("Data: "+ Current.getValue()+" ");
				Current = Current.getNode();  // i=i+1
				}
			}
		}
	}

}
