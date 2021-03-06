package com.kedzier.spring.feature.event;

/**
 * @author kedzierm
 */
public class MyEvent {

    private Long id;

    private String message;

    public MyEvent(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
            "id=" + id +
            ", message='" + message + '\'' +
            '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
