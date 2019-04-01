package models.manaCard;

import models.utils.ManaType;

public class ManaCard {
    // Declaration
    private int id;
    private int number;
    private Enum<ManaType> manaTypeTop;
    private int manaTypeNumberTop;
    private Enum<ManaType> manaTypeBot;
    private int ManaTypeNumberBot;

    // Constructor
    public ManaCard(int id, int number, Enum<ManaType> manaTypeTop, int manaTypeNumberTop, Enum<ManaType> manaTypeBot, int manaTypeNumberBot) {
        this.id = id;
        this.number = number;
        this.manaTypeTop = manaTypeTop;
        this.manaTypeNumberTop = manaTypeNumberTop;
        this.manaTypeBot = manaTypeBot;
        this.ManaTypeNumberBot = manaTypeNumberBot;
    }

    public ManaCard() {
        // empty constructor on purpose
    }

    // Override methods
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "ManaCard{" +
                "number=" + number +
                ", manaTypeTop=" + manaTypeTop +
                ", manaTypeNumberTop=" + manaTypeNumberTop +
                ", manaTypeBot=" + manaTypeBot +
                ", ManaTypeNumberBot=" + ManaTypeNumberBot +
                '}';
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Enum<ManaType> getManaTypeTop() {
        return manaTypeTop;
    }

    public void setManaTypeTop(Enum<ManaType> manaTypeTop) {
        this.manaTypeTop = manaTypeTop;
    }

    public int getManaTypeNumberTop() {
        return manaTypeNumberTop;
    }

    public void setManaTypeNumberTop(int manaTypeNumberTop) {
        this.manaTypeNumberTop = manaTypeNumberTop;
    }

    public Enum<ManaType> getManaTypeBot() {
        return manaTypeBot;
    }

    public void setManaTypeBot(Enum<ManaType> manaTypeBot) {
        this.manaTypeBot = manaTypeBot;
    }

    public int getManaTypeNumberBot() {
        return ManaTypeNumberBot;
    }

    public void setManaTypeNumberBot(int manaTypeNumberBot) {
        ManaTypeNumberBot = manaTypeNumberBot;
    }
}