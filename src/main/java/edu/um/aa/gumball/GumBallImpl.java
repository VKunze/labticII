package edu.um.aa.gumball;

/**
 * Implementation for GumBall
 */
public class GumBallImpl implements GumBall {

    private final GumBallActions gumBallActions;

    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = NO_QUARTER; // the current state
    int count = 0; // the amount of balls in the machine

    public GumBallImpl(GumBallActions gumBallActions, int count) {
        this.gumBallActions = gumBallActions;
        this.count = count;
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            gumBallActions.displayMessage("Quarter already in");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            gumBallActions.displayMessage("Quarter inserted");
        } else if (state == SOLD) {
            gumBallActions.displayMessage("Please wait, we're giving you a gumball");
        } else if (state == SOLD_OUT) {
            gumBallActions.displayMessage("No more balls in machine");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            state = NO_QUARTER;
            gumBallActions.displayMessage("Ejected");
        } else if (state == NO_QUARTER) {
            gumBallActions.displayMessage("No quarter to eject");
        } else if (state == SOLD) {
            gumBallActions.displayMessage("Can't claim your quarter now. Delivering gumball already");
        } else if (state == SOLD_OUT) {
            gumBallActions.displayMessage("No quarter to eject");
        }
    }

    public void turnCrank() {
        if (state == SOLD) {
            gumBallActions.displayMessage("Turning twice does not get you another gumball");
        } else if (state == NO_QUARTER) {
            gumBallActions.displayMessage("No quarter in machine.");
        } else if (state == SOLD_OUT) {
            gumBallActions.displayMessage("No more balls!");
        } else if (state == HAS_QUARTER) {
            gumBallActions.displayMessage("You turned...");
            state = SOLD;
            dispense();
        }
    }

    public void dispense() {
        if (state == SOLD) {
            gumBallActions.grantGumBall();
            count--;
            if (count == 0) {
                state = SOLD_OUT;
                gumBallActions.displayMessage("Oops no more balls!");
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            gumBallActions.displayMessage("You need to pay first.");
        } else if (state == SOLD_OUT) {
            gumBallActions.displayMessage("No gumball dispensed");
        } else if (state == HAS_QUARTER) {
            gumBallActions.displayMessage("No gumball dispensed");
        }
    }
}

