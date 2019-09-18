package GameX;

public class Counter {
    private long count;

    void countdown(){
        count--;
    }
    void update(){
        count++;
    }

    void reset(){
        count=0;
    }

    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
}
