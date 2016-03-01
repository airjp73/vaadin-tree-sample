package de.vaadin.sample.db.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static javax.persistence.FetchType.EAGER;

@Entity
public class Node{

    public Node(){
    }

    public Node(Node parent){
        this.parent = parent;
    }

    @Id
    @GeneratedValue
    private int nodeId;

    @OneToOne(fetch = EAGER)
    private Node parent;

    public int getNodeId() {
        return nodeId;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node " + nodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getNodeId() == node.getNodeId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNodeId());
    }
}