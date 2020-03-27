package com.gds.obmediator.ob;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhanglifeng
 * @since 2020-03-26 11:22
 */
public abstract class EventConsumer {
    // 处理者的处理能力
    private Set<EventConsumerType> types = new HashSet<>();

    public EventConsumer(EventConsumerType type) {
        addConsumerType(type);
    }

    public EventConsumer(EventConsumerType... type) {
        for (EventConsumerType t : type) {
            addConsumerType(t);
        }
    }

    public void addConsumerType(EventConsumerType type) {
        types.add(type);
    }

    public Set<EventConsumerType> getTypes() {
        return types;
    }

    public abstract void exec(ProductEvent event);
}
