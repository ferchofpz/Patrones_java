package creational.factory;

public class PaymentFactory {
    public static Payment buildPayment (PaymentType paymentType){
        switch (paymentType){
            case GOOGLEPAY:
                return new GooglePayment();
            case CARD:
            default:
                return new CardPayment();
        }
    }
}
