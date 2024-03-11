package com.taltou.yatzy;

import java.util.List;

public class Yatzy {

    public static int computeChance(Roll roll)
    {
        return roll.sumNumber();
    }
    public static int computeYatzy(Roll roll)
    {
        return roll.isYatzy() ? 50: 0;
    }
    public static int computeOnes(Roll roll)
    {
        return roll.countDie(1);
    }
    public static int computeTwos(Roll roll)
    {
        return roll.countDie(2) * 2;
    }
    public static int computeThrees(Roll roll)
    {
        return roll.countDie(3) * 3;
    }
    public static int computeFours(Roll roll)  {

        return roll.countDie(4) * 4;
    }
    public static int computeFives(Roll roll)
    {
        return roll.countDie(5) * 5;
    }
    public static int computeSixes(Roll roll)
    {
        return roll.countDie(6) * 6;
    }

    public static int computeOnePair(Roll roll){
        List<Integer> pairs = roll.handlePairs();
        if(pairs.isEmpty()){
            return 0;
        }else {
            return pairs.get(0) * 2;
        }

    }

    public static int computeTwoPair(Roll roll)
    {
        List<Integer> pairs = roll.handlePairs();
       return (pairs.size() >= 2 ? pairs.stream()
               .mapToInt(pair -> pair * 2)
               .sum() : 0);
    }
    public static int computeThreeOfAKind(Roll roll)
    {
        return roll.handleKind(3) * 3;
    }
    public static int computeFourOfAKind(Roll roll)
    {
        return roll.handleKind(4) * 4;
    }
    public static int computeSmallStraight(Roll roll)
    {
       return roll.isSmallStraight() ? 15 : 0;
    }
    public static int computeLargeStraight(Roll roll)
    {
        return roll.isLargeStraight() ? 20 : 0;
    }
    public static int computeFullHouse(Roll roll)
    {
        return  roll.isFullHouse() ? roll.sumNumber() : 0;
    }
}



