package org.example;

import java.util.Collections;
import java.util.List;

public class ContainerSynchManager {

    private final List<Integer> container;

    public ContainerSynchManager(List<Integer> container) {
        this.container = Collections.synchronizedList(container);
    }

    /// orice operatie urmeaza a fi definita aici trebuie sa fie synch

    // ratio citire/scriere ---> mare
}
