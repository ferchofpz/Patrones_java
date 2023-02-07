import creational.abstractFactory.AbstractFactory;
import creational.abstractFactory.Card;
import creational.abstractFactory.FactoryProvider;
import creational.abstractFactory.PaymentMethod;
import creational.factory.Payment;
import creational.factory.PaymentFactory;
import creational.factory.PaymentType;

public class Main {
    public static void main(String[] args) {
        
        // probarFactoryMethod();
        probarAbstractFactoryMethod();
    }

    private static void probarAbstractFactoryMethod() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card tarjeta = (Card) abstractFactory.create("VISA");

        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("CREDIT");

        System.out.println(tarjeta.getCardType() + " " + paymentMethod.doPayment());
    }

    private static void probarFactoryMethod(){
        Payment payment = PaymentFactory.buildPayment(PaymentType.CARD);
        payment.doPayment();
    }
}