package np.com.kshitij.commons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Printer {
    private Printer() {
        //no instance
    }

    public static <T> void print(T[] ts) {
        print(Arrays.asList(ts));
    }

    public static void print(int[] ts) {
        print(Arrays.stream(ts)
                .boxed()
                .collect(Collectors.toList()));
    }

    public static <T> void print(List<T> ts) {
        System.out.println(ts);
    }
}
