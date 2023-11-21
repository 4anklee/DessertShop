/**
 * Module: ShoppingPlan.
 * Assignment: Lab10a - Debugging ToDo.
 * @author jeffreylight
 * @since 11/17/2019
 */
package ToDoLists;


import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import static ToDoLists.Planner.getValidInt;

/**
 * Class: ShoppingPlan.
 * Assignment: Lab10a - Debugging ToDo.
 * Subclass for an instructive class hierarchy to teach debugging skills.
 * A Shopping Plan describes items and amounts you need to buy.
 * Includes shopping information as well as a shopping list.
 * @author jeffreylight
 * @since 11/17/2019
 */
public class ShoppingPlan extends ToDo {
	private final Scanner in = new Scanner(System.in);
	//Attributes
	private final HashMap<String, Integer> items;		//HashMap that holds the items needed(key) and their quantities(value) for a Shopping Plan
	private String shoppingType;				//Describes the type of shopping to be done.  E.g. "Groceries", "Home Improvement", "Crafts", etc.
	
	//Constructors
	/**
	 * Default Constructor.  Not intended for normal use.
	 * Sets all class attributes to their default values based on type.
	 * Instantiates a new items HashMap(String, Integer).
	 *
	 * @return	void
	 */
	public ShoppingPlan() {
		super();
		shoppingType = "";
		items = new HashMap<>();
	}//end of constructor ShoppingPlan()
	
	/**
	 * Primary Constructor.
	 * Sets all class attributes to their default values based on type.
	 * Instantiates a new items HashMap(String, Integer).
	 * 
	 * @param	t		The title of a ToDo list object.  User created through a user interface.
	 * @param	type	The type of shopping being planned.  Ex: "Groceries", "Home Improvement", "Crafts", etc. User created through a user interface.
	 * @return	void
	 */
	public ShoppingPlan(String t, String type) {
		super(t);
		shoppingType = type;
		items = new HashMap<>();
	}//end of constructor ShoppingPlan(String)
	
	
	//Methods
	/**
	 * shoppingType getter method
	 * 
	 * @return	A String with the shoppingType of the ShoppingPlan object. 
	 */
	public String getShoppingType() {
		return shoppingType;
	}//end of method getShoppingType()

	/**
	 * shoppingType setter method
	 * 
	 * @param	t	A String containing the shoppingType to be set.
	 * @return		A String with the shoppingType for the ShoppingPlan object. 
	 */
	public void setShoppingType(String t) {
		shoppingType = t;
	}//end of method setShoppingType()
	
	/**
	 * Returns a HashMap<String, Integer> containing a list of items (key) and their associated quantities (value).
	 *
	 * @return	HashMap<String, Integer>.
	 */	
	public HashMap<String, Integer> getMap(){
		return items;
	}//end of method getMap()

	/**
	 * Returns true if HashMap(String item, Integer quantity) contains the item as a key.
	 * Returns false otherwise.
	 *
	 * @param	item	The key to the HashMap(String, Integer).
	 * @return			A boolean indicating if the key is in the HashMap. 
	 */	
	public boolean hasItem(String item) {
        //end of if(gear.containsKey(item))
        return items.containsKey(item);
    }//end of method hasItem(String)
	
	/**
	 * Returns the Set<String> of keys from a HashMap<String, Integer>.
	 *
	 * @return	Set<String> of keys from a HashMap<String, Integer>.
	 */	
	public Set<String> getItems(){
		return items.keySet();
	}//end of method getItems()
	
	/**
	 * Returns the Collection<Integers> of values from a HashMap<String, Integer>.
	 *
	 * @return	Collection<Integers> of values from a HashMap<String, Integer>.
	 */	
	public Collection<Integer> getAmounts(){
		return items.values();
	}//end of method getAmounts()
		
	/**
	 * Returns the quantity (value) for the associated String key in a HashMap<String, Integer>
	 * or -1 if the key is not found.
	 *
	 * @param	item	The key to the HashMap(String, Integer).
	 * @return			The value for the associated key in the HashMap. 
	 */	
	public int getAmount(String item) {
		return items.getOrDefault(item, -1);
	}//end of method getAmount(String)
	
	/**
	 * Returns void.
	 * Adds a new key/value pair in a HashMap<String, Integer>.
	 *
	 * @param	item		The key to the new entry in HashMap(String, Integer).
	 * @param	quantity	The value for the new entry in HashMap(String, Integer).
	 * @return				void 
	 */	
	public void add(String item, int quantity) {
		items.put(item, quantity);
	}//end of method add(String, int)
	
	/**
	 * Returns void.
	 * Modifies the value in a key/value pair by change amount for the associated key in a HashMap<String, Integer>.
	 *
	 * @param	item	The key to the entry in HashMap(String, Integer) that needs to be modified.
	 * @param	change	The amount the existing value needs to change.
	 * @return			void 
	 */	
	public void change(String item, int change) {
		int current = items.get(item);
		while(current + change <= 0){
			try{
				throw new IllegalArgumentException();
			}catch(IllegalArgumentException e) {
				System.out.println("The quantity can't be negative.");
				change = getValidInt(in, "How many would you like to add or subtract?: ", "Invalid response.  Please enter a whole number.");
			}
		}
		items.put(item, current + change);
	}//end of method change(String, int)

	/**
	 * Returns void.
	 * Deletes the key/value pair indicated by the key in a HashMap<String, Integer>.
	 *
	 * @param	item	The key to the entry in the HashMap(String, Integer) that will be deleted.
	 * @return			void 
	 */	
	public void delete(String item) {
		items.remove(item);
	}//end of method delete(String)
	
	/**
	 * Returns an int indicating how many entries are in the HashMap<String, Integer>.
	 *
	 * @return	int indicating how many entries are in the HashMap<String, Integer>.
	 */	
	public int getSize() {
		return items.size();
	}//end of method getSize()

	/**
	 * Returns a String that represents the Shopping Plan in a readable format.
	 *
	 * @return	String that represents the Shopping Plan in a readable format.
	 */
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append("\n--------------------------------------\n");
		text.append(String.format("%-25s%s\n", this.getTitle(), this.shoppingType));
		text.append("--------------------------------------\n");
		for(String item : items.keySet()) {
			text.append(String.format("  %-20s%8d\n", item, this.getAmount(item)));
		}//end of for(String item : items.keySet())
		text.append("--------------------------------------");
		return text.toString();
	}//end of method toString()
	
}//end of class ShoppingPlan
