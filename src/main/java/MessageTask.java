import model.Player;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageTask {

    /** Maximum messages stored inside the Queue. */
    private static final int MAX_MESSAGES_IN_QUEUE = 1;

    public static void main(String[] args) {

        Player sender = new Player();
        Player receiver = new Player();

        BlockingQueue<Player> firstToSecond = new ArrayBlockingQueue<Player>(MAX_MESSAGES_IN_QUEUE);
        BlockingQueue<Player> secondToFirst = new ArrayBlockingQueue<Player>(MAX_MESSAGES_IN_QUEUE);

        Producer producer = new Producer(firstToSecond, secondToFirst, sender, receiver);
        Consumer consumer = new Consumer(secondToFirst, firstToSecond, receiver, sender);

        /** Second player will wait for initialization message from the first player. */
        new Thread(consumer).start();
        new Thread(producer).start();
    }
}
