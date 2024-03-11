package com.taltou.yatzy;

import java.util.function.Function;

public enum Category {
    Chance(com.taltou.yatzy.Yatzy::computeChance),
    Yatzy(com.taltou.yatzy.Yatzy::computeYatzy),
    Ones(com.taltou.yatzy.Yatzy::computeOnes),
    Twos(com.taltou.yatzy.Yatzy::computeTwos),
    Threes(com.taltou.yatzy.Yatzy::computeThrees),
    Fours(com.taltou.yatzy.Yatzy::computeFours),
    Fives(com.taltou.yatzy.Yatzy::computeFives),
    Sixes(com.taltou.yatzy.Yatzy::computeSixes),
    OnePairs(com.taltou.yatzy.Yatzy::computeOnePair),
    TwoPairs(com.taltou.yatzy.Yatzy::computeTwoPair),
    ThreeOfAKind(com.taltou.yatzy.Yatzy::computeThreeOfAKind),
    FourOfAKind(com.taltou.yatzy.Yatzy::computeFourOfAKind),
    SmallStraight(com.taltou.yatzy.Yatzy::computeSmallStraight),
    LargeStraight(com.taltou.yatzy.Yatzy::computeLargeStraight),
    FullHouse(com.taltou.yatzy.Yatzy::computeFullHouse);
    private final Function<Roll, Integer> score;

    Category(Function<Roll, Integer> score) {
        this.score = score;
    }

    public int computeScore(Roll roll) {
        return this.score.apply(roll);
    }
}
