package com.gds.facade.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 16:30
 */
public class ModernPostOffice {

    private ILetterProcess letterProcess = new LetterProcessImpl();

    private Police police = new Police();

    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);
        police.checkLetter(letterProcess);
        letterProcess.letterIntoEnvelope();
        letterProcess.sendLetter();
    }
}
