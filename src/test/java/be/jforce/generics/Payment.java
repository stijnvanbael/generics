package be.jforce.generics;

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

    public static abstract class Builder {
        String id;
        String amount;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder amount(String amount) {
            this.amount = amount;
            return this;
        }
    }
}
