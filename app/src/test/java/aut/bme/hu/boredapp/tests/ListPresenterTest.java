package aut.bme.hu.boredapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.boredapp.TestApplication;
import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.ui.list.ListActivity;
import aut.bme.hu.boredapp.ui.list.ListPresenter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class ListPresenterTest  {
    @Inject
    ListPresenter presenter;

    @Mock
    ListActivity mockActivity;

    @Before
    public void setup(){
        mockActivity = Mockito.mock(ListActivity.class);
        TestApplication.injector.inject(mockActivity);

        presenter = mockActivity.presenter;
        presenter.attachScreen(mockActivity);
    }

    @Test
    public void testGetAll(){
        presenter.getAll();
        verify(mockActivity, times(1) ).showActivities(any());
    }
}
