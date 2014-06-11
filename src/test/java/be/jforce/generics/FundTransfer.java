package be.jforce.generics;

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

    public static class Builder extends Payment.Builder {
        String fromAccount;
        String toAccount;

        public Builder fromAccount(String fromAccount) {
            this.fromAccount = fromAccount;
            return this;
        }

        public Builder toAccount(String toAccount) {
            this.toAccount = toAccount;
            return this;
        }

        public FundTransfer build() {
            return new FundTransfer(id, fromAccount, toAccount, amount);
        }
    }
}
