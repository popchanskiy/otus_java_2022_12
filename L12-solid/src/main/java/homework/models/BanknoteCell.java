package homework.models;

import homework.enums.*;

import java.util.*;

public interface BanknoteCell {

    int getBanknoteNominal();

    void addBanknoteToCell(Banknote banknote);

    Collection<Banknote> extractBanknoteFromCell(int count);

    int countBanknotesAmount();
}
