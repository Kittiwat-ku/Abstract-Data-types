import java.util.ArrayList;
/**
 * ADT thats store Integer min to max
 */
public class IntegerSet {
    ArrayList<Integer> number;

    public IntegerSet() {
        number = new ArrayList<>();
        checkRep();

    }

    private void checkRep() {
        if (number == null)
            throw new RuntimeException("number");
        if (number.size() > 1) {
            for (int i = 0; i < number.size() - 1; i++) {
                if (number.get(i) >= number.get(i + 1)) {
                    throw new RuntimeException("error sort");
                }
            }
        }
    }
    public void add(Integer x){
         if (!number.contains(x) && number != null  && x != null) {
            if (number.size()==0) {
                number.add(x);
            } else {
               for(int i=0;i<number.size();i++){
                if (x<number.get(0)) {
                    number.add(0,x);
                    break;
                }
                if (i==number.size()-1) {
                    number.add(x);
                    break;
                }
                if (number.get(i)<x&&x<number.get(i+1)) {
                    number.add(i+1,x);
                    break;
                }
               }
            }
         }
         checkRep();
    }
    public void remove(Integer x){
        if (x!=null) {
            number.remove(x);
        }
    }
    public boolean contains(Integer x){
        return number.contains(x);
    }
    public int size(){
        return number.size();
    }
    public String toString(){
        return number.toString();
    } 
    }
    






