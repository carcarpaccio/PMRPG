package GameX;

public class Counter {
    long count;

    public long getCount() {
        return count;
    }

    void update(){
        count++;
    }
    void reset(){
        count=0;
    }
}
