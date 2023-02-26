package org.training.event;

import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public class MyTestClassEvent extends AbstractEvent {
    private String headline;
    private String content;

    public MyTestClassEvent(String headline, String content) {
        super();
        this.headline = headline;
        this.content = content;
    }


    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
