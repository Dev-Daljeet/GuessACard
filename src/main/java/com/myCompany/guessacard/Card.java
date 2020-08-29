package com.myCompany.guessacard;

/** Represents a card from 52 playing card deck.
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
public class Card {
    private Value value;
    private Suit suit;

    /** Represents the suit of card.
     */
    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    /** Represents the value of card.
     */
    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    /** Parameterized constructor to make an instance of class.
     * @param value A Value(enum) representing the value of card.
     * @param suit A Suit(enum) representing the suit of a card.
     */
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /** Gets the value of card
     * @return value A Value(enum) representing the value of card.
     */
    public Value getValue() {
        return this.value;
    }

    /** Sets the value of card.
     * @param value A Value(enum) representing the value of card.
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /** Gets the suit of a card.
     * @return A Suit(enum) representing the suit of a card.
     */
    public Suit getSuit() {
        return this.suit;
    }

    /** Sets the suit of card.
     * @param suit A Suit(enum) representing the suit of a card.
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

}
