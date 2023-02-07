package creational.abstractFactory;

public class Debit implements PaymentMethod{
    @Override
    public String doPayment() {
        return "Pago a débito";
    }
}
