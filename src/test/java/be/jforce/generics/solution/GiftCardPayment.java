package be.jforce.generics.solution;

public class GiftCardPayment extends Payment {
    private final String giftCard;

    public GiftCardPayment(String id, String amount, String giftCard) {
        super(id, amount);
        this.giftCard = giftCard;
    }

    public String getGiftCard() {
        return giftCard;
    }
}
