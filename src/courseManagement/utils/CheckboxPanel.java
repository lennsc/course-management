package courseManagement.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import courseManagement.Identifiable;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CheckboxPanel<T extends Identifiable> extends JPanel {

	private List<T> options;
	private Set<Integer> selectedOptionsIdSet;
	private Set<Integer> preselectedOptionsIdSet;
	private Function<T, String> labelProviderFunction;

	/**
	 * Create a managed list of checkboxes.
	 * 
	 * @param options               Options to be displayed in the panel
	 * @param labelProviderFunction
	 */
	public CheckboxPanel(List<T> options, Function<T, String> labelProviderFunction) {
		this(options, new ArrayList<>(), labelProviderFunction);
	}

	/**
	 * Create a managed list of checkboxes.
	 * 
	 * @param options               Options to be displayed in the panel
	 * @param preselectedOptions    Initially selected options
	 * @param labelProviderFunction
	 */
	public CheckboxPanel(List<T> options, List<T> preselectedOptions, Function<T, String> labelProviderFunction) {
		this.options = new ArrayList<>(options);
		this.selectedOptionsIdSet = new HashSet<>();
		this.preselectedOptionsIdSet = new HashSet<>();
		this.labelProviderFunction = labelProviderFunction;

		for (T option : preselectedOptions) {
			preselectedOptionsIdSet.add(option.getId());
			selectedOptionsIdSet.add(option.getId());
		}

		setLayout(new MigLayout("insets 0"));
		renderCheckboxes();
	}

	/**
	 * Get current selected options.
	 * 
	 * @return List of options
	 */
	public List<T> getSelectedOptions() {
		List<T> selectedOptions = new ArrayList<>();

		for (T option : options) {
			if (selectedOptionsIdSet.contains(option.getId())) {
				selectedOptions.add(option);
			}
		}
		
		return selectedOptions;
	}

	private void renderCheckboxes() {
		for (T option : options) {
			JCheckBox checkBox = new JCheckBox(labelProviderFunction.apply(option));
			checkBox.addActionListener(e -> {
				if (checkBox.isSelected()) {
					this.selectedOptionsIdSet.add(option.getId());
				} else {
					this.selectedOptionsIdSet.remove(option.getId());
				}
			});
			
			if (preselectedOptionsIdSet.contains(option.getId())) {
				checkBox.setSelected(true);
			}
			
			add(checkBox, "wrap");
		}
	}
}
