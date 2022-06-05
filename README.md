The requirements are as follows:

Given a Player class - an instance of which can communicate with other Players.

The requirements are as follows:

1. create 2 Player instances
2. one of the players should send a message to second player (let's call this player "initiator")
3. when a player receives a message, it should reply with a message that contains the received message concatenated with the value of a counter holding the number of messages this player already sent.
4. finalize the program (gracefully) after the initiator sent 10 messages and received back 10 messages (stop condition)
5. both players should run in the same java process (strong requirement)
6. document for every class the responsibilities it has.
7. additional challenge (nice to have) opposite to 5: have every player in a separate JAVA process.

Please use core Java as much as possible without additional frameworks like Spring etc; focus on design and not on the technology.
Please include a maven project with the source code to build the jar and a shell script to start the program.
Everything not specified is to be decided by you; everything specified is a hard requirement.

You should send your source code as an archive attached to the e-mail; inline links for downloading will be ignored.

Getting start
1. Compile the application

   mvn clean install -DskipTests

2. Start the Application

   java -cp target/Players-1.0-SNAPSHOT.jar MessageTask

3. Outputs

bash start.sh

Player sent message [initiator ].
Player [Producer@6dd581b] sent message [initiator  0 0].
Player [Consumer@4f531afa] sent message [initiator  0].
Player [Consumer@4f531afa] sent message [initiator  0 0 1].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2 2 3].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2 3 3].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2 2 3 3 4].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2 3 3 4 4].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6 7].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9].
Player [Consumer@4f531afa] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10].
Player [Producer@6dd581b] sent message [initiator  0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10].