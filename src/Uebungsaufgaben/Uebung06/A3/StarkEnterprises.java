package Uebungsaufgaben.Uebung06.A3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Implementieren Sie eine Java-Klasse StarkEnterprises, welche bei der Ausführung der Test-Klasse folgende
Ausgabe erzeugt:
Jarvis[2]: Jarvis[2] Suit[0]
Pepper[1]: Finances[3]
Tony[0]: Jarvis[1] Suit[0]

Sie dürfen dazu drei Exceptions und zwei Comparator-Klassen implementieren, dürfen sonst aber ausschließlich
Klassen und Interfaces des JDK verwenden, beispielsweise die aus der Vorlesung bekannten
Typen. Insbesondere dürfen Sie keine Klassen Person oder Project anlegen.

Denken Sie daran, die toString-Methode zu überschreiben, um die Ausgabe der Mitarbeiter (alphabetisch
sortiert) mit ihren Projekten (ebenfalls alphabetisch sortiert) zu ermöglichen. Geben Sie bei den Mit-
arbeitern und Projekten auch immer die ID in [] mit an, damit Einträge mit gleichem Namen unterschieden
werden können.

Hinweis 1: Einer Comparator-Implementierung können Sie (z.B. im Konstruktor) zusätzliche Informationen
übergeben, die für einen Vergleich nötig sind.
Hinweis 2: Die Klasse String implementiert das Comparable<String>-Interface.
Hinweis 3: Beachten Sie beim Sortieren, dass nur die IDs, nicht aber die Namen eindeutig sind.
 */

public class StarkEnterprises implements Company {
	
	// Attribute
	
	private Map<Integer, String> employee = new HashMap<>();	// employeeID -> employeeName
    private Map<Integer, String> projects = new HashMap<>();	// projectID -> projectName

    private Map<Integer, Set<Integer>> employeeProjects = new HashMap<>();		// employeeID -> Projekte
    private Map<Integer, Set<Integer>> projectEmployees = new HashMap<>();		// projectID -> Mitarbeiter

    //
    // Operationen
    //

	public void addEmployee(int id, String inName) throws DuplicateIdException {
		if ( employee.containsKey(id) ) {
			throw new DuplicateIdException("Employee bereits vorhanden");
		}
		employee.put(id, inName);
		employeeProjects.put(id, new HashSet<>() );
	};
	

	public String getEmployeeName(int id) {
    	if ( !employee.containsKey(id))	return null;
    	return employee.get(id);
    };

    
	public void addProject(int id, String inName) throws DuplicateIdException {
    	if ( projects.containsKey(id) ) {
    		throw new DuplicateIdException("Project bereits vorhanden");
    	}
    	projects.put(id, inName);
    	projectEmployees.put(id, new HashSet<>() );
    };


	public String getProjectName(int id) {
    	if ( !projects.containsKey(id))	return null;
    	return projects.get(id);
    };

 //   private Map<Integer, Set<Integer>> employeeProjects = new HashMap<>();		// employeeID -> Projekte
 //   private Map<Integer, Set<Integer>> projectEmployees = new HashMap<>();		// projectID -> Mitarbeiter

    public void assignEmployeeToProject(int employeeId, int projectId) throws UnknownIdException {
		if ( !employee.containsKey(employeeId) )
			throw new UnknownIdException("EmployeeID ist ungueltig");
    	if ( !projects.containsKey(projectId) )
    		throw new UnknownIdException("ProjectID ist ungueltig");
    	// employeeProjects, projectEmployees haben garantiert Eintraege fuer Mitarbeiter/Projekte (s.o)
    	Set<Integer> projSet = employeeProjects.get(employeeId);
    	projSet.add(projectId);
    	//
    	Set<Integer> emplSet = projectEmployees.get(projectId);
    	emplSet.add(employeeId);
   };


    public void removeEmployeeFromProject(int employeeId, int projectId) throws UnknownIdException {
		if ( !employee.containsKey(employeeId) )
			throw new UnknownIdException("EmployeeID ist ungueltig");
    	if ( !projects.containsKey(projectId) )
    		throw new UnknownIdException("ProjectID ist ungueltig");
    	// employeeProjects, projectEmployees haben garantiert Eintraege fuer Mitarbeiter/Projekte (s.o)
    	Set<Integer> projSet = employeeProjects.get(employeeId);
    	projSet.remove(projectId);
    	//
    	Set<Integer> emplSet = projectEmployees.get(projectId);
    	emplSet.remove(employeeId);
    };


    public Collection<Integer> getEmployees() {
    	return sortMapEntries(new ArrayList<>(employee.entrySet()));
    };
        
    public Collection<Integer> getProjectsForEmployee(int employeeId) throws UnknownIdException {
		if ( !employee.containsKey(employeeId) )
			throw new UnknownIdException("EmployeeID ist ungueltig");
    	Set<Integer> projSet = employeeProjects.get(employeeId);
    	//
    	ArrayList<Map.Entry<Integer,String>> entryList = new ArrayList<>();
    	for ( Map.Entry<Integer,String> e : projects.entrySet() ) {
    		if ( projSet.contains(e.getKey()) ) {
    			entryList.add(e);
    		};
    	}
    	return sortMapEntries(entryList);
    };
       
    public String toString() {
    	String outString = "";
    	for ( Integer employeeId : getEmployees() ) {
    		String empString = getEmployeeName(employeeId) + "[" + employeeId + "]:";
    		try {
    			for ( Integer projectId : getProjectsForEmployee(employeeId) ) {
    				empString += " " + getProjectName(projectId) + "[" + projectId + "]";
    			}
    		} catch (UnknownIdException e){
    			System.out.println("Kann nicht vorkommen");
    		}
    		outString += empString + "\n";
    	}
    	return outString;
    }
    
    //
    // privat
    //
    
    private Collection<Integer> sortMapEntries( ArrayList<Map.Entry<Integer,String>> entryList ) {
    	entryList.sort( new EntryComparator() );
    	ArrayList<Integer> entryIds = new ArrayList<>();
    	for ( Map.Entry<Integer,String> e : entryList ) {
    		entryIds.add(e.getKey());
    	}
    	return entryIds;
    };



}

