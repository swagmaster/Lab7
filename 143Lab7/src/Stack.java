

/*
 * Adam Atienza
 * 
 * Stack class has similar functions to ArrayList, but uses enqueue and dequeue to follow LIFO
 * 
 */
public class Stack {
	
    private Object[] stack = new Object[1]; 
    private int items = 0; 

    /*
     * Add the object to the 'top' of the stack.
     */
    public void push(Object other) {
        if (items + 1 == stack.length)
            expand();
        stack[items] = other;
        items++;
    }
    
    /*
     * Remove the object from the 'top' of the stack.
     */
    public Object pop() {
        if (items == 0)
            throw new RuntimeException("The stack is empty.");
        items--;
        return stack[items];
    }

    /*
     * Expands the size of the stack and adds the elements back into the newly sized stack.
     */
    private void expand() {
        Object[] box = new Object[stack.length * 2]; 
        for (int i = 0; i < items; i++)
            box[i] = stack[i];

        stack = box;
    }
   
    /*
     * Return number of elements in the stack.
     */
    public int size() {
        return items;
    }
    
    /*
     * Checks if stack is empty.
     */
    public boolean isEmpty() {
        if ((items == 0))
            return true;
        else
            return false;
    }

    /*
     * Checks if another object is equal to another instance of the Stack object.
     */
    public boolean equals(Object other) {
        if ((other == null) || !(other instanceof Stack))
            return false;

        Stack that = (Stack) other;
        if (this.size() != that.size())
            return false;

        for (int i = 0; i < items; i++) {
            if ((this.stack[i]).equals(that.stack[i])) //checks if the items of the two objects are exact at the same index
                continue;
            else
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String s = "Bottom--->  ";
        for (int i = 0; i < items; i++)
            s += stack[i] + " ";

        return s + " <---Top";
    }

}