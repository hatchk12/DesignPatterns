public class NoGumQuarter implements MachineStates {

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
        System.out.println("There is already a quarter in the slot");
        machine.setMachine(this);
    }

    @Override
    public void removeQuarter(GumballMachine machine) {
        System.out.println("Quarter removed");
        machine.setMachine(new NoGumNoQuarter());
    }

    @Override
    public void turnHandle(GumballMachine machine) {
        machine.incrementQuarterCount(1);
        machine.setMachine(new NoGumNoQuarter());
        System.out.println("Accepted: you received no gumballs");
    }
}
