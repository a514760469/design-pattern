package com.gds.retry;

/**
 * @author zhanglifeng
 * @since 2020-05-08 11:15
 */
@FunctionalInterface
public interface BusinessOperation<T> {

    /**
     * 执行业务操作，成功返回T，失败抛出异常
     * @return 返回值
     * @throws BusinessException 根据错误条件抛出更具体的子类型
     */
    T perform() throws BusinessException;
}
