package be.jforce.generics.solution;

public class ElectronicFundTransfer extends FundTransfer {

    private final String terminalId;

    public ElectronicFundTransfer(String id, String fromAccount, String toAccount, String amount, String terminalId) {
        super(id, fromAccount, toAccount, amount);
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder extends FundTransfer.Builder<ElectronicFundTransfer, Builder> {
        String terminalId;

        public Builder terminalId(String terminalId) {
            this.terminalId = terminalId;
            return self();
        }

        @Override
        protected ElectronicFundTransfer buildInternal() {
            return new ElectronicFundTransfer(id, fromAccount, toAccount, amount, terminalId);
        }
    }
}
