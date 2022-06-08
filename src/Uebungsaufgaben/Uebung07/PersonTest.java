package uebung07.a3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 *  Aufgbabe 3:
 *  
 *  Gegeben sei folgende Java-Klasse Person, die eine Person mit Vor- und Nachnamen abbildet. Sie speichert
 *	außerdem ein Attribut sortname, das nicht direkt von außen gesetzt wird, sondern das sich aus Nach- und
 *	Vornamen zusammensetzt (Methode updateSortname()).
*/

class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Attribute
	
	private String firstname;
	private String lastname;
	private String sortname;
	
	// Constructoren
	
	public Person() { }
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		updateSortname();
	}
	
	//
	// getter und setter
	//
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
		updateSortname();
	}
	
	//
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
		updateSortname();
	}
	
	//
	
	public String getSortname() {
		return sortname;
	}
	
	public void updateSortname() {
		sortname = lastname + firstname;
	}
	
	// toString Methode
	
	@Override
	public String toString() {
		return firstname + " " + lastname + " (" + sortname + ")";
	}
	
	//
	// Operationen
	//
	
	/*
	 * Verändern Sie die Klasse Person so, dass sich das Testprogramm erfolgreich ausführen lässt. Implementieren
	 *	Sie dazu folgende statische Methoden in der Klasse Person:
	 *
	 * 	Hinweis 1: Beachten Sie dabei, dass der sortname nicht gespeichert werden soll.
	 *	Hinweis 2: Denken Sie daran, dass Sie zur Verwendung des Java-Serialisierungs-Mechanismus die Klasse
	 *	Person um eine Schnittstellen-Implementierung erweitern müssen.
	 *
	 */
	
	public static List<Person> load(String filename) throws IOException {
		// Verwendet die Methode load(...): Person, um eine Liste von Personen aus einer Datei zu lesen.
		List<Person> allPersons = new ArrayList<>();
		DataInputStream in = null;
		try {
			in = new DataInputStream( new BufferedInputStream(
					new FileInputStream(filename) ) );
			while (true) {
				Person person = load(in);
				if ( person == null )		// Dateiende erreicht
					break;
				allPersons.add(person);
			}
		} finally {
			if ( in != null ) {
				in.close();
			}
		}
		return allPersons;
	}
	
	public static Person load(DataInputStream in) throws IOException { 
		// Verwendet einen DataInputStream, um eine Person zu laden.
		try {
			String firstname = in.readUTF();
			String lastname = in.readUTF();
			return new Person(firstname, lastname);
		} catch (EOFException e) {
			return null;
		}
	}
	
	public static void save(String filename, List<Person> list) throws IOException {
		// Verwendet die Methode save(..., Person), um eine Liste von Personen in eine Datei zu schreiben.
		DataOutputStream out = null;
		try {
			out = new DataOutputStream( new BufferedOutputStream(
					new FileOutputStream(filename) ) );
			for ( Person person : list )
				save(out, person);
		} finally {
			if ( out != null )
				out.close();
		}
	}
	
	public static void save(DataOutputStream out, Person person) throws IOException {
		// Verwendet einen DataOutputStream, um eine Person zu speichern.
		out.writeUTF(person.getFirstname() );
		out.writeUTF(person.getLastname() );
	}
	
	public static List<Person> unserialize(String filename) throws IOException, ClassNotFoundException {
		// Verwendet die Java-Serialisierung, um eine Liste von Personen aus einer Datei zu lesen.
		List<Person> allPersons = new ArrayList<>();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream( new BufferedInputStream(
					new FileInputStream(filename) ) );
			while (true) {
				try {
					Person person = (Person) in.readObject();
					allPersons.add(person);
				} catch (EOFException e) {
					break;
				}
			}
		} finally {
			if ( in != null ) {
				in.close();
			}
		}
		return allPersons;
	}
	
	public static void serialize(String filename, List<Person> persons) throws IOException {
		// Verwendet die Java-Serialisierung, um eine Liste von Personen in eine Datei zu schreiben.
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream( new BufferedOutputStream(
					new FileOutputStream(filename) ) );
			for ( Person person : persons )
				out.writeObject(person);
		} finally {
			if ( out != null )
				out.close();
		}
	}
	
}

/*
 * Gegeben sei außerdem eine Test-Klasse PersonTest, welche eine Liste von Personen anlegt, in einer Datei
 *	speichert und wieder ausliest.
 */

public class PersonTest {
	
	/*
	 * Das Programm soll folgende Ausgabe erzeugen:
	 *	[Willy Wonka (WonkaWilly), Charlie Bucket (BucketCharlie), Grandpa Joe (JoeGrandpa)]
	 *	[Willy Wonka (WonkaWilly), Charlie Bucket (BucketCharlie), Grandpa Joe (JoeGrandpa)]
	 *	[Willy Wonka (WonkaWilly), Charlie Bucket (BucketCharlie), Grandpa Joe (JoeGrandpa)]
	 */

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Willy", "Wonka"));
		persons.add(new Person("Charlie", "Bucket"));
		persons.add(new Person("Grandpa", "Joe"));
		System.out.println(persons);
		//
		Person.save("persons.sav", persons);
		persons = Person.load("persons.sav");
		System.out.println(persons);
		//
		Person.serialize("persons.ser", persons);
		persons = Person.unserialize("persons.ser");
		System.out.println(persons);
	}

}
