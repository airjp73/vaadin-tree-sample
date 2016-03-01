package de.vaadin.sample.cdi;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

import de.vaadin.sample.db.dao.NodeDao;

public class PersistServiceInitializer {

    @Inject
    PersistServiceInitializer(PersistService persistService, NodeDao nodeDao){
        persistService.start();
        nodeDao.addSampleData();
    }
}
