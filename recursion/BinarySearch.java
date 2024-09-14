package recursion;

public class BinarySearch {

    public static void main(String[] args) {
        int[] list = { 1, 2, 5, 6, 8, 10, 15, 18, 25, 28, 35, 45 };

        System.out.println(search(list, 5));
    }

    public static int search(int[] list, int target) {
        return search(list, target, 0, list.length - 1);
    }

    private static int search(int[] list, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (list[mid] == target) {
            return mid;
        }

        if (list[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }

        return search(list, target, start, end);
    }
}