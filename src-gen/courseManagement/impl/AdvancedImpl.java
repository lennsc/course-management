/**
 */
package courseManagement.impl;

import courseManagement.Advanced;
import courseManagement.Course;
import courseManagement.CourseManagementPackage;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advanced</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link courseManagement.impl.AdvancedImpl#getPrereqs <em>Prereqs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdvancedImpl extends CourseImpl implements Advanced {
	/**
	 * The cached value of the '{@link #getPrereqs() <em>Prereqs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrereqs()
	 * @generated
	 * @ordered
	 */
	protected EList<Course> prereqs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdvancedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CourseManagementPackage.Literals.ADVANCED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Course> getPrereqs() {
		if (prereqs == null) {
			prereqs = new EObjectResolvingEList<Course>(Course.class, this, CourseManagementPackage.ADVANCED__PREREQS);
		}
		return prereqs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CourseManagementPackage.ADVANCED__PREREQS:
			return getPrereqs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CourseManagementPackage.ADVANCED__PREREQS:
			getPrereqs().clear();
			getPrereqs().addAll((Collection<? extends Course>) newValue);
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
		case CourseManagementPackage.ADVANCED__PREREQS:
			getPrereqs().clear();
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
		case CourseManagementPackage.ADVANCED__PREREQS:
			return prereqs != null && !prereqs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AdvancedImpl
