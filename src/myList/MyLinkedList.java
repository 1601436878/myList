package myList;


public class MyLinkedList {
	private Node first ;
	private Node last;
	private int size;
	
	/**
	 * 增加元素
	 * @param data
	 */
	public void add(Object data){
		Node temp = new Node();
		temp.setData(data);
		
		if (first == null){
			temp.setPrevious(null);
			temp.setNext(null);
			
			first = temp ;
			last = temp ;
		}
		else{
			temp.setNext(null);
			temp.setPrevious(last);
			
			last.setNext(temp);
			last = temp;
		}
		size++;
	}
	/**
	 * 指定位置插入元素
	 * @param index
	 * @param data
	 */
	public void add(int index , Object data){
		Node temp = getNode(index);
		
		Node s = new Node();
		s.setData(data);
		
		Node up = temp.getPrevious();
		
		s.setPrevious(up);
		s.setNext(temp);
		up.setNext(s);
		temp.setPrevious(s);
		
		size++;
	}
	public Object get(int index){
		if(index<0 || index>size){
			try{
				throw new Exception();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return getNode(index).getData();
	}
	/**
	 * 移除指定位置的元素
	 * @param index
	 */
	public void remove(int index){
		Node temp = getNode(index);
		
		Node up = temp.getPrevious();
		Node down = temp.getNext();
		
		up.setNext(down);
		down.setPrevious(up);
		
		size--;
	}
	public int size(){
		return size;
	}
	
	public Node getNode(int index){
		Node temp = first ;
		for(int i=0;i<index;i++){
			temp = temp.getNext();
		}
		return temp;
	}
	
	
	
	//测试
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		System.out.println(list.size());
		list.remove(2);
		for(int i=0 ;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	

}
/**
 * 链表的节点
 * @author wangchao
 *
 */
class Node{
	private Node previous;
	private Object data;
	private Node next;
	
	public Node(){}
	public Node(Node previous, Object data, Node next) {
		super();
		this.previous = previous;
		this.data = data;
		this.next = next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
