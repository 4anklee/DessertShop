/**
 * Class: Planner.
 * @author jeffreylight
 * @since 11/17/2019
 * Assignment: Lab10a - Debugging ToDo.
 * Class for an instructive class hierarchy to teach debugging skills.
 * Contains the main method as well as auxiliary methods to utilize and debug a class hierarchy. 
 * Instructor's Name: Jeff Light.
 */
package ToDoLists;


/*
 * Go to Window->Preferences->Java->Debug->Step Filtering and check all the boxes
 */


import java.util.*;

/**
 * Class for an instructive class hierarchy to teach debugging skills.
 * Contains the main method as well as auxiliary methods to utilize and debug a class hierarchy. 
 * Instructor's Name: Jeff Light.
 * 
 * @author jeffreylight
 * @since 11/17/2019
 */
public class Planner {
	//Attributes
	private static ArrayList<ToDo> plans = new ArrayList<ToDo>();			//An ArrayList of ToDo plans.  These plans will be either Packing Plans or Shopping Plans.
	
	/**
	 * Main method to launch a Planning application.
	 * Can not be instantiated directly.
	 * The application will allow users to create, view and update ToDo plans such as Packing Plans and Shopping Plans.
	 * Presents a menu to the user and calls the associated method.
	 * 
	 * @param	args	Command line input.  Not intended for use.
	 * @return	void
	 */
	public static void main(String[] args) {
		Scanner sIn = new Scanner(System.in);	//Used for user input from the console.	
		String choice;			//The user's choice returned from getCommand().
		boolean done = false;	//while loop control.
		
		//Load Test Data.  Comment out before going to production.
		loadTestData();
		
		//Present a menu to the user and call the associated method.
		//Keep presenting the menu until the user decides to quit.
		while(!done) {
			choice = getCommand(sIn, "Main Menu", new String[]{"View Plans", "Create Plan", "Update Plan", "Exit"});
			if (choice.equalsIgnoreCase("4")) {
				break;
			}//end of if (choice.equalsIgnoreCase("4"))
			switch (choice) {
				case "1":			
					viewModule(sIn);
					break;
				case "2":			
					createModule(sIn);
					break;
				case "3":			
					updateModule(sIn);
					break;
				default:			
					System.out.println("\nInvalid response:  Please enter a choice from the menu (1-3)");
					break;
			}//end of switch (choice)
		}// end of while(!done)
	}//end of main()

	/**
	 * Returns void.
	 * Creates several Packing Plans and Shopping Plans and stores them in the ArrayList<ToDo> plans.
	 * Allows developers and testers to quickly load data for testing purposes.
	 * 
	 * @implNote Remove before release to production.
	 * @return			void
	 */
	public static void loadTestData() {
		PackingPlan p1 = new PackingPlan("June Silver Lake", "Silver Lake", 7, "Camping");
		p1.add("Tent", 3);
		p1.add("First Aid Kit", 1);
		p1.add("Bear Repelant", 4);
		p1.add("Fishing Poles", 7);
		p1.add("Canteen", 10);
		p1.add("Folding Chairs", 5);
		plans.add(p1);
		
		ShoppingPlan s1 = new ShoppingPlan("Maceys", "Groceries");
		s1.add("Oranges", 6);
		s1.add("Bread", 2);
		s1.add("Apples", 12);
		s1.add("Milk", 4);
		s1.add("Fruit Loops", 1);
		s1.add("Potato Chips", 2);
		s1.add("Dip", 2);
		s1.add("Olives", 3);
		s1.add("Aspirin", 1);
		s1.add("Toothpaste", 3);
		s1.add("Instant Noodles", 12);
		s1.add("Hot Dogs", 1);
		s1.add("Hot Dog Buns", 1);
		plans.add(s1);
		
		PackingPlan p2 = new PackingPlan("Summer So Cal", "Disneyland", 7, "Theme Park");
		p2.add("Tickets", 7);
		p2.add("Fanny Pack", 4);
		p2.add("Camera", 3);
		p2.add("Sunglasses", 3);
		p2.add("Water Bottle", 7);
		p2.add("Shoe Inserts", 4);
		p2.add("Snacks", 24);
		
		ShoppingPlan s2 = new ShoppingPlan("Home Depot", "Home Improvement");
		s2.add("1 1/2 in. Screws", 100);
		s2.add("Oak 1x8x76", 3);
		s2.add("Drill", 1);
		s2.add("Phillips Bits", 10);
		s2.add("Shelf Supposrt", 6);
		s2.add("Measuring Tape", 1);
		s2.add("2' Level", 1);
		plans.add(s2);
		
		ShoppingPlan s3 = new ShoppingPlan("Joann's", "Crafts");
		s3.add("Cheese cloth", 1);
		s3.add("Chiffon", 10);
		s3.add("Googly Eyes", 12);
		s3.add("Styrofoam", 6);
		s3.add("Glue", 2);
		plans.add(s3);
		
		plans.add(p2);
		PackingPlan p3 = new PackingPlan("April Quarterly Reviews", "Chicago", 1, "Business");
		p3.add("Suit Coat", 1);
		p3.add("Tie", 2);
		p3.add("Overcoat", 1);
		p3.add("Report Copies", 14);
		p3.add("Laser Pointer", 1);
		plans.add(p3);
		
		PackingPlan p4 = new PackingPlan("July 14 ACME", "Phoenix", 1, "Sales Call");
		p4.add("Gift Cards", 2);
		p4.add("Short Sleeve Shirts", 3);
		p4.add("ACME Tie", 1);
		p4.add("Sunglasses", 1);
		plans.add(p4);
	}//end of loadTestData

