package deckBuilderGUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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

public class DeckBuilder extends JFrame {

	/* Reference objects */
	private Card referenceCard;
	private ArrayList<Card> allCards;
	private ArrayList<Card> filteredCards;

	/* Builder GUI */
	private Box searchBox;
	private JScrollPane imageBox;
	private JScrollPane listBox;
	private Box detailBox;

	private JTabbedPane contentBody;

	/* Final variables */
	final private int height = 600;
	final private int width = (int) (height * 16 / 9);

	/**
	 * 
	 */
	private static final long serialVersionUID = 5447979137960563144L;
	private static final int MAX_RESULT_SHOWN = 500;
	private static final int RESULT_PER_LINE = 10;

	public DeckBuilder() {
		super("Some sort of deck builder");

		searchBox = Box.createVerticalBox();
		imageBox = new JScrollPane();
		listBox = new JScrollPane();
		detailBox = Box.createVerticalBox();

		allCards = new ArrayList<Card>();
		filteredCards = new ArrayList<Card>();

		deserialize();

		if (allCards != null && allCards.size() > 0) {
			referenceCard = allCards.get(0);
		} else {
			referenceCard = new Card("SAMPLE_CARD");
			filteredCards.add(referenceCard);
		}

		setSize(width, height);
		setResizable(false);
	}

	/**
	 * De-serialize card list data to be used for reference
	 */
	private void deserialize() {
		// TODO Auto-generated method stub
		filteredCards = allCards;
	}

	/**
	 * Create search fields for the specific game
	 */
	private void createSearchFields() {
		Iterator<String> properties = referenceCard.getProperties().keySet()
				.iterator();

		while (properties.hasNext()) {
			String property = properties.next();

			JLabel propertyLabel = new JLabel(property);
			JTextField propertyInput = new JTextField();
			propertyLabel.setLabelFor(propertyInput);

			searchBox.add(Box.createHorizontalStrut(5));
			searchBox.add(propertyLabel);
			searchBox.add(propertyInput);
		}
	}

	/**
	 * Display the card information of the selected card
	 * 
	 * @param referenceCard
	 *            selected card object from either the list or the image view
	 */
	private void createCardInfo(Card referenceCard) {
		// TODO Auto-generated method stub

	}

	/**
	 * Display the card list of the search result
	 */
	private void createListView() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Display the card image pane of the search result
	 */
	private void createImageIcons() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Box.LEFT_ALIGNMENT);
		Box vbox = Box.createVerticalBox();
		vbox.setAlignmentX(Box.LEFT_ALIGNMENT);

		if (filteredCards.size() > MAX_RESULT_SHOWN) {
		} else {
			for (int i = 0; i < filteredCards.size(); i++) {
				if (i % RESULT_PER_LINE == 0 && i > 0) {
					vbox.add(box);
					box = Box.createHorizontalBox();
					box.setAlignmentX(Box.LEFT_ALIGNMENT);
				}
				/*
				final Card thisCard = filteredCards.get(i);
				JLabel tempLab = thisCard.grabImage();
				MouseListener listener = new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {

						referenceCard = thisCard;
						System.out.println("selected " + referenceCard);

						if ((e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1)
								|| (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3)) {
							referenceCard = thisCard;
						}
					}
				};

				tempLab.addMouseListener(listener);
				box.add(tempLab);
				*/

			}
			vbox.add(box);

			panel.add(vbox);
		}
		imageBox = new JScrollPane(panel);
		imageBox.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

	/**
	 * Create and display the deck builder
	 */
	private void init() {
		createSearchFields();
		createImageIcons();
		createListView();
		createCardInfo(referenceCard);

		contentBody = new JTabbedPane();
		contentBody.add("List View", listBox);
		contentBody.add("Image View", imageBox);
		
		add(searchBox);
		add(contentBody);
		add(detailBox);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckBuilder builder = new DeckBuilder();
		builder.init();

		builder.setDefaultCloseOperation(EXIT_ON_CLOSE);
		builder.setLocationRelativeTo(null);
		builder.setVisible(true);
	}

}
