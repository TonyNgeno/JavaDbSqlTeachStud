import com.tony.ngeno.Result;
import com.tony.ngeno.Student;
import com.tony.ngeno.Subject;
import com.tony.ngeno.Teacher;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ResultTest {
    private Result result;

    @Before
    public void setUp() {
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        Subject subject = new Subject("Maths", new Teacher("Yobra one"));
        subject.setScore(50);
        subjects.add(subject);
        Subject subject1 = new Subject("Science", new Teacher("Kimathi Nut"));
        subject1.setScore(56);
        subjects.add(subject1);
        Subject subject2 = new Subject("Physics", new Teacher("Mister Cap"));
        subject2.setScore(87);
        subjects.add(subject2);
        result = new Result(
                new Student("Tony", "78/020"),
                subjects
        );
    }

    @Test
    public void testGetTotal() {
        assertEquals(193, result.getTotal());
    }

    @Test
    public void  testGetAverage() {
        assertEquals(64.0, result.getAverage(), 0);
    }

    @Test
    public void  testGetSize() {
        assertEquals(3, result.getSize());
    }

    @Ignore
    @Test
    public void  testGetResult() {
    }

    @Test
    public  void  testGetRemarks(){
        assertEquals("Passed",result.getRemarks());
    }

}