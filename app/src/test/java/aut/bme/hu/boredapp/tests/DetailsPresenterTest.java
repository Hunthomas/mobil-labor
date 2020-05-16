package aut.bme.hu.boredapp.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;

import javax.inject.Inject;

import aut.bme.hu.boredapp.TestApplication;
import aut.bme.hu.boredapp.model.BoredActivity;
import aut.bme.hu.boredapp.ui.details.DetailsActivity;
import aut.bme.hu.boredapp.ui.details.DetailsPresenter;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class DetailsPresenterTest {

    @Inject
    DetailsPresenter presenter;

    @Mock
    DetailsActivity mockActivity;

    @Before
    public void setup(){
        mockActivity = Mockito.mock(DetailsActivity.class);
        TestApplication.injector.inject(mockActivity);

        presenter = mockActivity.presenter;
        presenter.attachScreen(mockActivity);
    }

    @Test
    public void networkTest(){
        try {
            //Act
            presenter.getNewActivity();

            // Assert
            ArgumentCaptor<BoredActivity> argument = ArgumentCaptor.forClass(BoredActivity.class);
            verify(mockActivity, times(1) ).showBoredActivity(argument.capture());

            BoredActivity argumentValue = argument.getValue();
            Assert.assertEquals(1, argumentValue.getKey());
            Assert.assertEquals("Go cycling", argumentValue.getActivity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void localTest(){
        // Act
        presenter.getFromDb(1);

        // Assert
        ArgumentCaptor<BoredActivity> argument = ArgumentCaptor.forClass(BoredActivity.class);
        verify(mockActivity, times(1) ).showBoredActivity(argument.capture());

        BoredActivity argumentValue = argument.getValue();
        Assert.assertEquals(1, argumentValue.getKey());
        Assert.assertEquals("Go cycling", argumentValue.getActivity());

    }

}
