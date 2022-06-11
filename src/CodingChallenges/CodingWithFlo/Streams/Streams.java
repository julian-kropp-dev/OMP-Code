package CodingChallenges.CodingWithFlo.Streams;

import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, i -> i +1);
        filter(stream);

    }

    public static void filter(Stream<Integer> stream) {
         stream
                 .limit(10)
                 .filter(i -> i % 2 == 0)
                 //.map(Object::toString)
                 .map(k -> k += '#')
                 .forEach(System.out::println);
    }



}
