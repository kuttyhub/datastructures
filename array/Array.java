import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
        // declaration of arrays;
        // int[] a = new int[2];
        // int[] a2 = { 10, 10, 20 };
        // custom array class
        // Array a3 = new Array(10);
        // a3.insert(10);
        // a3.removeAt(0);
        // a3.IndexOf(10);
        // a3.print();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(2);

        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);

        ArrayList<Integer> res = new ArrayList<>(l);
        l.removeAll(l);
        l.addAll(res);
        System.out.println(l);
    }

    private int[] array;
    private int lastIdx;

    public Array(int length) {
        array = new int[length];
        lastIdx = 0;
    }

    public void insert(int data) {
        // if array is full
        if (array.length == lastIdx) {
            int[] newArr = new int[lastIdx * 2];
            // coping old array to new array
            for (int i = 0; i < lastIdx; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[lastIdx++] = data;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= lastIdx) {
            System.out.println("index out of range");
            return;
        }
        for (int i = index; i < lastIdx; i++) {
            array[i] = array[i + 1];
        }
        lastIdx--;
    }

    public int IndexOf(int value) {
        for (int i = 0; i < lastIdx; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
