package org.training.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import org.training.dao.TokenWrapperDao;
import org.training.model.TokenWrapperModel;

import javax.annotation.Resource;
import java.util.Random;

public class GenerateNewTokenJob  extends AbstractJobPerformable<CronJobModel> {
    @Resource
    private TokenWrapperDao tokenWrapperDao;
    private final Random random = new Random();
    @Resource
    private ModelService modelService;

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        TokenWrapperModel tokenWrapperModel = tokenWrapperDao.getFirst();
        tokenWrapperModel.setToken(random.nextInt());
        modelService.save(tokenWrapperModel);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}
