package service;

import model.Player;

import java.util.concurrent.BlockingQueue;

/**
 * <p>ChannelImp class provided implementation for Channel interface.</p>
 * These are the methods used for communicate with two different object.
 */
public class ChannelImp implements Channel {

    private static final String INIT_MESSAGE = "initiator ";
    /**
     * It is used to hold the number message sent across the object.
     */
    private volatile int numberOfMessagesSent = 0;

    protected final BlockingQueue<Player> sent;
    protected final BlockingQueue<Player> received;
    private Player send;
    private Player receiver;

    public ChannelImp(BlockingQueue<Player> sent, BlockingQueue<Player> received, Player sendPlayer, Player recPlayer) {
        this.sent = sent;
        this.received = received;
        this.send = sendPlayer;
        this.receiver = recPlayer;
    }

    /**
     * This getter is used to get the current total number of message sent for this object
     */
    public int getNumberOfMessagesSent() {
        return this.numberOfMessagesSent;
    }


    /**
     * This method is used to receive the message from the queue.
     * received queue holds the player object which is initiated by other player object.
     *
     * @return current received string from the current executing player.
     */
    @Override
    public String receive() {
        String receivedMessage;
        try {
            /** Take message from the queue if available or wait otherwise. */
            receivedMessage = received.take().getMessage();
        } catch (InterruptedException interrupted) {
            String error = String.format(
                    "Player failed to receive message on iteration [%d].", numberOfMessagesSent);
            throw new IllegalStateException(error, interrupted);
        }
        return receivedMessage;
    }

    /**
     * This method is used to send the message from current player to other consumer player.
     *
     * @param receivedMessage
     */
    @Override
    public void send(String receivedMessage) {
        String reply = receivedMessage + " " + numberOfMessagesSent;
        try {
            /** Send message if the queue is not full or wait until one message can fit. */
            receiver.setMessage(reply);
            sent.put(receiver);
            System.out.printf("Player [%s] sent message [%s].%n", this, reply);
            numberOfMessagesSent = numberOfMessagesSent + 1;

            /** slowing the console output down, and it works without below code.*/
            Thread.sleep(1000);
        } catch (InterruptedException interrupted) {
            String error = String.format(
                    "Player failed to send message [%s] on iteration [%d].", reply, numberOfMessagesSent);
            throw new IllegalStateException(error);
        }
    }

    /**
     * This method is used to send the initial message from the sender player.
     */
    @Override
    public void sendInitMessage() {
        try {
            send.setMessage(INIT_MESSAGE);
            sent.put(send);
            System.out.printf("Player sent message [%s].%n", INIT_MESSAGE);
        } catch (InterruptedException interrupted) {
            String error = String.format(
                    "Player failed to sent message [%s].", INIT_MESSAGE);
            throw new IllegalStateException(error, interrupted);
        }
    }
}
