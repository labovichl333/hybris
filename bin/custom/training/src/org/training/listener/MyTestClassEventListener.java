package org.training.listener;

import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import org.training.event.MyTestClassEvent;
import org.training.model.NewsModel;

import javax.annotation.Resource;
import java.util.Date;

public class MyTestClassEventListener extends AbstractEventListener<MyTestClassEvent> {
    @Resource
    private ModelService modelService;
    @Override
    protected void onEvent(MyTestClassEvent event) {
        if (event != null) {
            NewsModel news = new NewsModel();
            news.setDate(new Date());
            news.setHeadline(event.getHeadline());
            news.setContent(event.getContent());
            modelService.save(news);
        }
    }
}