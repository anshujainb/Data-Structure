package GenericLinkList;

public class ListOperation {
 
 public static void main(String[] args) {
	 //GenericCircularLinkList<String> l= new  GenericCircularLinkList<String>();
	 GenericDoublyLinkList<String> l=new  GenericDoublyLinkList<String>();
	 l.InsertFirst("anshu");
	 l.add("riya");
	 l.addFirst("asm");
	 l.showList();
	 
}
}
