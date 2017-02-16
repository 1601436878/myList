package myList;


public class MyArrayList {
	private Object [] elementData;
	private int size;
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int initCapacity){
		if(initCapacity<0){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		elementData = new Object[initCapacity];
	}
	/**
	 * ����
	 * @param data
	 * @return
	 */
	public boolean add(Object data){
		if(size>=elementData.length){
			Object [] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = data;
		return true;
	}
	/**
	 * Ԫ�ظ���
	 * @return
	 */
	public int getSize(){
		return size;
	}
	/**
	 * �жϼ����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return size==0;
	}
	/**
	 * ��ȡ�±�Ϊindex��Ԫ��
	 * @param index
	 * @return
	 */
	public Object get(int index){
		this.rangeCheck(index);
		return elementData[index];
	}
	
	/**
	 * �����±��Ƴ�Ԫ��
	 * @param index
	 */
	public void remove(int index){
		this.rangeCheck(index);
		System.arraycopy(elementData, index+1, elementData, index, size-index-1);
		size--;
	}
	
	/**
	 * �Ƴ���data��ȵ�Ԫ��
	 * @param data
	 */
	public void remove (Object data){
		for(int i=0;i<size;i++){
			if(get(i).equals(data))
				remove(i);
		}
	}
	/**
	 * �ı��ض�λ�õ�Ԫ�ص�ֵ
	 * @param index
	 * @param data
	 * @return
	 */
	public Object set(int index,Object data){
		Object oldValue = elementData[index];
		elementData[index] = data;
		return oldValue;
	}
	/**
	 * ���ض�λ�ò���
	 * @param index
	 * @param data
	 */
	public void add(int index , Object data){
		ensureCapacity();
		System.arraycopy(elementData, index, elementData, index+1, elementData.length-index-1);
		elementData[index] = data;
		size++;
	}
	
	/**
	 * �������С������
	 */
	private void ensureCapacity(){
		if(size>=elementData.length){
			Object [] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
	}
	/**
	 * ��������Ƿ�װ��
	 * @param index
	 */
	private void rangeCheck(int index){
		if(index<0||index>=size){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
		
	//-----------------------------------------------
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add(3,"ddd");
		System.out.println(list.getSize());
		for(int i=0;i<list.getSize();i++){
			System.out.println(list.get(i));
		}
	}

}
