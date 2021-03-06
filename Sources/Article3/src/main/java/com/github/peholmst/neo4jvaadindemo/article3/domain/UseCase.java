package com.github.peholmst.neo4jvaadindemo.article3.domain;

import com.github.peholmst.neo4jvaadindemo.article3.domain.util.AggregateRoot;
import com.github.peholmst.neo4jvaadindemo.article3.domain.util.CollectionFacade;
import com.github.peholmst.neo4jvaadindemo.article3.util.ItemProperty;
import com.github.peholmst.neo4jvaadindemo.article3.domain.util.Nameable;
import com.vaadin.data.Item;

public interface UseCase extends AggregateRoot, Nameable, Item {

    static final String PROP_SCOPE = "scope";
    static final String PROP_PRECONDITIONS = "preconditions";
    static final String PROP_SUCCESS_GUARANTEE = "successGuarantee";

    @ItemProperty
    String getScope();

    void setScope(String scope);

    @ItemProperty
    String getPreconditions();

    void setPreconditions(String preconditions);

    @ItemProperty
    String getSuccessGuarantee();

    void setSuccessGuarantee(String successGuarantee);

    CollectionFacade<Scenario> getScenarios();

    Scenario addScenario(Scenario.Type scenarioType);

    void removeScenario(Scenario scenario);

    CollectionFacade<UseCaseActor> getActors();

    UseCaseActor addActor(UseCaseActor.Type actorType, Actor actor);

    void removeActor(UseCaseActor actor);

    CollectionFacade<UseCaseAssociation> getUseCaseAssociations();

    UseCaseAssociation associateWithUseCase(UseCase destination);

    void removeAssociation(UseCaseAssociation association);

    CollectionFacade<UseCaseRequirementAssociation> getRequirementAssociations();

    UseCaseRequirementAssociation associateWithRequirement(Requirement destination);

    void removeAssociation(UseCaseRequirementAssociation association);
}
