/**
 */
package courseManagement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Course</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link courseManagement.Course#getTitle <em>Title</em>}</li>
 *   <li>{@link courseManagement.Course#getId <em>Id</em>}</li>
 *   <li>{@link courseManagement.Course#getCourseType <em>Course Type</em>}</li>
 *   <li>{@link courseManagement.Course#getEvaluation <em>Evaluation</em>}</li>
 * </ul>
 *
 * @see courseManagement.CourseManagementPackage#getCourse()
 * @model abstract="true"
 * @generated
 */
public interface Course extends Identifiable, Labeled {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see courseManagement.CourseManagementPackage#getCourse_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link courseManagement.Course#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getLabel();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see courseManagement.CourseManagementPackage#getCourse_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link courseManagement.Course#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Course Type</b></em>' attribute.
	 * The literals are from the enumeration {@link courseManagement.CourseType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Course Type</em>' attribute.
	 * @see courseManagement.CourseType
	 * @see #setCourseType(CourseType)
	 * @see courseManagement.CourseManagementPackage#getCourse_CourseType()
	 * @model
	 * @generated
	 */
	CourseType getCourseType();

	/**
	 * Sets the value of the '{@link courseManagement.Course#getCourseType <em>Course Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Course Type</em>' attribute.
	 * @see courseManagement.CourseType
	 * @see #getCourseType()
	 * @generated
	 */
	void setCourseType(CourseType value);

	/**
	 * Returns the value of the '<em><b>Evaluation</b></em>' attribute.
	 * The default value is <code>"ONE"</code>.
	 * The literals are from the enumeration {@link courseManagement.Evaluation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluation</em>' attribute.
	 * @see courseManagement.Evaluation
	 * @see #setEvaluation(Evaluation)
	 * @see courseManagement.CourseManagementPackage#getCourse_Evaluation()
	 * @model default="ONE"
	 * @generated
	 */
	Evaluation getEvaluation();

	/**
	 * Sets the value of the '{@link courseManagement.Course#getEvaluation <em>Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation</em>' attribute.
	 * @see courseManagement.Evaluation
	 * @see #getEvaluation()
	 * @generated
	 */
	void setEvaluation(Evaluation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isElective();

} // Course
