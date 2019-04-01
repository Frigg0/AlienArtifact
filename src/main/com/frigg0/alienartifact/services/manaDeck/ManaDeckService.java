package services.manaDeck;

import exceptionFactory.CurrentDeckException;
import models.manaCard.ManaCard;
import models.utils.ManaType;
import models.utils.Turn;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ManaDeckService {
    /* Instantiations */
    private final Logger logger = LogManager.getFormatterLogger();

    private Turn turn = new Turn();
    private List<ManaCard> startingDeck = constructingStartingDeck();
    private List<ManaCard> deckRotate = new ArrayList<>();
    private List<ManaCard> deckGraveyard = new ArrayList<>();
    private List<ManaCard> deck = currentDeck(turn.getTurn());

    /* Constructors */
    public ManaDeckService() throws Exception {
    }

    /* Methods */
    // Defining current deck which to draw cards
    private List<ManaCard> currentDeck(int turn) throws Exception{
        switch (turn){
            case 2:
                deck = startingDeck;
                break;
            case 1:
                deck = deckRotate;
                break;
            default:
                throw new CurrentDeckException("The current deck selected is undefined");
        }
        return deck;
    }

    // Defining current graveyard for used cards
    private List<ManaCard> currentGraveyard(int turn) throws Exception{
        switch (turn){
            case 2:
                deckGraveyard = deckRotate;
                break;
            case 1:
                deckGraveyard = startingDeck;
                break;
            default:
                throw new CurrentDeckException("The current deck selected is undefined");
        }
        return deckGraveyard;
    }

    private void currentTurn(){
        // Changing turn if deck empty
        if(deck.size() == 0){
            turn.setTurn(turn.getTurn()-1);
            // then changing deck
            try {
                currentDeck(turn.getTurn());
            } catch (Exception e) {
                logger.error(e);
            }
        }

        // testing end of game
        // TODO Trigger de fin de game
        if(turn.getTurn() == 0){
            System.out.println("game is over, count the points");
        }
        logger.debug("What turn are we: " + turn.getTurn());
    }

    public ManaCard drawCard(){
        // checking turn
        currentTurn();

        // Checking deck before drawing
        logger.debug("Deck size before picking: %s", deck.size());

        // Retrieve the random number for the card to pick and test if already draw
        int n = getRandom();
        logger.debug("Random index generated to draw: %s", n);

        // Stock card draw to return
        ManaCard manaCard = getCardInDeck(n);

        // remove the card draw from the deck
        deck.remove(n);
        // for testing, checking deckRotate
        cardUsed(manaCard);
        System.out.println("deck rotate size : "+ deckRotate.size());
        System.out.println("Current startingDeck size : "+startingDeck.size());

        return manaCard;
    }

    private void cardUsed(ManaCard manaCard){
        // Defining graveyard
        try {
            currentGraveyard(turn.getTurn()).add(manaCard);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    // Generate a random number from 0 to deck size
    private int getRandom(){
        int n = deck.size();
        return ThreadLocalRandom.current().nextInt(n);
    }

    // Retrieve a card from deck at target index
    private ManaCard getCardInDeck(int index){
        return deck.get(index);
    }

    private List<ManaCard> constructingStartingDeck(){
        List<ManaCard> cardList = new ArrayList<>();

        cardList.add(createNewManaCard(0, 0, ManaType.Tech, 0, ManaType.Strike, 0));
        cardList.add(createNewManaCard(1, 4, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(2, 4, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(3, 4, ManaType.Strike, 2, ManaType.Moon, 2));
       /* cardList.add(createNewManaCard(4, 4, ManaType.Strike, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(5, 4, ManaType.Tech, 3, ManaType.Moon, 1));
        cardList.add(createNewManaCard(6, 4, ManaType.Tech, 1, ManaType.Moon, 3));
        cardList.add(createNewManaCard(7, 4, ManaType.Tech, 1, ManaType.Moon, 3));
        cardList.add(createNewManaCard(8, 4, ManaType.Tech, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(9, 4, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(10, 4, ManaType.Strike, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(11, 4, ManaType.Tech, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(12, 4, ManaType.Tech, 1, ManaType.Strike, 3));
        cardList.add(createNewManaCard(13, 4, ManaType.Tech, 3, ManaType.Moon, 1));
        cardList.add(createNewManaCard(14, 4, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(15, 3, ManaType.Tech, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(16, 3, ManaType.Moon, 3, ManaType.Joker, 1));
        cardList.add(createNewManaCard(17, 3, ManaType.Moon, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(18, 3, ManaType.Tech, 3, ManaType.Strike, 3));
        cardList.add(createNewManaCard(19, 3, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(20, 3, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(21, 3, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(22, 3, ManaType.Strike, 1, ManaType.Moon, 3));
        cardList.add(createNewManaCard(23, 3, ManaType.Strike, 1, ManaType.Moon, 3));
        cardList.add(createNewManaCard(24, 3, ManaType.Strike, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(25, 3, ManaType.Strike, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(26, 3, ManaType.Strike, 3, ManaType.Moon, 1));
        cardList.add(createNewManaCard(27, 3, ManaType.Strike, 3, ManaType.Moon, 1));
        cardList.add(createNewManaCard(28, 3, ManaType.Strike, 3, ManaType.Joker, 1));
        cardList.add(createNewManaCard(29, 3, ManaType.Tech, 3, ManaType.Strike, 1));
        cardList.add(createNewManaCard(30, 3, ManaType.Strike, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(31, 3, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(32, 3, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(33, 3, ManaType.Tech, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(34, 3, ManaType.Tech, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(35, 3, ManaType.Tech, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(36, 3, ManaType.Strike, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(37, 3, ManaType.Strike, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(38, 3, ManaType.Strike, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(39, 3, ManaType.Tech, 1, ManaType.Moon, 3));
        cardList.add(createNewManaCard(40, 3, ManaType.Moon, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(41, 2, ManaType.Tech, 3, ManaType.Strike, 2));
        cardList.add(createNewManaCard(42, 2, ManaType.Tech, 2, ManaType.Moon, 3));
        cardList.add(createNewManaCard(43, 2, ManaType.Tech, 3, ManaType.Moon, 1));
        cardList.add(createNewManaCard(44, 2, ManaType.Tech, 3, ManaType.Moon, 2));
        cardList.add(createNewManaCard(45, 2, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(46, 2, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(47, 2, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(48, 2, ManaType.Strike, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(49, 2, ManaType.Strike, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(50, 2, ManaType.Strike, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(51, 2, ManaType.Strike, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(52, 2, ManaType.Strike, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(53, 2, ManaType.Strike, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(54, 2, ManaType.Moon, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(55, 2, ManaType.Moon, 3, ManaType.Joker, 1));
        cardList.add(createNewManaCard(56, 2, ManaType.Tech, 2, ManaType.Strike, 3));
        cardList.add(createNewManaCard(57, 2, ManaType.Tech, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(58, 2, ManaType.Tech, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(59, 2, ManaType.Tech, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(60, 2, ManaType.Strike, 3, ManaType.Joker, 1));
        cardList.add(createNewManaCard(61, 2, ManaType.Moon, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(62, 2, ManaType.Moon, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(63, 2, ManaType.Strike, 2, ManaType.Joker, 2));
        cardList.add(createNewManaCard(64, 2, ManaType.Moon, 3, ManaType.Strike, 2));
        cardList.add(createNewManaCard(65, 2, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(66, 2, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(67, 2, ManaType.Tech, 1, ManaType.Strike, 3));
        cardList.add(createNewManaCard(68, 2, ManaType.Tech, 3, ManaType.Strike, 1));
        cardList.add(createNewManaCard(69, 1, ManaType.Strike, 1, ManaType.Moon, 3));
        cardList.add(createNewManaCard(70, 1, ManaType.Moon, 3, ManaType.Joker, 1));
        cardList.add(createNewManaCard(71, 1, ManaType.Strike, 1, ManaType.Moon, 3));
        cardList.add(createNewManaCard(72, 1, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(73, 1, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(74, 1, ManaType.Tech, 2, ManaType.Moon, 2));
        cardList.add(createNewManaCard(75, 1, ManaType.Moon, 3, ManaType.Joker, 1));
        cardList.add(createNewManaCard(76, 1, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(77, 1, ManaType.Tech, 3, ManaType.Joker, 1));
        cardList.add(createNewManaCard(78, 1, ManaType.Moon, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(79, 1, ManaType.Tech, 3, ManaType.Joker, 2));
        cardList.add(createNewManaCard(80, 1, ManaType.Tech, 2, ManaType.Strike, 2));
        cardList.add(createNewManaCard(81, 1, ManaType.Tech, 3, ManaType.Strike, 1));
        cardList.add(createNewManaCard(82, 1, ManaType.Strike, 3, ManaType.Moon, 1));
        cardList.add(createNewManaCard(83, 1, ManaType.Strike, 3, ManaType.Joker, 2));*/

        return cardList;
    }

    /* Methods */
    // Calling new Mana card constructor easily
    private ManaCard createNewManaCard(int id, int number, Enum<ManaType> manaTypeTop,
                                       int manaTypeNumberTop, Enum<ManaType> manaTypeBot, int manaTypeNumberBot){
        return new ManaCard(id, number, manaTypeTop, manaTypeNumberTop, manaTypeBot, manaTypeNumberBot);
    }

}