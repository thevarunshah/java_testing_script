
/**
 * 
 * A simple program which adds two numbers
 * 
 * @author TheVarunShah
 *
 */
public class Sum {

	public static void main(String[] args) {
		
		//ask for the two numbers
		int x = IO.readInt();
		int y = IO.readInt();
		
		//add the two numbers 
		int sum = x+y;
		
		//output the sum
		IO.outputIntAnswer(sum);
	}
}
