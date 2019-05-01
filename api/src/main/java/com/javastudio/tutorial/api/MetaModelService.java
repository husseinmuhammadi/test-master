package com.javastudio.tutorial.api;

import javax.ejb.Local;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@Local
public interface MetaModelService {
    Set<EntityType<?>> getMetamodelEntityTypes();
}
