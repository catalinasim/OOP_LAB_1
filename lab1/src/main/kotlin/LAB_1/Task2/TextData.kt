package LAB_1.Task2

// TextData class
class TextData(
    //- String fileName
    private val fileName: String = "",
    //- String text
    private var text: String,
    //- int numberOfVowels
    private var numberOfVowels: Int = -1,
    //- int numberOfConsonants
    private var numberOfConsonants: Int = -1,
    //- int numberOfLetters
    private var numberOfLetters: Int = -1,
    //- int numberOfSentences
    private var numberOfSentences: Int = -1,
    //- String longestWord
    private var longestWord: String = ""
) {
    // list of vowels to use in the methods later
    private val vowels = listOf('a', 'e', 'i', 'o', 'u')

    // if it were in java, this would have been +TextData(String text)
    constructor(text: String) : this("", text) {
        if (text.isEmpty()) {
            error("Text cannot be an empty string")
        }
    }

    //+ String getFilename()
    fun getFilename(): String {
        return fileName
    }

    //+ String getText()
    fun getText(): String {
        return text
    }

    //+ int getNumberOfVowels()
    fun getNumberOfVowels(): Int {
        if (numberOfVowels == -1) {
            numberOfVowels = text.lowercase().count { it in vowels }
        }
        return numberOfVowels
    }

    //+ int getNumberOfConsonants()
    fun getNumberOfConsonants(): Int {
        if (numberOfConsonants == -1) {
            numberOfConsonants = text.lowercase().count { it !in vowels && it.isLetter() }
        }
        return numberOfConsonants
    }

    //+ int getNumberOfLetter()
    fun getNumberOfLetters(): Int {
        if (numberOfLetters == -1) {
            numberOfLetters = text.count { it.isLetter() }
        }
        return numberOfLetters
    }

    //+ int getNumberOfSentences()
    fun getNumberOfSentences(): Int {
        if (numberOfSentences == -1) {
            numberOfSentences = text.count { it == '.' || it == '!' || it == '?' }
        }
        return numberOfSentences
    }

    //+ String getLongestWord()
    fun getLongestWord(): String {
        if (longestWord == "") {
            // Use Regex to select only the words
            val words = text.split(Regex("[^\\w]"))
            for (word in words) {
                // Get the longest word
                if (word.length > longestWord.length) {
                    longestWord = word
                }
            }
        }
        return longestWord
    }
}