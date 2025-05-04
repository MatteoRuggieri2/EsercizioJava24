package esercizi;

import java.io.IOException;

public interface StreamWords {
	
	/* 1. Returns the count of words in the file */
	long countAll() throws IOException;
	
	/* 2. Returns all words in the file */
	String[] words() throws IOException;
	
	/* 3. Returns the number of occurrences of a word */
	long count(String parola) throws IOException;
	
	/* 4. Returns the greater word (alphabetically greater) */
	String wordGreater() throws IOException;
	
	/* 5. Returns all words with less then n characters */
	String[] wordsWithLenghtLessThen(int numChar) throws IOException;
	
	/* 6. Returns a string with all file words concatenated */
	String wordsJoined() throws IOException;

}
