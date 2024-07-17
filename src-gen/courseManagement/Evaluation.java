/**
 */
package courseManagement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link courseManagement.Evaluation#getCourse <em>Course</em>}</li>
 *   <li>{@link courseManagement.Evaluation#getStudent <em>Student</em>}</li>
 *   <li>{@link courseManagement.Evaluation#getValue <em>Value</em>}</li>
 *   <li>{@link courseManagement.Evaluation#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see courseManagement.CourseManagementPackage#getEvaluation()
 * @model
 * @generated
 */
public interface Evaluation extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Course</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Course</em>' reference.
	 * @see #setCourse(Course)
	 * @see courseManagement.CourseManagementPackage#getEvaluation_Course()
	 * @model required="true"
	 * @generated
	 */
	Course getCourse();

	/**
	 * Sets the value of the '{@link courseManagement.Evaluation#getCourse <em>Course</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Course</em>' reference.
	 * @see #getCourse()
	 * @generated
	 */
	void setCourse(Course value);

	/**
	 * Returns the value of the '<em><b>Student</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Student</em>' reference.
	 * @see #setStudent(Student)
	 * @see courseManagement.CourseManagementPackage#getEvaluation_Student()
	 * @model required="true"
	 * @generated
	 */
	Student getStudent();

	/**
	 * Sets the value of the '{@link courseManagement.Evaluation#getStudent <em>Student</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Student</em>' reference.
	 * @see #getStudent()
	 * @generated
	 */
	void setStudent(Student value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"A"</code>.
	 * The literals are from the enumeration {@link courseManagement.Grade}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see courseManagement.Grade
	 * @see #setValue(Grade)
	 * @see courseManagement.CourseManagementPackage#getEvaluation_Value()
	 * @model default="A" required="true"
	 * @generated
	 */
	Grade getValue();

	/**
	 * Sets the value of the '{@link courseManagement.Evaluation#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see courseManagement.Grade
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Grade value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see courseManagement.CourseManagementPackage#getEvaluation_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link courseManagement.Evaluation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

} // Evaluation
