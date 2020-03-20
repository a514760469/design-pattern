package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-19 18:40
 */
public class ManagerEmployee extends Employee {

    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    protected void accept(IVisitor visitor) {
        visitor.visitManager(this);
    }
}
