package com.joon.springjpa.post;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PostPublishedEvent  extends ApplicationEvent {
    private Post post;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PostPublishedEvent(Object source) {
        super(source);
        this.post= (Post) source;
    }
}
