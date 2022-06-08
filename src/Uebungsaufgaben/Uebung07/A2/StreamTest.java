package Uebungsaufgaben.Uebung07.A2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream<Integer> naturals = Stream.iterate(1, i -> i+1);
        Stream<Integer> integers = Stream.iterate(0, i -> i > 0 ? -i : -i+1);
        System.out.println(filterAndSum(naturals));
        System.out.println(filterAndSum(integers));

    }

    public static Integer filterAndSum(Stream<Integer> stream) {
        return stream.filter(i -> i % 2 == 0)
                .limit(10)
                .reduce(Integer::sum)
                .orElse(0);


    }
}
