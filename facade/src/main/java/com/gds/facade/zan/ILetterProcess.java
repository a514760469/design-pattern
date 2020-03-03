package com.gds.facade.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 16:23
 */
public interface ILetterProcess {

    // 首先要写信的内容
    void writeContext(String context);

    // 其次写信封
    void fillEnvelope(String address);

    // 把信放到信封里
    void letterIntoEnvelope();

    // 然后邮递
    void sendLetter();


}
