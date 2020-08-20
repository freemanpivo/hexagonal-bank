package com.freemanpivo.hexagonal.ports.outbound;

import java.util.List;
import java.util.Optional;

public interface Datastore <MODEL, ID_TYPE> {
    MODEL save(MODEL model);
    Optional<MODEL> get(ID_TYPE id);
}
