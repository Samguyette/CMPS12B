//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// FileReverse.java
// Takes a text file, reads each line of input, parse the tokens, 
// then prints each token backwards to an output file on a line by itself.  
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.*;
import java.util.Scanner;

class FileReverse{
	public static void main(String args[]) throws IOException{
		if(args.length < 2){
			System.out.println("Usage: java -jar FileReverse.jar <input file> <output file>");
			System.exit(1);
		}



		Scanner in = new Scanner(new File (args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));

		while(in.hasNextLine()){
			//convert string to an array of strings
			String text = in.nextLine().trim()+" ";

			String[] token = text.split("\\s+");
			
			int length = token.length;
			for(int i = 0; i < length; i++){
				String x = stringReverse(token[i]);
				out.println(x);
			}
		}
		in.close();
		out.close();
	}

	public static String stringReverse(String s){
		String reverse = "";
		for(int i = s.length() - 1; i >= 0; i--){
			reverse = reverse  + s.charAt(i);
		}
		return reverse;
	}
}



