package Uebungsaufgaben.Uebung07;

public class LambdaTest {
    public static void main(String[] args) {
        Function<Double, Double> id = (value) -> value;
        System.out.println(id.calculate(5.0)); // 5.0

        Function<Double, Double> inverse = (value) -> value * -1;
        System.out.println(inverse.calculate(5.0)); // -5.0
        System.out.println(inverse.calculate(-9.3)); // 9.3

        Function<Double, Double> timesTen = (value) -> value * 10;
        System.out.println(timesTen.calculate(10.0)); //100
        System.out.println(timesTen.calculate(-8.5)); //-85

        Function<Double, Double> divideByPi = (value) -> value / Math.PI;
        System.out.println(divideByPi.calculate(3.141592)); // ca. 1 ;)
        System.out.println(divideByPi.calculate(-92.3));// ca. -29 ;)

        Function<Double, Long> doubleLong = Math::round;
        System.out.println(doubleLong.calculate(3.41)); //3

        @SuppressWarnings("unchecked")
        Function<Double, Double> chain = makeChain(new Function[]{ inverse, id, timesTen, divideByPi });

        System.out.println(doubleLong.calculate(chain.calculate(5.5))); //18
    }

    private static Function<Double, Double> makeChain(final Function<Double, Double>[] funs) {
        return (x) -> {
            for (Function<Double, Double> f : funs) {
                x = f.calculate(x);
            }
            return x;
        };
    }

}


interface Function<T extends Number, G extends Number> {
    abstract G calculate(T number);
}

