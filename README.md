# Stream, Lambda, Collectors

## StatsFileWords

L'obiettivo di questo esercizio è l'utilizzo di **Stream**, **Lambda**, **Collectors**.

Creare la classe `StatsFileWords` con relativo JUnit di test `StatsFileWordsTest`.
La classe implementa l'interfaccia `StreamWords` contenente le funzionalità relative alle statistiche di un file.
All'interno della classe è presente un solo costruttore con il nome del file da trattare.

> **Nota:** Il file contiene parole separate da uno o più spazi ed è possibile che contenga anche una o più righe vuote o spazi.

```java
class StatsFileWords implements StreamWords {

    private String fileName;

    public StatsFileWords(String fileName);
}
```

### Output

Eseguire i metodi all'interno dell'interface `StreamWords`.

## Files

**StreamWords.java**

```java
public interface StreamWords {
    /* 1. Returns the count of words in the file */
    long countAll() throws IOException;
    /* 2. Returns all words in the file */
    String[] words() throws IOException;
    /* 3. Returns the number of occurrences of a word */
    long count(String word) throws IOException;
    /* 4. Returns the greater word (alphabetically greater) */
    String wordGreater() throws IOException;
    /* 5. Returns all words with less then n characters */
    String[] wordsWithLenghtLessThen(int numChar) throws IOException;
    /* 6. Returns a string with all file words concatenated */
    String wordsJoined() throws IOException;
}
