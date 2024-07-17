package courseManagement.utils;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import courseManagement.Advanced;
import courseManagement.CourseManagementFactory;
import courseManagement.CourseSet;
import courseManagement.Evaluation;
import courseManagement.Introductory;
import courseManagement.Program;
import courseManagement.Result;
import courseManagement.Student;

import java.util.List;

@SuppressWarnings("serial")
public class EMFObjectFactory extends DefaultObjectFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T create(Class<T> type) {
        if (type.equals(Student.class)) {
            return (T) CourseManagementFactory.eINSTANCE.createStudent();
        } else if (type.equals(Introductory.class)) {
            return (T) CourseManagementFactory.eINSTANCE.createIntroductory();
        } else if (type.equals(Advanced.class)) {
            return (T) CourseManagementFactory.eINSTANCE.createAdvanced();
        } else if (type.equals(Result.class)) {
            return (T) CourseManagementFactory.eINSTANCE.createResult();
        } else if (type.equals(Evaluation.class)) {
            return (T) CourseManagementFactory.eINSTANCE.createEvaluation();
        } else if (type.equals(Program.class)) {
            return (T) CourseManagementFactory.eINSTANCE.createProgram();
        } else if (type.equals(CourseSet.class)) {
            return (T) CourseManagementFactory.eINSTANCE.createCourseSet();
        }
        return super.create(type);
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        if (EList.class.isAssignableFrom(type)) {
            return (T) new BasicEList<>();
        }
        return super.create(type, constructorArgTypes, constructorArgs);
    }
}
