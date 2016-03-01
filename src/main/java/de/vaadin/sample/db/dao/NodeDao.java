package de.vaadin.sample.db.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import de.vaadin.sample.db.domain.Node;

import java.util.List;

import javax.persistence.EntityManager;

@Singleton
public class NodeDao {

    @Inject
    private Provider<EntityManager> entityManagerProvider;

    @Transactional
    public Node upsert(Node node){
        return entityManagerProvider.get().merge(node);
    }

    @Transactional
    public Node get(int nodeId){
        return entityManagerProvider
                .get()
                .find(Node.class, nodeId);
    }

    @Transactional
    public List<Node> getSubNodes(Node node){
        return entityManagerProvider
                .get()
                .createQuery("from Node where parent = :parent", Node.class)
                .setParameter("parent", node)
                .getResultList();
    }

    @Transactional
    public List<Node> getRootNodes(){
        return getSubNodes(get(initNodeId));
    }

    private int initNodeId;

    @Transactional
    public void addSampleData() {
        Node node0 = upsert(new Node());
        initNodeId = node0.getNodeId();
        Node node1 = upsert(new Node(node0));
        Node node1_1 = upsert(new Node(node1));
        Node node1_2 = upsert(new Node(node1));
        Node node1_2_1 = upsert(new Node(node1_2));
        Node node2 = upsert(new Node(node0));
        Node node2_1 = upsert(new Node(node2));
        Node node2_2 = upsert(new Node(node2));
        Node node2_2_1 = upsert(new Node(node2_2));
    }
}