public class WordObject implements Comparable<WordObject>{
   	int occurrenceCount;
  	String word;
  	int wordLength;

   	public WordObject(int occurrenceCount, String word) {
   		this.wordLength = word.length();
        this.occurrenceCount = occurrenceCount;
        this.word = word;
   	}

   	public int compareTo(WordObject temp){
   		if(temp.occurrenceCount == this.occurrenceCount){		//checks if words have the same count
   			for(int i = 0; i < 30; i++){						//goes down both words finding which comes first 
	   			char one = temp.word.charAt(i);				//aphabetically 
	    		char two = this.word.charAt(i);				
	    		if(one > two){
	    			return -1;
	    		}
	    		if(two > one){
	    			return 1;
	    		}		
   			}	
   		}
   		return Integer.compare(temp.occurrenceCount, this.occurrenceCount);
   	}
}