import java.text.DecimalFormat;
import java.util.Scanner;
/*
 * Author: Josh Knox COP2551
 * Date: 10-17-2022
 * Description: This program determines if a truck should or should not be set for auction based on its mileage.
 * 				It then displays all information related to the truck that was entered and prompts the user whether
 * 				to continue to enter another truck or not. If they continue, the end report should tally all entered
 * 				values for auction prices and the number of trucks to be auctioned. When the user decides to quit,
 * 				the total of all trucks to be auctioned should be shown.
 */
public class HW2_Knox 
{
	// Global working variables:
	static Scanner get = new Scanner(System.in);
	static DecimalFormat DF = new DecimalFormat("####0.00");
	static String input = " ";
	
	public static void main(String[] args)
	{
		//declarations
			//Attributes related to truck auction information:
			String vin = " ";
			String make = " ";
			String model = " ";
			double price = 0.0;
			double mileage = 0.0;
			boolean auctionStatus = true;
			double auctionPrice = 0.0;
			double totalAuctionPrice = 0.0;
			int totalAuctioned = 0;
			//Working variables:
			int answer = 1; //used to repeat
			int start = 0;//used to start or quit early
		
		//Start or quit: 1 to start, 0 to quit
		start = getStart(); //Calling the method getStart() to get user feedback 1 or 0
		
		if(start == 0)		
			System.out.println("Thank you for visiting!");
		else
		{
			while(answer == 1)
			{
				//input:
					//get truck VIN:
					vin = getVin();
					//get truck make:
					make = getMake();
					//get truck model:
					model = getModel();
					//get truck price:
					price = getPrice();
					//get truck mileage:
					mileage = getMileage();	
					
					//evaluate mileage and set auction status:
					auctionStatus = getStatus(mileage);
					//routine to tally total number of auctioned trucks:
					if(auctionStatus = true)//accumulates total number of trucks auctioned
					{
						totalAuctioned = totalAuctioned + 1;
					}//end if(true)
					//evaluate auction price:
					auctionPrice = getAuctionPrice(auctionStatus, price);
					//routine to tally the total of all auction prices:
					totalAuctionPrice = totalAuctionPrice + auctionPrice;
					//display final report:
					dispReport(vin, make, model, price, mileage, auctionStatus, auctionPrice);					
					//continue?
					answer = getAnswer();
			}//end while(answer == 1)
			dispFinalReport(totalAuctioned, totalAuctionPrice);
			System.out.println("Thank you for using this program!");
		}//end else if(start == 0)
		System.out.println("Goodbye!");
	}//end main
	//============================================================================
	public static int getStart()
	{
		int start = 0;
		System.out.println("This program determines if a truck meets the criteria to be placed for auction...Do you want to start? 1 for yes or 0 for no: ");
		input = get.nextLine();
		//validate: a digit
		start = Integer.parseInt(input);
		while(start != 1 && start !=0)
		{
			System.out.println("Invalid input! Please re-enter 1 for yes or 0 for no: ");
			input = get.nextLine();
			start = Integer.parseInt(input);
		}//end while start....
		return start;
	}//end getStart
	//============================================================================
	public static String getVin()
	{
		String vin = " ";
		System.out.println("Enter truck vin: ");
		input = get.nextLine();
		//validate: numbers & letters
		vin = input;
		return vin;
	}//end getVin
	//============================================================================
	public static String getMake()
	{
		String make = " ";
		System.out.println("Enter truck make: ");
		input = get.nextLine();
		//validate: letters only
		make = input;
		return make;
	}//end getMake
	//============================================================================
	public static String getModel()
	{
		String model = " ";
		System.out.println("Enter truck model: ");
		input = get.nextLine();
		//validate: letters only
		model = input;
		return model;
	}//end getModel
	//============================================================================
	public static double getPrice()
	{
		Double price = 0.0;
		System.out.println("Enter truck original price: ");
		input = get.nextLine();
		//validate: numbers only
		price = Double.parseDouble(input);
		return price;
	}//end getPrice
	//============================================================================
	public static double getMileage()
	{
		Double mileage = 0.0;
		System.out.println("Enter truck mileage: ");
		input = get.nextLine();
		//validate: numbers only
		mileage = Double.parseDouble(input);
		return mileage;
	}//end getMileage
	//============================================================================
	public static boolean getStatus(double mileage)
	{
		boolean auctionStatus = true;
		if(mileage > 750000)
			auctionStatus = true;
		else
		{
			while(mileage < 750000)
			{
				auctionStatus = false;
			}//end while
		}
		return auctionStatus;		
	}//end getStatus
	//============================================================================
	public static double getAuctionPrice(boolean auctionStatus, double price)
	{
		double auctionPrice = 0.0;
		if(auctionStatus == true)
			auctionPrice = price * 0.4;
		else
		{
				auctionPrice = 0.0;
		}//end else if
		return auctionPrice;
	}//end getAuctionPrice
	//============================================================================
	public static void dispReport(String vin, String make, String model, double price, double mileage, boolean auctionStatus, double auctionPrice)
	{
		System.out.println("VIN: " + vin +
				"\n" + "Make: " + make +
				"\n" + "Model: " + model +
				"\n" + "Original Price: " + price +
				"\n" + "Mileage: " + mileage +
				"\n" + "Set for Auction: " + auctionStatus +
				"\n" + "Auction Price: " + auctionPrice);
	}//end dispReport
	//============================================================================
	public static int getAnswer()
	{
		int answer = 0;
		System.out.println("Do you want to process another truck? 1 for yes or 0 for no: ");
		input = get.nextLine();
		//validate: one digit
		answer = Integer.parseInt(input);
		while(answer != 1 && answer != 0)
		{
			System.out.println("Invalid input: Please re-enter 1 for yes or 0 for no: ");
			input = get.nextLine();
			//validate: one digit
			answer = Integer.parseInt(input);
		}//end while
		return answer;
	}//end getAnswer
	//============================================================================
	public static void dispFinalReport(int totalAuctioned, double totalAuctionPrice)
	{
		System.out.println("Total of all auction prices: " + totalAuctionPrice +
				"\n" + "Total of all trucks auctioned: " + totalAuctioned);
	}//end dispFinalReport
}//end class HW2_Knox
