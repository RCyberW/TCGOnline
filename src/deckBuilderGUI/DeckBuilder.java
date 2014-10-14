package deckBuilderGUI;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

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

	/* Builder GUI */
	private Box searchBox;
	private JScrollPane imageBox;
	private JScrollPane listBox;
	private Box detailBox;

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
		imageBox = new JScrollPane();
		listBox = new JScrollPane();
		detailBox = Box.createVerticalBox();

		gameController = createGameControllerMap();

		setTitle(cardGameType);
		setSize(width, height);
		setResizable(false);
	}

	public Controller createGameControllerMap() {
		gameControllerMap = new HashMap<String, Controller>();
		gameControllerMap.put("Weiss Schwarz", new WeissSchwarzController());

//		InputStream fileInput;
//		ObjectInputStream objectInput;
//
//		try {
//			System.out.println("Opening data");
//			fileInput = getClass().getResourceAsStream("/resources/GameControllers");
//			objectInput = new ObjectInputStream(fileInput);
//
//			gameControllerMap = (HashMap<String, Controller>) objectInput
//					.readObject();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

		gameController = gameControllerMap.get(cardGameType);
		if (gameController == null)
			return gameControllerMap.get("Weiss Schwarz");
		else
			return gameController;
	}

	/**
	 * Create search fields for the specific game
	 */
	private void createSearchFields() {
		Iterator<String> properties = gameController.getProperties().keySet()
				.iterator();

		int totalRows = gameController.getSearchRowCount();
		Box[] rowBoxes = new Box[totalRows];

		while (properties.hasNext()) {
			String property = properties.next();
			Integer row = gameController.getProperties().get(property);

			Box thisBox = null;
			if (rowBoxes[row] == null) {
				rowBoxes[row] = Box.createHorizontalBox();
			}
			thisBox = rowBoxes[row];

			JLabel propertyLabel = new JLabel(property);
			JTextField propertyInput = new JTextField();
			propertyLabel.setLabelFor(propertyInput);

			thisBox.add(Box.createHorizontalStrut(5));
			thisBox.add(propertyLabel);
			thisBox.add(propertyInput);
			
			System.out.printf("Creating search field for element %s at row %d\n", property, row);
		}

		for (int i = 0; i < rowBoxes.length; ++i) {
			searchBox.add(rowBoxes[i]);
		}
	}

	private String createSearchQuery() {
		// TODO Auto-generated method stub
		return null;
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
	}

	/**
	 * Display the card list of the search result
	 */
	private void createListView() {
		// TODO get full list view from controller
		listBox = gameController.getQueryListView(createSearchQuery());
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
		imageBox = new JScrollPane(panel);
		imageBox
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

	/**
	 * Create and display the deck builder
	 */
	private void init() {
		createSearchFields();
		createImageIcons();
		createListView();
		createCardInfo(selectedCard);

		contentBody = new JTabbedPane();
		contentBody.add("List View", listBox);
// contentBody.add("Image View", imageBox);

		add(searchBox);
		add(listBox);
		add(detailBox);
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
