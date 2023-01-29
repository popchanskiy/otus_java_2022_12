import com.google.common.collect.*;

import java.util.*;

public class App {
    public static void main(String... args) {
        List<Integer> example = new ArrayList<>();
        int min = 0;
        int max = 100;
        for (int i = min; i < max; i++) {
            example.add(i);
        }
        System.out.println(Lists.reverse(example));
    }
}
