package be.jforce.generics;

public class ElectronicFundTransfer extends FundTransfer {

    private final String terminalId;

    public ElectronicFundTransfer(String id, String fromAccount, String toAccount, String amount, String terminalId) {
        super(id, fromAccount, toAccount, amount);
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public static class Builder extends FundTransfer.Builder {
        String terminalId;

        public Builder terminalId(String terminalId) {
            this.terminalId = terminalId;
            return this;
        }

        public ElectronicFundTransfer build() {
            return new ElectronicFundTransfer(id, fromAccount, toAccount, amount, terminalId);
        }
    }
}
