import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class NicknameGenerator {
    private static AtomicInteger count3 = new AtomicInteger(0);
    private static AtomicInteger count4 = new AtomicInteger(0);
    private static AtomicInteger count5 = new AtomicInteger(0);

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static void checkPalindromes(String[] texts) {
        for (String text : texts) {
            if (text.length() == 3) {
                if (isPalindrome(text)) count3.incrementAndGet();
            } else if (text.length() == 4) {
                if (isPalindrome(text)) count4.incrementAndGet();
            } else if (text.length() == 5) {
                if (isPalindrome(text)) count5.incrementAndGet();
            }
        }
    }

    private static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void checkSameLetters(String[] texts) {
        for (String text : texts) {
            if (text.length() == 3) {
                if (isSameLetter(text)) count3.incrementAndGet();
            } else if (text.length() == 4) {
                if (isSameLetter(text)) count4.incrementAndGet();
            } else if (text.length() == 5) {
                if (isSameLetter(text)) count5.incrementAndGet();
            }
        }
    }

    private static boolean isSameLetter(String text) {
        char firstChar = text.charAt(0);
        for (char c : text.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }

    public static void checkAscendingOrder(String[] texts) {
        for (String text : texts) {
            if (text.length() == 3) {
                if (isAscending(text)) count3.incrementAndGet();
            } else if (text.length() == 4) {
                if (isAscending(text)) count4.incrementAndGet();
            } else if (text.length() == 5) {
                if (isAscending(text)) count5.incrementAndGet();
            }
        }
    }

    private static boolean isAscending(String text) {
        char lastChar = 0;
        for (char c : text.toCharArray()) {
            if (lastChar > c) {
                return false;
            }
            lastChar = c;
        }
        return true;
    }

    public static AtomicInteger getCount3() {
        return count3;
    }

    public static AtomicInteger getCount4() {
        return count4;
    }

    public static AtomicInteger getCount5() {
        return count5;
    }
}
