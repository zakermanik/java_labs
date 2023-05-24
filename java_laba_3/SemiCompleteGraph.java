import java.util.*;

public class SemiCompleteGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества вершин и ребер
        System.out.print("Введите количество вершин (n): ");
        int n = scanner.nextInt();

        System.out.print("Введите количество ребер (m): ");
        int m = scanner.nextInt();

        // Создание графа в виде списка ребер
        List<Edge> edges = new ArrayList<>();

        System.out.println("Введите ребра графа (в формате \"вершина1 вершина2\"):");
        for (int i = 0; i < m; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges.add(new Edge(vertex1, vertex2));
        }

        // Проверка на полуполноту графа
        boolean isSemiComplete = isSemiCompleteGraph(n, edges);

        // Вывод результата
        if (isSemiComplete) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static boolean isSemiCompleteGraph(int n, List<Edge> edges) {
        Set<Integer> vertices = new HashSet<>();
        for (Edge edge : edges) {
            vertices.add(edge.vertex1);
            vertices.add(edge.vertex2);
        }
        // Проверка наличия ребра между каждой парой вершин
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && !edges.contains(new Edge(i, j))) {
                    return false;
                }
            }
        }

        return true;
    }
    static class Edge {
        int vertex1;
        int vertex2;

        public Edge(int vertex1, int vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Edge edge = (Edge) obj;
            return (vertex1 == edge.vertex1 && vertex2 == edge.vertex2) ||
                    (vertex1 == edge.vertex2 && vertex2 == edge.vertex1);
        }
        @Override
        public int hashCode() {
            return Objects.hash(Math.min(vertex1, vertex2), Math.max(vertex1, vertex2));
        }
    }
}
