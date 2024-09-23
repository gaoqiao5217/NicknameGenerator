import java.util.Random;

public class Main {
    private static final int NUM_WORDS = 100_000;
    private static final String LETTERS = "abc";

    public static void main(String[] args) {
        Random random = new Random();
        String[] texts = new String[NUM_WORDS];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = NicknameGenerator.generateText(LETTERS, 3 + random.nextInt(3));
        }

        Thread thread1 = new Thread(() -> NicknameGenerator.checkPalindromes(texts));
        Thread thread2 = new Thread(() -> NicknameGenerator.checkSameLetters(texts));
        Thread thread3 = new Thread(() -> NicknameGenerator.checkAscendingOrder(texts));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Красивых слов с длиной 3: " + NicknameGenerator.getCount3() + " шт");
        System.out.println("Красивых слов с длиной 4: " + NicknameGenerator.getCount4() + " шт");
        System.out.println("Красивых слов с длиной 5: " + NicknameGenerator.getCount5() + " шт");
    }
}
