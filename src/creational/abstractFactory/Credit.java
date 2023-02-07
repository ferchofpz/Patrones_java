package creational.abstractFactory;

public class Credit implements PaymentMethod{
    @Override
    public String doPayment() {
        return "Pago a crédito";
    }
}