	/**
	 * Returns void.
	 * Provides the user with a list of Plans and allows them to select one to view the details.
	 * If the user doesn't select any plan, the return from getPlan will be null and the method exits.
	 * 
	 * @param	sIn	A Scanner object used to get user input.
	 * @return		void
	 */	
	public static void viewModule(Scanner sIn) {
		boolean done = false;	//while loop control.
		ToDo selectedPlan;		//The plan the user would like to view.
		
		//Keep displaying this menu until the user chooses to exit.
		while(!done) {
			selectedPlan = getPlan(sIn);
			if (selectedPlan == null) {
				break;			//User selected No Plan.
			}// end of if (getPlan(sIn) == null)
			System.out.println("\nCurrent Plan Details: View Only Mode");
			System.out.println(selectedPlan);	//Calls the toString() method for the plan which prints out Plan details in a readable form.
		}// end of while(!done)	
	}//end of method viewModule
	
	/**
	 * Returns void.
	 * Provides the user with a sub-menu which allows them to choose to create a Packing Plan or a Shopping Plan.
	 * If the user doesn't select either option, the method exits.
	 * 
	 * @param	sIn	A Scanner object used to get user input.
	 * @return		void
	 */		
	public static void createModule(Scanner sIn) {
		String choice;			//The user's choice returned from getCommand().
		boolean done = false;	//while loop control.
		
		//Keep displaying this menu until the user chooses to exit.
		while(!done) {
			choice = getCommand(sIn, "Create Plan Menu", new String[]{"Create New Packing Plan", "Create New Shopping Plan",});
			if (choice.equalsIgnoreCase("")){
				return;			//User chooses to exit.
			}
			switch (choice) {
				case "1":			
					addPlan(sIn, "Packing");
					break;
				case "2":			
					addPlan(sIn, "Shopping");
					break;
				default:			
					System.out.println("\nInvalid response:  Please enter a choice from the menu (1-2)");
					break;
			}//end of switch (choice)
		}// end of while(!done)			
	}//end of method createModule	
	

