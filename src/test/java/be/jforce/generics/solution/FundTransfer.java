package be.jforce.generics.solution;

public class FundTransfer extends Payment {
    private final String fromAccount;
    private final String toAccount;

    public FundTransfer(String id, String fromAccount, String toAccount, String amount) {
        super(id, amount);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public static Builder<?, ?> createBuilder() {
        return new Builder();
    }

    public static class Builder<P extends FundTransfer, B extends Builder<P, B>> extends Payment.Builder<P, B> {
        String fromAccount;
        String toAccount;

        public B fromAccount(String fromAccount) {
            this.fromAccount = fromAccount;
            return self();
        }

        public B toAccount(String toAccount) {
            this.toAccount = toAccount;
            return self();
        }

        @Override
        protected FundTransfer buildInternal() {
            return new FundTransfer(id, fromAccount, toAccount, amount);
        }
    }
}
