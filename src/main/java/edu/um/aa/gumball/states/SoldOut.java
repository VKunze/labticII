package edu.um.aa.gumball.states;

import edu.um.aa.gumball.GumBall;
import edu.um.aa.gumball.GumBallActions;

public class SoldOut implements GumBall{
	
	private final GumBallActions gumBallActions;

	public SoldOut(GumBallActions gumBallActions) {
		 this.gumBallActions = gumBallActions;
	}

	public void insertQuarter() {
		gumBallActions.displayMessage("No more balls in machine");
	}

	public void ejectQuarter() {
		// TODO Auto-generated method stub
		
	}

	public void turnCrank() {
		// TODO Auto-generated method stub
		
	}

	public void dispense() {
		// TODO Auto-generated method stub
		
	}

	
}
