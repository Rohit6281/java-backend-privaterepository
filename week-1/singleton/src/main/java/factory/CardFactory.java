package factory;

public  class CardFactory {
    private CardFactory (){

    }
    public  static  CardFactory newInstance(){
        return  new CardFactory();
        }

    public static CardProvider getCard(String bank){
        if(bank.equals("pqr")) return  new PqrCard();
        if(bank.equals("abc")) return  new AbcCard();
        if(bank.equals("xyz")) return  new XyzCard();
        throw new  InvalidBankException("ATM card Facility is not provided by  "+bank);


    }
}
