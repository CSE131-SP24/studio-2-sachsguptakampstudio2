package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// accept following inputs //
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your initial amount of money: ");
		double initialStartAmount = in.nextDouble();
		
		System.out.println("Enter the chance you'll win a single play (as a decimal): ");
		double winChance = in.nextDouble();
		
		System.out.println("What is your goal amount of money? ");
		double winLimit = in.nextDouble();
		
		System.out.println("How many days will you play? ");
		int totalSimulations = in.nextInt();
		
		int ruinCount = 0;
		for (int days = 0; days<totalSimulations; days++)
		{
			int count = 0;
			double startAmount = initialStartAmount;
			while ((startAmount>0) && (startAmount<winLimit))
			{
				double probability = Math.random();
				if (probability >= winChance)
				{
					startAmount++;
				}
				else
				{
					startAmount--;
				}
				count++;
			}
			String dayOutcome = "";
			if (startAmount==0)
			{
				dayOutcome = "LOSE";
				ruinCount++;
			}
			else
			{
				dayOutcome = "WIN";
			}
			System.out.println("Simulation " + days + ": " + count + " " + dayOutcome);
		}
		double expectedRuin;
		double alpha = (1-winChance)/winChance;
		if (winChance==0.5)
		{
			expectedRuin = 1-(initialStartAmount/winLimit);
		}
		else
		{
			expectedRuin = ((double)(Math.pow(alpha, initialStartAmount)) - (Math.pow(alpha, winLimit))) / ((double)(1-(Math.pow(alpha,  winLimit))));
		}
		System.out.println("Ruin rate from Simulation: " + (((double)ruinCount / (double)totalSimulations)) + " Expected Ruin Rate: " + expectedRuin);
		
		

	}

}
