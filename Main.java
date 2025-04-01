import java.util.Random;
import java.util.Scanner;

public class Main {

	//change S1 back to true
	public static boolean S1 = true;
	public static boolean S2 = false;
	public static void main(String[] args) {
		boolean retry = true;
		while (retry) {
		System.out.println("Would you like to sort integers or doubles? \n 1) integers \n 2) doubles \n 3) Options");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			
			int[] list1 = makeIntList(input);
			for(int j : list1) {
				System.out.print(j + ", ");
			}
			System.out.println();
			intSorter(list1);
			retry = false;
			break;
		case 2:
			double[] list2 = makeDoubleList(input);
			for(int i = 0; i < list2.length; i++) {
				System.out.print(list2[i] + " ");
			}
			doubleSorter(list2);
			retry = false;
			break;
		case 3:
			System.out.println("Show steps: " + S1 + "\n Read from file: " + S2);
			System.out.println("Edit variables? (Y)/(N)");
			char Choice = input.next().charAt(0);
			Choice = Character.toUpperCase(Choice);
				if(Choice != 'Y' && Choice != 'N') {
					continue;
				}
				else if (Choice == 'Y') {
					System.out.println("Would you like to see the individual steps of the sorter? (Y)/(N)");
					char Choice2 = input.next().charAt(0);
					Choice2 = Character.toUpperCase(Choice2);
					if(Choice2 == 'N') {
						System.out.println("Disabling steps");
						S1 = false;
					}
					else {
						System.out.println("Returning...");
						continue;
					}
				}
			
			continue;
		default:
			System.out.println("Invalid input");
		}
		}

	}
	
	public static int[] makeIntList(Scanner input) {
		Random r1 = new Random();
		System.out.println("How big of an array?");
		int listLength = input.nextInt();
		System.out.println("Between what range?");
		System.out.print("Low end: ");
		int Low = input.nextInt();
		System.out.println("High end: ");
		int High = input.nextInt();
		System.out.println("Creating a new list of length " + listLength);
		int[] list1 = new int[listLength];
		for(int i = 0; i < list1.length; i++) {
			list1[i] = r1.nextInt(Low, High);
		}
		input.close();
		return list1;
	}
	
	public static double[] makeDoubleList(Scanner input) {
		Random r1 = new Random();
		System.out.println("How big of an array?");
		int listLength = input.nextInt();
		System.out.println("Between what range?");
		System.out.print("Low end: ");
		double Low = input.nextDouble();
		System.out.println("High end: ");
		double High = input.nextDouble();
		input.close();
		System.out.println("Creating a new list of length " + listLength);
		double[] list1 = new double[listLength];
		for(int i = 0; i < list1.length; i++) {
			double num =(r1.nextDouble(Low, High));
			String formatted = String.format("%.2f", num);
			num = Double.parseDouble(formatted);
			list1[i] = num;
		}
		return list1;
	}
	
	public static void intSorter(int[] list1) {
			//needed variables
				int indexHigh = list1.length-1,
					indexLow = 0,
					holder,
					tMax = list1.length;
				
				//sorter
				for(int i = 0; i <= tMax; i++) {
					if(S1) {
						System.out.println();
						System.out.println("indexHigh = " +indexHigh + "\n indexLow = " + indexLow);
					}
					if(list1[indexLow] > list1[indexHigh]) {
						holder = list1[indexLow];
						list1[indexLow] = list1[indexHigh];
						list1[indexHigh] = holder;
					}
					
					if(list1[indexHigh] < list1[indexHigh-1]) {
						holder = list1[indexHigh];
						list1[indexHigh] = list1[indexHigh-1];
						list1[indexHigh-1] = holder;
						tMax++;
					}
					else if(list1[indexHigh] >= list1[indexHigh-1]) {
						//tMax--;
					}
					
					if(list1[indexLow] > list1[indexLow+1]) {
						holder = list1[indexLow];
						list1[indexLow] = list1[indexLow+1];
						list1[indexLow+1] = holder;
						tMax++;
					}
					else if(list1[indexLow] >= list1[indexLow+1]) {
						//tMax--;
					}
					
					indexHigh--;
					indexLow++;
					
					//resets the indexes to maintain the 'bubbler' logic
					if(indexLow == indexHigh) {
						indexLow = 0;
						indexHigh = list1.length-1;
					}
					else if(indexLow - indexHigh >= 0) {
						indexLow = 0;
						indexHigh = list1.length-1;
					}
					
					
					if(S1) {
					for(int l= 0; l < list1.length; l ++) {
						if(l == indexHigh) {
							System.out.println(list1[l] + " <");
						}
						else if(l == indexLow) {
							System.out.println(list1[l] + " <");
						}
						else {
						System.out.println(list1[l]);
						}
					}
					System.out.println();
					}
					else {
						continue;
					}
				}
				
				System.out.println("Number of loops: " + tMax);
				System.out.println("====Final Sorted List====");
				for(int k : list1) {
					System.out.print(k+ " ");
				}
				
				
	}

	public static void doubleSorter(double[] list1) {
			//needed variables
					int indexHigh = list1.length-1,
						indexLow = 0,
						tMax = list1.length;
					double holder;
					
					//sorter
					for(int i = 0; i <= tMax; i++) {
						if(S1) {
							System.out.println();
						System.out.println("indexHigh = " +indexHigh + "\n indexLow = " + indexLow);
						}
						if(list1[indexLow] > list1[indexHigh]) {
							holder = list1[indexLow];
							list1[indexLow] = list1[indexHigh];
							list1[indexHigh] = holder;
						}
						
						if(list1[indexHigh] < list1[indexHigh-1]) {
							holder = list1[indexHigh];
							list1[indexHigh] = list1[indexHigh-1];
							list1[indexHigh-1] = holder;
							tMax++;
						}
						else if(list1[indexHigh] >= list1[indexHigh-1]) {
							//tMax--;
						}
						
						if(list1[indexLow] > list1[indexLow+1]) {
							holder = list1[indexLow];
							list1[indexLow] = list1[indexLow+1];
							list1[indexLow+1] = holder;
							tMax++;
						}
						else if(list1[indexLow] >= list1[indexLow+1]) {
							//tMax--;
						}
						
						indexHigh--;
						indexLow++;
						
						//resets the indexes to maintain the 'bubbler' logic
						if(indexLow == indexHigh) {
							indexLow = 0;
							indexHigh = list1.length-1;
						}
						else if(indexLow - indexHigh >= 0) {
							indexLow = 0;
							indexHigh = list1.length-1;
						}
						
						
						if(S1) {
						for(int l= 0; l < list1.length; l ++) {
							if(l == indexHigh) {
								System.out.println(list1[l] + " <");
							}
							else if(l == indexLow) {
								System.out.println(list1[l] + " <");
							}
							else {
							System.out.println(list1[l]);
							}

						}

						System.out.println();
					}
						else {
							continue;
						}
					}
					
					System.out.println("Number of loops: " + tMax);
					System.out.println("====Final Sorted List====");
					for(int k = 0; k < list1.length; k++) {
						System.out.print(list1[k]+ " ");
					}
	}
}
