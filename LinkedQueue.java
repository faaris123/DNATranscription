import java.util.NoSuchElementException;

public class LinkedQueue<T> implements QueueADT<T> {
  private int n;
  protected Node<T> front;
  protected Node<T> back;

  @Override
  /**
   * Adds one element to the back of the queue
   */
  public void enqueue(T data) {
    Node<T> node = new Node<T>(data);
    if (isEmpty()) {
      back = node;
      front = node;
    } else {
      back.setNext(node);
      back = node;
    }
    n++;
  }

  @Override
  /**
   * Removes and returns the element at the front of the queue
   */
  public T dequeue() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("The queue is empty");
    }

    T data = front.getData();
    if (size() == 1) {
      back = null;
      front = null;
    }

    else {
      front = front.getNext();
    }
    n--;
    return data;
  }

  @Override
  /**
   * Returns without removing the element at the front of the queue
   */
  public T peek() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("The queue is empty");
    }

    T peeked = front.getData();

    return peeked;
  }

  @Override
  /**
   * Returns true if and only if the queue contains no elements
   */
  public boolean isEmpty() {
    if (n == 0) {
      return true;
    }
    return false;
  }

  @Override
  /**
   * Returns the number of elements in the queue
   */
  public int size() {
    return n;
  }
  
  /**
   * Returns a string representation of the queue
   */
  public String toString() {
    String queue = "";
    Node<T> currentNode = front;

    while (currentNode != null) {
      queue = queue + currentNode.getData().toString() + " ";
      currentNode = currentNode.getNext();
    }

    return queue;
  }
}
