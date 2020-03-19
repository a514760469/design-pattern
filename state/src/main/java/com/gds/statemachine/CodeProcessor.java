package com.gds.statemachine;

/**
 * 状态模式实现：
 * 给出一段java程序，删除其中的注释并返回删除注释之后的代码。
 * @author zhanglifeng
 * @since 2020-03-18 10:56
 */
public class CodeProcessor {

    private InputState currentState;

    private StringBuilder codeWithoutComment = new StringBuilder();

    private String originCode;// 原始代码

    public CodeProcessor(String code) {
        this.originCode = code;
        this.currentState = new Normal();// 初始化状态
    }

    public InputState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(InputState currentState) {
        this.currentState = currentState;
    }

    /**
     * 返回清除注释的代码
     */
    public String clearComment() {
        for (int i = 0; i < originCode.length(); i++) {
            char charAt = getChar(i);
            currentState.handleInput(charAt, this);
        }
        return codeWithoutComment.toString();
    }

    /**
     * 放入无注释字符
     * @param c
     */
    public void putChar(char c) {
        codeWithoutComment.append(c);
    }

    private char getChar(int i) {
        return originCode.charAt(i);
    }


    public static void main(String[] args) {
        String code =
                " public static void main(String[] args) {" + "\n"
                + "    String file = \"/tmp/log.log\""  + "\n"
                + "    /**hehe "                        + "\n"
                + "      hehe "                         + "\n"
                + "     */ "                            + "\n"
                + "    /*hehe*/"                        + "\n"
                + "    int a, int b; "                  + "\n"
                + "    /* hehe */ "                     + "\n"
                + "    //hehe"                          + "\n"
                + "    a = 4+2; //hehe"                 + "\n"
                + "    b = a;"                          + "\n"
                + " }";
        System.out.println(code);
        System.out.println("------------------------------------");
        CodeProcessor process = new CodeProcessor(code);
        String str = process.clearComment();
        System.out.println(str);
    }
}
