public class GumQuarter implements MachineStates{

    @Override
    public void addGumballs(GumballMachine machine, int count) {
        machine.incrementGumballCount(count);
        machine.setMachine(new GumNoQuarter());
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
        machine.setMachine(new GumNoQuarter());
    }

    @Override
    public void turnHandle(GumballMachine machine) {
        machine.incrementQuarterCount(1);
        machine.incrementGumballCount(-1);
        if(machine.getGumballCount() <= 1){
            machine.setMachine(new NoGumNoQuarter());
        }
        else{
            machine.setMachine(new GumNoQuarter());
        }
        System.out.println("Accepted: You received a pink gumball");
    }
}
