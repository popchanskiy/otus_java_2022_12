import homework.enums.*;
import homework.exceptions.*;
import homework.models.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ATMTests {
    private ATM atm;
    private List<Banknote> banknotes = List.of(Banknote.TEN,
            Banknote.TWENTY_FIVE,
            Banknote.TEN,
            Banknote.TWENTY_FIVE,
            Banknote.FIFTY,
            Banknote.ONE_HUNDRED,
            Banknote.TWENTY_FIVE,
            Banknote.TEN,
            Banknote.ONE_HUNDRED,
            Banknote.FIFTY,
            Banknote.TEN,
            Banknote.FIVE,
            Banknote.TEN,
            Banknote.FIVE);
    Storage storage = new StorageImpl();

    @BeforeEach
    void setUp() {
        atm = new ATMImpl(storage);
        Collection<Banknote> banknotes = new ArrayList<>();
        atm.load(banknotes);
    }

    @DisplayName("Проверка баланса после загрузки банкнот")
    @Test
    void checkBalanceAfterLoading() {
        List<Banknote> banknotesToLoad = List.of(Banknote.FIVE, Banknote.ONE_HUNDRED);
        atm.load(banknotesToLoad);
        assertEquals(105, atm.getATMBalance());
    }

    @DisplayName("Получение наличности меньше максимальной суммы, находящейся в банкомвте")
    @Test
    void checkExtractingIntermediateSum() {
        List<Banknote> banknotesToLoad = List.of(Banknote.ONE_HUNDRED, Banknote.ONE_HUNDRED,Banknote.FIFTY,
                Banknote.FIFTY,Banknote.TEN);
        atm.load(banknotesToLoad);
        Collection<Banknote> banknotes = atm.cashOut(200);
        int cashedOutSum = banknotes.stream().mapToInt(Banknote::getNominal).sum();
        int remainingBalance = atm.getATMBalance();
        boolean matchNominal = banknotes.stream().allMatch(banknote -> banknote.getNominal() == 100);
        assertEquals(200,cashedOutSum);
        assertEquals(110,remainingBalance);
        assertEquals(true,matchNominal);
    }

    @DisplayName("Получение неположительной суммы")
    @Test
    void checkExtractingNegativeSum() {
        List<Banknote> banknotesToLoad = List.of(Banknote.ONE_HUNDRED, Banknote.ONE_HUNDRED);
        atm.load(banknotesToLoad);
        assertThrows(CashingOutException.class,()->atm.cashOut(0));
        assertThrows(CashingOutException.class,()->atm.cashOut(-1));
    }

    @DisplayName("Получение суммы большей чем на балансе банкомата")
    @Test
    void checkExtractingMoreThanMaxSum() {
        List<Banknote> banknotesToLoad = List.of(Banknote.ONE_HUNDRED, Banknote.ONE_HUNDRED);
        atm.load(banknotesToLoad);
        Collection<Banknote> banknotes = atm.cashOut(201);
        assertEquals(0,banknotes.size());
        assertEquals(200,atm.getATMBalance());
    }

}

