import model.Player;
import service.ChannelImp;

import java.util.concurrent.BlockingQueue;

/**
 * <p>Consumer class is responsible for waiting for the initial message from producer first player.
 * Once the message is received from the producer it updates the counter and sends the updated message.</p>
 */
public class Consumer extends ChannelImp implements Runnable {

    public Consumer(BlockingQueue<Player> sent, BlockingQueue<Player> received, Player receiverPlayer, Player senderPlayer) {
        super(sent, received, receiverPlayer, senderPlayer);
    }

    /**
     * This method is used to get the received message from the producer and pass over the updated message to producer
     * with the counter value.
     */
    @Override
    public void run() {
        while (true && getNumberOfMessagesSent() <= 10) {
            String receivedMessage = receive();
            send(receivedMessage);
        }
    }
}
