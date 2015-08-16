
/**
 * 
 * An example of how to use the testing interface class
 * 
 * @author TheVarunShah
 *
 */
public class TestSum {

	public static void main(String[] args) {
		
		//absolute path of program
		String absPathToDir = "C:\\Users\\Varun\\Documents\\~Rutgers\\CS111Research\\WebCat\\JavaTestingScript\\src";
		//name of program
		String fileName = "Sum";
		
		try {
			//compile program - only continue if program compiles
			boolean compiled = TestInterface.compileProgram(absPathToDir, fileName);
			if(!compiled){
				return;
			}
			
			//run program with a different set of arguments each time
			String[] testArgs1 = {"123", "123"};
			TestInterface.runProgramWithArgs(absPathToDir, fileName, testArgs1);
			String[] testArgs2 = {"123", "-123"};
			TestInterface.runProgramWithArgs(absPathToDir, fileName, testArgs2);
			String[] testArgs3 = {"-123", "-123"};
			TestInterface.runProgramWithArgs(absPathToDir, fileName, testArgs3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
