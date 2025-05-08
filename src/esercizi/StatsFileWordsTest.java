package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StatsFileWordsTest {
	
	static StatsFileWords sfw;
	
	static String filePath = "src/text_files/wordsstream.txt";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sfw = new StatsFileWords(filePath);
	}

	@Test
	void testWords() throws IOException {
		String[] testWordsArray = {"PAROLA1", "PAROLA1", "PAROLA11", "PAROLA2", "PAROLA2", "PAROLA22", "PAROLA3", "PAROLA33", "PAROLA4", "PAROLA4", "PAROLA44"};
		assertArrayEquals(testWordsArray, sfw.words());
		assertThrows(IOException.class, () -> new StatsFileWords(filePath + "err")); // Test lancio IOException
	}
	
	@Test
	void testCountAll() throws IOException {
		assertEquals(11, sfw.countAll());
	}
	
	@Test
	void testCount() throws IOException {
		assertEquals(1, sfw.count("parola3"));
	}
	
	@Test
	void testWordGreater() throws IOException {
		assertEquals("PAROLA44", sfw.wordGreater());
	}
	
	@Test
	void testWordsWithLenghtLessThen() throws IOException {
		String[] testArray = {"PAROLA1", "PAROLA1", "PAROLA2", "PAROLA2", "PAROLA3", "PAROLA4", "PAROLA4"};
		assertArrayEquals(testArray, sfw.wordsWithLenghtLessThen(8));
	}
	
	@Test
	void testWordsJoined() throws IOException {
		String testString = "PAROLA1PAROLA1PAROLA11PAROLA2PAROLA2PAROLA22PAROLA3PAROLA33PAROLA4PAROLA4PAROLA44";
		assertEquals(testString, sfw.wordsJoined());
	}

}
