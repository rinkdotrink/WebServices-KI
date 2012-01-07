package de.ki.server.learn.cal2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import de.ki.PropertyAndConcept;
import de.ki.server.learn.Learner;

public class DecisionTree
   implements Learner {

   private DecisionTree root;
   private int propertyIndex = -1;
   private List<DecisionTree> nexts = new ArrayList<DecisionTree>();
   private List<Integer> values = new ArrayList<Integer>();
   private String concept = "?";
   private boolean isLeaf = true;
   private PropertyAndConcept propAndCon;
   private static List<PropertyAndConcept> propAndContHistory =
      new ArrayList<PropertyAndConcept>();

   public DecisionTree() {
      this.root = this;
   }

   public DecisionTree(final DecisionTree aRoot, final int aPropertyIndex) {
      this.root = aRoot;
      this.propertyIndex = aPropertyIndex;
   }

   public DecisionTree classify(final DecisionTree aDecTree,
                                final PropertyAndConcept aPropAndCon) {
      final int NODE_NOT_FOUND = -1;
      this.propAndCon = aPropAndCon;
      if (aDecTree.isLeaf) {
         return aDecTree;
      }
      int nextIndex = getNextIndex(aDecTree);
      if (nextIndex == NODE_NOT_FOUND) {
         return getNewEmptyLeaf(aDecTree, getProperty(aDecTree));
      } else {
         return classify(aDecTree.getNexts().get(nextIndex), aPropAndCon);
      }
   }

   private int getNextIndex(final DecisionTree aDecTree) {
      Integer property = getProperty(aDecTree);
      List<Integer> values = aDecTree.getValues();
      int nextIndex = values.indexOf(property);
      return nextIndex;
   }

   private Integer getProperty(final DecisionTree aDecTree) {
      Vector<Integer> properties = propAndCon.getProperty();
      Integer property = properties.get(aDecTree.getPropertyIndex());
      return property;
   }

   private DecisionTree getNewEmptyLeaf(final DecisionTree aParent,
                                        final Integer aProperty) {
      Integer propertyIndexParent = aParent.getPropertyIndex();
      DecisionTree decTree = new DecisionTree(root, propertyIndexParent);
      decTree.setConcept("?");
      decTree.setLeaf(true);
      aParent.nexts.add(decTree);
      aParent.values.add(new Integer(aProperty));
      return decTree;
   }

   private void doCal2(final PropertyAndConcept aPropAndCon) {
      int index = 0;
      propAndContHistory.add(aPropAndCon);
      System.out.println(aPropAndCon.getProperty() + aPropAndCon.getConcept());
      while (index < propAndContHistory.size()) {
         boolean readFromTheBeginning = doCal2Internal(aPropAndCon);
         if (readFromTheBeginning) {
            index = 0;
         }
         index++;
      }
   }

   private boolean doCal2Internal(final PropertyAndConcept aPropAndCon) {
      DecisionTree leaf;
      String classifiedConcept;
      boolean readFromTheBeginning = false;

      leaf = classify(root, aPropAndCon);
      classifiedConcept = leaf.getConcept();
      if (classifiedConcept.equals("?")) {
         doConceptUnknown(aPropAndCon);
      } else if (classifiedConcept.equals(aPropAndCon.getConcept())) {
         // everything is fine;
      } else if (!classifiedConcept.equals(aPropAndCon.getConcept())) {
         readFromTheBeginning =
            readFromTheBeginningConceptNotMatches(aPropAndCon);
      }
      return readFromTheBeginning;
   }

   private boolean readFromTheBeginningConceptNotMatches(final PropertyAndConcept aPropAndCon) {
      boolean readFromTheBeginning = false;
      DecisionTree decisionTree = doConceptDoNotMatches(aPropAndCon);
      if (decisionTree == null) {
         readFromTheBeginning = false;
      } else {
         readFromTheBeginning = true;
      }
      return readFromTheBeginning;
   }

   public DecisionTree doConceptDoNotMatches(final PropertyAndConcept aPropAndCon) {
      DecisionTree emptyLeaf = classify(root, aPropAndCon);
      DecisionTree node = transformLeafToNode(emptyLeaf);
      if (node != null) {
         createDecisionTreeConceptLeaf(node);
      }
      return node;
   }

   private DecisionTree transformLeafToNode(final DecisionTree aEmptyLeaf) {
      Vector<Integer> properties = propAndCon.getProperty();
      if (aEmptyLeaf.propertyIndex < properties.size()) {
         Integer property = properties.get(aEmptyLeaf.propertyIndex);
         aEmptyLeaf.values.add(property);
         aEmptyLeaf.concept = "node";
         aEmptyLeaf.isLeaf = false;
         root.isLeaf = false;
      } else {
         // zu wenig Merkmale, um neues Konzept hinzuzufügen.
         // Das alte Konzept bleibt bestehen, das neue wird verworfen
         return null;
      }
      return aEmptyLeaf;
   }

   private void createDecisionTreeConceptLeaf(final DecisionTree aEmptyLeaf) {
      DecisionTree conceptLeaf = new DecisionTree(root, propertyIndex);
      conceptLeaf.setConcept(propAndCon.getConcept());
      conceptLeaf.setLeaf(true);
      conceptLeaf.setPropertyIndex(aEmptyLeaf.getPropertyIndex() + 1);
      aEmptyLeaf.nexts.add(conceptLeaf);
   }

   public void doConceptUnknown(final PropertyAndConcept aPropAndCon) {
      this.propAndCon = aPropAndCon;
      DecisionTree emptyLeaf = classify(root, aPropAndCon);
      Integer propertyIndex = emptyLeaf.getPropertyIndex();
      emptyLeaf.setPropertyIndex(propertyIndex + 1);
      emptyLeaf.setConcept(aPropAndCon.getConcept());
   }

   public DecisionTree getRoot() {
      return root;
   }

   public void setRoot(final DecisionTree aRoot) {
      this.root = aRoot;
   }

   public int getPropertyIndex() {
      return propertyIndex;
   }

   public void setPropertyIndex(final int aPropertyIndex) {
      this.propertyIndex = aPropertyIndex;
   }

   public List<DecisionTree> getNexts() {
      return nexts;
   }

   public void setNexts(final List<DecisionTree> aNexts) {
      this.nexts = aNexts;
   }

   public List<Integer> getValues() {
      return values;
   }

   public void setValues(final List<Integer> aValues) {
      this.values = aValues;
   }

   public String getConcept() {
      return concept;
   }

   public void setConcept(final String aConcept) {
      this.concept = aConcept;
   }

   public boolean isLeaf() {
      return isLeaf;
   }

   public void setLeaf(final boolean isLeaf) {
      this.isLeaf = isLeaf;
   }

   public PropertyAndConcept getPropertyVectorAndConcept() {
      return propAndCon;
   }

   public void setPropertyAndConcept(final PropertyAndConcept aPropertyVectorAndConcept) {
      this.propAndCon = aPropertyVectorAndConcept;
   }

   public String classify(final PropertyAndConcept aPropAndConcept) {
      DecisionTree decisionTree = classify(root, aPropAndConcept);
      return decisionTree.getConcept();
   }

   public void learn(final PropertyAndConcept aPropAndCon) {
      doCal2(aPropAndCon);
   }
}
