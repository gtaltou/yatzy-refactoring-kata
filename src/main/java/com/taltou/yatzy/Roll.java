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
    public Roll(int d1, int d2, int d3, int d4, int d5)
    {
        this.die = Arrays.asList(d1, d2, d3, d4, d5);
    }
    public Map<Integer, Integer> counts()
    {
        return die.stream().collect(groupingBy(identity(), countInt));
    }
    public int sumNumber()
    {
        return die.stream().mapToInt(Integer::intValue).sum();
    }
    public int countDie(int die)
    {
        return counts().getOrDefault(die, 0);
    }
    public boolean isYatzy(){
        return counts()
                .values()
                .stream()
                .allMatch(count -> count == 5);
    }
    private Stream<Integer> doFilter(int n){
        return counts().entrySet().stream()
                .filter(entry -> entry.getValue() >= n)
                .map(Map.Entry::getKey);
    }
    public List<Integer> handlePairs(){
        return doFilter(2)
                .sorted(Comparator.reverseOrder())
                .collect(toList());
    }
    public int handleKind(int n){
        return doFilter(n)
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
    public boolean isFullHouse() {

        boolean hasThreeOFAKind = handleKind(3) !=0 ;
        boolean hasPair = !handlePairs().isEmpty();
        boolean isYatzy = isYatzy();

        return  hasThreeOFAKind && hasPair && !isYatzy ;
    }

}
