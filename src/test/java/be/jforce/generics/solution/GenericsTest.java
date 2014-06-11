package be.jforce.generics.solution;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GenericsTest {

    @Test
    public void genericClass() {
        GenericFactory<FundTransfer> factory = new FundTransferFactory();

        FundTransfer transfer = factory.create("115abc", "1234-5678-9012-3456", "1000-2000-3000-4000", "EUR 15.33");
        assertThat(transfer.getFromAccount(), is("1234-5678-9012-3456"));
        assertThat(transfer.getToAccount(), is("1000-2000-3000-4000"));
        assertThat(transfer.getAmount(), is("EUR 15.33"));
    }

    @Test
    public void genericMethod() {
        PaymentRepository repository = new PaymentRepository();
        repository.addPayment(new FundTransfer("115abc", "1234-5678-9012-3456", "1000-2000-3000-4000", "EUR 15.33"));
        repository.addPayment(new GiftCardPayment("116def", "EUR 35.00", "1000345"));

        FundTransfer transfer = repository.findWithId("115abc", FundTransfer.class);
        assertThat(transfer.getFromAccount(), is("1234-5678-9012-3456"));
        assertThat(transfer.getToAccount(), is("1000-2000-3000-4000"));
        assertThat(transfer.getAmount(), is("EUR 15.33"));
        GiftCardPayment giftCardPayment = repository.findWithId("116def", GiftCardPayment.class);
        assertThat(giftCardPayment.getGiftCard(), is("1000345"));
        assertThat(giftCardPayment.getAmount(), is("EUR 35.00"));
    }

    @Test
    public void advancedGenericMethod() {
        Payment giftCardPayment = new GiftCardPayment("116def", "EUR 35.00", "1000345");
        Payment transfer = new FundTransfer("115abc", "1234-5678-9012-3456", "1000-2000-3000-4000", "EUR 15.33");
        List<Payment> payments = Lists.newArrayList(
                giftCardPayment,
                transfer
        );
        Collections.sort(payments, Comparators.on(new Function<Payment, String>() {
            @Override
            public String apply(Payment input) {
                return input.getId();
            }
        }));

        assertThat(payments.get(0), is(transfer));
        assertThat(payments.get(1), is(giftCardPayment));
    }

    @Test
    public void extendableBuilder() {
        FundTransfer transfer = FundTransfer.createBuilder()
                .id("115abc")
                .fromAccount("1234-5678-9012-3456")
                .toAccount("1000-2000-3000-4000")
                .amount("EUR 15.33")
                .build();

        assertThat(transfer.getFromAccount(), is("1234-5678-9012-3456"));
        assertThat(transfer.getToAccount(), is("1000-2000-3000-4000"));
        assertThat(transfer.getAmount(), is("EUR 15.33"));
    }

    @Test
    public void genericReflection() {
        GenericFactory factory = new FundTransferFactory();

        assertEquals(FundTransfer.class, factory.getProductType());
    }
}
