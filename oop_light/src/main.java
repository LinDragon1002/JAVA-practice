import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10)
                .forEach(System.out::println);
    }
}
