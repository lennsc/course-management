package courseManagement.utils;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import courseManagement.CourseManagementFactory;
import courseManagement.Student;

@SuppressWarnings("serial")
public class EMFObjectFactory extends DefaultObjectFactory {

    @SuppressWarnings("unchecked")
	@Override
    public <T> T create(Class<T> type) {
        if (type.equals(Student.class)) {
            return (T) CourseManagementFactory.eINSTANCE.createStudent();
        }
        return super.create(type);
    }
}
