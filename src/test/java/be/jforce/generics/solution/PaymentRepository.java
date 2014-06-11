package be.jforce.generics.solution;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    private Map<String, Payment> payments = new HashMap<>();

    public <T extends Payment> T findWithId(String id, Class<T> type) {
        return type.cast(payments.get(id));
    }

    public void addPayment(Payment payment) {
        payments.put(payment.getId(), payment);
    }
}
