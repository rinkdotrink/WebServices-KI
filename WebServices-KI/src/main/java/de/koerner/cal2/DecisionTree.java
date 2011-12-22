package de.koerner.cal2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DecisionTree extends LearnerImpl {

	private DecisionTree root;
	private int propertyIndex = -1;
	private List<DecisionTree> nexts = new ArrayList<DecisionTree>();
	private List<Integer> values = new ArrayList<Integer>();
	private String concept = "?";
	private boolean isLeaf = true;
	private PropertyAndConcept propAndCon;
	private static List<PropertyAndConcept> propAndContHistory = new ArrayList<PropertyAndConcept>();

	public DecisionTree() {
		this.root = this;
	}

	public DecisionTree(DecisionTree root, int propertyIndex) {
		this.root = root;
		this.propertyIndex = propertyIndex;
	}

	public DecisionTree classify(DecisionTree decTree,
			PropertyAndConcept propAndCon) {
		final int NODE_NOT_FOUND = -1;
		this.propAndCon = propAndCon;
		if (decTree.isLeaf) {
			return decTree;
		}
		int nextIndex = getNextIndex(decTree);
		if (nextIndex == NODE_NOT_FOUND) {
			return getNewEmptyLeaf(decTree, getProperty(decTree));
		} else {
			return classify(decTree.getNexts().get(nextIndex), propAndCon);
		}
	}

	private int getNextIndex(DecisionTree decTree) {
		Integer property = getProperty(decTree);
		List<Integer> values = decTree.getValues();
		int nextIndex = values.indexOf(property);
		return nextIndex;
	}

	private Integer getProperty(DecisionTree decTree) {
		Vector<Integer> properties = propAndCon.getProperty();
		Integer property = properties.get(decTree.getPropertyIndex());
		return property;
	}

	private DecisionTree getNewEmptyLeaf(DecisionTree parent, Integer property) {
		Integer propertyIndexParent = parent.getPropertyIndex();
		DecisionTree decTree = new DecisionTree(root, propertyIndexParent);
		decTree.setConcept("?");
		decTree.setLeaf(true);
		parent.nexts.add(decTree);
		parent.values.add(new Integer(property));
		return decTree;
	}
	
	private void doCal2(PropertyAndConcept propAndCon) {
		int index = 0;
		propAndContHistory.add(propAndCon);
		System.out.println(propAndCon.getProperty() + propAndCon.getConcept());
		while (index < propAndContHistory.size()) {
			propAndCon = propAndContHistory.get(index);
			boolean readFromTheBeginning = doCal2Internal(propAndCon);
			if (readFromTheBeginning) {
				index = 0;
			}
			index++;
		}
	}

	private boolean doCal2Internal(PropertyAndConcept propAndCon) {
		DecisionTree leaf;
		String classifiedConcept;
		boolean readFromTheBeginning = false;

		leaf = classify(root, propAndCon);
		classifiedConcept = leaf.getConcept();
		if (classifiedConcept.equals("?")) {
			doConceptUnknown(propAndCon);
		} else if (classifiedConcept.equals(propAndCon.getConcept())) {
			// everything is fine;
		} else if (!classifiedConcept.equals(propAndCon.getConcept())) {
			readFromTheBeginning = readFromTheBeginningConceptNotMatches(propAndCon);			
		}
		return readFromTheBeginning;
	}
	
	private boolean readFromTheBeginningConceptNotMatches(PropertyAndConcept propAndCon){
		boolean readFromTheBeginning = false;
		DecisionTree decisionTree = doConceptDoNotMatches(propAndCon);
		if(decisionTree == null){
			readFromTheBeginning = false;
		} else {
			readFromTheBeginning = true;
		}
		return readFromTheBeginning;
	}

	public DecisionTree doConceptDoNotMatches(PropertyAndConcept propAndCon) {
		DecisionTree emptyLeaf = classify(root, propAndCon);
		DecisionTree node = transformLeafToNode(emptyLeaf);
		if (node != null) {
			createDecisionTreeConceptLeaf(node);
		}
		return node;
	}

	private DecisionTree transformLeafToNode(DecisionTree emptyLeaf) {
		Vector<Integer> properties = propAndCon.getProperty();
		if (emptyLeaf.propertyIndex < properties.size()) {
			Integer property = properties.get(emptyLeaf.propertyIndex);
			emptyLeaf.values.add(property);
			emptyLeaf.concept = "node";
			emptyLeaf.isLeaf = false;
			root.isLeaf = false;
		} else {
			// zu wenig Merkmale, um neues Konzept hinzuzufügen.
			// Das alte Konzept bleibt bestehen, das neue wird verworfen
			return null;
		}
		return emptyLeaf;
	}

	private void createDecisionTreeConceptLeaf(DecisionTree emptyLeaf) {
		DecisionTree conceptLeaf = new DecisionTree(root, propertyIndex);
		conceptLeaf.setConcept(propAndCon.getConcept());
		conceptLeaf.setLeaf(true);
		conceptLeaf.setPropertyIndex(emptyLeaf.getPropertyIndex() + 1);
		emptyLeaf.nexts.add(conceptLeaf);
	}

	public void doConceptUnknown(PropertyAndConcept propAndCon) {
		this.propAndCon = propAndCon;
		DecisionTree emptyLeaf = classify(root, propAndCon);
		Integer propertyIndex = emptyLeaf.getPropertyIndex();
		emptyLeaf.setPropertyIndex(propertyIndex + 1);
		emptyLeaf.setConcept(propAndCon.getConcept());
	}

	public DecisionTree getRoot() {
		return root;
	}

	public void setRoot(DecisionTree root) {
		this.root = root;
	}

	public int getPropertyIndex() {
		return propertyIndex;
	}

	public void setPropertyIndex(int propertyIndex) {
		this.propertyIndex = propertyIndex;
	}

	public List<DecisionTree> getNexts() {
		return nexts;
	}

	public void setNexts(List<DecisionTree> nexts) {
		this.nexts = nexts;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public PropertyAndConcept getPropertyVectorAndConcept() {
		return propAndCon;
	}

	public void setPropertyAndConcept(
			PropertyAndConcept propertyVectorAndConcept) {
		this.propAndCon = propertyVectorAndConcept;
	}

	public String classify(PropertyAndConcept propAndConcept) {
		DecisionTree decisionTree = classify(root, propAndConcept);
		return decisionTree.getConcept();
	}

	public void learn(PropertyAndConcept propAndCon) {
		doCal2(propAndCon);
	}
}
