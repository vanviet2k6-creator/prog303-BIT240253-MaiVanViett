import java.util.ArrayList;
import java.util.List;

public class StudentManager<T> {
    private List<T> data;
    
    // Constructor
    public StudentManager() {
        this.data = new ArrayList<>();
    }
    
    // Phương thức thêm đối tượng vào danh sách
    public void add(T item) {
        data.add(item);
    }
    
    // Phương thức trả về toàn bộ danh sách
    public List<T> getAll() {
        return data;
    }
}
