package com.gds.zan.spec;

import com.gds.zan.User;

/**
 * @author zhanglifeng
 * @since 2020-03-30 11:00
 */
public class UserByNameLike extends BaseUserSpecification {

    private final static String LIKE_FLAG = "%";

    private String likeName;

    public UserByNameLike(String likeName) {
        this.likeName = likeName;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        String name = user.getName();
        String str = likeName.replaceAll(LIKE_FLAG, "");
        // A%
        if (likeName.endsWith(LIKE_FLAG) && !likeName.startsWith(LIKE_FLAG)) {
            return name.startsWith(str);
        } else if (!likeName.endsWith(LIKE_FLAG) && likeName.startsWith(LIKE_FLAG)) {  // %A
            return name.endsWith(str);
        } else {    // %A%
            return name.contains(str);
        }
    }
}
