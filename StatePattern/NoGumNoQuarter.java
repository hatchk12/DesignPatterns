public class NoGumNoQuarter implements MachineStates {

    @Override
    public void addGumballs(GumballMachine machine, int count) {
        machine.incrementGumballCount(count);
        if(count > 0){
            machine.setMachine(new GumNoQuarter());
        }
        else{
            machine.setMachine(this);
        }
        System.out.println("There are " + machine.getGumballCount() + " gumballs in the machine");
    }

    @Override
    public void insertQuarter(GumballMachine machine) {
        System.out.println("Quarter now waiting for action");
        machine.setMachine(new NoGumQuarter());
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
