import model.Player;
import service.ChannelImp;

import java.util.concurrent.BlockingQueue;

/**
 * <p>Producer class is a agent or trigger point for the first player process the message. One of the
 * producer thread on behalf initiate player it sends the message. Other thread wait for the message.
 * It receive updated message from the consumer and send back the update message to consumer thread.
 */
public class Producer extends ChannelImp implements Runnable {

    public Producer(BlockingQueue<Player> sent, BlockingQueue<Player> received, Player sendPlayer, Player recPlayer) {
        super(sent, received, sendPlayer, recPlayer);
    }

    /**
     * This method is override method of Runnable interface for initiating and receive message from the consumer.
     */
    @Override
    public void run() {
        sendInitMessage();
        while (true && getNumberOfMessagesSent() <= 10) {
            String receivedMessage = receive();
            send(receivedMessage);
        }
    }
}
