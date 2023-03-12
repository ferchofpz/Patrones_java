package behavioral.chainOfResponsability;

public class Black implements ApproveLoanChain{
    private ApproveLoanChain next;
    @Override
    public void setNext(ApproveLoanChain loan) {
        next = loan;
    }

    @Override
    public ApproveLoanChain getNext() {
        return next;
    }

    @Override
    public void creditCardRequest(int totalLoan) {
        if(totalLoan > 50000){
            System.out.println("Esta solicitud de TC la maneja la tarjeta Black");
        } else {
            next.creditCardRequest(totalLoan);
        }
    }
}
