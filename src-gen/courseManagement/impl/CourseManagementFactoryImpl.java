/**
 */
package courseManagement.impl;

import courseManagement.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CourseManagementFactoryImpl extends EFactoryImpl implements CourseManagementFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CourseManagementFactory init() {
		try {
			CourseManagementFactory theCourseManagementFactory = (CourseManagementFactory) EPackage.Registry.INSTANCE
					.getEFactory(CourseManagementPackage.eNS_URI);
			if (theCourseManagementFactory != null) {
				return theCourseManagementFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CourseManagementFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CourseManagementFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case CourseManagementPackage.SERVICE_FACADE:
			return createServiceFacade();
		case CourseManagementPackage.RESULT:
			return createResult();
		case CourseManagementPackage.STUDENT:
			return createStudent();
		case CourseManagementPackage.PROGRAM:
			return createProgram();
		case CourseManagementPackage.ADVANCED:
			return createAdvanced();
		case CourseManagementPackage.INTRODUCTORY:
			return createIntroductory();
		case CourseManagementPackage.COURSE_SET:
			return createCourseSet();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case CourseManagementPackage.GRADE:
			return createGradeFromString(eDataType, initialValue);
		case CourseManagementPackage.SEMESTER:
			return createSemesterFromString(eDataType, initialValue);
		case CourseManagementPackage.COURSE_TYPE:
			return createCourseTypeFromString(eDataType, initialValue);
		case CourseManagementPackage.EVALUATION:
			return createEvaluationFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case CourseManagementPackage.GRADE:
			return convertGradeToString(eDataType, instanceValue);
		case CourseManagementPackage.SEMESTER:
			return convertSemesterToString(eDataType, instanceValue);
		case CourseManagementPackage.COURSE_TYPE:
			return convertCourseTypeToString(eDataType, instanceValue);
		case CourseManagementPackage.EVALUATION:
			return convertEvaluationToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceFacade createServiceFacade() {
		ServiceFacadeImpl serviceFacade = new ServiceFacadeImpl();
		return serviceFacade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Result createResult() {
		ResultImpl result = new ResultImpl();
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Student createStudent() {
		StudentImpl student = new StudentImpl();
		return student;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Advanced createAdvanced() {
		AdvancedImpl advanced = new AdvancedImpl();
		return advanced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Introductory createIntroductory() {
		IntroductoryImpl introductory = new IntroductoryImpl();
		return introductory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CourseSet createCourseSet() {
		CourseSetImpl courseSet = new CourseSetImpl();
		return courseSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Grade createGradeFromString(EDataType eDataType, String initialValue) {
		Grade result = Grade.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGradeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Semester createSemesterFromString(EDataType eDataType, String initialValue) {
		Semester result = Semester.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSemesterToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CourseType createCourseTypeFromString(EDataType eDataType, String initialValue) {
		CourseType result = CourseType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCourseTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Evaluation createEvaluationFromString(EDataType eDataType, String initialValue) {
		Evaluation result = Evaluation.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEvaluationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CourseManagementPackage getCourseManagementPackage() {
		return (CourseManagementPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CourseManagementPackage getPackage() {
		return CourseManagementPackage.eINSTANCE;
	}

} //CourseManagementFactoryImpl
