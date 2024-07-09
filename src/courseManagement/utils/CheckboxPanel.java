package courseManagement.utils;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import courseManagement.Labeled;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CheckboxPanel<T extends Labeled> extends JPanel {

	private List<T> selectedOptions;

	/**
	 * Create a managed list of checkboxes.
	 * 
	 * @param options Options to be displayed in the panel
	 */
	public CheckboxPanel(List<T> options) {
		this(options, new ArrayList<>());
	}

	/**
	 * Create a managed list of checkboxes.
	 * 
	 * @param options         Options to be displayed in the panel
	 * @param selectedOptions Initially selected options
	 */
	public CheckboxPanel(List<T> options, List<T> selectedOptions) {
		this.selectedOptions = new ArrayList<>(selectedOptions);
		setLayout(new MigLayout("insets 0"));

		for (T option : options) {
			JCheckBox checkBox = new JCheckBox(option.getLabel());
			checkBox.addActionListener(e -> {
				if (checkBox.isSelected()) {
					this.selectedOptions.add(option);
				} else {
					this.selectedOptions.remove(option);
				}
			});
			add(checkBox, "wrap");
			if (selectedOptions.contains(option)) {
				checkBox.setSelected(true);
			}
		}
	}

	/**
	 * Get current selected options.
	 * 
	 * @return List of options
	 */
	public List<T> getSelectedOptions() {
		return selectedOptions;
	}
}
