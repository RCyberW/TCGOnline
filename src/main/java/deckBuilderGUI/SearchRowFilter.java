package deckBuilderGUI;

import javax.swing.RowFilter;

// import deckComponents.Card;
import tcg.CardProtos.Card;

public class SearchRowFilter extends RowFilter<ListTableModel, Integer> {

  private Card query;

  public SearchRowFilter(Card query) {
    setQuery(query);
  }

  @Override
  public boolean include(Entry<? extends ListTableModel, ? extends Integer> entry) {
    ListTableModel resultCardListModel = (ListTableModel) entry.getModel();
    Card card = resultCardListModel.getCard(entry.getIdentifier());
    
    boolean cardMetRequirement = hasCardMetRequirment(card);
    
    if (cardMetRequirement)
      return true;
    else
      return false;
  }
  
  /**
   * @param card to check against the query
   * @return if the card matches the requirement
   */
  private boolean hasCardMetRequirment(Card card) {
    // TODO TBD
    return false;
  }

  /**
   * @return the query
   */
  public Card getQuery() {
    return query;
  }

  /**
   * @param query the query to set
   */
  public void setQuery(Card query) {
    this.query = query;
  }
}