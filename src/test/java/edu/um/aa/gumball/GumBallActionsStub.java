package edu.um.aa.gumball;

public class GumBallActionsStub implements GumBallActions {

    private String lastMessage;

    public void displayMessage(String msg) {
        lastMessage = msg;
    }

    public void grantGumBall() {
        lastMessage = "Gumball out!";
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
