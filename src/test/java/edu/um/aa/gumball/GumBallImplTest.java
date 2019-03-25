package edu.um.aa.gumball;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GumBallImplTest {

    private GumBallActionsStub actionsStub = new GumBallActionsStub();

    @Test
    public void testNoQuarter() {
        GumBall machine = new GumBallImpl(actionsStub,5);
        machine.ejectQuarter();
        assertEquals("No quarter to eject",actionsStub.getLastMessage());
        machine.turnCrank();
        assertEquals("No quarter in machine.",actionsStub.getLastMessage());
        machine.insertQuarter();
        assertEquals("Quarter inserted",actionsStub.getLastMessage());
        machine.ejectQuarter();
        assertEquals("Ejected",actionsStub.getLastMessage());
        machine.insertQuarter();
        assertEquals("Quarter inserted",actionsStub.getLastMessage());
    }

    @Test
    public void testQuarter() {
        GumBall machine = new GumBallImpl(actionsStub,5);
        machine.insertQuarter();
        assertEquals("Quarter inserted",actionsStub.getLastMessage());
        machine.insertQuarter();
        assertEquals("Quarter already in",actionsStub.getLastMessage());
        machine.turnCrank();
        assertEquals("Gumball out!",actionsStub.getLastMessage());
    }

    @Test
    public void testCrank() {
        GumBall machine = new GumBallImpl(actionsStub,5);
        machine.insertQuarter();
        assertEquals("Quarter inserted",actionsStub.getLastMessage());
        machine.turnCrank();
        assertEquals("Gumball out!",actionsStub.getLastMessage());
        machine.insertQuarter();
        assertEquals("Quarter inserted",actionsStub.getLastMessage());
        machine.turnCrank();
        assertEquals("Gumball out!",actionsStub.getLastMessage());

    }

    @Test
    public void testSoldOut() {
        GumBall machine = new GumBallImpl(actionsStub,2);
        machine.insertQuarter();
        assertEquals("Quarter inserted",actionsStub.getLastMessage());
        machine.turnCrank();
        assertEquals("Gumball out!",actionsStub.getLastMessage());
        machine.insertQuarter();
        assertEquals("Quarter inserted",actionsStub.getLastMessage());
        machine.turnCrank();
        assertEquals("Oops no more balls!",actionsStub.getLastMessage());
        machine.insertQuarter();
        assertEquals("No more balls in machine",actionsStub.getLastMessage());
    }


}
