/**
 */
package courseManagement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Facade</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link courseManagement.ServiceFacade#getResults <em>Results</em>}</li>
 *   <li>{@link courseManagement.ServiceFacade#getStudents <em>Students</em>}</li>
 *   <li>{@link courseManagement.ServiceFacade#getPrograms <em>Programs</em>}</li>
 *   <li>{@link courseManagement.ServiceFacade#getAllCourses <em>All Courses</em>}</li>
 * </ul>
 *
 * @see courseManagement.CourseManagementPackage#getServiceFacade()
 * @model
 * @generated
 */
public interface ServiceFacade extends EObject {
	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link courseManagement.Result}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see courseManagement.CourseManagementPackage#getServiceFacade_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<Result> getResults();

	/**
	 * Returns the value of the '<em><b>Students</b></em>' reference list.
	 * The list contents are of type {@link courseManagement.Student}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Students</em>' reference list.
	 * @see courseManagement.CourseManagementPackage#getServiceFacade_Students()
	 * @model
	 * @generated
	 */
	EList<Student> getStudents();

	/**
	 * Returns the value of the '<em><b>Programs</b></em>' containment reference list.
	 * The list contents are of type {@link courseManagement.Program}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Programs</em>' containment reference list.
	 * @see courseManagement.CourseManagementPackage#getServiceFacade_Programs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Program> getPrograms();

	/**
	 * Returns the value of the '<em><b>All Courses</b></em>' containment reference list.
	 * The list contents are of type {@link courseManagement.Course}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Courses</em>' containment reference list.
	 * @see courseManagement.CourseManagementPackage#getServiceFacade_AllCourses()
	 * @model containment="true"
	 * @generated
	 */
	EList<Course> getAllCourses();

} // ServiceFacade
