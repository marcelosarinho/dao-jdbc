package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("=== TEST 1: department findById =====");
        Department dep = departmentDao.findById(1);

        System.out.println(dep);
        System.out.println();

        System.out.println("=== TEST 2: department findAll =====");
        List<Department> deps = departmentDao.findAll();

        for (Department d: deps) {
            System.out.println(d);
        }

        System.out.println();

        System.out.println("=== TEST 3: seller insert =====");
        Department department = new Department(null, "Arts");
        departmentDao.insert(department);
        System.out.println("Inserted! New id = " + department.getId());

        System.out.println();

        System.out.println("=== TEST 4: department update =====");
        department = departmentDao.findById(1);
        department.setName("Games");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("=== TEST 5: department deleteById =====");
        System.out.println("Enter id for delete test:");
        int id = sc.nextInt();

        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
