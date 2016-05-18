package me.drewhoener.compsci.advanced.maxmemorial;

import java.awt.*;

public class GBConstraints {

	private GridBagConstraints gridBagConstraints;

	public GBConstraints(int gridx, int gridy) {

		this.gridBagConstraints = new GridBagConstraints();
		this.gridBagConstraints.gridx = gridx;
		this.gridBagConstraints.gridy = gridy;
	}

	public GBConstraints gridPos(int gridx, int gridy) {
		this.gridBagConstraints.gridx = gridx;
		this.gridBagConstraints.gridy = gridy;
		return this;
	}

	public GBConstraints gridSize(int gridwidth, int gridheight) {
		this.gridBagConstraints.gridwidth = gridwidth;
		this.gridBagConstraints.gridheight = gridheight;
		return this;
	}

	public GBConstraints fill(int fill) {
		this.gridBagConstraints.fill = fill;
		return this;
	}

	public GBConstraints anchor(int anchor) {
		this.gridBagConstraints.anchor = anchor;
		return this;
	}

	public GBConstraints ipad(int ipadx, int ipady) {
		this.gridBagConstraints.ipadx = ipadx;
		this.gridBagConstraints.ipady = ipady;
		return this;
	}

	public GBConstraints insets(Insets i) {
		this.gridBagConstraints.insets = i;
		return this;
	}

	public GBConstraints weight(double weightx, double weighty) {
		this.gridBagConstraints.weightx = weightx;
		this.gridBagConstraints.weighty = weighty;
		return this;
	}

	public GridBagConstraints create() {
		return this.gridBagConstraints;
	}

}
