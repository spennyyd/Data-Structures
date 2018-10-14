/**
 * @author Dr. Rouse, commented by Spencer Davis
 * Assignment 4
 * Completed on 09-24-18
 * Worked on assignment for 1 hour
 * Windows 10
 * Visual studio code
 */


class LinkedList
{
    /** The start of the linked list */
    protected aNode start;
    /** The end of the linked list */
    protected aNode end ;
    /** The size of the linked list */
    public int size ;
 
    /** Default constcutor for a linked list */
    public LinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }

    /**
     * Checks if there is a node in the first element of the linked list, thus checking if the list is empty.
     * @return Whether or not the linked list is empty.
     */
    public boolean isEmpty()
    {
        return start == null;
    }

    /**
     * Will get the size of the linked list and return it.
     * @return The size of the linked list.
     */
    public int getSize()
    {
        return size;
    }    

    /**
     * Insterts a string into the start of the list.
     * @param val The (string) value that is going to be inserted.
     */
    public void insertAtStart(String val)
    {
        /** Creates a new node with a String and a null pointer. */
        aNode nptr = new aNode(val, null);    
        size++ ;
        
        // Checks if the start is null and if it is it sets the starting node.
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            // Sets the reference of the ntpr object to the node that was previously in the start position.
            nptr.setLink(start);
            // Sets start to reference the new starting position.
            start = nptr;
        }
    }

    /**
     * Inserts a string into the end of the list.
     * @param val The (string) value that is going to be inserted.
     */
    public void insertAtEnd(String val)
    {
        aNode nptr = new aNode(val,null);    
        size++ ;    

        // Checks if the start of the list is null and if it is sets the starting node to the 
        // new node.
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            // Sets the end node to point to the new node that is being added. 
            end.setLink(nptr);
            // Sets the end variable to point to the new end of the list.
            end = nptr;
        }
    }

    /**
     * Inserts a string at a position in the linked list. Can only be called if at LEAST 2 items are in the list.
     * @param val The string that is going to be added to the list.
     * @param pos The position that the string is going to be added to.
     */
    public void insertAtPos(String val , int pos)
    {
        // Creating a new pointer with the string in it that points to nothing.
        aNode nptr = new aNode(val, null);

        // Variable used to go through the list. Starts at the starting node.                
        aNode ptr = start;

        // It is position - 1 not just the position because you have to stop before arriving at the postition
        // to be added to.
        pos = pos - 1;

        // Start a loop to go through each node until the position is found.
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                // Creating a temporary link and pointing it to the ptr node.
                aNode tmp = ptr.getLink();

                // Setting the current node to point to the new pointer.
                ptr.setLink(nptr);
                
                // Setting the new pointer to point to the temporary link.
                nptr.setLink(tmp); 
                
                break;
            }
            // Gets the next node that ptr is pointing at.
            ptr = ptr.getLink();
        }
        size++ ;
    }

    /**
     * Removes a value from the linked list.
     * @param pos The position that is going to be removed from the linked list.
     */
    public void deleteAtPos(int pos)
    {        
        // This runs if the position the user wants to remove is the starting node.
        if (pos == 1) 
        {
            // The start node is now the node that the old start node was pointing to.
            start = start.getLink();
            size--; 
            return ;
        }

        // This runs if the position the user wants to remove is the ending node.
        if (pos == size) 
        {
            // Two nodes that point to the starting node.
            aNode s = start;
            aNode t = start;

            // Runes while s hasn't hit the final node of the list.
            while (s != end)
            {
                // Set t equal to s
                t = s;
                // Set the pointer s is pointing to to s
                s = s.getLink();
            }
            // Set the end node to t.
            end = t;
            // The end node points to null now.
            end.setLink(null);
            size --;

            // This will exit the method.
            return;
        }

        // Variable used to go through the list. Starts at the starting node.
        aNode ptr = start;

        // It is position - 1 not just the position because you have to stop before arriving at the postition
        // to be added to.
        pos = pos - 1 ;

        // Start a loop to go through each node until the position is found.
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                // Creating a temporary link and pointing it to the ptr node.
                aNode tmp = ptr.getLink();

                // Setting temp equal to the node that temp is pointing at.
                tmp = tmp.getLink();

                // Setting the ptr link to point at the new temp value.
                ptr.setLink(tmp);
                break;
            }
            // Gets the next node that ptr is pointing at.
            ptr = ptr.getLink();
        }
        size-- ;
    }    
}
