package deckBuilderGUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import deckComponents.Card;

public class ListTableModel extends AbstractTableModel {

  /**
	 * 
	 */
  private static final long serialVersionUID = -5659027655019078895L;

  private String[] columnNames;
  private Class<?>[] types;
  private ArrayList<Card> cardList;

  public ListTableModel(String[] columnNames, Class<?>[] types, ArrayList<Card> cardList) {
    this.columnNames = columnNames;
    this.types = types;
    this.cardList = cardList;
  }

  @Override
  public int getRowCount() {
    return cardList.size();
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    // TODO Auto-generated method stub
    String c = cardList.get(rowIndex).getProperties().get("card_name");

    return c;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return columnNames[columnIndex];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return types[columnIndex];
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  public void removeRow(int row) {
    cardList.remove(row);
  }

}
