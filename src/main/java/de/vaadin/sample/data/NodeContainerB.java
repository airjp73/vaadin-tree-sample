package de.vaadin.sample.data;

import com.google.inject.Inject;

import com.vaadin.guice.annotation.UIScope;

import de.vaadin.sample.db.dao.NodeDao;

@UIScope
public class NodeContainerB extends NodeContainer {

    @Inject
    public NodeContainerB(NodeDao nodeDao) {
        super(nodeDao.get(6));
    }
}
