package deckBuilderGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import deckComponents.Card;

/**
 * A dynamic deck builder that will change displayed information based on the
 * type of card game specified
 * 
 * @author Frank Chen
 * @version 0.1
 * @since 2014-10-12
 */

public class DeckBuilder extends JFrame {

	/* Reference objects */
	private Controller gameController;
	private Card selectedCard;
	private String cardGameType;
	private HashMap<String, Controller> gameControllerMap;
	private HashMap<String, String> queryMap;

	/* Builder GUI */
	private Box searchBox;
	private Box imageBox;
	private Box listBox;
	private Box detailBox;
	private Box deckBox;

	private JTabbedPane contentBody;

	/* Final variables */
	final private int height = 600;
	final private int width = height * 16 / 9;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5447979137960563144L;
	private static final int MAX_RESULT_SHOWN = 500;
	private static final int RESULT_PER_LINE = 10;

	public DeckBuilder() {
		super("Some sort of deck builder");

		cardGameType = "SOME_SORT_CARD_GAME";

		searchBox = Box.createVerticalBox();
		imageBox = Box.createVerticalBox();
		listBox = Box.createVerticalBox();
		detailBox = Box.createVerticalBox();

		gameController = createGameControllerMap();

		// Update UI components look and feel
		if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
			try {
				for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} catch (Exception e) {
				System.err.println("Nimbus not available");
			}
		}

