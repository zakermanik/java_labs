public class PalindromeCheck {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama!";

        boolean result = isPossiblePalindromeTransformation(input);

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isPossiblePalindromeTransformation(String input) {
        // Игнорирование нерелевантных символов и приведение к нижнему регистру
        String normalizedInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Проверка, является ли строка палиндромом
        if (isPalindrome(normalizedInput)) {
            return true;
        }

        // Проверка замены, удаления или добавления не более одного символа
        int length = normalizedInput.length();

        for (int i = 0; i < length; i++) {
            String modifiedString = removeCharacter(normalizedInput, i);
            if (isPalindrome(modifiedString)) {
                return true;
            }
        }

        for (int i = 0; i < length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String modifiedString = insertCharacter(normalizedInput, i, c);
                if (isPalindrome(modifiedString)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isPalindrome(String str) {
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static String removeCharacter(String str, int index) {
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(index);
        return sb.toString();
    }

    public static String insertCharacter(String str, int index, char c) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(index, c);
        return sb.toString();
    }
}
