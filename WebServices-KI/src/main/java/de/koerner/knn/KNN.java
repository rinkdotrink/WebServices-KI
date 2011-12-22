package de.koerner.knn;

import de.koerner.cal2.LearnerImpl;
import de.koerner.cal2.PropertyAndConcept;

public class KNN extends LearnerImpl{

	int count;
	Perzeptron perzeptronVorfahrtVonRechts = new Perzeptron("Vorfahrt von Rechts");
	Perzeptron perzeptronVorfahrtGewaehren = new Perzeptron("Vorfahrt gewaehren");
	Perzeptron perzeptronStopp = new Perzeptron("Stop");
	Perzeptron perzeptronFahrtrichtungLinks = new Perzeptron("Fahrtrichtung links");
	Perzeptron perzeptronFahrtrichtungRechts = new Perzeptron("Fahrtrichtung rechts");
	Perzeptron perzeptronVorfahrtsstrasse = new Perzeptron("Vorfahrtsstrasse");
	
	
	
	
	public String classify(PropertyAndConcept propAndCon) {
		String computedConcept = "";
		boolean vorfahrtVonRechts = perzeptronVorfahrtVonRechts.classify(propAndCon);
		boolean vorfahrtGewaehren = perzeptronVorfahrtGewaehren.classify(propAndCon);
		boolean stopp = perzeptronStopp.classify(propAndCon);
		boolean fahrtrichtungLinks = perzeptronFahrtrichtungLinks.classify(propAndCon);
		boolean fahrtrichtungRechts = perzeptronFahrtrichtungRechts.classify(propAndCon);
		boolean vorfahrtsstrasse = perzeptronVorfahrtsstrasse.classify(propAndCon);

		boolean sureVorfahrtVonRechts = vorfahrtVonRechts && !vorfahrtGewaehren && !stopp && !fahrtrichtungLinks && !fahrtrichtungRechts && !vorfahrtsstrasse; 
		boolean sureVorfahrtGewaehren = !vorfahrtVonRechts && vorfahrtGewaehren && !stopp && !fahrtrichtungLinks && !fahrtrichtungRechts && !vorfahrtsstrasse;
		boolean sureStopp = !vorfahrtVonRechts && !vorfahrtGewaehren && stopp && !fahrtrichtungLinks && !fahrtrichtungRechts && !vorfahrtsstrasse;
		boolean sureFahrtrichtungLinks = !vorfahrtVonRechts && !vorfahrtGewaehren && !stopp && fahrtrichtungLinks && !fahrtrichtungRechts && !vorfahrtsstrasse;
		boolean sureFahrtrichtungRechts = !vorfahrtVonRechts && !vorfahrtGewaehren && !stopp && !fahrtrichtungLinks && fahrtrichtungRechts && !vorfahrtsstrasse;
		boolean sureVorfahrtsstrasse = !vorfahrtVonRechts && !vorfahrtGewaehren && !stopp && !fahrtrichtungLinks && !fahrtrichtungRechts && vorfahrtsstrasse;
		
		if(sureVorfahrtVonRechts){
			computedConcept = "Vorfahrt von Rechts";
		} else if(sureVorfahrtGewaehren){
			computedConcept = "Vorfahrt gewaehren";
		} else if(sureStopp) {
			computedConcept = "Stop";
		} else if(sureFahrtrichtungLinks){
			computedConcept = "Fahrtrichtung links";
		} else if(sureFahrtrichtungRechts) {
			computedConcept = "Fahrtrichtung rechts";
		} else if(sureVorfahrtsstrasse) {
			computedConcept = "Vorfahrtsstrasse";
		} else {
			computedConcept = "dont know";
			System.out.println(" vorfahrtVonRechts: " + vorfahrtVonRechts + "vorfahrtGewaehren: " + vorfahrtGewaehren +"stopp: " + stopp + "fahrtrichtungLinks: " + fahrtrichtungLinks + "fahrtrichtungRechts " + fahrtrichtungRechts + "vorfahrtsstrasse " + vorfahrtsstrasse);
		}

		return computedConcept;
	}

	public void learn(PropertyAndConcept propAndCon) {
		doKNNLearnAlgorithmen(propAndCon);
		
	}
	
	public void doKNNLearnAlgorithmen(PropertyAndConcept propAndCon){
		
			perzeptronVorfahrtVonRechts.computePropertyVector(propAndCon);
			perzeptronVorfahrtGewaehren.computePropertyVector(propAndCon);
			perzeptronStopp.computePropertyVector(propAndCon);
			perzeptronFahrtrichtungLinks.computePropertyVector(propAndCon);
			perzeptronFahrtrichtungRechts.computePropertyVector(propAndCon);
			perzeptronVorfahrtsstrasse.computePropertyVector(propAndCon);
	}

	
}


	

