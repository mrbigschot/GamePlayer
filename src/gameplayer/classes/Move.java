package gameplayer.classes;

public class Move {

    protected int ri;
    protected int ci;
    protected int rf;
    protected int cf;

    public Move() {
    }

    public Move(int ri, int ci, int rf, int cf) {   //initializing constructor
        this();   // invoke the default constructor
        this.ri = ri;
        this.ci = ci;
        this.rf = rf;
        this.cf = cf;
    }

    public int getRi() {
        return ri;
    }

    public int getCi() {
        return ci;
    }

    public int getRf() {
        return rf;
    }

    public int getCf() {
        return cf;
    }

    public void setRi(int ri) {
        this.ri = ri;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public void setRf(int rf) {
        this.rf = rf;
    }

    public void setCf(int cf) {
        this.cf = cf;
    }

    @Override
    public boolean equals(Object o) {
        Move m = (Move) o;
        return (this.ri == m.getRi() && this.rf == m.getRf() && this.ci == m.getCi() && this.cf == m.getCf());
    }

    @Override
    public String toString() {
        String returnMe = "I am a Move: ";
        returnMe += "\tri=" + getRi();
        returnMe += "\tci=" + getCi();
        returnMe += "\trf=" + getRf();
        returnMe += "\tcf=" + getCf();
        return returnMe;
    }

}
