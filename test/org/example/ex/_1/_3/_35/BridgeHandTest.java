package org.example.ex._1._3._35;

import org.example.ex._1._3._14.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeHandTest {

    @Test
    void getCards() {
        final BridgeHand bridgeHand = new BridgeHand();

        final Queue<Card> cards = bridgeHand.getCards();
        final int size = cards.size();

        for (int i = 0; i < size; i++) {
            System.out.print(cards.dequeue() + " ");
        }

        System.out.println();
    }
}