	/**
	 * Returns void.
	 * Allows the user to add a plan of playType.
	 * Asks the user appropriate questions for either option.
	 * Creates the new plan and adds it to the plans ArrayList.
	 * 
	 * @param	sIn		 A Scanner object used to get user input.
	 * @param	planType A String (flag) indicating what type of plan will be entered Choices: <Packing, Shopping>.
	 * @return			 void
	 */	
	public static void addPlan(Scanner sIn, String planType) {
		System.out.print("Please enter a title for your new plan: ");
		String planTitle = sIn.nextLine();
		if (planType.equalsIgnoreCase("Packing")) {
			System.out.print("Please enter the destination for the trip: ");
			String destination = sIn.nextLine();
			System.out.print("Please enter the type of trip being planned: ");
			String tripType = sIn.nextLine();			
			int travelers = getValidInt(sIn, "Please enter the number of travelers for this trip: ", "Invalid entry.  Number of travelers must be a whole number.");
			PackingPlan packingPlan = new PackingPlan(planTitle, destination, travelers, tripType);
			plans.add(packingPlan);
			System.out.printf("\nThe '%s' Packing Plan has been created and is ready for update.\n", packingPlan.getTitle());
		} else if(planType.equalsIgnoreCase("Shopping")) {
			System.out.print("Please enter the type of shopping plan: ");
			String shoppingType = sIn.nextLine();		
			ShoppingPlan shoppingPlan = new ShoppingPlan(planTitle, shoppingType);
			plans.add(shoppingPlan);
			System.out.printf("\nThe '%s' Shopping Plan has been created and is ready for update.\n", shoppingPlan.getTitle());
		}//end of(type.equalsIgnoreCase("Packing"))		
	}//end of method addPlan
	
	
	/**
	 * Returns void.
	 * Provides the user with a list of Plans and allows them to select one to modify.
	 * If the user doesn't select any plan, the return from getPlan will be null and the method exits.
	 * Provides the user with a sub-menu which allows them to choose to:
	 * 	 - Add a new item to the selected plan.
	 *   - Change the quantities of an item in the selected plan.
	 *   - Delete an item from the selected plan.
	 * Prints the updated plan.
	 * If the user doesn't select any option, the method exits.
	 * 
	 * @param	sIn		A Scanner object used to get user input.
	 * @return			void
	 */	
	public static void updateModule(Scanner sIn) {
		String choice;			//The user's choice returned from getCommand().		
		boolean done = false;	//while loop control.
		ToDo selectedPlan;		//The plan the user would like to view.
		
		//Keep displaying this menu until the user chooses to exit.
		while(!done) {
			selectedPlan = getPlan(sIn);
			if (selectedPlan == null) {
				break;			//User selected No Plan.
			}// end of if (getPlan(sIn) == null)
			System.out.println("\nCurrent Plan Details: Update Mode");
			System.out.println(selectedPlan);	//Calls the toString() method for the plan which prints out Plan details in a readable form.
			
			choice = getCommand(sIn, "Update Plan Menu", new String[]{"Add New Item", "Change Quantity of an Item", "Delete Item"});
			if (choice.equalsIgnoreCase("")){
				return;			//User chooses to exit.
			}
			switch (choice) {
				case "1":			
					addItem(sIn, selectedPlan);
					break;
				case "2":			
					changeItemQty(sIn, selectedPlan);
					break;
				case "3":			
					deleteItem(sIn, selectedPlan);
					break;
				default:			
					System.out.println("\nInvalid response:  Please enter a choice from the menu (1-3)");
					break;
			}//end of switch (choice)
			System.out.println("\nThe plan is now:");	//Print the updated plan.
			System.out.println(selectedPlan);			//Calls the toString() method for the plan which prints out Plan details in a readable form.
		}// end of while(!done)			
	}//end of method updateModule
	

	/**
	 * Returns void.
	 * Allows the user to add an item to the selectedplan.
	 * 
	 * @param	sIn		A Scanner object used to get user input.
	 * @param	plan	A ToDo object to be modified.
	 * @return			void
	 */	
	public static void addItem(Scanner sIn, ToDo plan) {
		System.out.print("What would you like to add the the list?: ");
		String item = sIn.nextLine();
		int quantity = getValidInt(sIn, "How many would you like to add?: ", "\nInvalid response.  Please enter a whole number.");
		plan.add(item, quantity);
		System.out.printf("\nYour '%s' plan has been updated with %d '%s'.\n",plan.getTitle(), quantity, item);		
	}//end of method addItem(Scanner, ToDo)
	

