public class DNA {
  protected LinkedQueue<Character> DNA;
  protected static String[][] mRNAtoProteinMap =
      {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
          {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
          {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
          {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
          {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
          {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
          {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
          {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
          {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
          {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
          {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};

  /**
   * This constructor creates the DNA queue from the provided String. Each Node contains a single
   * Character from the sequence.
   * 
   * @param sequence
   */
  public DNA(String sequence) {
    DNA = new LinkedQueue<Character>();
    for (int i = 0; i < sequence.length(); i++) {
      DNA.enqueue(sequence.charAt(i));
    }
  }

  /**
   * This method creates a new mRNA linked queue of Characters from the DNA linked queue. The
   * transcription is done one character at a time, as (A->U, T->A, C->G, G->C).
   * 
   * @return the queue containing the mRNA sequence
   */
  public LinkedQueue<Character> transcribeDNA() {
    LinkedQueue<Character> mRNA = new LinkedQueue<Character>();
    LinkedQueue<Character> newDNA = new LinkedQueue<Character>();
    while (!DNA.isEmpty()) {
      Character charDNA = DNA.dequeue();
      Character charmRNA;
      if (charDNA == 'A') {
        charmRNA = 'U';
      }

      else if (charDNA == 'T') {
        charmRNA = 'A';
      }

      else if (charDNA == 'C') {
        charmRNA = 'G';
      }

      else {
        charmRNA = 'C';
      }

      mRNA.enqueue(charmRNA);
      newDNA.enqueue(charDNA);
    }
    DNA = newDNA;
    return mRNA;
  }

  /**
   * This method creates and returns a new queue of amino acids from a provided queue of mRNA
   * characters. It groups three mRNA characters to translate into a protein using the
   * mRNAtoProteinMap provided above.
   * 
   * @param mRNA
   * @return the queue containing the amino acid sequence
   */
  public LinkedQueue<String> mRNATranslate​(LinkedQueue<Character> mRNA) {
    LinkedQueue<String> protein = new LinkedQueue<String>();
    while (mRNA.size() >= 3) {
      String s = "";
      for (int i = 0; i < 3; i++) {
        s += mRNA.dequeue();
      }
      for (int j = 0; j < mRNAtoProteinMap.length; j++) {
        if (s.equals(mRNAtoProteinMap[j][0])) {
          if (mRNAtoProteinMap[j][1].equals("STOP")) {
            return protein;
          }
          protein.enqueue(mRNAtoProteinMap[j][1]);
        }
      }
    }
    return protein;
  }

  /**
   * This method serves as a shortcut method that translates the stored DNA sequence to a queue of
   * amino acids using the other two methods in this class
   * 
   * @return the queue containing the amino acid sequence
   */
  public LinkedQueue<String> translateDNA() {
    return mRNATranslate​(transcribeDNA());
  }
}
