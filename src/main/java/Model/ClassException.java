package Model;
import java.util.List;

public class ClassException extends Exception {
    public ClassException() {
        super("So lop dat toi gioi han!");
    }

    public void check(List<Class> c) throws ClassException {
        if (c.size() > 10) {
            throw new ClassException();
        }
    }
}

class SubjectException extends Exception{
    public SubjectException(){
        super("So mon dat toi gioi han");
    }
    
    public void check(List<MonHoc> c) throws SubjectException {
        if (c.size() > 5) {
            throw new SubjectException();
        }
    }
}
