package be.jforce.generics;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    private Map<String, Payment> payments = new HashMap<>();

    public Payment findWithId(String id) {
        return payments.get(id);
    }

    public void addPayment(Payment payment) {
        payments.put(payment.getId(), payment);
    }
}
