package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-19 18:39
 */
public class CommonEmployee extends Employee {

    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    protected void accept(IVisitor visitor) {
        visitor.visitCommonEmployee(this);
    }
}