	/**
	 * Returns void.
	 * Presents the user with a list of items in the plan.
	 * Allows the user to choose an item to modify and verifies it is a valid item from the plan.
	 * Asks the user to indicate how many to add or subtract to the quantity of the item.
	 * Note: getValidString requires a String[] array of valid choices so the Set<String> of keys must be converted to an array.
	 * 
	 * @param	sIn		A Scanner object used to get user input.
	 * @param	plan	A ToDo object containing the item to be modified.
	 * @return			void
	 */	
	public static void changeItemQty(Scanner sIn, ToDo plan) {
		//Get the list of items (keys) from the plan HashMap and convert the Set<String> to an array String[].
		Set<String> itemList = plan.getItems();		//Get the Set<String> of keys from the HashMap.
		int setSize = itemList.size();				//Find the number of items in the HashMap.
		String[] choices = new String[setSize];		//Create a new array String[] that is the same size as the HashMap.
		
		int index = 0;								//Load the new String[] array with the items (keys) from the HashMap.
		for(String item : itemList) {
			choices[index++] = item;
		}//end of for(String item : itemList)
		
		String item = getValidString(sIn, "Which item would you like to change?: ", "\nInvalid entery.  That is not an item in the plan.", choices );
		int changeQty = getValidInt(sIn, "How many would you like to add or subtract?: ", "Invalid response.  Please enter a whole number.");
		plan.change(item, changeQty);
		System.out.printf("\nThe '%s' item has been updated by %d.\n", item, changeQty);		
	}//end of method changeItemQty(Scanner, ToDo)
	
	
	/**
	 * Returns void.
	 * Presents the user with a list of items in the plan.
	 * Allows the user to choose an item to delete and verifies it is a valid item from the plan.
	 * Note: getValidString requires a String[] array of valid choices so the Set<String> of keys must be converted to an array.
	 *
	 * @param	sIn		A Scanner object used to get user input.
	 * @param	plan	A ToDo object containing the item to be deleted.
	 * @return			void
	 */	
	public static void deleteItem(Scanner sIn, ToDo plan) {
		//Get the list of items (keys) from the plan HashMap and convert the Set<String> to an array String[].
		Set<String> itemList = plan.getItems();		//Get the Set<String> of keys from the HashMap.
		int setSize = itemList.size();			//Find the number of items in the HashMap.
		String[] choices = new String[setSize];		//Create a new array String[] that is the same size as the HashMap.
		
		int index = 0;								//Load the new String[] array with the items (keys) from the HashMap.
		for(String item : itemList) {
			choices[index++] = item;
		}//end of for(String item : itemList)
		
		String item = getValidString(sIn, "Which item would you like to delete?: ", "\nInvalid entry.  That is not an item in the plan.", choices );
		plan.delete(item);
		System.out.printf("\nThe '%s' item has been deleted from your '%s' plan.\n", item, plan.getTitle());		
	}//end of method deleteItem(Scanner, ToDo)	
	
