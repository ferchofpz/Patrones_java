import behavioral.chainOfResponsability.Tarjeta;
import creational.abstractFactory.AbstractFactory;
import creational.abstractFactory.Card;
import creational.abstractFactory.FactoryProvider;
import creational.abstractFactory.PaymentMethod;
import creational.factory.Payment;
import creational.factory.PaymentFactory;
import creational.factory.PaymentType;
import creational.prototype.PrototypeCard;
import creational.prototype.PrototypeFactory;

import static creational.prototype.PrototypeFactory.CardType.AMEX;
import static creational.prototype.PrototypeFactory.CardType.VISA;

public class Main {
    public static void main(String[] args) {
        
        //Creacionales
        // probarFactoryMethod();
        // probarAbstractFactoryMethod();
        // probarBuilder();
        // probarPrototype();
        // probarSingleton();
        
        //Comportamiento
        probarChainOfResponsability();
    }

    private static void probarChainOfResponsability() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.creditCardRequest(100000);
    }

    private static void probarSingleton() {
        // creational.singleton.Card card = new creational.singleton.Card();
        creational.singleton.Card.getInstance().setCardNumber("1234 4567");
        System.out.println(creational.singleton.Card.getInstance().getCardNumber());
    }

    private static void probarPrototype() {
        PrototypeFactory.loadCard();
        try{
            PrototypeCard visa = PrototypeFactory.getInstance(VISA);
            visa.getCard();

            PrototypeCard amex = PrototypeFactory.getInstance(AMEX);
            amex.getCard();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

    private static void probarBuilder(){
        creational.builder.Card card = new creational.builder.Card.CardBuilder("VISA","0000 0000 0000")
                .name("Fernando")
                .expires(2023)
                .credit(true)
                .build();

        System.out.println(card);
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