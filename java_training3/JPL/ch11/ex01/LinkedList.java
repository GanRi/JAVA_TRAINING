package ch11.ex01;

public class LinkedList<E> {
	private E element = null;
	private LinkedList<E> next = null;
	
	public boolean add(E element){
		LinkedList<E> newNode = new LinkedList<E>();
		newNode.element = element;
		LinkedList<E> tail = this;
		while(tail.next != null){
			tail = tail.next;
		}
		tail.next = newNode;
		return true;
	}
	
	public void add(int index, E element)throws IndexOutOfBoundsException{
		LinkedList<E> tail = this;
		int i = 0;
		while(i < index && tail.next != null){
			tail = tail.next;
			i++;
		}
		if(i != index){
			throw new IndexOutOfBoundsException();
		}
		
		LinkedList<E> newNode = new LinkedList<E>();
		newNode.element = element;
		newNode.next = tail.next;
		tail.next = newNode;
	}
	
	public E get(int index){
		LinkedList<E> tail = this.next;
		if(tail == null){
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		while(i < index && tail.next != null){
			tail = tail.next;
			i++;
		}
		if(i != index){
			throw new IndexOutOfBoundsException();
		}
		
		return tail.element;
	}
	
	public E remove(int index){
		LinkedList<E> prev = this;
		LinkedList<E> tail = this.next;
		if(tail == null){
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		while(i < index && tail.next != null){
			prev = tail;
			tail = tail.next;
			i++;
		}
		if(i != index){
			throw new IndexOutOfBoundsException();
		}
		
		prev.next = tail.next;
		
		return tail.element;
	}	
	
	public void clear(){
		while(next != null){
			next = next.next;
		}
		
		
	}
	
	public int size(){
		int length = 0;
		LinkedList<E> tail = this;
		while(tail.next != null){
			tail = tail.next;
			length++;
		}
		return length;
	}
	
	public Object[] toArray(){
		int length = size();
		Object[] array = new Object[length];
		LinkedList<E> current = this.next;
		for(int i = 0; i < length; i++){
			array[i] = current.element;
			current = current.next;
		}
		return array;
	}
	
}
