package com.frigg0.alienartifact.models.planetCards;

import com.frigg0.alienartifact.models.utils.TypeCard;

public class PlanetOperationnalCard {
    /* Declarations */
    private int id;
    private Enum<TypeCard> cardType;
    private String description;

    /* Constructors */
    public PlanetOperationnalCard(int id, Enum<TypeCard> cardType, String description) {
        this.id = id;
        this.cardType = cardType;
        this.description = description;
    }

    public PlanetOperationnalCard() {
        // Empty constructor on purpose
    }

    /* toString */
    @Override
    public String toString() {
        return "PlanetOperationnalCard{" +
                "id=" + id +
                ", cardType=" + cardType +
                ", description='" + description + '\'' +
                '}';
    }

    /* Override methods */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* Getter and setters */
    public int getId() {
        return id;
    }

    public Enum<TypeCard> getCardType() {
        return cardType;
    }

    public void setCardType(Enum<TypeCard> cardType) {
        this.cardType = cardType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
