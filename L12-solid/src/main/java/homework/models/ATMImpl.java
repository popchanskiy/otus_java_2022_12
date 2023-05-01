package homework.models;

import homework.enums.*;

import java.util.*;

public class ATMImpl implements ATM{
   private Storage storage;

   public ATMImpl(Storage storage) {
      this.storage = storage;
   }

   @Override
   public void load(Collection<Banknote> banknoteCollection) {
      banknoteCollection.forEach(banknote -> storage.putToStorage(banknote));
   }

   @Override
   public Collection<Banknote> cashOut(int sum) {
      return storage.getFromStorage(sum);
   }

   @Override
   public int getATMBalance() {
      return storage.getBalance();
   }
}
