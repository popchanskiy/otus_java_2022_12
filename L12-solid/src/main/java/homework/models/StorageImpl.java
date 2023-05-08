package homework.models;

import homework.enums.*;
import homework.exceptions.*;

import java.util.*;
import java.util.concurrent.atomic.*;

public class StorageImpl implements Storage {
    private Map<Integer, BanknoteCell> banknoteCells = new TreeMap<>(Comparator.comparing(Integer::intValue,
            Comparator.reverseOrder()));

    public StorageImpl() {
        for (Banknote banknote : Banknote.values()) {
            banknoteCells.put(banknote.getNominal(), new BanknoteCellImpl(banknote));
        }
    }

    @Override
    public void putToStorage(Banknote banknote) {
        banknoteCells.get(banknote.getNominal()).addBanknoteToCell(banknote);
    }

    @Override
    public Collection<Banknote> getFromStorage(int sum) {
        Collection<Banknote> banknotes = new ArrayList<>();
        if(sum<=0){
            throw new CashingOutException("Cashing out sum should be more than zero");
        }
        if (availableToExtract(sum)) {
            for (BanknoteCell banknoteCell : banknoteCells.values()) {
                int cnt = Math.min(banknoteCell.countBanknotesAmount(), sum / banknoteCell.getBanknoteNominal());
                if (cnt == 0) continue;
                banknotes.addAll(banknoteCell.extractBanknoteFromCell(cnt));
                sum -= cnt * banknoteCell.getBanknoteNominal();
                if (sum == 0) break;
            }
        }
        return banknotes;
    }

    @Override
    public int getBalance() {
        AtomicInteger balance = new AtomicInteger();
        banknoteCells.forEach((k, v) -> balance.addAndGet(k * v.countBanknotesAmount()));
        return balance.get();
    }


    private boolean availableToExtract(int sum) {
        for (BanknoteCell banknoteCell : banknoteCells.values()) {
            int cnt = Math.min(banknoteCell.countBanknotesAmount(), sum / banknoteCell.getBanknoteNominal());
            sum -= cnt * banknoteCell.getBanknoteNominal();
            if (sum == 0) return true;
        }
        return false;
    }

}
