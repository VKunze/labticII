package edu.um.aa.gumball.states;

import edu.um.aa.gumball.GumBall;
import edu.um.aa.gumball.GumBallActions;

public class HasQuarter implements GumBall{

	 private final GumBallActions gumBallActions;

	public HasQuarter(GumBallActions gumBallActions) {
		 this.gumBallActions = gumBallActions;
	}
	
	public void insertQuarter() {
		gumBallActions.displayMessage("Quarter already in");
	}

	

	public void ejectQuarter() {
		 state = NO_QUARTER;
         gumBallActions.displayMessage("Ejected");
	}

	public void turnCrank() {
		gumBallActions.displayMessage("You turned...");
        state = SOLD;
        dispense();
	}

	public void dispense() {
		gumBallActions.displayMessage("No gumball dispensed");
	}

}
