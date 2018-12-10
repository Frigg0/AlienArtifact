package com.frigg0.alienartifact.services;

import com.frigg0.alienartifact.models.ManaCard;
import com.frigg0.alienartifact.models.ManaType;
import com.frigg0.alienartifact.models.Turn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ManaDeckService {

    /**
     * TODO
     * Peupler le deuxieme deck après utilisation des cartes en main
     * Deck de début de game opérationnel
     */

    /* Instantiations */
    private Turn turn = new Turn();
    private List<ManaCard> startingDeck = new ArrayList<>();
    private List<ManaCard> deckRotate = new ArrayList<>();
    private List<ManaCard> deck = currentDeck(turn.getTurn());

    /* Constructos */
    public ManaDeckService() throws Exception {
    }

    /* Methods */
    // Defining current deck which to draw cards
    private List<ManaCard> currentDeck(int turn) throws Exception {
        switch (turn){
            case 2:
                deck = constructingStartingDeck();
                break;
            case 1:
                deck = deckRotate;
                break;
            default:
                throw new Exception();
        }
        return deck;
    }

    private void currentTurn(){
        // Changing turn if deck empty
        if(deck.size() == 0){
            turn.setTurn(turn.getTurn()-1);
        }

        // testing end of game
        // TODO Trigger de fin de game
        if(turn.getTurn() == 0){
            System.out.println("game is over, count the points");
        }

        System.out.println("What turn are we: " + turn.getTurn());
    }

    public ManaCard drawCard(){
        // Retrieve the random number for the card to pick and test if already draw
        int n = getRandom();

        // Stock card draw to return
        ManaCard manaCard = getCardInDeck(n);

        // remove the card draw from the deck
        deck.remove(n);

        // changing turn?
        currentTurn();

        return manaCard;
    }

    // Generate a random number from 0 to deck size
    private int getRandom(){
        Random random = new Random();
        int n = deck.size();

        return random.nextInt(n);
    }

    // Retrieve a card from deck at target index
    private ManaCard getCardInDeck(int index){
        return deck.get(index);
    }

    private List<ManaCard> constructingStartingDeck(){
        startingDeck.add(createNewManaCard(0, 0, ManaType.Tech, 0, ManaType.Strike, 0));
        startingDeck.add(createNewManaCard(1, 4, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(2, 4, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(3, 4, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(4, 4, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(5, 4, ManaType.Tech, 3, ManaType.Moon, 1));
        startingDeck.add(createNewManaCard(6, 4, ManaType.Tech, 1, ManaType.Moon, 3));
        startingDeck.add(createNewManaCard(7, 4, ManaType.Tech, 1, ManaType.Moon, 3));
        startingDeck.add(createNewManaCard(8, 4, ManaType.Tech, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(9, 4, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(10, 4, ManaType.Strike, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(11, 4, ManaType.Tech, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(12, 4, ManaType.Tech, 1, ManaType.Strike, 3));
        startingDeck.add(createNewManaCard(13, 4, ManaType.Tech, 3, ManaType.Moon, 1));
        startingDeck.add(createNewManaCard(14, 4, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(15, 3, ManaType.Tech, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(16, 3, ManaType.Moon, 3, ManaType.Joker, 1));
        startingDeck.add(createNewManaCard(17, 3, ManaType.Moon, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(18, 3, ManaType.Tech, 3, ManaType.Strike, 3));
        startingDeck.add(createNewManaCard(19, 3, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(20, 3, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(21, 3, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(22, 3, ManaType.Strike, 1, ManaType.Moon, 3));
        startingDeck.add(createNewManaCard(23, 3, ManaType.Strike, 1, ManaType.Moon, 3));
        startingDeck.add(createNewManaCard(24, 3, ManaType.Strike, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(25, 3, ManaType.Strike, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(26, 3, ManaType.Strike, 3, ManaType.Moon, 1));
        startingDeck.add(createNewManaCard(27, 3, ManaType.Strike, 3, ManaType.Moon, 1));
        startingDeck.add(createNewManaCard(28, 3, ManaType.Strike, 3, ManaType.Joker, 1));
        startingDeck.add(createNewManaCard(29, 3, ManaType.Tech, 3, ManaType.Strike, 1));
        startingDeck.add(createNewManaCard(30, 3, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(31, 3, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(32, 3, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(33, 3, ManaType.Tech, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(34, 3, ManaType.Tech, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(35, 3, ManaType.Tech, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(36, 3, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(37, 3, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(38, 3, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(39, 3, ManaType.Tech, 1, ManaType.Moon, 3));
        startingDeck.add(createNewManaCard(40, 3, ManaType.Moon, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(41, 2, ManaType.Tech, 3, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(42, 2, ManaType.Tech, 2, ManaType.Moon, 3));
        startingDeck.add(createNewManaCard(43, 2, ManaType.Tech, 3, ManaType.Moon, 1));
        startingDeck.add(createNewManaCard(44, 2, ManaType.Tech, 3, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(45, 2, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(46, 2, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(47, 2, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(48, 2, ManaType.Strike, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(49, 2, ManaType.Strike, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(50, 2, ManaType.Strike, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(51, 2, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(52, 2, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(53, 2, ManaType.Strike, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(54, 2, ManaType.Moon, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(55, 2, ManaType.Moon, 3, ManaType.Joker, 1));
        startingDeck.add(createNewManaCard(56, 2, ManaType.Tech, 2, ManaType.Strike, 3));
        startingDeck.add(createNewManaCard(57, 2, ManaType.Tech, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(58, 2, ManaType.Tech, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(59, 2, ManaType.Tech, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(60, 2, ManaType.Strike, 3, ManaType.Joker, 1));
        startingDeck.add(createNewManaCard(61, 2, ManaType.Moon, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(62, 2, ManaType.Moon, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(63, 2, ManaType.Strike, 2, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(64, 2, ManaType.Moon, 3, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(65, 2, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(66, 2, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(67, 2, ManaType.Tech, 1, ManaType.Strike, 3));
        startingDeck.add(createNewManaCard(68, 2, ManaType.Tech, 3, ManaType.Strike, 1));
        startingDeck.add(createNewManaCard(69, 1, ManaType.Strike, 1, ManaType.Moon, 3));
        startingDeck.add(createNewManaCard(70, 1, ManaType.Moon, 3, ManaType.Joker, 1));
        startingDeck.add(createNewManaCard(71, 1, ManaType.Strike, 1, ManaType.Moon, 3));
        startingDeck.add(createNewManaCard(72, 1, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(73, 1, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(74, 1, ManaType.Tech, 2, ManaType.Moon, 2));
        startingDeck.add(createNewManaCard(75, 1, ManaType.Moon, 3, ManaType.Joker, 1));
        startingDeck.add(createNewManaCard(76, 1, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(77, 1, ManaType.Tech, 3, ManaType.Joker, 1));
        startingDeck.add(createNewManaCard(78, 1, ManaType.Moon, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(79, 1, ManaType.Tech, 3, ManaType.Joker, 2));
        startingDeck.add(createNewManaCard(80, 1, ManaType.Tech, 2, ManaType.Strike, 2));
        startingDeck.add(createNewManaCard(81, 1, ManaType.Tech, 3, ManaType.Strike, 1));
        startingDeck.add(createNewManaCard(82, 1, ManaType.Strike, 3, ManaType.Moon, 1));
        startingDeck.add(createNewManaCard(83, 1, ManaType.Strike, 3, ManaType.Joker, 2));

        return startingDeck;
    }

    /* Methods */
    // Calling new Mana card constructor easily
    private ManaCard createNewManaCard(int id, int number, Enum<ManaType> manaTypeTop, int manaTypeNumberTop, Enum<ManaType> manaTypeBot, int manaTypeNumberBot){
        return new ManaCard(id, number, manaTypeTop, manaTypeNumberTop, manaTypeBot, manaTypeNumberBot);
    }

}