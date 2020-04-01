package com.gds.zan.spec;

/**
 * @author zhanglifeng
 * @since 2020-03-30 11:19
 */
public abstract class BaseUserSpecification implements IUserSpecification {

    @Override
    public IUserSpecification and(IUserSpecification userSpec) {
        return new AndSpecification(this, userSpec);
    }

    @Override
    public IUserSpecification or(IUserSpecification userSpec) {
        return new OrSpecification(this, userSpec);
    }

    @Override
    public IUserSpecification not() {
        return new NotSpecification(this);
    }
}
