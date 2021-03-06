package deckBuilderGUI;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import deckBuilderGUI.UIComponentInfo.UIType;
import tcg.CardProtos.Card;
//import deckComponents.Card;

public class WeissSchwarzController extends Controller {

  public WeissSchwarzController() {
    super();
    createSearchPositionMap();
  }

  @Override
  public void deserialize() {
// InputStream fileInput;
// ObjectInputStream objectInput;
//
// try {
// System.out.println("Opening data");
// fileInput = getClass().getResourceAsStream("/resources/GameControllers");
// objectInput = new ObjectInputStream(fileInput);
//
// ArrayList<Card> resultList = (ArrayList<Card>) objectInput.readObject();
// this.setResultList(resultList);
//
// } catch (IOException e) {
// e.printStackTrace();
// } catch (ClassNotFoundException e) {
// e.printStackTrace();
// }
  }

  @Override
  public Box getDetailedView(Card referenceCard) {
    // TODO Auto-generated method stub
    Box cardDetailView = Box.createVerticalBox();

    return cardDetailView;
  }

  @Override
  public JTable getQueryListView(HashMap<String, String> query) {
    // TODO Auto-generated method stub
    String[] columnNames = { "Card ID", "Name", "Color", "Type" };
    String[][] dataSet = { { "00-000", "Anzu", "BLUE", "Chara" },
        { "00-001", "Otome", "YELLOW", "Chara" }, { "00-002", "Charles", "RED", "Chara" },
        { "00-003", "Nanaka", "GREEN", "Chara" }, { "00-000", "Anzu", "BLUE", "Chara" },
        { "00-001", "Otome", "YELLOW", "Chara" }, { "00-002", "Charles", "RED", "Chara" },
        { "00-003", "Nanaka", "GREEN", "Chara" }, { "00-000", "Anzu", "BLUE", "Chara" },
        { "00-001", "Otome", "YELLOW", "Chara" }, { "00-002", "Charles", "RED", "Chara" },
        { "00-003", "Nanaka", "GREEN", "Chara" }, { "00-000", "Anzu", "BLUE", "Chara" },
        { "00-001", "Otome", "YELLOW", "Chara" }, { "00-002", "Charles", "RED", "Chara" },
        { "00-003", "Nanaka", "GREEN", "Chara" }, { "00-000", "Anzu", "BLUE", "Chara" },
        { "00-001", "Otome", "YELLOW", "Chara" }, { "00-002", "Charles", "RED", "Chara" },
        { "00-003", "Nanaka", "GREEN", "Chara" }, { "00-000", "Anzu", "BLUE", "Chara" },
        { "00-001", "Otome", "YELLOW", "Chara" }, { "00-002", "Charles", "RED", "Chara" },
        { "00-003", "Nanaka", "GREEN", "Chara" } };

    JTable listTable = new JTable(dataSet, columnNames) {
      /**
			 * 
			 */
      private static final long serialVersionUID = -8791285381071866475L;

      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
      }
    };

    return listTable;
  }

  @Override
  public JTable getDeckListView() {
    // TODO Auto-generated method stub
    String[] columnNames = { "Card ID", "Name", "Color", "Type" };
    Class<?>[] columnClasses = new Class<?>[columnNames.length];

    for (int i = 0; i < columnClasses.length; i++) {
      columnClasses[i] = columnNames[i].getClass();
    }

    ArrayList<Card> cardsInDeck = new ArrayList<Card>();
    
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());
    cardsInDeck.add(Card.newBuilder().build());

    final ListTableModel listTableModel = new ListTableModel(columnNames, columnClasses,
        cardsInDeck);

    final JTable listTable = new JTable(listTableModel) {
      /**
			 * 
			 */
      private static final long serialVersionUID = 6813909761668112368L;

      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
      }
    };

    listTable.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // Left mouse click
        if (SwingUtilities.isLeftMouseButton(e)) {
          // Do something
        }
        // Right mouse click
        else if (SwingUtilities.isRightMouseButton(e)) {
          // get the coordinates of the mouse click
          Point p = e.getPoint();

          // get the row index that contains that coordinate
          int rowNumber = listTable.rowAtPoint(p);
          listTableModel.removeRow(rowNumber);
          listTable.addNotify();
        }
      }
    });

    return listTable;
  }

  @Override
  public Box getDeckInfoPane() {
    // TODO Auto-generated method stub
    Box infoBox = Box.createVerticalBox();

    JLabel yellowLabel = new JLabel("Yellow");
    JLabel greenLabel = new JLabel("Green");
    JLabel redLabel = new JLabel("Red");
    JLabel blueLabel = new JLabel("Blue");

    infoBox.add(yellowLabel);
    infoBox.add(greenLabel);
    infoBox.add(redLabel);
    infoBox.add(blueLabel);

    return infoBox;
  }

  public void createSearchPositionMap() {
    ArrayList<UIComponentInfo> componentList = new ArrayList<UIComponentInfo>();

    componentList.add(new UIComponentInfo("Card ID", UIType.INPUT, 0, null));
    componentList.add(new UIComponentInfo("Card Name", UIType.INPUT, 0, null));
    componentList.add(new UIComponentInfo("Color", UIType.DROPDOWN, 0, new String[] { "Yellow",
        "Green", "Red", "Blue" }));
    componentList.add(new UIComponentInfo("Type", UIType.DROPDOWN, 0, new String[] { "Character",
        "Event", "Climax" }));
    componentList.add(new UIComponentInfo("Trigger", UIType.INPUT, 1, null));
    componentList.add(new UIComponentInfo("Power", UIType.INPUT, 1, null));
    componentList.add(new UIComponentInfo("Cost", UIType.INPUT, 1, null));
    componentList.add(new UIComponentInfo("Soul", UIType.INPUT, 1, null));
    componentList.add(new UIComponentInfo("Level", UIType.DROPDOWN, 1, new String[] { "0", "1",
        "2", "3" }));
    componentList.add(new UIComponentInfo("Trait", UIType.INPUT, 1, null));
    componentList.add(new UIComponentInfo("Ability Text", UIType.INPUT, 2, null));

    this.setProperties(componentList);
    this.setSearchRowCount(3);
  }
}
