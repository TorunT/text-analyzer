# TextAnalyzer — String-Based Text Analysis Tool

> A Java console application that performs character-level and word-level analysis on any text input. Built as part of **CS 1103 Unit 1** at the University of the People.

---

## Overview

**TextAnalyzer** is a command-line tool that takes a block of text from the user and extracts meaningful statistics from it. The project demonstrates core Java string handling concepts including `String` methods, `HashMap`-based frequency analysis, `Set`-based uniqueness detection, and input validation.

---

## Features

| Feature | Description |
|---|---|
| Character Count | Total number of characters in the input |
| Word Count | Total number of words (space-delimited) |
| Most Common Character | Character with the highest frequency |
| Character Frequency | How often a user-specified character appears (case-insensitive) |
| Word Frequency | How often a user-specified word appears (case-insensitive) |
| Unique Word Count | Number of distinct words in the text |

---

## Sample Output

```
╔══════════════════════════════════════════════════════╗
║          TEXT ANALYZER  —      
║        String-Based Data Analysis Tool               ║
╚══════════════════════════════════════════════════════╝

Enter your text (paragraph or lengthy text):
──────────────────────────────────────────────
Java is a powerful language. Java is used everywhere.

┌─────────────────────────────────────────────────────┐
│    ANALYSIS RESULTS                                  │
└─────────────────────────────────────────────────────┘

Character Count                →  53
Word Count                     →  8
Most Common Character          →  'a'  →  appeared 7 times

[INPUT] Enter a character to search: a
Frequency of 'a'               →  7 occurrence(s)  (case-insensitive)

[INPUT] Enter a word to search: java
Frequency of "java"            →  2 occurrence(s)  (case-insensitive)

Unique Word Count              →  6
```

---

## Project Structure

```
text-analyzer/
│
├── src/
│   └── TextAnalyzer.java       # Main source file
│
├── screenshots/
│   └── output.png              # Sample program output
│
└── README.md
```

---

## How to Run

### Prerequisites
- Java JDK 8 or higher installed
- A terminal or command prompt

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/text-analyzer.git
cd text-analyzer

# 2. Compile the source file
javac src/TextAnalyzer.java -d out

# 3. Run the program
java -cp out TextAnalyzer
```

---

## Concepts Demonstrated

- `String` methods: `.length()`, `.toLowerCase()`, `.trim()`, `.split()`, `.charAt()`, `.replaceAll()`
- `HashMap` and `LinkedHashMap` for frequency counting
- `HashSet` for unique word detection
- Java Streams (`.chars()`, `.filter()`, `.count()`)
- Input validation with `Scanner`
- ANSI terminal colors for formatted output
- Clean code practices: single-responsibility methods, meaningful variable names, consistent formatting

---

## Academic Context

**Course:** CS 1103 — Programming 2  
**University:** University of the People  
**Unit:** 1 — String Handling  
**Assignment:** Text Analysis Tool

---

## References

- Eck, D. J. (2022). *Introduction to programming using Java version 9, JavaFX edition*. https://math.hws.edu/javanotes/
- Morelli, R., & Wade, R. (n.d.). *Exceptions: When things go wrong*. LibreTexts.
- Samoylov, N. (2018). *Introduction to programming: Learn to program in Java with data structures, algorithms, and logic*. Packt Publishing.

---

## License

This project is submitted for academic purposes at the University of the People.

