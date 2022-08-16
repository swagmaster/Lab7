

/*
 * Adam Atienza
 * 
 * Queue class has similar functions to ArrayList, but uses enqueue and dequeue to follow FIFO
 */
public class Queue {
	
    private Object[] queue = new Object[1]; 
    private int numElements = 0;
    int back; 

    public Queue() {
    	
    }
    /*
     * Add the object to the 'back' of the queue and expand the queue size.
     */
    public void enqueue(Object other) {
        if(numElements + 1 == queue.length)
            expand();
        queue[numElements] = other;
        numElements++;
        back = numElements - 1;

    }
    /*
     * Remove the object from the 'front' of the queue and shift the queue size.
     */
    public Object dequeue() {
        Object retVal = queue[0];
        shift();
        back--;
        numElements--;
        return retVal;
    }

    /*
     * Return the number of elements in the queue.
     */
    public int size() {
        return numElements;
    }
    
    /*
     * Shifts the items of the queue when something is dequeue'd.
     */
    private void shift() {
        for (int j = 0; j < back; j++)
            queue[j] = queue[j + 1];
    }

    /*
     * Expands the size of the queue and adds the elements back into the newly sized queue.
     */
    private void expand() {
        Object[] box = new Object[queue.length * 2]; 
        for (int i = 0; i < numElements; i++)
            box[i] = queue[i];

        queue = box;
    }

    /*
     * Checks if queue is empty.
     */
    public boolean isEmpty() {
        if ((numElements == 0))
            return true;
        else
            return false;
    }

    /*
     * Checks if another object is equal to another instance of the Queue object.
     */
    public boolean equals(Object other) {
        if ((other == null) || !(other instanceof Queue)) 
            return false;

        Queue that = (Queue) other;
        if (this.size() != that.size())
            return false;

        for (int i = 0; i < numElements; i++) {
            if ((this.queue[i]).equals(that.queue[i])) //checks if the items of the two objects are exact at the same index
                continue;
            else
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "Front--->  ";
        for (int i = 0; i < numElements; i++)
            s += queue[i] + " ";
        return s + " <---Back";
    }

}