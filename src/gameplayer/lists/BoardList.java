package gameplayer.lists;

import gameplayer.classes.Board;
import java.util.ArrayList;

public class BoardList extends ArrayList<Board>{
    
    @Override
    public String toString(){
        String returnMe = "";
        for (Board next : this) {
            returnMe += next.toString() + "\n";
        }
        return returnMe;
    }
    
}
