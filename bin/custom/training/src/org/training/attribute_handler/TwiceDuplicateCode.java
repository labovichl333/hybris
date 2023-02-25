package org.training.attribute_handler;

import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import org.training.model.MyItem4Model;

public class TwiceDuplicateCode extends AbstractDynamicAttributeHandler<String, MyItem4Model> {
    @Override
    public String get(MyItem4Model model) {
        if(model.getCode()==null){
            return null;
        }
        return model.getCode().concat(model.getCode());
    }
}
