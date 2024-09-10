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

    public ADT set(int idx, int num) {
        // O(1)
        if (idx < 0 || idx >= length) {
            System.out.println("Array index out of bound");
            return this;
        }
        array[idx] = num;
        return this;
    }

    public ADT append(int num) {
        // O(1)
        if (length == size) {
            System.out.println("Array size exceeded");
            return this;
        }
        array[length++] = num;

        return this;
    }

    public ADT prepend(int num) {
        // O(n)
        insert(num, 0);

        return this;
    }

    public ADT insert(int num, int idx) {
        // O(n)
        if (length == size) {
            System.out.println("Array size exceeded");
            return this;
        }

        if (idx < 0 || idx > length) {
            System.out.println("Index out of bound");
            return this;
        }

        if (idx == length) {
            this.append(num);
            return this;
        }

        for (int i = length; i > idx; i--) {
            array[i] = array[i - 1];
        }

        array[idx] = num;
        length++;
        return this;
    }

    public ADT delete(int idx) {
        // O(n)
        if (idx < 0 || idx >= length) {
            System.out.println("Index out of bound");
            return this;
        }
        for (int i = idx; i < length - 1; i++) {
            array[i] = array[i + 1];
        }

        length--;

        return this;
    }

    public ADT deleteElement(int num) {
        // O(n)
        for (int i = 0; i < length; i++) {
            if (array[i] == num) {
                delete(i); // O(n)
                return this;
            }
        }
        return this;
    }

    public ADT deleteElementLast(int num) {
        // O(n)
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] == num) {
                delete(i);
                return this;
            }
        }
        return this;
    }

    public ADT deleteElementAll(int num) {
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
        return this;
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

    public int binarySearch(int num) {
        // O(log n)
        int start = 0;
        int end = length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (array[mid] == num) {
                return mid;
            } else if (array[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
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

    public ADT bubbleSort() {
        // O(n*n)
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
        return this;
    }

    public int avg() {
        // O(n)
        if (length <= 0) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < length; i++)
            sum += array[i];

        return sum / length;
    }

    public int max() {
        // O(n)
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
        // O(n)
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

    public ADT reverse() {
        // O(n)
        if (length < 2) {
            return this;
        }

        int start = 0;
        int end = length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        return this;
    }

    public ADT rotate() {
        // O(n)
        if (length < 1) {
            return this;
        }

        int first = array[0];

        for (int i = 0; i < length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[length - 1] = first;
        return this;
    }

    public ADT rotateRight() {
        // O(n)
        if (length < 1) {
            return this;
        }

        int last = array[length - 1];

        for (int i = length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = last;
        return this;
    }

    public ADT merge(ADT newArray) {
        // O(n)
        if ((size - length) < newArray.length()) {
            System.out.println("Array size exceeded");
            return this;
        }

        for (int i = 0; i < newArray.length(); i++) {
            this.append(newArray.get(i));
        }

        return this;
    }

    public ADT merge(int[] newArray) {
        // O(n)
        if ((size - length) < newArray.length) {
            System.out.println("Array size exceeded");
            return this;
        }

        for (int i = 0; i < newArray.length; i++) {
            this.append(newArray[i]);
        }

        return this;
    }

    public static void main(String[] args) {
        ADT arr = new ADT(100);

        arr.append(7013)
                .append(52)
                .prepend(111)
                .prepend(144)
                .prepend(13)
                .prepend(18)
                .insert(55, 2)
                .insert(55, 3)
                .insert(55, arr.length() - 2)
                .insert(55, arr.length() - 2)
                .insert(2001, arr.length() / 2)
                .insert(1001, 0)
                .insert(3001, arr.length())
                .merge(new int[]{13, 52, 20, 21, 25, 27, 28});

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
            System.out.print(arr.get(i) + " ");
        System.out.println();

        System.out.printf("%nSet 2: %n");
        arr.set(2, 2525);
        System.out.println(arr);

        System.out.printf("%nSearch First 52: %n");
        System.out.println(arr.search(52));

        System.out.printf("%nSearch Last 52: %n");
        System.out.println(arr.searchLast(52));
        System.out.println();

        if (!arr.checkSorted()) {
            System.out.println("Array not sorted");
        }

        arr.bubbleSort();
        System.out.println(arr);

        if (arr.checkSorted()) {
            System.out.println("Array is sorted");
        }

        arr.reverse();
        System.out.println(arr);
        System.out.printf("%nLeft Rotate: %n");
        arr.rotate();
        System.out.println(arr);

        System.out.printf("%nRight Rotate: %n");
        arr.rotateRight();
        System.out.println(arr);
        arr.rotateRight();
        System.out.println(arr);
        arr.rotateRight();
        System.out.println(arr);

        System.out.printf("%nMerge Array: %n");
        arr.merge(new ADT().merge(new int[]{333, 5255, 255, 525}));
        System.out.println(arr);

        System.out.printf("%nBinary Search: %n");
        if (!arr.checkSorted()) {
            arr.bubbleSort();
            System.out.println(arr);

            System.out.println(arr.binarySearch(13));
        }

    }
}