import java.util.ArrayList;
import java.util.Scanner;


/*
 * This program is a solution to problem 6796 from the ACM-ICPC archive. "Factorial Factors"
 * My solution runs over the 3 second time limit when faced with many high value numbers  
 *
 *============================================= 
 *\\\\        FROM THE ICPC WEBSIE        \\\\\\
 *\\\\\ https://icpcarchive.ecs.baylor.edu/ \\\\\\
 *================================================
 *
 *The factorial of a number N, written N!, is the product of all integers between 1 and N, inclusively.
 *For example, 5! = 120.
 *Every integer greater than 1 can be written as the product of 1 or more prime numbers, some of
 *which may repeat. For example, 120 = 2 x 2 x 2 x 3 x 5.
 *For this problem, we are interested in the prime factorization of the factorial of a number. You will
 *need to determine the number of total and distinct prime factors. For the example above, there are 5
 *total prime factors (2, 2, 2, 3, 5) and 3 distinct prime factors (2, 3, 5).
 * 
 * 
 * Input :
 * The first line of input will contain the number of test cases, C (1 <= C <= 50). Each test case will consist
 * of a single line containing an integer N (2 <= N <= 100, 000).
 * 
 * output: 
 * Each test case will result in a single line of output D T where D is the number of distinct prime factors
 * of N! and T is the total number of prime factors of N!.
 * 
 * Sample Input:
 * 2
 * 5
 * 6
 * 
 * Sample Output:
 * 3 5
 * 3 7
 *
 *======================================================
 * 
 * @author Nolan R. Sherman
 * @revised 10 March, 2017
 */
public class Factorials {
	private static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) {
		//initilize Scanner
		Scanner input = new Scanner(System.in);
		
		//create an array with all the prime numbers between 2 and 100,000
		ArrayList<Integer> primeNumbers = makePrimesArray(2, 100000);
		
		//System.out.println("Primare Numbers: \n");
		//printArrayList(primeNumbers);//for testing
		//System.out.println("\n ------------------\n");
		
		//get number of casses
		int numCases = input.nextInt();
		//System.out.println("num of cases: " + numCases +"\n");
		//define for loop to run each case
		for(int i = 0; i < numCases; i++){
			
			//define variables
			ArrayList<Integer> d = new ArrayList<Integer>(); //distinct prime factors
			
			int f = 0; //total number of prime factors.
			
			int num = input.nextInt();//given integer
			//check each factorial of i
			for(int fact = 2; fact <= num; fact++){
				
				
				//check if fact shoould be added to the counter variables
				if(primeNumbers.contains(fact)){//if factorial of i is in prime numbers array, add to d array. increment f
					if(!d.contains(fact)){ // if d deosnt already contains fact
						d.add(fact);// and i to d
					}
					f++;//add 1 to f
					
					//System.out.println(fact+ " is prime!");
				} else {
					//System.out.println(fact+ " is not prime");
					/*
					 * TODO
					 * if fact is not a prime number, is it divisible by any? loop through until
					 * it cant be devided any more, incrementing f when a division is successful .. (ie no remainder)
					 */
					
					
					
					//number is not prime. so check if it is divisible by primes
					int j = 0;// start from smallest prime at listArray d[0]
					int copyOfNum = fact;
					while ( j < d.size() ){
						
						if(copyOfNum == 1 || j > copyOfNum>>1){
							break;//some times we will divide and num will become 1, we just need to break and finish when this happens.
						}
						
						if( (copyOfNum % d.get(j)) == 0 ){// if num / prime has no remainder
							f++; // increase number of primes
							copyOfNum /= d.get(j);//devide num by prime.
							continue; //lets try deviding by the same prime again!
						} else {// cant be devided by this prime so try the next one!
							j++;
						}
						
					}
					
				}
			}
			
			//print results
			
			System.out.printf("%d %d \n", d.size(), f);
			//printArrayList(d);
			
			
		}
		
		
		// print the time it took.
        long endTime = System.currentTimeMillis();
        System.out.println("\n It took " + (endTime - startTime) + " milliseconds");

	}

	private static void printArrayList(ArrayList<Integer> primeNumbers) {
		System.out.printf("--- primes:");
		for (int prime : primeNumbers){
			System.out.printf("%d,",prime);
		}
	}

	private static ArrayList<Integer> makePrimesArray(int min, int max) {
	
		
		
		
		ArrayList<Integer> primeArrays = new ArrayList<Integer>();
		for(int i = min; i <= max; i++){
			
			//check if i is a primary number
			boolean isPrime = true;
			for(int t = 2; t <= i>>1; t++){// t should be less than i, but i will never need to test higher then half the value.
				if(i%t == 0){//if i modulas t has a remainder of 0
					isPrime = false;//i is not prime.
					break;//break out of loop, we dont need to check any more.
				}
			}
			
			if(isPrime){//if i is prime
				//add it to the prime array list
				primeArrays.add(i);
			}
			
		}
		
		return primeArrays;
	}

}
