package esercizi;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatsFileWords implements StreamWords {
	
	private String nomeFile;
	
	private String[] fileWords;
	
	public StatsFileWords(String filePathName) throws IOException {
		this.nomeFile = filePathName;
		this.fileWords = this.words();
	}

	@Override
	public long countAll() throws IOException {
		return fileWords.length;
	}

	// Questa funzione ritorna tutte le parole presenti nel file
	@Override
	public String[] words() throws IOException {
		
		File file = new File(this.nomeFile);
		Path path = file.toPath();
		this.fileWords = Files.lines(path, StandardCharsets.UTF_8)
				          .flatMap(line -> Stream.of(line.split(" +"))) // Separo le parole con il delimitatore "uno o più spazi"
				          .filter(s -> !s.isEmpty()) // Filtro le righe, tengo solo quelle che non sono vuote
			        	  .map((s) -> s.toUpperCase()) // Trasformo tutte le parole in maiuscolo (per il sort, dato che per il riordinamento fa casini se ci sono parole con lettere minuscole o maiuscole mischiate).
				          .sorted() // Le metto in ordine alfabetico
				          .toArray(String[]::new);
//		                  .forEach((s) -> System.out.println(s)); // Stampo ogni parola
		
		return this.fileWords;
	}

	@Override
	public long count(String parola) throws IOException {
		return Arrays.stream(this.fileWords)
					 .filter(word -> word.equalsIgnoreCase(parola))
					 .collect(Collectors.counting());
	}

	@Override
	public String wordGreater() throws IOException {
		return Arrays.stream(this.fileWords) // Trasformo il mio array di parole in stream
				 .sorted() // Le metto in ordine alfabetico
				 .reduce((first, second) -> second).orElse(null);
				 /* Con questa lambda expression sto dicendo che ad ogni ciclo prende la
				  * prima parola e la seconda e tiene solo la seconda. Poi continua a fare
				  * la stessa cosa fino a quando le parole non esauriscono.
				  * Arriverà quindi ad 1 sola parola, l'ultima.
				  */
	}

	@Override
	public String[] wordsWithLenghtLessThen(int numChar) throws IOException {
		
		return Arrays.stream(this.fileWords)
				 .filter(word -> word.length() < numChar)
				 .toArray(String[]::new);
		
		/* Trasformo l'array in stream
		 * Per ogni parola, se la lunghezza è inferiore a quella passata, la tengo */
	}

	@Override
	public String wordsJoined() throws IOException {
		return Arrays.stream(this.fileWords) // Trasformo il mio array di parole in stream
//				 .reduce((totalString, s) -> totalString + s).orElse(null); /* Per ogni parola concateno la stringa */
				 .collect(Collectors.joining());
	}
}





