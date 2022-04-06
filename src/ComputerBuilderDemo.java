import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerBuilderDemo {

	public static void main(String[] args) throws InterruptedException {

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		// TODO: Make a Computer object, using the default constructor
		Computer myComputer = new Computer(); // mCPU and everything else is null
		// TODO: Make an array list of Computer objects to represent the shopping cart
		List<Computer> cart = new ArrayList<>();

		int option;
		double capacity, speed, price;
		String manufacturer, core, maxRes, type;
		
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.print(
					"\n********************************************************************\n"
					+ "**                                                                **\n"
					+ "**                  BUILD YOUR OWN COMPUTER!                      **\n"
					+ "**                                                                **\n"
					+ "********************************************************************\n"
					+ "** Please select from the following options:                      **\n"
					+ "** 1) Configure CPU                                               **\n"
					+ "** 2) Configure RAM                                               **\n"
					+ "** 3) Configure Storage                                           **\n"
					+ "** 4) Configure Video Card                                        **\n"
					+ "** 5) Display Computer Configuration                              **\n"
					+ "** 6) Add Computer to Shopping Cart                               **\n"
					+ "** 7) Display Entire Shopping Cart                                **\n"
					+ "** 8) Checkout                                                    **\n"
					+ "********************************************************************\n" 
					+ ">> ");

			option = keyboard.nextInt();
			keyboard.nextLine();

			switch (option) {
			case 1: // CPU
				System.out.println("~~~CPU~~~");
				System.out.print("Enter manufacturer: ");
				manufacturer = keyboard.nextLine();
				System.out.print("Enter core: ");
				core = keyboard.nextLine();
				System.out.print("Enter speed (GHz): ");
				speed = keyboard.nextDouble();
				System.out.print("Enter price $ ");
				price = keyboard.nextDouble();
				// TODO: Instantiate new CPU object
				myComputer.new CPU(manufacturer,core,speed,price);
				break;
			case 2: // RAM
				System.out.println("~~~RAM~~~");
				System.out.print("Enter manufacturer: ");
				manufacturer = keyboard.nextLine();
				System.out.print("Enter capacity (GB): ");
				capacity = keyboard.nextDouble();
				System.out.print("Enter speed (MHz): ");
				speed = keyboard.nextDouble();
				System.out.print("Enter price $ ");
				price = keyboard.nextDouble();
				// TODO: Instantiate new RAM object
				myComputer.new RAM(manufacturer,price,speed,capacity);
				break;
			case 3: // Storage
				System.out.println("~~~Storage~~~");
				System.out.print("Enter manufacturer: ");
				manufacturer = keyboard.nextLine();
				System.out.print("Enter capacity (TB): ");
				capacity = keyboard.nextDouble();
				keyboard.nextLine();
				System.out.print("Enter type: ");
				type = keyboard.nextLine();
				System.out.print("Enter price $ ");
				price = keyboard.nextDouble();
				// TODO: Instantiate new Storage object
					myComputer.new Storage(manufacturer,type,price,capacity);

				break;
			case 4: // Video Card
				System.out.println("~~~Video Card~~~");
				System.out.print("Enter manufacturer: ");
				manufacturer = keyboard.nextLine();
				System.out.print("Enter capacity: ");
				capacity = keyboard.nextInt();
				keyboard.nextLine();
				System.out.print("Enter maximum resolution: ");
				maxRes = keyboard.nextLine();
				System.out.print("Enter price $ ");
				price = keyboard.nextDouble();
				// TODO: Instantiate new VideoCard object
				myComputer.new VideoCard(manufacturer,maxRes,price,capacity);

				break;
			case 5: // Display Computer Configuration 
				// TODO: Print the Computer object to the screen
				//if(myComputer.getCPU() != null)
					System.out.println(myComputer);
				//else
				//	System.out.println("BRUH");
				break;
			case 6: // Add Computer to Shopping Cart
				// TODO: If any of the components (CPU, RAM, Storage or VideoCard) is null, 
				// TODO: display error message.
				// TODO: Otherwise, add the Computer to the shopping cart (array list)
				String errorMessage = "";
				if(myComputer.getCPU() == null)
					errorMessage += "Configure CPU before adding to cart\n";
				if(myComputer.getRAM() == null)
					errorMessage+= "Configure RAM before adding to cart\n";
				if(myComputer.getStorage() == null)
					errorMessage += "Configure Storage before adding to cart\n";
				if(myComputer.getVideoCard() == null)
					errorMessage += "Configure VideoCard before adding to cart\n";

				if(errorMessage.equals("")) {
					cart.add(myComputer);
					// Reset myComputer by instantiating a new object
					myComputer = new Computer();
					System.out.println("Computer added to cart successfully.");
				}
				else
					System.err.println(errorMessage);
				break;
			case 7: // Display Entire Shopping Cart
				// TODO: If shopping cart is empty, please display the error message below,
				// Otherwise, loop through the cart and print out each Computer object.
				if(cart.isEmpty())
					System.err.println("No computers added to cart...yet");
				else
					for (Computer comp: cart)
						System.out.println(comp);

				break;
			case 8: // Checkout
				// TODO: If shopping cart is empty, please display the error message below,
				if(cart.isEmpty())
				System.err.println("No computers added to cart...yet");

				// TODO: Otherwise, implement a method that calculates the entire cost of the order by summing the total cost of
				// TODO: each Computer object in the shopping cart.
				System.out.println("Please pay " + currency.format(cart) + " to checkout.");
				System.out.println("Thanks for your business!  Happy Computing!");
				break;
			default:
				System.err.println("Enter valid option between 1-7.");
				Thread.sleep(5);

			}
		} while (option != 8);
		
		keyboard.close();
	}

	// TODO: Implement a method named totalCost, which takes an ArrayList as its parameter, loops through each Computer object
	// TODO: and sums all prices of the computers in the shopping cart.
	public static double totalCost(List<Computer> cart)
	{
		double total = 0.0;
		for (Computer comp: cart) {
			total += comp.calculateCost();
		}
		return total;
	}
}
