public class GumNoQuarter implements MachineStates {

    @Override
    public void addGumballs(GumballMachine machine, int count) {
        machine.incrementGumballCount(count);
        machine.setMachine(new GumNoQuarter());
        System.out.println("There are " + machine.getGumballCount() + " gumballs in the machine");
    }

    @Override
    public void insertQuarter(GumballMachine machine) {
        System.out.println("Quarter now waiting for action");
        machine.setMachine(new GumQuarter());
    }

    @Override
    public void removeQuarter(GumballMachine machine) {
        System.out.println("There is no quarter to remove");
        machine.setMachine(this);
    }

    @Override
    public void turnHandle(GumballMachine machine) {
        System.out.println("You must insert a quarter first");
        machine.setMachine(this);


    }
}
