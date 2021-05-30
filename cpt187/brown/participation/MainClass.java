//Author:BrownD
//Course: CPT 187
//Purpose: To calculate the cost and discount on orders 
//from SodNotZod. 
//StartDate: 10/22/19

package edu.cpt187.brown.participation;
import java.util.Scanner; 

public class MainClass 
{
	//Declare CLASS CONSTANTS
	public static final String MENU_CREATE_ORDER = "Create Order";
	public static final String MENU_QUIT = "Quit";

	public static void main(String[] args) 
	{
		//Create Scanner
		Scanner input = new Scanner(System.in);

		//Variables
		String userName = "";
		char menuSelection = ' ';
		int currentHowMany = 0; 

		//supportive class
		SodOrder mySodOrder = new SodOrder();

		//Display Welcome Banner
		displayWelcomeBanner();

		//Get userName
		userName = getUserName(input);


		//Validate mainMenu
		menuSelection = validateMainMenu(input); 


		//Start run-while
		while (menuSelection !='Q')
		{

			menuSelection = validateItemMenu(input, 
					mySodOrder.getItemNamePremium(),
					mySodOrder.getItemNameSpecial(),
					mySodOrder.getItemNameBasic(),
					mySodOrder.getItemPricePremium(), 
					mySodOrder.getItemPriceSpecial(),
					mySodOrder.getItemPriceBasic());

			mySodOrder.setItemName(menuSelection); 
			mySodOrder.setItemPrice(menuSelection);

			//validate howMany
			currentHowMany = validateHowMany(input);
			mySodOrder.setHowMany(currentHowMany);

			//Validate Discount Menu
			menuSelection = validateDiscountMenu(input, 
					mySodOrder.getDiscountNameMember(),
					mySodOrder.getDiscountNameSenior(),
					mySodOrder.getDiscountNameNone(),
					mySodOrder.getDiscountRateMember(), 
					mySodOrder.getDiscountRateSenior(),
					mySodOrder.getDiscountRateNone());


			mySodOrder.setDiscountRate(menuSelection);

			//display Item Receipt
			displayItemReceipt(userName, mySodOrder.getItemName(),
					mySodOrder.getItemPrice(), 
					mySodOrder.getHowMany(),
					mySodOrder.getDiscountRate(),
					mySodOrder.getDiscountAmt(),
					mySodOrder.getDiscountPrice(),
					mySodOrder.getSubTotal(),
					mySodOrder.getTaxRate(), 
					mySodOrder.getTaxAmt(),
					mySodOrder.getTotalCost());

			//Validate mainMenu
			menuSelection = validateMainMenu(input); 


		}//End of run-while


		//Display Farewell Message
		displayFarewellMessage();

		//Close Scanner
		input.close();
	}//End of Main

	//Start Welcome Banner
	public static void displayWelcomeBanner()
	{
		System.out.println("Welcome! To Item Selection");
		System.out.println("Program. This program will");
		System.out.println("calulate discount and costs");
		System.out.println("all SodNotZod orders.");
	}//End of Welcome Banner

	//userName
	public static String getUserName(Scanner borrowedInput)
	{
		String UserName; 

		System.out.println("");
		System.out.println("Please enter your First Name.");
		System.out.print("Enter Here:");
		UserName = borrowedInput.nextLine();

		return UserName; 
	}

