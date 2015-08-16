import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * 
 * A simple java based testing interface which can compile and run a java program
 * 
 * @author TheVarunShah
 *
 */
public class TestInterface {
	
	/**
	 * Compiles the java program
	 * 
	 * @param absPathToDir location of the java program (absolute path)
	 * @param fileName name of the java program
	 * @return true if successfully compiled, else false
	 * @throws InterruptedException
	 */
	public static boolean compileProgram(String absPathToDir, String fileName) throws InterruptedException{
		
		Process pro = null;
		try {
			//navigate to the directory and compile the program
			pro = Runtime.getRuntime().exec("cmd /c cd \"" + absPathToDir + "\" & javac " + fileName + ".java");
			
			//print out any compile-time messages and/or errors
			printLines("stdout:", pro.getInputStream());
			printLines("stderr:", pro.getErrorStream());
		} catch (IOException e){
			e.printStackTrace();
		}
		pro.waitFor();
		
		if(pro.exitValue() != 0){
			System.out.println("program did not compile");
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * Runs an already compiled program with the given arguments
	 * 
	 * @param absPathToDir location of the compiled java program (absolute path)
	 * @param fileName name of the java program
	 * @param args an array of arguments given as input to the program when executed
	 * @return true if successfully executed the program, else false
	 * @throws InterruptedException
	 */
	public static boolean runProgramWithArgs(String absPathToDir, String fileName, String[] args) throws InterruptedException{
		
		Process pro = null;
		try {
			//navigate to the directory and execute the program
			pro = Runtime.getRuntime().exec("cmd /c cd \"" + absPathToDir + "\" & java -cp \"" + absPathToDir + "\" " + fileName);
			
			//input each of the args, one by one
			OutputStream out = pro.getOutputStream();
			for(String arg : args){
				out.write((arg + "\n").getBytes());
				out.flush();
			}
			
			//print out any compile-time messages and/or errors
			printLines("stdout:", pro.getInputStream());
			printLines("stderr:", pro.getErrorStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		pro.waitFor();
		
		if(pro.exitValue() != 0){
			System.out.println("program did not exit successfully");
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * Helper method to print out any messages
	 * 
	 * @param name stdout/stderr - the type of message
	 * @param ins the stream of messages
	 * @throws IOException
	 */
	private static void printLines(String name, InputStream ins) throws IOException {
		
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while((line = in.readLine()) != null) {
			System.out.println(name + " " + line);
		}
	}
}
