public interface QueueADT<T> {
  
  /**
   * Adds one element to the back of the queue
   * @param element
   */
  public void enqueue(T element);

  /**
   * Removes and returns the element at the front of the queue
   * @return
   */
  public T dequeue();

  /**
   * Returns without removing the element at the front of the queue
   * @return
   */
  public T peek();

  /**
   * Returns true if and only if the queue contains no elements
   * @return
   */
  public boolean isEmpty();

  /**
   * Returns the number of elements in the queue
   * @return
   */
  public int size();

  /**
   * Returns a string representation of the queue
   * @return
   */
  public String toString();
}
