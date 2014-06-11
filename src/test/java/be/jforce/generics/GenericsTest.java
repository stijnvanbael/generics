package be.jforce.generics;

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
        GenericFactory factory = new FundTransferFactory();

        // TODO: replace cast with generics
        FundTransfer transfer = (FundTransfer) factory.create("115abc", "1234-5678-9012-3456", "1000-2000-3000-4000", "EUR 15.33");
        assertThat(transfer.getFromAccount(), is("1234-5678-9012-3456"));
        assertThat(transfer.getToAccount(), is("1000-2000-3000-4000"));
        assertThat(transfer.getAmount(), is("EUR 15.33"));
    }

    @Test
    public void genericMethod() {
        PaymentRepository repository = new PaymentRepository();
        repository.addPayment(new FundTransfer("115abc", "1234-5678-9012-3456", "1000-2000-3000-4000", "EUR 15.33"));
        repository.addPayment(new GiftCardPayment("116def", "EUR 35.00", "1000345"));

        // TODO: replace casts with generics
        FundTransfer transfer = (FundTransfer) repository.findWithId("115abc");
        assertThat(transfer.getFromAccount(), is("1234-5678-9012-3456"));
        assertThat(transfer.getToAccount(), is("1000-2000-3000-4000"));
        assertThat(transfer.getAmount(), is("EUR 15.33"));
        GiftCardPayment giftCardPayment = (GiftCardPayment) repository.findWithId("116def");
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
        // TODO: use generics to avoid compiler warnings and casts
        Collections.sort(payments, Comparators.on(new Function() {
            @Override
            public Object apply(Object input) {
                return ((Payment) input).getId();
            }
        }));

        assertThat(payments.get(0), is(transfer));
        assertThat(payments.get(1), is(giftCardPayment));
    }

    @Test
    public void extendableBuilder() {
        // TODO: replace casts with generics
        FundTransfer transfer = ((FundTransfer.Builder) ((FundTransfer.Builder) FundTransfer.createBuilder()
                .id("115abc"))
                .fromAccount("1234-5678-9012-3456")
                .toAccount("1000-2000-3000-4000")
                .amount("EUR 15.33"))
                .build();

        assertThat(transfer.getFromAccount(), is("1234-5678-9012-3456"));
        assertThat(transfer.getToAccount(), is("1000-2000-3000-4000"));
        assertThat(transfer.getAmount(), is("EUR 15.33"));
    }

    @Test
    public void genericReflection() {
        GenericFactory factory = new FundTransferFactory();

        // TODO: derive product type from the generic type argument on FundTransferFactory using reflection
        assertEquals(FundTransfer.class, factory.getProductType());
    }
}
