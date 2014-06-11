package be.jforce.generics;

public abstract class GenericFactory {

    private Object product;
    private Class<?> productType;

    public Object create(String... parameters) {
        if(product == null) {
            product = createInternal(parameters);
        }
        return product;
    }

    protected abstract Object createInternal(String... parameters);

    public Class<?> getProductType() {
        return productType;
    }
}
