package recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        // number of disks, tower 1, tower 2, tower 3
        // tower 1 -> source
        // tower 2 -> intermediate
        // tower 3 -> destination
        solveTowerOfHanoi(3, 1, 2, 3);
    }

    public static void solveTowerOfHanoi(int n, int source, int temp, int destination) {
        if (n <= 0)
            return;

        solveTowerOfHanoi(n - 1, source, destination, temp);
        System.out.printf("Moving (%d, %d)%n", source, destination);
        solveTowerOfHanoi(n - 1, temp, source, destination);
    }
}