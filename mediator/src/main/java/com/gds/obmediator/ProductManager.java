package com.gds.obmediator;

import com.gds.obmediator.ob.ProductEvent;
import com.gds.obmediator.ob.ProductEventType;

/**
 * @author zhanglifeng
 * @since 2020-03-25 17:45
 */
public class ProductManager {

    private boolean createProduct = false;

    /**
     * 单来源调用, 只有createProduct = true 才可以创建产品。
     * @param name
     * @return
     */
    public Product createProduct(String name) {
        createProduct = true;
        Product product = new Product(this, name);
        // 产生一个创建事件
        new ProductEvent(product, ProductEventType.NEW_PRODUCT);
        return product;
    }

    /**
     * 废弃一个产品，例如删除数据库记录
     */
    public void abandonProduct(Product p) {
        // 产生删除事件
        new ProductEvent(p, ProductEventType.DEL_PRODUCT);
    }

    public void editProduct(Product p, String name) {
        p.setName(name);
        // 产生修改事件
        new ProductEvent(p, ProductEventType.EDIT_PRODUCT);
    }

    /**
     * 获取是否可以创建参数
     */
    public boolean isCreateProduct() {
        return createProduct;
    }

    public void setCreateProduct(boolean createProduct) {
        this.createProduct = createProduct;
    }


    public Product clone(Product p) throws CloneNotSupportedException {
        // 产生克隆事件
        new ProductEvent(p, ProductEventType.CLONE_PRODUCT);
        return p.clone();
    }
}
