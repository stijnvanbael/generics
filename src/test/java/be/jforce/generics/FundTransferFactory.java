package be.jforce.generics;

public class FundTransferFactory extends GenericFactory {
    @Override
    protected Object createInternal(String... parameters) {
        return new FundTransfer(parameters[0], parameters[1], parameters[2], parameters[3]);
    }
}
