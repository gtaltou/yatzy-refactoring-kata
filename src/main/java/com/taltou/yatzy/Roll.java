package com.taltou.yatzy;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class Roll {

    private static final Collector<Integer, ?, Integer> countInt = Collectors.reducing(0, (previous, current) -> previous + 1 );

    private final List<Integer> die;


    public Roll(int d1, int d2, int d3, int d4, int d5) {
        this.die = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public Map<Integer, Integer> counts() {
        return die.stream().collect(groupingBy(identity(), countInt));
    }

    public int sumNumber(){
        return die.stream().mapToInt(Integer::intValue).sum();
    }

    public int countDie(int die){
        return counts().getOrDefault(die, 0);
    }

    public boolean isYatzy(){
        return counts()
                .values()
                .stream()
                .allMatch(count -> count == 5);
    }

    private Stream<Integer> filterCounting(int n){
        return counts().entrySet().stream()
                .filter(entry -> entry.getValue()>=n)
                .map(Map.Entry::getKey);
    }

    public List<Integer> checkPairs(){
        return filterCounting(2).collect(toList());

    }


    public int processKind(int n){
        return filterCounting(n)
                .findFirst()
                .orElse(0);
    }

    private List<Integer> sortNumber (){
        return  die.stream().sorted().collect(toList());
    }

    public boolean isSmallStraight(){
        return sortNumber().equals(Arrays.asList(1,2,3,4,5));
    }

    public boolean isLargeStraight(){
        return sortNumber().equals(Arrays.asList(2,3,4,5,6));
    }

}