	public static void displayMainMenu()
	{
		System.out.println("");
		System.out.println("****************************");
		System.out.println("Main Menu");
		System.out.printf("%-4s%-15s\n","[A]", 
				MENU_CREATE_ORDER);
		System.out.printf("%-4s%-15s\n","[Q]", MENU_QUIT);
		System.out.println("Enter Here:");

	}
	public static char validateMainMenu(Scanner borrowedInput)
	{
		char menuSelection = ' ';
		displayMainMenu();
		menuSelection = borrowedInput. next().toUpperCase().charAt(0);

		while (menuSelection != 'A' && menuSelection !='Q')
		{
			System.out.println("");
			System.out.println("Invalid Selection");
			displayMainMenu();
			menuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return menuSelection; 
	}//End of VR Loop 

	//Display Item Menu
	public static void displayItemMenu(String 
			borrowedItemNamePremium, 
			String borrowedItemNameSpecial, 
			String borrowedItemNameBasic,
			double borrowedItemPricePremium,
			double borrowedItemPriceSpecial,
			double borrowedItemPriceBasic)
	{
		System.out.println("");
		System.out.println("*****************************");
		System.out.println("Main Menu");
		System.out.printf("%-4s%-15s%-3s%8.2f\n", "[A]",
				borrowedItemNamePremium,"$",
				borrowedItemPricePremium); 
		System.out.printf("%-4s%-15s%-3s%8.2f\n", "[B]",
				borrowedItemNameSpecial,"$",
				borrowedItemPriceSpecial); 
		System.out.printf("%-4s%-15s%-3s%8.2f\n", "[C]",
				borrowedItemNameBasic,"$",
				borrowedItemPriceBasic);
		System.out.println("Enter Here:");
	}
	public static char validateItemMenu(Scanner borrowedInput,
			String borrowedItemNamePremium, String borrowedItemNameSpecial, 
			String borrowedItemNameBasic, double borrowedItemPricePremium, 
			double borrowedItemPriceSpecial,double borrowedItemPriceBasic)
	{
		char menuSelection = ' ';
		displayItemMenu(borrowedItemNamePremium, borrowedItemNameSpecial, 
				borrowedItemNameBasic, borrowedItemPricePremium, 
				borrowedItemPriceSpecial,borrowedItemPriceBasic);
		menuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while (menuSelection != 'A' && menuSelection !='B'
				&& menuSelection !='C')
		{
			System.out.println("");
			System.out.println("**Invalid Selection**");
			displayItemMenu(borrowedItemNamePremium, borrowedItemNameSpecial, 
					borrowedItemNameBasic, borrowedItemPricePremium, 
					borrowedItemPriceSpecial,borrowedItemPriceBasic);
			menuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return menuSelection; 
	}//End of VR Loop 

	//Display Discount Menu
	public static void displayDiscountMenu(String 
			borrowedDiscountNameMember,
			String borrowedDiscountNameSenior,
			String borrowedDiscountNameNone, 
			double borrowedDiscountRateMember, 
			double borrowedDiscountRateSenior,
			double borrowedDiscountRateNone)
	{
		System.out.println("");
		System.out.println("*****************************");
		System.out.println("Discount Menu");
		System.out.printf("%-4s%-15s%8.1f%-5s\n", "[A]",
				borrowedDiscountNameMember,
				borrowedDiscountRateMember*100, "%");
		System.out.printf("%-4s%-15s%8.1f%-5s\n", "[B]",
				borrowedDiscountNameSenior,
				borrowedDiscountRateSenior*100, "%");
		System.out.printf("%-4s%-15s%8.1f%-5s\n", "[C]",
				borrowedDiscountNameNone,
				borrowedDiscountRateNone*100, "%");
		System.out.println("Enter Here:");
	}

	public static char validateDiscountMenu( Scanner borrowedInput,
			String borrowedDiscountNameMember,String borrowedDiscountNameSenior,String borrowedDiscountNameNone, 
			double borrowedDiscountRateMember, double borrowedDiscountRateSenior,
			double borrowedDiscountRateNone)
	{
		char menuSelection = ' ';
		displayDiscountMenu(borrowedDiscountNameMember, borrowedDiscountNameSenior,
				borrowedDiscountNameNone,borrowedDiscountRateMember, 
				borrowedDiscountRateSenior,
				borrowedDiscountRateNone); 
		menuSelection = borrowedInput.next().toUpperCase().charAt(0);

		while(menuSelection != 'A' && menuSelection !='B'
				&& menuSelection !='C')
		{
			System.out.println("");
			System.out.println("**Invalid Selection**");
			displayDiscountMenu(borrowedDiscountNameMember, borrowedDiscountNameSenior,
					borrowedDiscountNameNone,borrowedDiscountRateMember, 
					borrowedDiscountRateSenior,
					borrowedDiscountRateNone); 
			menuSelection = borrowedInput.next().toUpperCase().charAt(0);
		}

		return menuSelection; 
	}//VR Loop


	//validate howMany
	public static int validateHowMany(Scanner borrowedInput)
	{
		int howMany;

		System.out.println("");
		System.out.println("How many items would you like?");
		System.out.print("Enter Here:");
		howMany= borrowedInput.nextInt(); 

		while (howMany <= 0)
		{
			System.out.println("");
			System.out.println("**Invaild Selection**");
			System.out.println("How many items would you like?");
			System.out.println("");
			System.out.print("Enter Here:");
			howMany= borrowedInput.nextInt(); 
		}
		return howMany;

	}


	//Display Item Receipt
	public static void displayItemReceipt(String userName,String
			borrowedItemName, double borrowedItemPrice, int borrowedHowMany,
			double borrowedDiscountRate, double borrowedDiscountAmt, 
			double borrowedDiscountPrice, double borrowedSubTotal, 
			double borrowedTaxRate, double borrowedTaxAmt,
			double borrowedTotalCost)
	{

		System.out.println("");
		System.out.println("*****Item Receipt*****");
		System.out.println("");

		System.out.println("Thank you, " + userName
				+ " !");
		System.out.println("");

		System.out.printf("%-20s%-15s\n","Item Name:", 
				borrowedItemName);
		System.out.printf("%-20s%-3s%8.2f\n", "Item Price:",
				"$", borrowedItemPrice);

		System.out.printf("%-20s%11s\n","How Many"
				+ " Items:", borrowedHowMany);

		System.out.println("");

		System.out.printf("%-20s%-2s%8.1f%-3s\n", "Discount"
				+ " Rate:", "", borrowedDiscountRate*100, 
				"%");
		System.out.printf("%-20s%-3s%8.2f\n", "Discount"
				+ " Amount:", "$", borrowedDiscountAmt);
		System.out.printf("%-20s%-3s%8.2f\n", "Discount "
				+ "Price:","$", borrowedDiscountPrice);

		System.out.println("");

		System.out.printf("%-20s%-3s%8.2f\n", "Sub Total:",
				"$", borrowedSubTotal);
		System.out.printf("%-20s%-3s%8.2f\n", "Tax Rate:"
				,"$", borrowedTaxRate);
		System.out.printf("%-20s%-3s%8.2f\n", "Tax Amount:"
				,"$", borrowedTaxAmt);

		System.out.println("");

		System.out.printf("%-20s%-3s%8.2f\n", "Total Cost:",
				"$", borrowedTotalCost);		

	}

	//Display Farewell Message 
	public static void displayFarewellMessage()
	{
		System.out.println("");
		System.out.println("*************************");
		System.out.println("Thank You!");
		System.out.println("For using our system");
		System.out.println("Have a great day! ");	
	}//End of FarewellMessage 


}//End of Class
