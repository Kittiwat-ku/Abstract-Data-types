import java.util.ArrayList;

/**
 * ADT ที่เก็บค่า Integerที่ไม่ซ่ำกัน
 */
public class IntegerSet {
    ArrayList<Integer> numbers;
    // Rep Invariant (RI):
    // ห้ามตัวเลขซ้ำกัน
    // เลขจะเรียงจากน้อยไปมาก
    // ห้ามเป็นnull
    // AF(numbers) ค่าของ arr ที่มีค่าเป็น Integer

    /**
     * Constructor เริ่มต้น สร้างเซตว่าง
     */
    public IntegerSet() {
        numbers = new ArrayList<>();
        checkRep();

    }

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep() {
        if (numbers == null)
            throw new RuntimeException("numbers");
        if (numbers.size() > 1) {
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) >= numbers.get(i + 1)) {
                    throw new RuntimeException("error sort");
                }
            }
        }
    }

    /**
     * เพื่มตัวเลขลงในset
     * 
     * @param x ค่าที่ต้องการจะเพื่ม
     */
    public void add(Integer x) {
        if (!numbers.contains(x) && numbers != null && x != null) {
            if (numbers.size() == 0) {
                numbers.add(x);
            } else {
                for (int i = 0; i < numbers.size(); i++) {
                    if (x < numbers.get(0)) {
                        numbers.add(0, x);
                        break;
                    }
                    if (i == numbers.size() - 1) {
                        numbers.add(x);
                        break;
                    }
                    if (numbers.get(i) < x && x < numbers.get(i + 1)) {
                        numbers.add(i + 1, x);
                        break;
                    }
                }
            }
        }
        checkRep();
    }

    /**
     * ลบค่าในsetโดยอิงจากx
     * 
     * @param รับค่าที่ต้องจะลบ(x)
     */
    public void remove(Integer x) {
        if (x != null) {
            numbers.remove(x);
        }
    }

    /**
     * เช็คค่าในset
     * 
     * @param x ค่าที่ต้องการจะเช็คในset
     * @return true ถ้ามีค่านั้น / false ถ้าไม่มี
     */
    public boolean contains(Integer x) {
        return numbers.contains(x);
    }

    /**
     * หาขนาดของset
     * 
     * @return ขนาดของset
     */
    public int size() {
        return numbers.size();
    }

    public String toString() {
        return numbers.toString();
    }
}
