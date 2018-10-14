/**
 * @author Dr. Rouse, commented by Spencer Davis
 * Assignment 4
 * Completed on 09-26-18
 * Worked on assignment for 1 hour
 * Windows 10
 * Visual studio code
 */

class aNode
{
    protected String data;
    protected aNode link;

    /** An empty constructor for a node */
    public aNode()
    {
        link = null;
        data = "";
    }    

    /** Constructor that accepts a string and a link to the next node*/
    public aNode(String d,aNode n)
    {
        data = d;
        link = n;
    }    

    /**
     * Sets the link between nodes
     * @param n The node to be set
     */
    public void setLink(aNode n)
    {
        link = n;
    }    

    /**
     * Sets the data of a node. Can only be a string.
     * @param d The string to be stored in the node.
     */
    public void setData(String d)
    {
        data = d;
    }    

    /**
     * Returns the link.
     * @return The link between two nodes.
     */
    public aNode getLink()
    {
        return link;
    }    
    
    /**
     * Gets the data that is stored in the node.
     * @return The data stored in the node.
     */
    public String getData()
    {
        return data;
    }
}