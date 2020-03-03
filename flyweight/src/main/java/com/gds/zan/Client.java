package com.gds.zan;

/**
 * @author zhanglifeng
 * @since 2020-03-02 17:47
 */
public class Client {

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            String subject = "科目" + i;
            for (int j = 0; j < 30 ; j++) {
                String key = subject + "考试地点" + j;
                SignFactory.getSignInfo(key);
            }
        }

        SignInfo signInfo = SignFactory.getSignInfo("科目1考试地点1");;

        System.out.println(signInfo.getId());
    }
}
