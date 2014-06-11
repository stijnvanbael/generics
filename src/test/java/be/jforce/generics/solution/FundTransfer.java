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

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder extends Payment.Builder<FundTransfer, Builder> {
        private String fromAccount;
        private String toAccount;

        public Builder fromAccount(String fromAccount) {
            this.fromAccount = fromAccount;
            return this;
        }

        public Builder toAccount(String toAccount) {
            this.toAccount = toAccount;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public FundTransfer build() {
            return new FundTransfer(id, fromAccount, toAccount, amount);
        }
    }
}
