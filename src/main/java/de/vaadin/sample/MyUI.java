package de.vaadin.sample;

import com.google.inject.Inject;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.guice.annotation.Configuration;
import com.vaadin.guice.annotation.GuiceUI;
import com.vaadin.guice.server.GuiceVaadinServlet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

import de.vaadin.sample.cdi.SampleModule;
import de.vaadin.sample.components.TreeA;
import de.vaadin.sample.components.TreeB;

import static com.vaadin.ui.Alignment.TOP_LEFT;
import static com.vaadin.ui.Alignment.TOP_RIGHT;

/**
 *
 */
@Theme("mytheme")
@Widgetset("de.vaadin.sample.MyAppWidgetset")
@GuiceUI
public class MyUI extends UI {

    @Inject
    private TreeA treeA;

    @Inject
    private TreeB treeB;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();

        //horizontalLayout.addComponent(treeA);
        horizontalLayout.addComponents(treeA, treeB);
        horizontalLayout.setComponentAlignment(treeA, TOP_LEFT);
        horizontalLayout.setComponentAlignment(treeB, TOP_RIGHT);

        setContent(horizontalLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    @Configuration(modules = SampleModule.class, basePackages = "de.vaadin.sample")
    public static class MyUIServlet extends GuiceVaadinServlet {
    }
}
