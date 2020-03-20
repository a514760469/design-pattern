package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-19 18:24
 */
public abstract class Employee {

    private String name;

    private int salary;

    private Sex sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * 允许一个访问者访问
     * @param visitor 访问者
     */
    protected abstract void accept(IVisitor visitor);

    public enum Sex {
        MALE("男"), FEMALE("女");
        private String info;

        Sex(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }
}
