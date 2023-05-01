package homework.models;

import homework.enums.*;

import java.util.*;

public class BanknoteCellImpl implements BanknoteCell {
    private Banknote banknote;
    List<Banknote> banknotes = new ArrayList<>();

    public BanknoteCellImpl(Banknote banknote) {
        this.banknote = banknote;
    }

    @Override
    public int getBanknoteNominal() {
        return banknote.getNominal();
    }

    @Override
    public void addBanknoteToCell(Banknote banknote) {
        if(banknote.getNominal()!=banknote.getNominal()){
            throw new IllegalArgumentException("Mismatched banknote nominal");
        }
        banknotes.add(banknote);
    }

    @Override
    public Collection<Banknote> extractBanknoteFromCell(int count) {
        if (count <= 0 || count > banknotes.size()) throw new IllegalArgumentException("Incorrect count of banknotes");
        Collection<Banknote> extracted = new ArrayList<>();
        while (count > 0) {
            extracted.add(banknotes.remove(banknotes.size()-1));
            count--;
        }
        return extracted;
    }

    @Override
    public int countBanknotesAmount() {
        return banknotes.size();
    }
}
