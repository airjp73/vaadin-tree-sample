package de.vaadin.sample.cdi;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

import com.vaadin.event.dd.DropHandler;

import de.vaadin.sample.data.DropHandlerImpl;

public class SampleModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new JpaPersistModule("sample"));
        bind(PersistServiceInitializer.class).asEagerSingleton();
        bind(DropHandler.class).to(DropHandlerImpl.class);
    }
}
