package com.taltou.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.taltou.yatzy.Category.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    @DisplayName("Should return the sum of all the dice, regardless of what he reads.")
    public void chanceTest() {
        assertEquals(14, Chance.computeScore(new Roll(1,1,3,3,6)));
        assertEquals(21, Chance.computeScore(new Roll(4,5,5,6,1)));
        assertEquals(15, Chance.computeScore(new Roll(2,3,4,5,1)));
        assertEquals(16, Chance.computeScore(new Roll(3,3,4,5,1)));

    }
    @Test
    @DisplayName("Should return 50 points If all the dice have the same number.")
    public void yatzyTest() {
        assertEquals(50, Yatzy.computeScore(new Roll(1,1,1,1,1)));
        assertEquals(0, Yatzy.computeScore(new Roll(1,1,1,2,1)));
        assertEquals(50, Yatzy.computeScore(new Roll(4,4,4,4,4)));
        assertEquals(50, Yatzy.computeScore(new Roll(6,6,6,6,6)));
        assertEquals(0, Yatzy.computeScore(new Roll(6,6,6,6,3)));
    }
    @Test
    @DisplayName("Should return the sum of the dice which reads one.")
    public void OnesTest() {
        assertEquals(0, Ones.computeScore(new Roll(3,3,3,4,5)));
        assertEquals(1, Ones.computeScore(new Roll(1,2,3,4,5)));
        assertEquals(2, Ones.computeScore(new Roll(1,2,1,4,5)));
        assertEquals(0, Ones.computeScore(new Roll(6,2,2,4,5)));
        assertEquals(4, Ones.computeScore(new Roll(1,2,1,1,1)));
    }
    @Test
    @DisplayName("Should return the sum of the dice which reads two.")
    public void twosTest() {
        assertEquals(4, Twos.computeScore(new Roll(2,3,2,5,1)));
        assertEquals(4, Twos.computeScore(new Roll(1,2,3,2,6)));
        assertEquals(10, Twos.computeScore(new Roll(2,2,2,2,2)));
    }

    @Test
    @DisplayName("Should return the sum of the dice which reads three.")
    public void threesTest() {
        assertEquals(6, Threes.computeScore(new Roll(1,2,3,2,3)));
        assertEquals(12, Threes.computeScore(new Roll(2,3,3,3,3)));
    }

    @Test
    @DisplayName("Should return the sum of the dice which reads four.")
    public void foursTest()
    {
        assertEquals(8, Fours.computeScore(new Roll(1,1,2,4,4)));
        assertEquals(12, Fours.computeScore(new Roll(4,4,4,5,5)));
        assertEquals(8, Fours.computeScore(new Roll(4,4,5,5,5)));
        assertEquals(4, Fours.computeScore(new Roll(4,5,5,5,5)));
    }

    @Test
    @DisplayName("Should return the sum of the dice which reads five.")
    public void fivesTest() {
        assertEquals(10, Fives.computeScore(new Roll(4,4,4,5,5)));
        assertEquals(15, Fives.computeScore(new Roll(4,4,5,5,5)));
        assertEquals(20, Fives.computeScore(new Roll(4,5,5,5,5)));
    }

    @Test
    @DisplayName("Should return the sum of the dice which reads six.")
    public void sixesTest() {
        assertEquals(0, Sixes.computeScore(new Roll(4,4,4,5,5)));
        assertEquals(6, Sixes.computeScore(new Roll(4,4,6,5,5)));
        assertEquals(18, Sixes.computeScore(new Roll(6,5,6,6,5)));
    }

    @Test
    @DisplayName("Should return the sum of the two highest dice.")
    public void onePairTest() {
        assertEquals(0, OnePairs.computeScore(new Roll(1, 2, 3, 4, 5)));
        assertEquals(8, OnePairs.computeScore(new Roll(3, 3, 3, 4, 4)));
        assertEquals(12, OnePairs.computeScore(new Roll(1, 1, 6, 2, 6)));
        assertEquals(6, OnePairs.computeScore(new Roll(3, 3, 3, 4, 1)));
        assertEquals(6, OnePairs.computeScore(new Roll(3, 3, 3, 3, 1)));
        assertEquals(6, OnePairs.computeScore(new Roll(3, 4, 3, 5, 6)));
        assertEquals(10, OnePairs.computeScore(new Roll(5, 3, 3, 3, 5)));
        assertEquals(12, OnePairs.computeScore(new Roll(5, 3, 6, 6, 5)));
    }

    @Test
    @DisplayName("Should return the sum of two pairs of dice with the same number.")
    public void twoPairTest() {
        assertEquals(8, TwoPairs.computeScore(new Roll(1, 1, 2, 3, 3)));
        assertEquals(0, TwoPairs.computeScore(new Roll(1, 1, 2, 3, 4)));
        assertEquals(0, TwoPairs.computeScore(new Roll(3, 3, 3, 3, 1)));
        assertEquals(0, TwoPairs.computeScore(new Roll(3, 3, 3, 3, 1)));
        assertEquals(16, TwoPairs.computeScore(new Roll(3, 3, 5, 4, 5)));
        assertEquals(16, TwoPairs.computeScore(new Roll(3, 3, 5, 5, 5)));
    }

    @Test
    @DisplayName("Should return the sum of three dice with the same number.")
    public void threeOfAKindTest()
    {
        assertEquals(9, ThreeOfAKind.computeScore(new Roll(3, 3, 3, 4, 5)));
        assertEquals(0, ThreeOfAKind.computeScore(new Roll(3, 3, 4, 5, 6)));
        assertEquals(9, ThreeOfAKind.computeScore(new Roll(3, 3, 3, 3, 1)));
        assertEquals(9, ThreeOfAKind.computeScore(new Roll(3, 3, 3, 4, 5)));
        assertEquals(15, ThreeOfAKind.computeScore(new Roll(5, 3, 5, 4, 5)));
        assertEquals(9, ThreeOfAKind.computeScore(new Roll(3, 3, 3, 3, 5)));
        assertEquals(9, ThreeOfAKind.computeScore(new Roll(3, 3, 3, 3, 3)));
    }

    @Test
    @DisplayName("Should return the sum of four dice with the same number.")
    public void fourOfAKindTest() {
        assertEquals(8, FourOfAKind.computeScore(new Roll(2, 2, 2, 2, 5)));
        assertEquals(0, FourOfAKind.computeScore(new Roll(2, 2, 2, 5, 5)));
        assertEquals(8, FourOfAKind.computeScore(new Roll(2, 2, 2, 2, 2)));
        assertEquals(12, FourOfAKind.computeScore(new Roll(3, 3, 3, 3, 5)));
        assertEquals(20, FourOfAKind.computeScore(new Roll(5, 5, 5, 4, 5)));
    }

    @Test
    @DisplayName("Should return the sum of all dices if the dice are on a small straight line.")
    public void smallStraightTest() {
        assertEquals(15, SmallStraight.computeScore(new Roll(1, 2, 3, 4, 5)));
        assertEquals(15, SmallStraight.computeScore(new Roll(2, 3, 4, 5, 1)));
        assertEquals(0, SmallStraight.computeScore(new Roll(1, 2, 2, 4, 5)));
    }

    @Test
    @DisplayName("Should return the sum of all dices if the dice are on a large straight line.")
    public void largeStraightTest() {
        assertEquals(20, LargeStraight.computeScore(new Roll(6, 2, 3, 4, 5)));
        assertEquals(20, LargeStraight.computeScore(new Roll(2, 3, 4, 5, 6)));
        assertEquals(0, LargeStraight.computeScore(new Roll(1, 2, 2, 4, 5)));
    }

    @Test
    @DisplayName("Should return the sum of all dices If the dice are two and three of a kind.")
    public void fullHouseTest() {
        assertEquals(18, FullHouse.computeScore(new Roll(6, 2, 2, 2, 6)));
        assertEquals(0, FullHouse.computeScore(new Roll(2, 3, 4, 5, 6)));
        assertEquals(8, FullHouse.computeScore(new Roll(1, 1, 2, 2, 2)));
        assertEquals(0, FullHouse.computeScore(new Roll(2, 2, 3, 3, 4)));
        assertEquals(0, FullHouse.computeScore(new Roll(4, 4, 4, 4, 4)));

    }
}
