package com.gds.decorator.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 11:30
 */
public abstract class Decorator implements SchoolReport {


    private SchoolReport schoolReport;

    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    @Override
    public void report() {
        schoolReport.report();
    }

    @Override
    public void sign(String name) {
        schoolReport.sign(name);
    }
}
