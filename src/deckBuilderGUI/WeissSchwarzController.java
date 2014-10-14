package deckBuilderGUI;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JScrollPane;

import deckComponents.Card;

public class WeissSchwarzController extends Controller {

	public WeissSchwarzController() {
		super();
		createSearchMap();
	}
	
	@Override
	public void deserialize() {
//		InputStream fileInput;
//		ObjectInputStream objectInput;
//
//		try {
//			System.out.println("Opening data");
//			fileInput = getClass().getResourceAsStream("/resources/GameControllers");
//			objectInput = new ObjectInputStream(fileInput);
//
//			ArrayList<Card> resultList = (ArrayList<Card>) objectInput.readObject();
//			this.setResultList(resultList);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public Box getDetailedView(Card referenceCard) {
		// TODO Auto-generated method stub
		Box cardDetailView = Box.createVerticalBox();

		return cardDetailView;
	}

	@Override
	public JScrollPane getQueryListView(String query) {
		// TODO Auto-generated method stub
		JScrollPane scrollListView = new JScrollPane();

		return scrollListView;
	}

	@Override
	public Box getDeckListView(Card referenceCard) {
		// TODO Auto-generated method stub
		Box deckListView = Box.createVerticalBox();

		return deckListView;
	}
	
	public void createSearchMap() {
		HashMap<String, Integer> searchMap = new HashMap<String, Integer>();
		
		searchMap.put("name", 0);
		
		this.setProperties(searchMap);
		this.setSearchRowCount(1);
	}

}
