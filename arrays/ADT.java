package arrays;

public class ADT {
    private int[] array;
    private int length;
    private int size;

    ADT() {
        this(20);
    }

    ADT(int size) {
        array = new int[size];
        this.size = size;
        length = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                str.append(", ");
            }
            str.append(array[i]);
            // str.append("(").append(i).append(")");
        }
        str.append("]");

        str.append(" (").append(this.length).append(")");
        return str.toString();
    }

    public int length() {
        // O(1)
        return length;
    }

    public int get(int idx) {
        // O(1)
        if (idx < 0 || idx >= length) {
            System.out.println("Array index out of bound");
            return -1;
        }

        return array[idx];
    }

    public void set(int idx, int num) {
        // O(1)
        if (idx < 0 || idx >= length) {
            System.out.println("Array index out of bound");
        }
        array[idx] = num;
    }

    public void append(int num) {
        // O(1)
        if (length == size) {
            System.out.println("Array size exceeded");
            return;
        }
        array[length++] = num;
    }

    public void prepend(int num) {
        // O(n)
        insert(num, 0);
    }

    public void insert(int num, int idx) {
        // O(n)
        if (length == size) {
            System.out.println("Array size exceeded");
            return;
        }

        if (idx < 0 || idx > length) {
            System.out.println("Index out of bound");
            return;
        }

        if (idx == length) {
            this.append(num);
            return;
        }

        for (int i = length; i > idx; i--) {
            array[i] = array[i - 1];
        }

        array[idx] = num;
        length++;
    }

    public void delete(int idx) {
        // O(n)
        if (idx < 0 || idx >= length) {
            System.out.println("Index out of bound");
            return;
        }
        for (int i = idx; i < length - 1; i++) {
            array[i] = array[i + 1];
        }

        length--;
    }

    public void deleteElement(int num) {
        // O(n)
        for (int i = 0; i < length; i++) {
            if (array[i] == num) {
                delete(i); // O(n)
                return;
            }
        }
    }

    public void deleteElementLast(int num) {
        // O(n)
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] == num) {
                delete(i);
                return;
            }
        }
    }

    public void deleteElementAll(int num) {
        // O(n)
        int newIndex = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != num) {
                array[newIndex++] = array[i];
            }
        }

        for (int i = newIndex; i < length; i++) {
            array[i] = 0;
        }

        length = newIndex;
    }

    public int count(int num) {
        // O(n)
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == num)
                count++;
        }

        return count;
    }

    public int search(int num) {
        // O(n)
        for (int i = 0; i < length; i++) {
            if (array[i] == num) {
                return i;
            }
        }

        return -1;
    }

    public int searchLast(int num) {
        // O(n)
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkSorted() {
        // O(n)
        if (length < 2)
            return true;

        boolean isAscending = true;
        boolean isDecending = true;

        for (int i = 1; i < length; i++) {
            if (array[i - 1] < array[i]) {
                isDecending = false;
            } else if (array[i - 1] > array[i]) {
                isAscending = false;
            }

            if (!isAscending && !isDecending) {
                return false;
            }
        }

        return true;
    }

    public void bubbleSort() {
        for (int i = 0; i < length; i++) {
            boolean isSwapped = false;

            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSwapped = true;
                }
            }

            if (!isSwapped)
                break;
        }
    }

    public int avg() {
        if (length <= 0) {
            return 0;
        }

        int sum = 0;
        
        for (int i = 0; i < length; i++)
            sum += array[i];

        return sum / length;
    }

    public int max() {
        if (length <= 0) {
            return 0;
        }

        int max = array[0];

        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        return max;
    }

    public int min() {
        if (length <= 0) {
            return 0;
        }

        int min = array[0];

        for (int i = 1; i < length; i++) {
            if (array[i] < min)
                min = array[i];
        }

        return min;
    }

    public void reverse(){
        if(length<2){
            return;
        }

        int start =0;
        int end = length -1;
        while(start< end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // reverse
    // rotate
    // check sorted
    // mergeArray
    // union, intersection, difference
    // unique elements
    // make menu driven program

    public static void main(String[] args) {
        ADT arr = new ADT(50);

        arr.append(7013);
        arr.append(13);
        arr.append(52);
        arr.append(20);
        arr.append(21);
        arr.append(25);
        arr.append(27);
        arr.append(28);
        arr.append(52);
        arr.prepend(111);
        arr.prepend(144);
        arr.prepend(13);
        arr.prepend(18);
        arr.insert(55, 2);
        arr.insert(55, 3);
        arr.insert(55, arr.length() - 2);
        arr.insert(55, arr.length() - 2);

        arr.insert(2001, arr.length() / 2);
        arr.insert(1001, 0);
        arr.insert(3001, arr.length());
        System.out.println(arr);

        System.out.printf("%nDelete 0 index : %n");
        arr.delete(0);
        System.out.println(arr);

        System.out.printf("%nDelete First Element 55: %n");
        arr.deleteElement(55);
        System.out.println(arr);

        System.out.printf("%nDelete Last Element 55: %n");
        arr.deleteElementLast(55);
        System.out.println(arr);

        System.out.printf("%nDelete All 55: %n");
        arr.deleteElementAll(55);
        System.out.println(arr);

        System.out.printf("%nCount 52: %n");
        System.out.println(arr.count(52));

        System.out.printf("%nGet: %n");
        for (int i = 0; i < arr.length(); i++)
            System.err.print(arr.get(i) + " ");
        System.err.println();

        System.out.printf("%nSet 2: %n");
        arr.set(2, 2525);
        System.out.println(arr);

        System.out.printf("%nSearch First 52: %n");
        System.out.println(arr.search(52));

        System.out.printf("%nSearch Last 52: %n");
        System.out.println(arr.searchLast(52));
        System.err.println();

        if (!arr.checkSorted()) {
            System.out.println("Array not sorted");

        }

        arr.bubbleSort();
        System.err.println(arr);

        if (arr.checkSorted()) {
            System.out.println("Array is sorted");
        }

        arr.reverse();
        System.err.println(arr);
    }
}