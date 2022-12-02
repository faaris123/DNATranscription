public class Node<T> {
  private T data;
  private Node<T> next;

  /**
   * This is a basic constructor which creates a node that contains the provided data and no
   * linkages
   * 
   * @param data
   */
  public Node(T data) {
    this.data = data;
  }

  /**
   * This constructor allows for the specification of the next node in the chain
   * 
   * @param data
   * @param next
   */
  public Node(T data, Node<T> next) {
    this(data);
    this.next = next;
  }

  /**
   * Accessor method for this node's data, getter method for data
   * 
   * @return The data contained in a node
   */
  public T getData() {
    return data;
  }

  /**
   * Accessor method for the node following this one, getter method for the next node
   * 
   * @return The next node
   */
  public Node<T> getNext() {
    return next;
  }

  /**
   * Mutator method for the node following this one, setter method for the next node
   * 
   * @param next
   */
  public void setNext(Node<T> next) {
    this.next = next;
  }
}
