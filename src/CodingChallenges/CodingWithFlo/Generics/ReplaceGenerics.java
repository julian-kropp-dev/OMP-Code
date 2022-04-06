package CodingChallenges.CodingWithFlo.Generics;
import java.util.Arrays;

public class ReplaceGenerics<T> {
    public ReplaceGenerics() {
    }

    T[] replace(T[] a, T s1, T s2) {
        if (a.length == 0) {
            System.out.println("Leeres Array als Input. Richtig?");
        } else {
            for (int i = 0; i < a.length; i++) {
                if (s1.equals(a[i])) {
                    a[i] = s2;
                }
            }
        }
       return a;
    }
}
class Main {
    public static void main(String[] args) {
        Integer[] myArray1 = new Integer[] {1, 2, 3, 4};
        String[] myArray2 = new String[] {"a", "b", "c"};

        ReplaceGenerics<Integer> test = new ReplaceGenerics<>();
        ReplaceGenerics<String> test2 = new ReplaceGenerics<>();

        System.out.println(Arrays.toString(test.replace(myArray1, 2, 9)));
        System.out.println(Arrays.toString(test2.replace(myArray2, "a", "y")));



    }
}
