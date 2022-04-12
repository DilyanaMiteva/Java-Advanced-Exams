package Openning_03;


import java.util.ArrayList;
import java.util.List;

public class Bakery {

    public String name;
    public int capacity;
    public List<Employee> employees;

    public String getName() {

        return name;
    }

    public int getCapacity() {

        return capacity;
    }

    public List<Employee> getEmployees() {

        return employees;
    }

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Bakery(List<Employee> employees) {

        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if(this.employees.size() + 1 <= this.capacity){
            this.employees.add(employee);
        }
    }

    public boolean remove(String name){

        return this.employees.removeIf(e->e.getName().equals(name));
    }
    public Employee getOldestEmployee(){
        return this.employees.stream().min((a,b)->Integer.compare(b.getAge(),a.getAge())).orElse(null);
    }
    public Employee getEmployee(String name){
        return this.employees.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){

        return this.employees.size();
    }
    public String report(){
        StringBuilder output = new StringBuilder(String.format("Employees working at Bakery %s:",getName()));
        this.employees.forEach(e->output.append(System.lineSeparator()).append(e));
        return output.toString();
    }
}