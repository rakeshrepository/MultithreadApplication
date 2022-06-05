package service;

/**
 * <p>Channel Interface have method declarations for communicating message with two objects.</p>
 * The pure abstraction achieved with Channel Interface and these methods are used to pass the
 * message around the different object.
 */
public interface Channel {
    String receive();

    void send(String msg);

    void sendInitMessage();
}
