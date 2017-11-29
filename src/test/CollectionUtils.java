package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

    public static List<Integer> map(List<Integer> input, Function<Integer, Integer> processor) {
        List<Integer> result = new ArrayList<>();
        input.forEach(v->result.add(processor.apply(v)));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3);
        List<Integer> doubled = map(input, i -> i*2);

    }
}
