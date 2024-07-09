/**
 */
package courseManagement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link courseManagement.Result#getValue <em>Value</em>}</li>
 *   <li>{@link courseManagement.Result#getKey <em>Key</em>}</li>
 *   <li>{@link courseManagement.Result#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see courseManagement.CourseManagementPackage#getResult()
 * @model
 * @generated
 */
public interface Result extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"F"</code>.
	 * The literals are from the enumeration {@link courseManagement.Grade}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see courseManagement.Grade
	 * @see #setValue(Grade)
	 * @see courseManagement.CourseManagementPackage#getResult_Value()
	 * @model default="F" required="true"
	 * @generated
	 */
	Grade getValue();

	/**
	 * Sets the value of the '{@link courseManagement.Result#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see courseManagement.Grade
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Grade value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' reference.
	 * @see #setKey(Course)
	 * @see courseManagement.CourseManagementPackage#getResult_Key()
	 * @model required="true"
	 * @generated
	 */
	Course getKey();

	/**
	 * Sets the value of the '{@link courseManagement.Result#getKey <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(Course value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see courseManagement.CourseManagementPackage#getResult_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link courseManagement.Result#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

} // Result
