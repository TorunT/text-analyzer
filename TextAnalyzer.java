import java.util.*;

/**
 * ============================================================
 *  TextAnalyzer — String-Based Text Analysis Tool
 *  CS 1103 | Unit 1 Programming Assignment
 * ============================================================
 *  Performs character-level and word-level analysis on any
 *  text input provided by the user.
 * ============================================================
 */
public class TextAnalyzer {

    // ── ANSI color codes for terminal output ──────────────────
    private static final String RESET  = "\u001B[0m";
    private static final String BOLD   = "\u001B[1m";
    private static final String CYAN   = "\u001B[36m";
    private static final String GREEN  = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE   = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String RED    = "\u001B[31m";

    // ── Scanner shared across all methods ─────────────────────
    private static final Scanner scanner = new Scanner(System.in);

    // ==========================================================
    //  ENTRY POINT
    // ==========================================================
    public static void main(String[] args) {
        printBanner();

        String text = getUserText();

        if (text == null || text.isEmpty()) {
            System.out.println(RED + "\n[ERROR] No text provided. Exiting." + RESET);
            return;
        }

        printSectionHeader("ANALYSIS RESULTS");

        displayCharacterCount(text);
        displayWordCount(text);
        displayMostCommonCharacter(text);
        displayCharacterFrequency(text);
        displayWordFrequency(text);
        displayUniqueWordCount(text);

        printFooter();
        scanner.close();
    }

    // ==========================================================
    //  1. USER INPUT
    // ==========================================================
    private static String getUserText() {
        System.out.println(CYAN + BOLD + "\nEnter your text (paragraph or lengthy text):" + RESET);
        System.out.println(CYAN + "──────────────────────────────────────────────" + RESET);
        String input = scanner.nextLine().trim();

        // Input validation
        while (input.isEmpty()) {
            System.out.println(RED + "[WARNING] Input cannot be empty. Please try again:" + RESET);
            input = scanner.nextLine().trim();
        }
        return input;
    }

    // ==========================================================
    //  2. CHARACTER COUNT
    // ==========================================================
    private static void displayCharacterCount(String text) {
        int count = text.length();
        printResult("Character Count", String.valueOf(count), GREEN);
    }

    // ==========================================================
    //  3. WORD COUNT
    // ==========================================================
    private static void displayWordCount(String text) {
        // Split on one or more spaces; filter empty tokens
        String[] words = text.trim().split("\\s+");
        int count = (text.trim().isEmpty()) ? 0 : words.length;
        printResult("Word Count", String.valueOf(count), GREEN);
    }

    // ==========================================================
    //  4. MOST COMMON CHARACTER
    // ==========================================================
    private static void displayMostCommonCharacter(String text) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        String lower = text.toLowerCase();

        for (char c : lower.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        char mostCommon = ' ';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        String display = (mostCommon == ' ')
            ? "SPACE (' ')"
            : "'" + mostCommon + "'";

        printResult("Most Common Character",
            display + "  →  appeared " + maxCount + " times", YELLOW);
    }

    // ==========================================================
    //  5. CHARACTER FREQUENCY (user-specified)
    // ==========================================================
    private static void displayCharacterFrequency(String text) {
        System.out.println(BLUE + BOLD + "\n[INPUT] Enter a character to search:" + RESET + " ");
        String input = scanner.nextLine().trim();

        // Validate: must be exactly one character
        while (input.length() != 1) {
            System.out.println(RED + "[WARNING] Please enter exactly ONE character:" + RESET + " ");
            input = scanner.nextLine().trim();
        }

        char target = Character.toLowerCase(input.charAt(0));
        long count = text.toLowerCase()
                         .chars()
                         .filter(c -> c == target)
                         .count();

        printResult("Frequency of '" + input.charAt(0) + "'",
            count + " occurrence(s)  (case-insensitive)", BLUE);
    }

    // ==========================================================
    //  6. WORD FREQUENCY (user-specified)
    // ==========================================================
    private static void displayWordFrequency(String text) {
        System.out.println(PURPLE + BOLD + "\n[INPUT] Enter a word to search:" + RESET + " ");
        String word = scanner.nextLine().trim();

        // Validate: no empty input
        while (word.isEmpty()) {
            System.out.println(RED + "[WARNING] Word cannot be empty. Try again:" + RESET + " ");
            word = scanner.nextLine().trim();
        }

        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();
        String[] tokens  = lowerText.trim().split("\\s+");

        long count = Arrays.stream(tokens)
                           .filter(t -> t.replaceAll("[^a-zA-Z0-9]", "")
                                         .equals(lowerWord.replaceAll("[^a-zA-Z0-9]", "")))
                           .count();

        printResult("Frequency of \"" + word + "\"",
            count + " occurrence(s)  (case-insensitive)", PURPLE);
    }

    // ==========================================================
    //  7. UNIQUE WORD COUNT
    // ==========================================================
    private static void displayUniqueWordCount(String text) {
        String[] tokens = text.trim().toLowerCase().split("\\s+");
        Set<String> uniqueWords = new HashSet<>();

        for (String token : tokens) {
            String cleaned = token.replaceAll("[^a-zA-Z0-9]", "");
            if (!cleaned.isEmpty()) {
                uniqueWords.add(cleaned);
            }
        }

        printResult("Unique Word Count", String.valueOf(uniqueWords.size()), GREEN);
    }

    // ==========================================================
    //  HELPER — PRINT UTILITIES
    // ==========================================================
    private static void printBanner() {
        System.out.println(CYAN + BOLD);
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║          TEXT ANALYZER  —  CS 1103 Unit 1            ║");
        System.out.println("║        String-Based Data Analysis Tool               ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println(RESET);
    }

    private static void printSectionHeader(String title) {
        System.out.println(CYAN + BOLD + "\n┌─────────────────────────────────────────────────────┐");
        System.out.printf ("│  %-51s│%n", "  " + title);
        System.out.println("└─────────────────────────────────────────────────────┘" + RESET);
    }

    private static void printResult(String label, String value, String color) {
        System.out.printf("%s%-30s%s  →  %s%s%s%n",
            BOLD, label, RESET,
            color + BOLD, value, RESET);
    }

    private static void printFooter() {
        System.out.println(CYAN + "\n──────────────────────────────────────────────────────");
        System.out.println("  Analysis complete. Thank you for using TextAnalyzer.");
        System.out.println("──────────────────────────────────────────────────────" + RESET);
    }
}
