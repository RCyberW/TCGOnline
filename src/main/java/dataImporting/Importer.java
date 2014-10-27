package dataImporting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import deckComponents.Card;

/**
 * Import new card data information to create a serialized file that contains
 * all the card data
 * 
 * @author Frank Chen
 * @version 0.1
 * @since 2014-09-01
 */

public class Importer {

  /**
   * Items that will be serialized
   */
  private HashMap<String, Card> binder;

  /**
   * Serialize card data for future use
   */
  public void serialize() {
    FileOutputStream fileOutput;
    ObjectOutputStream objectOutput;
    try {
      fileOutput = new FileOutputStream("src/resources/CardData");
      objectOutput = new ObjectOutputStream(fileOutput);

      objectOutput.writeObject(binder);

      objectOutput.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deserialize() {

  }

}