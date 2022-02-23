package A_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A_1 {
    public static void main(String[] args) {
        String[] words = {"Amir", "Hatef", "Mehran", "Mojtaba",
                "Mohammad", "Ali" ,"Davood", "Reza", "Mohsen"};
        List<String> wordList = Arrays.asList(words);

        Map<Integer,List<String>> group =
                wordList.stream()
                        .collect(
                          Collectors.groupingBy(
                                  String::length
                          )
                        );
        System.out.println(group);

        Map<String,Long> groupBySize =
                wordList.stream()
                        .collect(
                                Collectors.groupingBy(Function.identity(), Collectors.counting())
                        );
        System.out.println(groupBySize);


    }
}
