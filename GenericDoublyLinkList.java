package GenericLinkList;

public class GenericDoublyLinkList<T> {
	private DoublyNode<T> Head;
	private DoublyNode<T> LinkNode; //currentNode
	private DoublyNode<T> nextNode;
	private DoublyNode<T> temp;
	private int size;
	DoublyNode<T> previousNode;
	DoublyNode<T> current;
	public DoublyNode<T> getHead() {
		return Head;
	}
	public void setHead(DoublyNode<T> head) {
		Head = head;
	}
	public DoublyNode<T> getLinkNode() {
		return LinkNode;
	}
	public void setLinkNode(DoublyNode<T> linkNode) {
		LinkNode = linkNode;
	}
	public DoublyNode<T> getTemp() {
		return temp;
	}
	public void setTemp(DoublyNode<T> temp) {
		this.temp = temp;
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
	
	public void InsertFirst(T data){
		 LinkNode=new DoublyNode<T>(data);
		 Head=LinkNode;
		 LinkNode.setPrevious(Head);
		 size++;
		 
	}
	
	public void addFirst(T data){
		temp = new DoublyNode<T>(data);	
		temp.setNext(LinkNode);
		this.Head = temp;
		this.size++;
		temp.setPrevious(Head);
		LinkNode.setPrevious(temp);
		LinkNode = temp;
	}
	
	
	public void addLast(T data){
		temp = new DoublyNode<T>(data);
		LinkNode.setNext(temp);
		temp.setPrevious(LinkNode);
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
	
public void add(int index,T data){
		current =Head;
		for(int i=1;i<=getSize();i++){
			if(index==i){
				temp=new DoublyNode<T>(data);
				nextNode= current;
				temp.setNext(nextNode);
				nextNode.setPrevious(temp);
				temp.setPrevious(previousNode);
				previousNode.setNext(temp);
				size++;
			}
			previousNode=current;
			if(current.getNext()!=null){
				current=current.getNext();
			}
			else{
					if(index>getSize()){
					System.out.println("index out of bound");
					}
				}
		}
	}

	public void InsertBefore(T data,int index){
			int tempIndex=index-1;
			add(tempIndex,data);
	}
	
	public void InsertAfter(T data,int index){
			int tempIndex=index+1;
			add(tempIndex,data);
	}
	
	public void removeAfter(int index){
			int tempIndex=index+1;
			removeWithIndex(tempIndex);
	}
	
	public void removeBefore(int index){
			int tempIndex=index-1;
			removeWithIndex(tempIndex);
	}
	
	public  T getFirst(){
		return Head.getData();	
	}
	
	public  T getLast(){
		current=Head;
		for(int i=1;i<=getSize();i++){
			if(i==getSize()){
				return current.getData();
			}
			current=current.getNext();
			
		}
		return null;
	}
	
	public void showList(){
		if(Head==null){
			System.out.println("empty List");
		}
		else{
			current = Head;
			for(int i=0;i<getSize();i++){
				System.out.println("Data: "+ current.getData()+" "+"previous:"+current.getPrevious().getData());
				if(current.getNext()!=null){
					System.out.println("next:"+current.getNext().getData());
				}
				else{
					System.out.println("next:null value");
				}
				current = current.getNext();  // i=i+1
			}
			
		}
	}
	
	public T getValueAt(int index){
		try{
			if(index>getSize()||index<=0){
				throw new IndexOutOfBoundException("index out of bound");
			}
		current =Head;
		for(int i=1;i<=getSize();i++){
			if(i==index){
				index=i;
				return current.getData();
			}
		current=current.getNext();
		}
		
		}
		catch(IndexOutOfBoundException e){
			e.getMessage();
		}
		return null;
	}
	
	public int getIndexOf(T data){
		current =Head;
		int index=-1;
		for(int i=1;i<=getSize();i++){
			if(current.getData()==data){
				index=i;
			}
		current=current.getNext();
		}
		return index;
	}
	
	public void deleteAll(){
		Head=null;
	}
	
	
	public void removeWithIndex(int index){
		current =Head;
		if(Head!=null){
		for(int i=1;i<=getSize();i++){
			if(index==i){
				previousNode.setNext(current.getNext());
				current.getNext().setPrevious(previousNode);
				current=previousNode;
				size--;
			}
			previousNode=current;
			if(current.getNext()!=null){
			current=current.getNext();
			}
		}
		}
	}
	
	public void removeFirst(){				
		if(Head!=null){
			Head= Head.getNext();
			Head.setPrevious(Head);
			size--;
		}
	}
	
	public void removeLast(){
		temp=Head;
		for(int i=0;i<getSize();i++){
			if(Head!=null){
				if(temp.getNext()!=null){
					current=temp.getNext();
					temp=temp.getNext();	
				}
				else{
					if(current!=null){
						current.setNext(null);
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

}
