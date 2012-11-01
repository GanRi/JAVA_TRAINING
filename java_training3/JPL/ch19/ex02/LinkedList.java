package ch19.ex02;

public class LinkedList 
{
	/**
	 * The content of this node.
	 */
	private Object data;
	
	/**
	 * The next node.
	 */	
	protected LinkedList next;
	
	
	/**
	 * The max capacity of linkedlist if {@value}.
	 */
	public static final int MAX_NUM = 500;
	
	
	/**
	 * Create a linkedlist node with the specified data. Next node is set to <code>null</code>.
	 * @see #LinkedList(Object, LinkedList)
	 * @param data The content of the node.
	 */
	public LinkedList(Object data)
	{
		this(data, null);
	}
	
	
	/**
	 * Create a linkedlist node with the specified data and next node.
	 * @see #LinkedList(Object)
	 * @param data The content of the node.
	 * @param next The next node.
	 */
	public LinkedList(Object data, LinkedList next)
	{
		this.data = data;
		this.next = next;
	}
	
	
	/**
	 * Append nodes to this linkedlist. Nodes could be more than one.
	 * @param nodes Nodes to be added to the list.
	 */
	public void append(LinkedList... nodes)
	{
		if(nodes == null || nodes.length == 0 || nodes[0] == null)
		{
			return;
		}
		LinkedList current = this;
		for(LinkedList node : nodes)
		{
			node.next = current.next;
			current.next = node;
			current = node;
		}
		
		
	}
	
	
	/**
	 * Convert list to string.
	 * @return The string representing all nodes in this list.
	 */
	public String toString()
	{
		if(next != null)
		{
			return data.toString() + "-->\n" + next.toString();
		}
		else
		{
			return data.toString();
		}
	}

	
	/**
	 * Get the content of this node.
	 * @return The content set by {@link #setData(Object)}
	 */
	public Object getData() {
		return data;
	}

	
	/**
	 * Set the content of this node returned by {@link #getData()}.
	 */	
	public void setData(Object data) {
		this.data = data;
	}

	
	/**
	 * Get the next node in this linkedlist.
	 * @return The next node.
	 */	
	public LinkedList getNext() {
		return next;
	}
	
	
	/**
	 * Get the number of nodes in this linkedlist. The max value is {@value ch19.ex02.LinkedList#MAX_NUM}.
	 * @return The current node number.
	 */		
	public int getNodeNum()
	{
		int num = 1;
		LinkedList nextNode = next;
		while(nextNode != null)
		{
			num++;
			nextNode = nextNode.next;
		}
		return num;
	}

}

