package ATM.Services;

import ATM.Views.Card;

import java.util.List;

public class CardReaderService {
    List<Card> cards;
    public void getAllCardsDetails() {
        //query from db and assign it to cards
    }
    Card cardReader(Card cardDetails) {
        for(int i=0;i<cards.size();i++) {
            if(cards.get(i)==cardDetails) {
                return cards.get(i);
            }
        }
        return null;
    }
}
