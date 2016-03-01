package de.vaadin.sample.data;

import com.google.inject.Inject;
import com.google.inject.Provider;

import com.vaadin.guice.annotation.UIScope;

import de.vaadin.sample.components.SampleTree;
import de.vaadin.sample.components.TreeA;

@UIScope
public class TreeExpanderA extends TreeExpander {
    @Inject
    TreeExpanderA(Provider<TreeA> sampleTreeProvider) {
        super(() -> sampleTreeProvider.get());
    }
}
