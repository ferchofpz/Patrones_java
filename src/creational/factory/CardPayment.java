package creational.factory;

public class CardPayment implements Payment{
    @Override
    public void doPayment() {
        System.out.println("Pagando con tarjeta de credito");
    }
}
