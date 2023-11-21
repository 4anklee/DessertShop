/**
 * Module: PackingPlan.
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
 * Class: PackingPlan.
 * Subclass for an instructive class hierarchy to teach debugging skills.
 * A Packing Plan describes things that need to be planned for a trip.
 * Ex. Vacation or business trip.
 * Includes trip information as well as a packing list.
 * @author jeffreylight
 * @since 11/17/2019
 */
public class PackingPlan extends ToDo {
	private final Scanner in = new Scanner(System.in);
	//Attributes
	private final HashMap<String, Integer> gear;		//HashMap that holds the items needed(key) and their quantities(value) for a Packing Plan
	private String destination;					//Destination of the trip
	private int travelers;						//How many travelers will be going on the trip
	private String tripType;					//Type of trip. E.g. "Business", "Vacation", "Sports", etc.
	
	//Constructors
	/**
	 * Default Constructor.  Not intended for normal use.
	 * Sets all class attributes to their default values based on type.
	 * Instantiates a new gear HashMap(String, Integer).
	 * 
	 * @return	void
	 */
	public PackingPlan() {
		super();
		destination = "";
		travelers = 1;
		tripType = "";
		gear = new HashMap<>();
	}//end of constructor PackingPlan()

	/**
	 * Primary Constructor.
	 * Sets all class attributes to their default values based on type.
	 * Instantiates a new gear HashMap(String, Integer).
	 * 
	 * @param	t		The title of a ToDo list object.  User created through a user interface.
	 * @param	d		The destination of a Packing Plan.  User created through a user interface.
	 * @param	people	The number of travelers for a Packing Plan.  User created through a user interface.
	 * @param	type	The type of trip being planned.  Ex: "Camping", "Business", etc. User created through a user interface.
	 * @return	void
	 */
	public PackingPlan(String t, String d, int people, String type) {
		super.setTitle(t);
		destination = d;
		travelers = people;
		tripType = type;
		gear = new HashMap<>();
	}//end of constructor PackingPlan(String)	
	
	
	//Methods
	/**
	 * destination getter method
	 * 
	 * @return	A String with the destination of the PackingPlan object. 
	 */
	public String getDestination() {
		return destination;
	}//end of method getDestination()

	/**
	 * travelers getter method
	 * 
	 * @return	An int with the travelers of the PackingPlan object. 
	 */
	public int getTravelers() {
		return travelers;
	}//end of method getTravelers()
	
	/**
	 * tripType getter method
	 * 
	 * @return	A String with the tripType of the PackingPlan object. 
	 */
	public String getTripType() {
		return tripType;
	}//end of method getTripType()

	/**
	 * destination setter method
	 * 
	 * @param	d	A String containing the destination to be set.
	 * @return		A String with the destination for the PackingPlan object. 
	 */
	public void setDestination(String d) {
		destination = d;
	}//end of method setDestination()

	/**
	 * travelers setter method
	 * 
	 * @param	t	An int containing the number of travelers to be set.
	 * @return		An int with the number of travelers for the PackingPlan object. 
	 */
	public void setTravelers(int t) {
		travelers = t;
	}//end of method setTravelers()

	/**
	 * tripType setter method
	 * 
	 * @param	t	A String containing the tripType to be set.
	 * @return		A String with the tripType for the PackingPlan object. 
	 */
	public void setTripType(String t) {
		tripType = t;
	}//end of method setTripType()
	
	/**
	 * Returns a HashMap<String, Integer> containing a list of items (key) and their associated quantities (value).
	 *
	 * @return	HashMap<String, Integer>.
	 */	
	public HashMap<String, Integer> getMap(){
		return gear;
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
        return gear.containsKey(item);
    }//end of method hasItem(String)
	
	/**
	 * Returns the Set<String> of keys from a HashMap<String, Integer>.
	 *
	 * @return	Set<String> of keys from a HashMap<String, Integer>.
	 */	
	public Set<String> getItems(){
		return gear.keySet();
	}//end of method getItems()
	
	/**
	 * Returns the Collection<Integers> of values from a HashMap<String, Integer>.
	 *
	 * @return	Collection<Integers> of values from a HashMap<String, Integer>.
	 */	
	public Collection<Integer> getAmounts(){
		return gear.values();
	}//end of method getAmounts()
		
	/**
	 * Returns the quantity (value) for the associated String key in a HashMap<String, Integer>
	 * or -1 if the key is not found.
	 *
	 * @param	item	The key to the HashMap(String, Integer).
	 * @return			The value for the associated key in the HashMap. 
	 */	
	public int getAmount(String item) {
		return gear.getOrDefault(item, -1);
	}//end of method getAmount(String)
	
	/**
	 * Returns void.
	 * Adds a new key/value pair in a HashMap<String, Integer>.
	 *
	 * @param	item			The key to the new entry in HashMap(String, Integer).
	 * @param	quantity	The value for the new entry in HashMap(String, Integer).
	 * @return				void 
	 */	
	public void add(String item, int quantity) {
		gear.put(item, quantity);
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
		int current = gear.get(item);
		while(current + change <= 0){
			try{
				throw new IllegalArgumentException();
			}catch(IllegalArgumentException e) {
				System.out.println("The quantity can't be negative.");
				change = getValidInt(in, "How many would you like to add or subtract?: ", "Invalid response.  Please enter a whole number.");
			}
		}
		gear.put(item, current + change);
		System.out.printf("\nThe '%s' item has been updated by %d.\n", item, change);
	}//end of method change(String, int)
	
	/**
	 * Returns void.
	 * Deletes the key/value pair indicated by the key in a HashMap<String, Integer>.
	 *
	 * @param	item	The key to the entry in the HashMap(String, Integer) that will be deleted.
	 * @return			void 
	 */	
	public void delete(String item) {
		gear.remove(item);
	}//end of method delete(String)

	/**
	 * Returns an int indicating how many entries are in the HashMap<String, Integer>.
	 *
	 * @return	int indicating how many entries are in the HashMap<String, Integer>.
	 */	
	public int getSize() {
		return gear.size();
	}//end of method getSize()

	/**
	 * Returns a String that represents the Packing Plan in a readable format.
	 *
	 * @return	String that represents the Packing Plan in a readable format.
	 */
	public String toString() {
		String text = "";
		text = text + "\n------------------------------------------\n";
		text = text + String.format("%-28sFor: %s\n",this.getTitle(), this.getTripType());
		text = text + String.format("%-28sTravelers: %d\n",("To: " + this.getDestination()), this.getTravelers());
        StringBuilder textBuilder = new StringBuilder(text + "------------------------------------------\n");
        for(String item : gear.keySet()) {
			textBuilder.append(String.format("  %-20s%8d\n", item, this.getAmount(item)));
		}//end of for(String item : gear.keySet())
        text = textBuilder.toString();
        text = text + "------------------------------------------";
		return text;
	}//end of method toString()
	
	
}//end of class PackingPlan
