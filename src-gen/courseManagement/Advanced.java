/**
 */
package courseManagement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advanced</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link courseManagement.Advanced#getPrereqs <em>Prereqs</em>}</li>
 * </ul>
 *
 * @see courseManagement.CourseManagementPackage#getAdvanced()
 * @model
 * @generated
 */
public interface Advanced extends Course {
	/**
	 * Returns the value of the '<em><b>Prereqs</b></em>' reference list.
	 * The list contents are of type {@link courseManagement.Course}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prereqs</em>' reference list.
	 * @see courseManagement.CourseManagementPackage#getAdvanced_Prereqs()
	 * @model required="true"
	 * @generated
	 */
	EList<Course> getPrereqs();

} // Advanced
