package characters.player;

import item.IItems;
import java.util.ArrayList;

public class ItemVault {
  private final ArrayList<IItems> itemList = new ArrayList<>();

  public ItemVault() {}

  public ArrayList getItems() {
    return itemList;
  }

  public void addItem(IItems item) {
    itemList.add(item);
  }

  public void useItem(IItems item, AbstractPlayer player) {
    if (itemList.contains(item)) {
      item.applyTo(player);
      itemList.remove(item);
    }
  }
}
