package Uebungsaufgaben.Uebung06.A3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StarkEnterprises implements Company {
    private Map<Integer, String> angestellte = new HashMap<>();
    private Map<Integer, String> projekte = new HashMap<>();

    @Override
    public void addEmployee(int id, String name) throws DuplicateIdException {
        if (angestellte.containsKey(id)) {
            throw new DuplicateIdException("id bereits vorhanden");
        }
        angestellte.put(id, name);
    }

    @Override
    public String getEmployeeName(int id) {
        if (!angestellte.containsKey(id)) return null;
        return angestellte.get(id);
    }

    @Override
    public void addProject(int id, String name) throws DuplicateIdException {
        if (projekte.containsKey(id)) throw new DuplicateIdException("id existiert bereits");
        projekte.put(id, name);

    }

    @Override
    public String getProjectName(int id) {
        if (!projekte.containsKey(id)) return null;
        return projekte.get(id);
    }

    @Override
    public void assignEmployeeToProject(int employeeId, int projectId) throws UnknownIdException {


    }

    @Override
    public void removeEmployeeFromProject(int employeeId, int projectId) throws UnknownIdException {

    }

    @Override
    public Collection<Integer> getEmployees() {
        return null;
    }

    @Override
    public Collection<Integer> getProjectsForEmployee(int employeeId) throws UnknownIdException {
        return null;
    }
}
