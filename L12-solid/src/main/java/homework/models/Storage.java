package homework.models;

import homework.enums.*;

import java.util.*;

public interface Storage {
public void putToStorage(Banknote banknote);

public Collection<Banknote> getFromStorage(int sum);

public int getBalance();

}
