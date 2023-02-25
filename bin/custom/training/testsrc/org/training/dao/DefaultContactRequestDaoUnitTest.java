package org.training.dao;

import de.hybris.bootstrap.annotations.UnitTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.training.dao.impl.DefaultContactRequestDao;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@UnitTest
public class DefaultContactRequestDaoUnitTest {
    @Mock
    private final DefaultContactRequestDao defaultContactRequestDao = new DefaultContactRequestDao();

    private final static String NOT_EXISTING_SENDER = "NotExistingSender";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnEmptyListByWhenSenderNotExists() {

        when(defaultContactRequestDao.findBySender(NOT_EXISTING_SENDER)).thenReturn(new ArrayList<>());

        Assert.assertEquals(0, defaultContactRequestDao.findBySender(NOT_EXISTING_SENDER).size());
    }
}
