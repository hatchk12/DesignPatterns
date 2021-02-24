public interface MachineStates {
    void addGumballs(GumballMachine machine, int count);// adds more gumballs to the machine
    void insertQuarter(GumballMachine machine); // inserts a quarter into the slot
    void removeQuarter(GumballMachine machine); // removes the quarter currently in the slot (user changed their mind)
    void turnHandle(GumballMachine machine); // consumes quarter and dispenses gumballs
}
