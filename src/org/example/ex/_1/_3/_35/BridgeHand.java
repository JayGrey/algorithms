package org.example.ex._1._3._35;

import org.example.ex._1._3._14.Queue;

public class BridgeHand {
    private final RandomQueue<Card> deck = new RandomQueue<>();

    public BridgeHand() {
        for(Card.Suit suit : Card.Suit.values()) {
            for(Card.Rank rank : Card.Rank.values()) {
                deck.enqueue(new Card(rank, suit));
            }
        }
    }

    public Queue<Card> getCards() {
        final ResizingArrayQueue<Card> queue = new ResizingArrayQueue<>();

        final int to = Math.min(13, deck.size());

        for (int i = 0; i < to; i++) {
            queue.enqueue(deck.dequeue());
        }

        return queue;
    }
}
