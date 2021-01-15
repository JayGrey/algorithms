package org.example.ex._1._3._35;

import java.util.StringJoiner;

public final class Card {
    public final Rank rank;
    public final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getUnicode() {
        switch (suit) {
            case SPADES: {
                switch (rank) {
                    case ACE:
                        return 0x1F0A1;
                    case TWO:
                        return 0x1F0A2;
                    case THREE:
                        return 0x1F0A3;
                    case FOUR:
                        return 0x1F0A4;
                    case FIVE:
                        return 0x1F0A5;
                    case SIX:
                        return 0x1F0A6;
                    case SEVEN:
                        return 0x1F0A7;
                    case EIGHT:
                        return 0x1F0A8;
                    case NINE:
                        return 0x1F0A9;
                    case TEN:
                        return 0x1F0AA;
                    case JACK:
                        return 0x1F0AB;
                    case QUEEN:
                        return 0x1F0AD;
                    case KING:
                        return 0x1F0AE;
                }
            }
            case HEARTS: {
                switch (rank) {
                    case ACE:
                        return 0x1F0B1;
                    case TWO:
                        return 0x1F0B2;
                    case THREE:
                        return 0x1F0B3;
                    case FOUR:
                        return 0x1F0B4;
                    case FIVE:
                        return 0x1F0B5;
                    case SIX:
                        return 0x1F0B6;
                    case SEVEN:
                        return 0x1F0B7;
                    case EIGHT:
                        return 0x1F0B8;
                    case NINE:
                        return 0x1F0B9;
                    case TEN:
                        return 0x1F0BA;
                    case JACK:
                        return 0x1F0BB;
                    case QUEEN:
                        return 0x1F0BD;
                    case KING:
                        return 0x1F0BE;
                }
            }
            case DIAMONDS: {
                switch (rank) {
                    case ACE:
                        return 0x1F0C1;
                    case TWO:
                        return 0x1F0C2;
                    case THREE:
                        return 0x1F0C3;
                    case FOUR:
                        return 0x1F0C4;
                    case FIVE:
                        return 0x1F0C5;
                    case SIX:
                        return 0x1F0C6;
                    case SEVEN:
                        return 0x1F0C7;
                    case EIGHT:
                        return 0x1F0C8;
                    case NINE:
                        return 0x1F0C9;
                    case TEN:
                        return 0x1F0CA;
                    case JACK:
                        return 0x1F0CB;
                    case QUEEN:
                        return 0x1F0CD;
                    case KING:
                        return 0x1F0CE;
                }
            }

            case CLUBS: {
                switch (rank) {
                    case ACE:
                        return 0x1F0D1;
                    case TWO:
                        return 0x1F0D2;
                    case THREE:
                        return 0x1F0D3;
                    case FOUR:
                        return 0x1F0D4;
                    case FIVE:
                        return 0x1F0D5;
                    case SIX:
                        return 0x1F0D6;
                    case SEVEN:
                        return 0x1F0D7;
                    case EIGHT:
                        return 0x1F0D8;
                    case NINE:
                        return 0x1F0D9;
                    case TEN:
                        return 0x1F0DA;
                    case JACK:
                        return 0x1F0DB;
                    case QUEEN:
                        return 0x1F0DD;
                    case KING:
                        return 0x1F0DE;
                }
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.format("%c", getUnicode());
    }

    public enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS}

    public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}
}