		setTitle(cardGameType);
	}

	public Controller createGameControllerMap() {
		gameControllerMap = new HashMap<String, Controller>();
		gameControllerMap.put("Weiss Schwarz", new WeissSchwarzController());

// InputStream fileInput;
// ObjectInputStream objectInput;
//
// try {
// System.out.println("Opening data");
// fileInput = getClass().getResourceAsStream("/resources/GameControllers");
// objectInput = new ObjectInputStream(fileInput);
//
// gameControllerMap = (HashMap<String, Controller>) objectInput
// .readObject();
//
// } catch (IOException e) {
// e.printStackTrace();
// } catch (ClassNotFoundException e) {
// e.printStackTrace();
// }

		gameController = gameControllerMap.get(cardGameType);
		if (gameController == null) {
			cardGameType = "Weiss Schwarz";
			return gameControllerMap.get("Weiss Schwarz");
		} else {
			return gameController;
		}
	}

	/**
	 * Create search fields for the specific game
	 */
	private void createSearchFields() {
		ArrayList<UIComponentInfo> properties = gameController.getProperties();

		// Mapping property name to the input field to allow easier identification
// of search items
		HashMap<String, JTextField> searchMap = new HashMap<String, JTextField>();

		int totalRows = gameController.getSearchRowCount();
		Box[] rowBoxes = new Box[totalRows];

		for (UIComponentInfo component : properties) {
			String property = component.getName();
			Integer row = component.getRow();

			Box thisBox = null;
			if (rowBoxes[row] == null) {
				rowBoxes[row] = Box.createHorizontalBox();
			}
			thisBox = rowBoxes[row];

			// Adding the label to the search fields
			JLabel propertyLabel = new JLabel(property);
			thisBox.add(Box.createHorizontalStrut(5));
			thisBox.add(propertyLabel);

			switch (component.getType()) {
			case DROPDOWN:
				JComboBox propertyDropdown = new JComboBox(component.getSelections());
				thisBox.add(Box.createHorizontalStrut(5));
				thisBox.add(propertyDropdown);
//				searchMap.put(property, propertyDropdown);
				break;
			case CHECKBOX:
				JCheckBox propertyCheckbox = new JCheckBox();
				thisBox.add(Box.createHorizontalStrut(5));
				thisBox.add(propertyCheckbox);
//				searchMap.put(property, propertyInput);
				break;
			default:
				JTextField propertyInput = new JTextField();
				thisBox.add(Box.createHorizontalStrut(5));
				thisBox.add(propertyInput);
//				searchMap.put(property, propertyInput);
				break;
			}
// propertyLabel.setLabelFor(propertyInput);
		}

		JButton searchButton = new JButton("Search");
		JButton clearButton = new JButton("Clear");

		searchButton.addActionListener(createSearchListener(searchMap));
		clearButton.addActionListener(createClearListener(searchMap));

		for (int i = 0; i < rowBoxes.length; ++i) {
			Box thisBox = rowBoxes[i];
			if (i == rowBoxes.length - 1) {
				thisBox.add(Box.createHorizontalStrut(5));
				thisBox.add(searchButton);
				thisBox.add(Box.createHorizontalStrut(5));
				thisBox.add(clearButton);
			}
			thisBox.add(Box.createHorizontalStrut(5));
			searchBox.add(Box.createVerticalStrut(5));
			searchBox.add(thisBox);
		}
		searchBox.add(Box.createVerticalStrut(5));
	}

	private ActionListener createClearListener(HashMap<String, JTextField> searchMap) {
		final HashMap<String, JTextField> clearSearchMap = searchMap;

		ActionListener clearListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				queryMap = new HashMap<String, String>();

				Iterator<String> searchKeys = clearSearchMap.keySet().iterator();
				while (searchKeys.hasNext()) {
					String searchKey = searchKeys.next();
					JTextField thisField = clearSearchMap.get(searchKey);
					thisField.setText("");
				}
			}
		};

		return clearListener;
	}

	private ActionListener createSearchListener(HashMap<String, JTextField> searchMap) {
		final HashMap<String, JTextField> submitedSearchMap = searchMap;

		ActionListener searchListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				queryMap = new HashMap<String, String>();

				Iterator<String> searchKeys = submitedSearchMap.keySet().iterator();
				while (searchKeys.hasNext()) {
					String searchKey = searchKeys.next();
					queryMap.put(searchKey, submitedSearchMap.get(searchKey).getText());
				}
			}
		};

		return searchListener;
	}

	/**
	 * @return a map of fields to match for card search
	 */
	private HashMap<String, String> createSearchQuery() {
		// TODO Auto-generated method stub
		return queryMap;
	}

	/**
	 * Display the card information of the selected card
	 * 
	 * @param referenceCard selected card object from either the list or the image
	 *          view
	 */
	private void createCardInfo(Card referenceCard) {
		// TODO Get the card detail pane from the controller
		detailBox = gameController.getDetailedView(referenceCard);
		detailBox.setPreferredSize(new Dimension(width / 2, (int) (height * 0.7)));
		detailBox.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Card Info"), null));
	}

	/**
	 * Display the card list of the search result
	 */
	private void createListView() {
		// TODO get full list view from controller
		JScrollPane resultScrollTable = gameController.getQueryListView(createSearchQuery());
		listBox.setPreferredSize(new Dimension(width / 2, (int) (height * 0.7)));

		listBox.add(new JLabel("Result count: "));

		listBox.add(resultScrollTable);
		listBox.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Search Result"), null));
	}

	/**
	 * Display the cards currently in deck
	 */
	private void createDeckBoxView() {
		// TODO Auto-generated method stub
		deckBox = gameController.getDeckListView();
		deckBox.setPreferredSize(new Dimension(width, (int) (height * 0.3)));
		deckBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Deck"),
				null));
	}

	/**
	 * Display the card image pane of the search result TODO TBD
	 */
	private void createImageIcons() {
		JPanel panel = new JPanel();
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Box.LEFT_ALIGNMENT);
		Box vbox = Box.createVerticalBox();
		vbox.setAlignmentX(Box.LEFT_ALIGNMENT);

		int filteredResultCount = gameController.getResultList().size();

		if (filteredResultCount > MAX_RESULT_SHOWN) {
		} else {
			for (int i = 0; i < filteredResultCount; i++) {
				if (i % RESULT_PER_LINE == 0 && i > 0) {
					vbox.add(box);
					box = Box.createHorizontalBox();
					box.setAlignmentX(Box.LEFT_ALIGNMENT);
				}
			}
			vbox.add(box);

			panel.add(vbox);
		}
		JScrollPane imageScroll = new JScrollPane(panel);
		imageScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		imageBox.add(imageScroll);
	}

	/**
	 * Create and display the deck builder
	 */
	private void init() {
		createSearchFields();
// createImageIcons();
		createListView();
		createDeckBoxView();
		createCardInfo(selectedCard);

		contentBody = new JTabbedPane();
		contentBody.add("List View", listBox);
// contentBody.add("Image View", imageBox);

		BorderLayout layout = new BorderLayout();
		getContentPane().setLayout(layout);

		add(BorderLayout.NORTH, searchBox);
		add(BorderLayout.WEST, detailBox);
		add(BorderLayout.EAST, listBox);
		add(BorderLayout.SOUTH, deckBox);

		pack();

		setResizable(false);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeckBuilder builder = new DeckBuilder();
		builder.init();

		builder.setDefaultCloseOperation(EXIT_ON_CLOSE);
		builder.setLocationRelativeTo(null);
		builder.setVisible(true);
	}
}
