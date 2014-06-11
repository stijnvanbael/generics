package be.jforce.generics.solution;

public class FundTransferFactory extends GenericFactory<FundTransfer> {
    @Override
    protected FundTransfer createInternal(String... parameters) {
        return new FundTransfer(parameters[0], parameters[1], parameters[2], parameters[3]);
    }
}
