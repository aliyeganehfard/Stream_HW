package A_1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class A_1 {
    public static void main(String[] args) {
        String[] words = {"Amir", "Hatef", "Mehran", "Mojtaba",
                "Mohammad", "Ali", "Davood", "Reza", "Mohsen"};
        List<String> wordList = Arrays.asList(words);

        Map<Integer, List<String>> group =
                wordList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        String::length
                                )
                        );

        System.out.println(group);


        for (Map.Entry<Integer, List<String>> a : group.entrySet()){
            ;
            System.out.println(a+" "+a.getValue().stream()
                    .count());
        }

        Map<Integer, Long> groupBySize =
                wordList.stream()
                        .collect(
                                Collectors.groupingBy(String::length, Collectors.counting())
                        );
        System.out.println(groupBySize);


    }
}
