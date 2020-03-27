package com.gds.specification.selector;

import java.util.Arrays;
import java.util.List;

/**
 * 连接选择器
 * @author zhanglifeng
 * @since 2020-03-27 10:43
 */
public class ConjunctionSelector<T> extends AbstractSelector<T> {


    private List<AbstractSelector<T>> leafComponents;

    @SafeVarargs
    ConjunctionSelector(AbstractSelector<T>... leafComponents) {
        this.leafComponents = Arrays.asList(leafComponents);
    }

    /***
     * 测试是否所有选择器都能通过
     * @param t
     * @return
     */
    @Override
    public boolean test(T t) {
        return leafComponents.stream()
//                .peek(s -> System.out.println(s + "开始工作"))
                .allMatch(selector -> selector.test(t));
    }

    @Override
    public String toString() {
        return "Conjunction选择器";
    }
}
