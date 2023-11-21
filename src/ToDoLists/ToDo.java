/**
 * Module: ToDo.
 * Assignment: Lab10a - Debugging ToDo.
 * Base class for an instructive class hierarchy to teach debugging skills. 
 * Instructor's Name: Jeff Light.
 * @author jeffreylight
 * @since 11/17/2019
 */
package ToDoLists;

import java.util.Set;

/**
 * Class: ToDo
 * Assignment: Lab10a - Debugging ToDo.
 * Base class for an instructive class hierarchy to teach debugging skills.
 * Instructor's Name: Jeff Light.
 * @author jeffreylight
 * @since 11/17/2019
 */
public abstract class ToDo implements Modifiable, Comparable<ToDo> {
	//Attributes
	private String title;				//Title of the ToDo plan
	private int toDoID;					//ID of the ToDo plan
	private static int nextToDoID=1;	//Holds the next ID for the class.
	
	
	//Constructors
	/**
	 * Default Constructor.  Not intended for normal use.
	 * Abstract Superclass.  Should not be instantiated directly.
	 * Sets all class attributes to their default values based on type.
	 * Automatically assigns the toDoID and increments the nextToDoID.
	 * 
	 * @return	void
	 */
	public ToDo() {
		title = "";
		toDoID = nextToDoID;
		nextToDoID ++;
	}//end of constructor ToDo()

	/**
	 * Primary Constructor.
	 * Automatically assigns the toDoID and increments the nextToDoID.
	 * 
	 * @param t	The title of a ToDo list object.  User created through a user interface.
	 * @return	void
	 */
	public ToDo(String t) {
		title = t;
		toDoID = nextToDoID;
		nextToDoID ++;
	}//end of constructor ToDo(String)	
	
	
	//Methods
	/**
	 * title getter method
	 * 
	 * @return	A String with the title of the ToDo list object. 
	 */
	public String getTitle() {
		return title;
	}//end of method getTitle()

	/**
	 * toDoID getter method
	 * 
	 * @return	An int with the toDoID of the ToDo list object.
	 */
	public int getToDoID() {
		return toDoID;
	}//end of method getToDoID()	

	/**
	 * title setter method
	 * 
	 * @param	s	A String with the title of the ToDo list object.
	 * @return		A String with the title of the ToDo list object. 
	 */
	public String setTitle(String s) {
		title = s;
		return title;
	}//end of method setTitle(String)
	
	/**
	 * Returns the Set<String> of keys from a HashMap<String, Integer>.
	 *
	 * @return	Set<String> of keys from a HashMap<String, Integer>.
	 */	
	public abstract Set<String> getItems();
	
	/**
	 * Returns void.
	 * Adds a new key/value pair in a HashMap<String, Integer>.
	 *
	 * @param	item		The key to the new entry in HashMap(String, Integer).
	 * @param	quantity	The value for the new entry in HashMap(String, Integer).
	 * @return				void 
	 */	
	public abstract void add(String item, int quantity);

	/**
	 * Returns void.
	 * Modifies the value in a key/value pair by change amount for the associated key in a HashMap<String, Integer>.
	 *
	 * @param	item	The key to the entry in HashMap(String, Integer) that needs to be modified.
	 * @param	changeQty	The amount the existing value needs to change.
	 * @return			void 
	 */	
	public abstract void change(String item, int changeQty);
	
	/**
	 * Returns void.
	 * Deletes the key/value pair indicated by the key in a HashMap<String, Integer>.
	 *
	 * @param	item	The key to the entry in the HashMap(String, Integer) that will be deleted.
	 * @return			void 
	 */	
	public abstract void delete(String item);
	
	/**
	 * Returns a String that represents the ToDo Plan in a readable format.
	 *
	 * @return	String that represents the ToDo Plan in a readable format.
	 */
	public abstract String toString();

	@Override
	public int compareTo(ToDo toDo){
		return Double.compare(this.toDoID, toDo.toDoID);
	}
	
}//end of class ToDo
