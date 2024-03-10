package com.taltou.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    @DisplayName("Should return the sum of all the dice, regardless of what he reads.")
    public void chanceTest() {
        assertEquals(14, Yatzy.computeChance(new Roll(1,1,3,3,6)));
        assertEquals(21, Yatzy.computeChance(new Roll(4,5,5,6,1)));
        assertEquals(15, Yatzy.computeChance(new Roll(2,3,4,5,1)));
        assertEquals(16, Yatzy.computeChance(new Roll(3,3,4,5,1)));

    }
    @Test
    @DisplayName("Should return 50 points If all the dice have the same number.")
    public void yatzyTest() {
        assertEquals(50, Yatzy.computeYatzy(new Roll(1,1,1,1,1)));
        assertEquals(0, Yatzy.computeYatzy(new Roll(1,1,1,2,1)));
        assertEquals(50, Yatzy.computeYatzy(new Roll(4,4,4,4,4)));
        assertEquals(50, Yatzy.computeYatzy(new Roll(6,6,6,6,6)));
        assertEquals(0, Yatzy.computeYatzy(new Roll(6,6,6,6,3)));
    }
    @Test
    @DisplayName("Should return the sum of the dice which reads one.")
    public void OnesTest() {
        assertEquals(0, Yatzy.computeOnes(new Roll(3,3,3,4,5)));
        assertEquals(1, Yatzy.computeOnes(new Roll(1,2,3,4,5)));
        assertEquals(2, Yatzy.computeOnes(new Roll(1,2,1,4,5)));
        assertEquals(0, Yatzy.computeOnes(new Roll(6,2,2,4,5)));
        assertEquals(4, Yatzy.computeOnes(new Roll(1,2,1,1,1)));
    }
    @Test
    @DisplayName("Should return the sum of the dice which reads two.")
    public void twosTest() {
        assertEquals(4, Yatzy.computeTwos(new Roll(2,3,2,5,1)));
        assertEquals(4, Yatzy.computeTwos(new Roll(1,2,3,2,6)));
        assertEquals(10, Yatzy.computeTwos(new Roll(2,2,2,2,2)));
    }

    @Test
    @DisplayName("Should return the sum of the dice which reads three.")
    public void threesTest() {
        assertEquals(6, Yatzy.computeThrees(new Roll(1,2,3,2,3)));
        assertEquals(12, Yatzy.computeThrees(new Roll(2,3,3,3,3)));
    }

    @Test
    @DisplayName("Should return the sum of the dice which reads four.")
    public void foursTest()
    {
        assertEquals(8, Yatzy.computeFours(new Roll(1,1,2,4,4)));
        assertEquals(12, Yatzy.computeFours(new Roll(4,4,4,5,5)));
        assertEquals(8, Yatzy.computeFours(new Roll(4,4,5,5,5)));
        assertEquals(4, Yatzy.computeFours(new Roll(4,5,5,5,5)));
    }

    @Test
    @DisplayName("Should return the sum of the dice which reads five.")
    public void fivesTest() {
        assertEquals(10, Yatzy.computeFives(new Roll(4,4,4,5,5)));
        assertEquals(15, Yatzy.computeFives(new Roll(4,4,5,5,5)));
        assertEquals(20, Yatzy.computeFives(new Roll(4,5,5,5,5)));
    }

    @Test
    @DisplayName("Should return the sum of the dice which reads six.")
    public void sixesTest() {
        assertEquals(0, Yatzy.computeSixes(new Roll(4,4,4,5,5)));
        assertEquals(6, Yatzy.computeSixes(new Roll(4,4,6,5,5)));
        assertEquals(18, Yatzy.computeSixes(new Roll(6,5,6,6,5)));
    }

    @Test
    @DisplayName("Should return the sum of the two highest dice.")
    public void onePairTest() {
        assertEquals(0, Yatzy.computeOnePair(new Roll(1, 2, 3, 4, 5)));
        assertEquals(8, Yatzy.computeOnePair(new Roll(3, 3, 3, 4, 4)));
        assertEquals(12, Yatzy.computeOnePair(new Roll(1, 1, 6, 2, 6)));
        assertEquals(6, Yatzy.computeOnePair(new Roll(3, 3, 3, 4, 1)));
        assertEquals(6, Yatzy.computeOnePair(new Roll(3, 3, 3, 3, 1)));
        assertEquals(6, Yatzy.computeOnePair(new Roll(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy.computeOnePair(new Roll(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy.computeOnePair(new Roll(5, 3, 6, 6, 5)));
    }

    @Test
    @DisplayName("Should return the sum of two pairs of dice with the same number.")
    public void twoPairTest() {
        assertEquals(8, Yatzy.computeTwoPair(new Roll(1, 1, 2, 3, 3)));
        assertEquals(0, Yatzy.computeTwoPair(new Roll(1, 1, 2, 3, 4)));
        assertEquals(0, Yatzy.computeTwoPair(new Roll(3, 3, 3, 3, 1)));
        assertEquals(0, Yatzy.computeTwoPair(new Roll(3, 3, 3, 3, 1)));
        assertEquals(16, Yatzy.computeTwoPair(new Roll(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy.computeTwoPair(new Roll(3, 3, 5, 5, 5)));
    }

    @Test
    @DisplayName("Should return the sum of three dice with the same number.")
    public void threeOfAKindTest()
    {
        assertEquals(9, Yatzy.computeThreeOfAKind(new Roll(3, 3, 3, 4, 5)));
        assertEquals(0, Yatzy.computeThreeOfAKind(new Roll(3, 3, 4, 5, 6)));
        assertEquals(9, Yatzy.computeThreeOfAKind(new Roll(3, 3, 3, 3, 1)));
        assertEquals(9, Yatzy.computeThreeOfAKind(new Roll(3, 3, 3, 4, 5)));
        assertEquals(15, Yatzy.computeThreeOfAKind(new Roll(5, 3, 5, 4, 5)));
        assertEquals(9, Yatzy.computeThreeOfAKind(new Roll(3, 3, 3, 3, 5)));
        assertEquals(9, Yatzy.computeThreeOfAKind(new Roll(3, 3, 3, 3, 3)));
    }

    @Test
    @DisplayName("Should return the sum of four dice with the same number.")
    public void fourOfAKindTest() {
        assertEquals(8, Yatzy.computeFourOfAKind(new Roll(2, 2, 2, 2, 5)));
        assertEquals(0, Yatzy.computeFourOfAKind(new Roll(2, 2, 2, 5, 5)));
        assertEquals(8, Yatzy.computeFourOfAKind(new Roll(2, 2, 2, 2, 2)));
        assertEquals(12, Yatzy.computeFourOfAKind(new Roll(3, 3, 3, 3, 5)));
        assertEquals(20, Yatzy.computeFourOfAKind(new Roll(5, 5, 5, 4, 5)));
    }

    @Test
    @DisplayName("Should return the sum of all dices if the dice are on a small straight line.")
    public void smallStraightTest() {
        assertEquals(15, Yatzy.computeSmallStraight(new Roll(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy.computeSmallStraight(new Roll(2, 3, 4, 5, 1)));
        assertEquals(0, Yatzy.computeSmallStraight(new Roll(1, 2, 2, 4, 5)));
    }

    @Test
    @DisplayName("Should return the sum of all dices if the dice are on a large straight line.")
    public void largeStraightTest() {
        assertEquals(20, Yatzy.computeLargeStraight(new Roll(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy.computeLargeStraight(new Roll(2, 3, 4, 5, 6)));
        assertEquals(0, Yatzy.computeLargeStraight(new Roll(1, 2, 2, 4, 5)));
    }

    @Test
    @DisplayName("Should return the sum of all dices If the dice are two and three of a kind.")
    public void fullHouseTest() {
        assertEquals(18, Yatzy.computeFullHouse(new Roll(6, 2, 2, 2, 6)));
        assertEquals(0, Yatzy.computeFullHouse(new Roll(2, 3, 4, 5, 6)));
        assertEquals(8, Yatzy.computeFullHouse(new Roll(1, 1, 2, 2, 2)));
        assertEquals(0, Yatzy.computeFullHouse(new Roll(2, 2, 3, 3, 4)));
        assertEquals(0, Yatzy.computeFullHouse(new Roll(4, 4, 4, 4, 4)));

    }
}
