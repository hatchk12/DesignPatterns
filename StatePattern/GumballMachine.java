public class GumballMachine {
    public int getGumballCount() {
        return gumballCount;
    }

    private int gumballCount;
    private int quarterCount;
    private MachineStates machineState;

    public GumballMachine() {
        machineState = new NoGumNoQuarter();
        gumballCount =0;
        quarterCount = 0;
    }

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine();
        gumballMachine.turnHandle(); // fail
        gumballMachine.addGumballs(1); //count 1
        gumballMachine.removeQuarter();
        gumballMachine.turnHandle(); // fail
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle(); // success w/ gumball
        //should be no gumballs now
        gumballMachine.insertQuarter();
        gumballMachine.turnHandle(); // success no gumballs
        gumballMachine.addGumballs(0);
        System.out.println("Overall quarters: " + gumballMachine.quarterCount); //2

    }


    public void addGumballs(int count) {
        machineState.addGumballs( this, count);
    }

    public void insertQuarter() {
        machineState.insertQuarter(this);
    }

    public void removeQuarter() {
        machineState.removeQuarter(this);
    }

    public void turnHandle() {
        machineState.turnHandle(this);
    }

    public void setMachine(MachineStates machine) {
        this.machineState = machine;
    }

    public void incrementGumballCount(int gumballCount) {
        this.gumballCount += gumballCount;
    }

    public void incrementQuarterCount(int quarterCount) {
        this.quarterCount += quarterCount;
    }
}
