package factory;

public class CoinFactory {
    private CoinFactory(){

    }
    static CoinFactory newInstance(){
        return  new CoinFactory();
    }
    public static CoinProvider getCoin(String bank){
        if (bank.equals("abc")) return new AbcCoin();
        throw new InvalidBankException("invalid bank");
    }
}
