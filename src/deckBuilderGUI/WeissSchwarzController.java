package deckBuilderGUI;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JScrollPane;

import deckBuilderGUI.UIComponentInfo.UIType;
import deckComponents.Card;

public class WeissSchwarzController extends Controller {

	public WeissSchwarzController() {
		super();
		createSearchPositionMap();
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
	public JScrollPane getQueryListView(HashMap<String, String> query) {
		// TODO Auto-generated method stub
		JScrollPane scrollListView = new JScrollPane();

		return scrollListView;
	}

	@Override
	public Box getDeckListView() {
		// TODO Auto-generated method stub
		Box deckListView = Box.createHorizontalBox();

		return deckListView;
	}
	
	public void createSearchPositionMap() {
		ArrayList<UIComponentInfo> componentList = new ArrayList<UIComponentInfo>();
		
		componentList.add(new UIComponentInfo("Card ID", UIType.INPUT, 0, null));
		componentList.add(new UIComponentInfo("Card Name", UIType.INPUT, 0, null));
		componentList.add(new UIComponentInfo("Color", UIType.DROPDOWN, 0, new String[]{"Yellow", "Green", "Red", "Blue"}));
		componentList.add(new UIComponentInfo("Type", UIType.DROPDOWN, 0, new String[]{"Character", "Event", "Climax"}));
		componentList.add(new UIComponentInfo("Trigger", UIType.INPUT, 1, null));
		componentList.add(new UIComponentInfo("Power", UIType.INPUT, 1, null));
		componentList.add(new UIComponentInfo("Cost", UIType.INPUT, 1, null));
		componentList.add(new UIComponentInfo("Soul", UIType.INPUT, 1, null));
		componentList.add(new UIComponentInfo("Level", UIType.INPUT, 1, null));
		componentList.add(new UIComponentInfo("Trait", UIType.INPUT, 1, null));
		componentList.add(new UIComponentInfo("Ability", UIType.INPUT, 2, null));
		
		this.setProperties(componentList);
		this.setSearchRowCount(3);
	}

}
