package be.jforce.generics.solution;

public abstract class Payment {
    private final String id;
    private final String amount;

    public Payment(String id, String amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public static abstract class Builder<P extends Payment, B extends Builder<P, B>> {
        String id;
        String amount;

        public B id(String id) {
            this.id = id;
            return self();
        }

        public B amount(String amount) {
            this.amount = amount;
            return self();
        }

        protected abstract B self();

        public abstract P build();
    }
}
