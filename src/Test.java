
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Test {

    public static String[] uniqueNames(String[] names1, String[] names2) {

        String[] both = Stream.concat(Arrays.stream(names1), Arrays.stream(names2))
                .toArray(String[]::new);

        Set<String> mySet = new HashSet<>(Arrays.asList(both));

        return mySet.stream().toArray(String[] ::new);
    }
}
