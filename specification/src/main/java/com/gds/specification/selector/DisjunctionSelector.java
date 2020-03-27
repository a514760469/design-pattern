package com.gds.specification.selector;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-03-27 11:15
 */
public class DisjunctionSelector<T> extends AbstractSelector<T> {

    private List<AbstractSelector<T>> leafComponents;

    @SafeVarargs
    DisjunctionSelector(AbstractSelector<T>... leafComponents) {
        this.leafComponents = Arrays.asList(leafComponents);
    }

    /**
     * 测试是否*至少一个*选择器是否通过测试。
     * @param t
     * @return
     */
    @Override
    public boolean test(T t) {
        return leafComponents.stream()
//                .peek(s -> System.out.println(s + "开始工作"))
                .anyMatch(selector -> selector.test(t));
    }

    @Override
    public String toString() {
        return "Disjunction选择器";
    }
}
