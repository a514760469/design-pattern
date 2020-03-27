package com.gds.obmediator;

/**
 * @author zhanglifeng
 * @since 2020-03-25 17:43
 */
public class Product implements Cloneable {

    private String name;

    private boolean canChange = false;

    public Product(ProductManager manager, String name) {
        if (manager.isCreateProduct()) {
            this.canChange = true;
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (canChange) {
            this.name = name;
        }
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
}
