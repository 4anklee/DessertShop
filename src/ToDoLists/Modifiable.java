/**
 * Interface: Modifiable.
 * Assignment: Lab10a - Debugging ToDo.
 * Interface to be used for an instructive class hierarchy to teach debugging skills.
 * A Modifiable interface describes the methods needed to create, view and update a HashMap.
 * Ex. Packing Lists or Shopping Lists. 
 * @author jeffreylight
 * @since 11/17/2019
 */
package ToDoLists;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Interface: Modifiable.
 * Assignment: Lab10a - Debugging ToDo.
 * Interface to be used for an instructive class hierarchy to teach debugging skills.
 * A Modifiable interface describes the methods needed to create, view and update a HashMap.
 * Ex. Packing Lists or Shopping Lists.
 * Includes:
 *   - public HashMap<String, Integer> getMap().
 *   - public boolean hasItem(String item).
 *   - public Set<String> getItems().
 *   - public Collection<Integer> getAmounts().
 *   - public int getAmount(String item).
 *   - public void add(String item, int quantity).
 *   - public void change(String item, int change).
 *   - public void delete(String item).
 *   - public int getSize().
 * @author jeffreylight
 * @since 11/17/2019
 */
public interface Modifiable {
	/**
	 * Returns a HashMap<String, Integer> containing a list of items (key) and their associated quantities (value).
	 *
	 * @return	HashMap<String, Integer>.
	 */
    HashMap<String, Integer> getMap();

	
	/**
	 * Returns true if HashMap(String item, Integer quantity) contains the item as a key.
	 * Returns false otherwise.
	 *
	 * @param	item	The key to the HashMap(String, Integer).
	 * @return			A boolean indicating if the key is in the HashMap. 
	 */
    boolean hasItem(String item);
	
	
	/**
	 * Returns the Set<String> of keys from a HashMap<String, Integer>.
	 *
	 * @return	Set<String> of keys from a HashMap<String, Integer>.
	 */
    Set<String> getItems();
	
	
	/**
	 * Returns the Collection<Integers> of values from a HashMap<String, Integer>.
	 *
	 * @return	Collection<Integers> of values from a HashMap<String, Integer>.
	 */
    Collection<Integer> getAmounts();
	
	
	/**
	 * Returns the quantity (value) for the associated String key in a HashMap<String, Integer>
	 * or -1 if the key is not found.
	 *
	 * @param	item	The key to the HashMap(String, Integer).
	 * @return			The value for the associated key in the HashMap. 
	 */
    int getAmount(String item);
	
	
	/**
	 * Returns void.
	 * Adds a new key/value pair in a HashMap<String, Integer>.
	 *
	 * @param	item		The key to the new entry in HashMap(String, Integer).
	 * @param	quantity	The value for the new entry in HashMap(String, Integer).
	 * @return				void 
	 */
    void add(String item, int quantity);
	
	
	/**
	 * Returns void.
	 * Modifies the value in a key/value pair by change amount for the associated key in a HashMap<String, Integer>.
	 *
	 * @param	item	The key to the entry in HashMap(String, Integer) that needs to be modified.
	 * @param	change	The amount the existing value needs to change.
	 * @return			void 
	 */
    void change(String item, int change);
	
	
	/**
	 * Returns void.
	 * Deletes the key/value pair indicated by the key in a HashMap<String, Integer>.
	 *
	 * @param	item	The key to the entry in the HashMap(String, Integer) that will be deleted.
	 * @return			void 
	 */
    void delete(String item);

	/**
	 * Returns an int indicating how many entries are in the HashMap<String, Integer>.
	 *
	 * @return	int indicating how many entries are in the HashMap<String, Integer>.
	 */
    int getSize();
	
}//end of interface Modifiable
