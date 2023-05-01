package homework.models;

import homework.enums.*;

import java.util.*;

public interface ATM {
    public void load(Collection<Banknote> banknoteCollection);

    public Collection<Banknote> cashOut(int sum);

    public int getATMBalance();

}
