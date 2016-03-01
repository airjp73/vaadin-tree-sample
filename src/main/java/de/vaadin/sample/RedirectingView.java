package de.vaadin.sample;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Panel;

import java.net.URL;

public class RedirectingView extends Panel implements View {

    public RedirectingView(URL urlWhereViewIsActuallyHosted){
        setContent(new BrowserFrame(null, new ExternalResource(urlWhereViewIsActuallyHosted)));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        //maybe viewChangeEvent.getParameters() needs to be passed on, in this case the url
        //needs to be stored and the parameters attached to it before creating an ExternalResource
    }
}
