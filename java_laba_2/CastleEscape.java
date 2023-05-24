import java.util.Scanner;

public class CastleEscape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размеров замка
        System.out.print("Введите количество строк (N): ");
        int N = scanner.nextInt();

        System.out.print("Введите количество столбцов (M): ");
        int M = scanner.nextInt();

        // Ввод плана замка
        int[][] castle = new int[N][M];
        System.out.println("Введите план замка:");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                castle[i][j] = scanner.nextInt();
            }
        }
        int result = countEscapeRoutes(castle);
        System.out.println("Количество маршрутов, ведущих к выходу: " + result);
    }
    public static int countEscapeRoutes(int[][] castle) {
        int N = castle.length;
        int M = castle[0].length;

        // Создание двумерного массива для хранения количества маршрутов
        int[][] dp = new int[N][M];

        // Инициализация базовых случаев
        dp[0][0] = castle[0][0];

        for (int i = 1; i < N; i++) {
            if (castle[i][0] == 1 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < M; j++) {
            if (castle[0][j] == 1 && dp[0][j - 1] == 1) {
                dp[0][j] = 1;
            }
        }
        // Заполнение массива dp
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (castle[i][j] == 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[N - 1][M - 1];
    }
}
