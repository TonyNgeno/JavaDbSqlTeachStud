import com.tony.ngeno.Teacher;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherTest {

    @Test
    public void  testGetName() {
        Teacher teacher=new Teacher("Tony");
        assertEquals("Tony",teacher.getName());
    }
}