	/**
	 * Returns a ToDo object.
	 * Presents the user with a list of plans.
	 * Allows the user to choose a plan from the plans ArrayList.
	 *
	 * @param	sIn	A Scanner object used to get user input.
	 * @return		A ToDo object representing the user selection. 
	 */		
	public static ToDo getPlan(Scanner sIn) {
		String choice;			//The user's selected menu option number choice.		
		boolean done = false;	//while loop control.
		ToDo selectedPlan;		//The plan the user would like to view.
		int cmd;				//The menu option number the user will enter to make a selection.
		HashMap<String, ToDo> menuMap = new HashMap<String, ToDo>();	//Holds the menu entries.  Associates a menu option number with a plan object.		
				
		//Keep displaying this menu until the user chooses to exit.
		while(!done) {
			System.out.println("\nCurrent Plans:\n");
			System.out.println("-------------------------------------");
			System.out.println("No.            Plan           PlanID");
			System.out.println("-------------------------------------");
			menuMap.clear();	//Empty the menu map for the next menu creation.
			
			cmd = 1;			//Load the menu map with menu option numbers associated with each plan in the plans ArrayList and print these to the console.
			Collections.sort(plans);
			for(ToDo plan : plans) {
				menuMap.put(Integer.toString(cmd), plan);
				System.out.printf("%d:  %-28s (%d)\n", cmd, plan.getTitle(), plan.getToDoID());
				cmd++;
			}//end of for(ToDo plan : plans)
			System.out.printf("ENTER: Exit back to previous menu\n\n");				
			System.out.print("Which plan?: ");			
			choice = sIn.nextLine();
			
			if(choice.equals("")) {
				done = true;	//User chooses to exit.
			} else {
				selectedPlan = menuMap.get(choice);
				if (selectedPlan != null) {
					return selectedPlan;		//return the plan based on the user choice.
				}else{
					System.out.println("Invalid response.  Please choose an option from the menu.");
				}//end of if (selectedPlan != null)
			}//end of if(choice.equals(""))
		}// end of while(!done)
		return null;	//User chose not to select a plan
	}//end of method getPlan(Scanner)
	
	
	/**
	 * Returns validated integer input.
	 * Validates user input is an Integer and returns it back to the calling method.
	 * Uses sIn to get user input from the console.
	 * Asks user question.
	 * If user input is not valid, prints warning and repeats question.
	 * 
	 * @param	sIn			A Scanner object used to get user input.
	 * @param	question	The question to ask the user.
	 * @param	warning		The warning message when the user enters invalid data.
	 * @return				An int containing the validated user input.
	 */
	public static int getValidInt(Scanner sIn, String question, String warning){
		String input;					//Users input
		int intNum=0;					//The integer var to hold the converted input
		boolean validAnswer = false;	//do-while loop control
		
		//Keep asking question until the user enters valid input.
		do {
			System.out.print(question);
			input = sIn.nextLine();
			try {
				intNum = Integer.parseInt(input);
				return intNum;					//If the input is a valid integer, return it.
			} // end of try to convert input to int
			catch (NumberFormatException e) {
				System.out.println(warning);	//If the input is not a valid integer, print warning and repeat.
			} // end of catch
		} while(!validAnswer);
		return intNum;
	}//end of method getValidInt(Scanner, String, String)
	
	
	/**
	 * Returns validated String input.
	 * Validates user input is within list of choices and returns it back to the calling method.
	 * Uses sIn to get user input from the console.
	 * Asks user question.
	 * If choices is empty, returns input.
	 * If choices is not empty, validates user input is within choices.
	 * If user input is not valid, prints warning and repeats question.
	 * 
	 * @param	sIn			A Scanner object used to get user input.
	 * @param	question	The question to ask the user.
	 * @param	warning		The warning message when the user enters invalid data.
	 * @param	choices		A String[] containing the valid choices for user input.
	 * @return				A String containing the validated user input.
	 */
	public static String getValidString(Scanner sIn, String question, String warning, String[] choices){
		String input;					//Users input
		boolean validAnswer = false;	//do-while loop control

		//Keep asking question until the user enters valid input.
        do {
            System.out.print(question);
        	input = sIn.nextLine();
        	if(choices.length == 0) {	//If choices is empty, return input.
        		return input;
        	}//end of if(choices.length == 0) 
        	for (String value: choices) {			//If the input is found in choices, return it.
        		if(input.equalsIgnoreCase(value)) {
        			return input;
        		}//end of if (input.equalsIgnoreCase(value))
        	}//end of for (String value: choices)
           	System.out.println(warning);			//If the input is not found in choices, print warning and repeat.
        } while (!validAnswer);
    	return input;
	}// end of method getValidString(Scanner, String, String, String[])
		
	/**
	 * Returns a number in the form of a String indicating which menu selection the user has made.
	 * Presents the user with a menu of choices based on the array String[] menu passed in.
	 * Asks the user to make a choice and returns input.
	 * 
	 * @param	sIn		A Scanner object used to get user input.
	 * @param	title	The title of the menu.
	 * @param	menu	A String[] containing the menu choices.
	 * @return			A String containing the user input.
	 */	
	public static String getCommand(Scanner sIn, String title, String[] menu) {
		System.out.println("\n");
		System.out.println("----------------------------------------");
		String format = "%" + ((40 - title.length())/2 + title.length()) + "s\n";
		System.out.printf(format, title);
		System.out.println("----------------------------------------");
		
		int i = 0;
		for(i = 0; i < menu.length; i++) {
			System.out.printf("%d: %s\n", i+1, menu[i]);
		}//end of for(i = 0; i < menu.length; i++)
		
		if(!title.equalsIgnoreCase("Main Menu")) {
			System.out.printf("ENTER: Exit back to previous menu\n");			
		}//end of if(!title.equalsIgnoreCase("Main Menu"))
		System.out.printf("\nWhat would you like to do? (1-%d): ", i);
		return sIn.nextLine();
	}//end of method getCommand(Scanner, String[])()
		
}//end of class Planner
