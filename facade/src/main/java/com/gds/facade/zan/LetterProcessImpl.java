package com.gds.facade.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 16:24
 */
public class LetterProcessImpl implements ILetterProcess {

    @Override
    public void writeContext(String context) {
        System.out.println("内容：" + context);
    }

    @Override
    public void fillEnvelope(String address) {
        System.out.println("地址：" + address);
    }

    @Override
    public void letterIntoEnvelope() {
        System.out.println("把信放到信封里");
    }

    @Override
    public void sendLetter() {
        System.out.println("邮递");
    }
}
