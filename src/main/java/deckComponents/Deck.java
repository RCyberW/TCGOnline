package deckComponents;

import gamePlay.Zone;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class Deck {
  private HashMap<UUID, Zone> zoneMapping;
  private HashMap<UUID, Card> cardMapping;

  public Deck() {
    setZoneMapping(new HashMap<UUID, Zone>());
    setCardMapping(new HashMap<UUID, Card>());
  }

  /**
   * @return the zoneMapping
   */
  public HashMap<UUID, Zone> getZoneMapping() {
    return zoneMapping;
  }

  /**
   * @param zoneMapping the zoneMapping to set
   */
  public void setZoneMapping(HashMap<UUID, Zone> zoneMapping) {
    this.zoneMapping = zoneMapping;
  }

  /**
   * @return the cardMapping
   */
  public HashMap<UUID, Card> getCardMapping() {
    return cardMapping;
  }

  /**
   * @param cardMapping the cardMapping to set
   */
  public void setCardMapping(HashMap<UUID, Card> cardMapping) {
    this.cardMapping = cardMapping;
  }

  /**
   * @param card add the specific card to the deck
   */
  public Card addCardToDeck(Card card) {
    return cardMapping.put(card.getCardID(), card);
  }

  /**
   * @param card remove the specific card from the deck
   */
  public Card removeCardFromDeck(Card card) {
    Card removedCard = cardMapping.get(card.getCardID());
    return cardMapping.remove(removedCard);
  }

  public void draw(Card card) {
    // TODO Auto-generated method stub

  }
}
