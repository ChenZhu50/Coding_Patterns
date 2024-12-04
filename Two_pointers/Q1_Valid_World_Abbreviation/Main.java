package Q1_Valid_World_Abbreviation;

public class Main {
    public static void main(String[] args) {
        String[] words = { "a", "a", "abcdefghijklmnopqrst", "abcdefghijklmnopqrst", "word", "internationalization",
                "localization" };
        String[] abbreviations = { "a", "b", "a18t", "a19t", "w0rd", "i18n", "l12n" };

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ".\t word: '" + words[i] + "'");
            System.out.println("\t abbr: '" + abbreviations[i] + "'");
            System.out.println("\n\t Is '" + abbreviations[i] + "' a valid abbreviation for the word '" + words[i]
                    + "'? " + (validWordAbbreviation(words[i], abbreviations[i]) ? "Yes" : "No"));
        }
    }

    public static boolean validWordAbbreviation(String word, String abbr) {

        // make two pointer point to the beginning of the word and abbreviation
        int wordIndex = 0, abbrIndex = 0;

        // loop through the word and abbreviation
        while (abbrIndex < abbr.length()) {
            // 如果abbr的当前字符是数字
            if (Character.isDigit(abbr.charAt(abbrIndex))) {
                // 如果数字的第一位是0，返回false
                if (abbr.charAt(abbrIndex) == '0')
                    return false;
                // 找到数字的结束位置
                int numEnd = abbrIndex;
                while (numEnd < abbr.length() && Character.isDigit(abbr.charAt(numEnd))) {
                    numEnd++;
                }
                // 将数字转换为int
                int num = Integer.parseInt(abbr.substring(abbrIndex, numEnd));
                // 将wordIndex移动num位
                wordIndex += num;
                // abbrIndex移动到数字的结束位置
                abbrIndex = numEnd;
            } else {
                // 如果abbr的当前字符是字母
                // 如果word和abbr的当前字符不相等，返回false
                if (wordIndex >= word.length() || word.charAt(wordIndex) != abbr.charAt(abbrIndex))
                    return false;
                // wordIndex和abbrIndex都向后移动一位
                wordIndex++;
                abbrIndex++;
            }
        }

        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}