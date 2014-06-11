package be.jforce.generics.solution;

import java.lang.reflect.ParameterizedType;

public abstract class GenericFactory<T> {

    private T product;
    private Class<T> productType;

    @SuppressWarnings("unchecked")
    public GenericFactory() {
        productType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T create(String... parameters) {
        if(product == null) {
            product = createInternal(parameters);
        }
        return product;
    }

    protected abstract T createInternal(String... parameters);

    public Class<T> getProductType() {
        return productType;
    }
}
