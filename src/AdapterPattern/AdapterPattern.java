package AdapterPattern;

/**
 * Adapter pattern is a coping mechanism where 2 different interface used into single class to communicate with each other.
 *
 * Consider a case interface 1 wants to communicate with interface 2 but there methods different, so we create special class (Adapter) where both gets together to communicate.
 * This pattern may programmatically or structurily look similar to Strategy, but pattern is based on intent not code/structure.
 *
 * Adapter = coping mechanism
 * Strategy = choice mechanism
 */

interface Payment{
    void pay(int amount);
}

//3rd party payments
class ThirdPartyPayment{
    void makePayment(int amount){
        System.out.println("payment made "+ amount);
    }
}

//Adapter
class PaymentAdapter implements Payment{
    ThirdPartyPayment thirdPartyPayment;

    PaymentAdapter(ThirdPartyPayment thirdPartyPayment){
        this.thirdPartyPayment = thirdPartyPayment;
    }

    public void pay(int amount){
        thirdPartyPayment.makePayment(amount);
    }
}

//Unchanged code
class Client{
    Payment payment;

    Client(Payment payment){
        this.payment = payment;
    }

    public void payAdapter(int amount){
        payment.pay(amount);
    }
}

public class AdapterPattern {
    public static void main(String[] args){
        ThirdPartyPayment thdPay = new ThirdPartyPayment();
        Payment payment = new PaymentAdapter(thdPay);
        Client client = new Client(payment);
        client.payAdapter(100);
    }
}
