/**
 */
package courseManagement.impl;

import courseManagement.Course;
import courseManagement.CourseManagementPackage;

import courseManagement.CourseType;
import courseManagement.Evaluation;
import courseManagement.Labeled;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Course</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link courseManagement.impl.CourseImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link courseManagement.impl.CourseImpl#getId <em>Id</em>}</li>
 *   <li>{@link courseManagement.impl.CourseImpl#getCourseType <em>Course Type</em>}</li>
 *   <li>{@link courseManagement.impl.CourseImpl#getEvaluation <em>Evaluation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CourseImpl extends MinimalEObjectImpl.Container implements Course {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCourseType() <em>Course Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCourseType()
	 * @generated
	 * @ordered
	 */
	protected static final CourseType COURSE_TYPE_EDEFAULT = CourseType.INTRODUCTORY;

	/**
	 * The cached value of the '{@link #getCourseType() <em>Course Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCourseType()
	 * @generated
	 * @ordered
	 */
	protected CourseType courseType = COURSE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEvaluation() <em>Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluation()
	 * @generated
	 * @ordered
	 */
	protected static final Evaluation EVALUATION_EDEFAULT = Evaluation.ONE;

	/**
	 * The cached value of the '{@link #getEvaluation() <em>Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvaluation()
	 * @generated
	 * @ordered
	 */
	protected Evaluation evaluation = EVALUATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CourseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CourseManagementPackage.Literals.COURSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CourseManagementPackage.COURSE__TITLE, oldTitle,
					title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the value of the title attribute.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getLabel() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CourseManagementPackage.COURSE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CourseType getCourseType() {
		return courseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCourseType(CourseType newCourseType) {
		CourseType oldCourseType = courseType;
		courseType = newCourseType == null ? COURSE_TYPE_EDEFAULT : newCourseType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CourseManagementPackage.COURSE__COURSE_TYPE,
					oldCourseType, courseType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Evaluation getEvaluation() {
		return evaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEvaluation(Evaluation newEvaluation) {
		Evaluation oldEvaluation = evaluation;
		evaluation = newEvaluation == null ? EVALUATION_EDEFAULT : newEvaluation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CourseManagementPackage.COURSE__EVALUATION,
					oldEvaluation, evaluation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isElective() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CourseManagementPackage.COURSE__TITLE:
			return getTitle();
		case CourseManagementPackage.COURSE__ID:
			return getId();
		case CourseManagementPackage.COURSE__COURSE_TYPE:
			return getCourseType();
		case CourseManagementPackage.COURSE__EVALUATION:
			return getEvaluation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CourseManagementPackage.COURSE__TITLE:
			setTitle((String) newValue);
			return;
		case CourseManagementPackage.COURSE__ID:
			setId((Integer) newValue);
			return;
		case CourseManagementPackage.COURSE__COURSE_TYPE:
			setCourseType((CourseType) newValue);
			return;
		case CourseManagementPackage.COURSE__EVALUATION:
			setEvaluation((Evaluation) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CourseManagementPackage.COURSE__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case CourseManagementPackage.COURSE__ID:
			setId(ID_EDEFAULT);
			return;
		case CourseManagementPackage.COURSE__COURSE_TYPE:
			setCourseType(COURSE_TYPE_EDEFAULT);
			return;
		case CourseManagementPackage.COURSE__EVALUATION:
			setEvaluation(EVALUATION_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CourseManagementPackage.COURSE__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
		case CourseManagementPackage.COURSE__ID:
			return id != ID_EDEFAULT;
		case CourseManagementPackage.COURSE__COURSE_TYPE:
			return courseType != COURSE_TYPE_EDEFAULT;
		case CourseManagementPackage.COURSE__EVALUATION:
			return evaluation != EVALUATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Labeled.class) {
			switch (baseOperationID) {
			case CourseManagementPackage.LABELED___GET_LABEL:
				return CourseManagementPackage.COURSE___GET_LABEL;
			default:
				return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case CourseManagementPackage.COURSE___IS_ELECTIVE:
			return isElective();
		case CourseManagementPackage.COURSE___GET_LABEL:
			return getLabel();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (title: ");
		result.append(title);
		result.append(", id: ");
		result.append(id);
		result.append(", courseType: ");
		result.append(courseType);
		result.append(", evaluation: ");
		result.append(evaluation);
		result.append(')');
		return result.toString();
	}

} //CourseImpl
