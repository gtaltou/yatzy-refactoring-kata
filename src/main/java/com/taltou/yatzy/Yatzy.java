package com.taltou.yatzy;

import java.util.Comparator;
import java.util.List;

public class Yatzy {

    public static int computeChance(Roll roll)
    {
        return roll.sumNumber();
    }


    public static int computeYatzy(Roll roll)  {
        return roll.isYatzy() ? 50: 0;
    }
    public static int computeOnes(Roll roll){
        return roll.countDie(1);
    }

    public static int computeTwos(Roll roll) {
        return roll.countDie(2) * 2;
    }

    public static int computeThrees(Roll roll) {
        return roll.countDie(3) * 3;
    }


    public static int computeFours(Roll roll)
    {
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

        return  roll.checkPairs()
                .stream()
                .max(Comparator.naturalOrder())
                .map(dice -> dice * 2)
                .orElse(0);

    }



    public static int computeTwoPair(Roll roll)
    {
        List<Integer> pairs = roll.checkPairs();
       return (pairs.size() >= 2 ? pairs.stream()
               .mapToInt(pair -> pair * 2)
               .sum() : 0);
    }


    public static int computeThreeOfAKind(Roll roll)
    {
        return roll.processKind(3) * 3;
    }

    public static int computeFourOfAKind(Roll roll)
    {
        return roll.processKind(4) * 4;
    }

      public static int computeSmallStraight(Roll roll)
    {
       return roll.isSmallStraight() ? 15 : 0;
    }

    public static int computeLargeStraight(Roll roll)
    {
        return roll.isLargeStraight() ? 20 : 0;
    }

    public static int computeFullHouse(Roll roll) {

        boolean hasThreeOFAKind = roll.processKind(3) !=0 ;
        boolean hasPair = !roll.checkPairs().isEmpty();
        boolean isYatzy = roll.isYatzy();

        return  (hasThreeOFAKind && hasPair && !isYatzy) ? roll.sumNumber() : 0;
    }
}



