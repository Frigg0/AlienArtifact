package com.frigg0.alienartifact.models.planetCards;

import com.frigg0.alienartifact.models.utils.ManaType;
import com.frigg0.alienartifact.models.utils.TypeCard;

public class PlanetLogisticCard {
    /* Declaration */
    private int id;
    private String name;
    private Enum<TypeCard> cardType;
    private Enum<ManaType> manaType;
    private int manaNumber;
    private String description;
    private String ressourcesPlanetReductionPrice;

    /* Constructors */
    public PlanetLogisticCard(int id, String name, Enum<TypeCard> cardType, Enum<ManaType> manaType, int manaNumber, String description, String ressourcesPlanetReductionPrice) {
        this.id = id;
        this.name = name;
        this.cardType = cardType;
        this.manaType = manaType;
        this.manaNumber = manaNumber;
        this.description = description;
        this.ressourcesPlanetReductionPrice = ressourcesPlanetReductionPrice;
    }

    public PlanetLogisticCard() {
        // empty constructor on purpose
    }

    /* toString */
    @Override
    public String toString() {
        return "PlanetLogisticCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardType=" + cardType +
                ", manaType=" + manaType +
                ", manaNumber=" + manaNumber +
                ", description='" + description + '\'' +
                ", ressourcesPlanetReductionPrice='" + ressourcesPlanetReductionPrice + '\'' +
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

    /* Getter and Setter */
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum<TypeCard> getCardType() {
        return cardType;
    }

    public void setCardType(Enum<TypeCard> cardType) {
        this.cardType = cardType;
    }

    public Enum<ManaType> getManaType() {
        return manaType;
    }

    public void setManaType(Enum<ManaType> manaType) {
        this.manaType = manaType;
    }

    public int getManaNumber() {
        return manaNumber;
    }

    public void setManaNumber(int manaNumber) {
        this.manaNumber = manaNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRessourcesPlanetReductionPrice() {
        return ressourcesPlanetReductionPrice;
    }

    public void setRessourcesPlanetReductionPrice(String ressourcesPlanetReductionPrice) {
        this.ressourcesPlanetReductionPrice = ressourcesPlanetReductionPrice;
    }
}
