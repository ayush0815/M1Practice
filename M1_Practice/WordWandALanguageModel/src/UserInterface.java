import java.util.Scanner;

class WordWand {
    private String sentence;
    public WordWand(String sentence) {
        this.sentence = sentence;
    }

    public boolean isValidSentence() {
        for (char c : sentence.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    public int wordCount() {
        return sentence.split("\\s+").length;
    }

    public String transformSentence() {
        if (!isValidSentence()) {
            return "Invalid Sentence";
        }

        String[] words = sentence.split("\\s+");
        int wordCount = wordCount();

        if (wordCount % 2 == 0) {
            StringBuilder transformedSentence = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                transformedSentence.append(words[i]).append(" ");
            }
            return "Word Count: " + wordCount + "\n" + transformedSentence.toString().trim();
        } else {
            StringBuilder transformedSentence = new StringBuilder();
            for (String word : words) {
                transformedSentence.append(new StringBuilder(word).reverse().toString()).append(" ");
            }
            return "Word Count: " + wordCount + "\n" + transformedSentence.toString().trim();
        }
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sentence = sc.nextLine();

        WordWand wordWand = new WordWand(sentence);
        System.out.println(wordWand.transformSentence());
    }
}
