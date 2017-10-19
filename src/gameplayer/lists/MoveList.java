package gameplayer.lists;

import gameplayer.classes.Move;
import java.util.ArrayList;

public class MoveList extends ArrayList<Move> {

    public Move random() {
        return this.get((int) (Math.random() * this.size()));
    }

}
