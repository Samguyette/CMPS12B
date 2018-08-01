//-----------------------------------------------------------------------------
// Samuel Guyette
// sguyette
// 1518801
// chessMoves.java  
// Reads in text file and stores in hash table. For any word length l and 
// number k, the program will find the k most frequent word of length l.
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Iterator;

class Bard{

	public static void main(String args[]) throws IOException{
		if(args.length < 2){
			System.out.println("Usage: java -jar Bard.jar <input file> <output file>");
			System.exit(1); 
		}

		Scanner in = new Scanner(new File (args[0]));					//opens file 
		Scanner text = new Scanner(new File("shakespeare.txt"));		//opens text file
		PrintWriter out = new PrintWriter(new File (args[1]));
		Hashtable<String, Integer> wordData = new Hashtable<String, Integer>();			//initilaizes hashtable

		while(text.hasNextLine()){
			String str = text.nextLine();							//replaces all unnessesary punctuation
 			str = str.replace('?','	');
 			str = str.replace(',','	');
 			str = str.replace('.','	');
 			str = str.replace('!','	');
 			str = str.replace(':','	');
 			str = str.replace(';','	');
 			str = str.replace('[','	');
 			str = str.replace(']','	');

 			String[] tokens = str.trim().split("\\s+");						//splits words 

 			for(int i = 0; i < tokens.length; i++){
 				tokens[i] = tokens[i].toLowerCase();						//converts all words to lowercase
 			}

 			for(int j = 0; j < tokens.length; j++){
 				String word = tokens[j];

 				if(wordData.containsKey(word)){ 
         			wordData.put(word, wordData.get(word)+1);				//if word is already in hash table, ups count
				}

				else{
        			wordData.put(word, 1);									//if not in hash table inserts new word into hashtable
				}
 			}
		}

		Set<String> keys = wordData.keySet();
		Iterator<String> itr = keys.iterator();								//creats iterator to iterate through hash table

		ArrayList<WordObject>[] main = (ArrayList<WordObject>[])new ArrayList[248];		//creats an array of arrayLists to store a list of all the words 
																						//of simmular length
		for(int n = 0; n < 248; n++){
			main[n] = new ArrayList<WordObject>();											//declares all arraylists
		}

		while(itr.hasNext()){
			String word = itr.next();
			
			WordObject newData = new WordObject(wordData.get(word), word);			//creates new word object with occurence size and word
			main[newData.wordLength].add(newData);									//adds it to proper arrayList in the main array
		}
		
		for(int i = 0; i < main.length; i++){
			Collections.sort(main[i]);									//sorts each arraylist in array
		}

		int length;
		int NmostFreq;
		while(in.hasNextLine()){
			if(in.hasNextInt()){
				length = in.nextInt();									//takes in input for length of int
				NmostFreq = in.nextInt();								//and the Nth most frequent spot starting at 0
			}
			else{
				break;
			}
			boolean lineWrote = false;

			if(main[length].size() == 0){				//checks if there a word of length length
				out.println('-');
				lineWrote = true;
			}
			if((main[length].size() <= NmostFreq) && lineWrote == false){		//checks if there is a word of NmostFreq
				out.println('-');										
				lineWrote = true;
			}
			if(lineWrote == false){
				out.println(main[length].get(NmostFreq).word);				//prints out the nth most frequent word of length length
			}																//if line has not been wrote on
		}
		out.close();
	}
}









