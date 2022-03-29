package CodingChallenges;

import java.util.Arrays;

public class SwapArray {
    public static void main(String[] args) {
        int[] myarray = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(swap(myarray, 2, 3)));
    }

    static int[] swap(int[] myarray, int indize1, int indize2) {
        int cache = myarray[indize1];
        myarray[indize1] = myarray[indize2];
        myarray[indize2] = cache;
        return myarray;
    }
}
