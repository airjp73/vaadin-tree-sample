package de.vaadin.sample.data;

import com.google.inject.Inject;
import com.google.inject.Provider;

import com.vaadin.guice.annotation.UIScope;

import de.vaadin.sample.components.TreeA;
import de.vaadin.sample.components.TreeB;

@UIScope
public class TreeExpanderB extends TreeExpander {
    @Inject
    TreeExpanderB(Provider<TreeB> sampleTreeProvider) {
        super(() -> sampleTreeProvider.get());
    }
}
