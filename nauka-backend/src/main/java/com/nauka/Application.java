package com.nauka;

import com.nauka.db.entity.Department;
import com.nauka.db.entity.Employee;
import com.nauka.db.entity.Report;
import com.nauka.db.service.DepartmentService;
import com.nauka.db.service.EmployeeService;
import com.nauka.db.service.ReportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(DepartmentService departmentService, EmployeeService employeeService,
                                        ReportService reportService) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                Employee employee1 = new Employee(
                        "Ivanov","Ivan","Ivanovich","Director",12345
                );
                Employee employee2 = new Employee(
                        "Andreev","Andrey","Andreevich","President",54321
                );

                Employee employee3 = new Employee(
                        "Test","Test","Test","test",1
                );

                Employee employee4 = new Employee(
                        "Nikitin","Nikita", "Nikitovich", "Worker", 43191
                );

                Employee employee5 = new Employee(
                        "Vasin","Vasya","Vasilevich","Secretary",32153
                );


                Department department1 = new Department("IT");
                Department department2 = new Department("Marketing");

                employee1.setDepartment(department1);
                employee2.setDepartment(department1);
                employee3.setDepartment(department1);
                employee4.setDepartment(department2);
                employee5.setDepartment(department2);

                departmentService.createDepartment(department1);
                departmentService.createDepartment(department2);

                employeeService.createEmployee(employee1);
                employeeService.createEmployee(employee2);
                employeeService.createEmployee(employee3);
                employeeService.createEmployee(employee4);
                employeeService.createEmployee(employee5);
                List<Employee> employees = new ArrayList<>();
                employees.add(employee1);
                employees.add(employee2);
                employees.add(employee3);
                employees.add(employee4);
                employees.add(employee5);

                Calendar calendar = new GregorianCalendar(2020,00,01);
                String[] datesOfHolidays = new String[] {
                        "2020-01-01", "2020-01-02","2020-01-03", "2020-01-06", "2020-01-07",
                        "2020-01-08","2020-02-24","2020-03-09","2020-05-04","2020-05-05","2020-05-11", "2020-06-12",
                        "2020-11-04"
                };
                String[] statusHolidays = new String[] {"В","Р_В"};
                String[] statusOtherDays = new String[] {"Р", "Н", "Б"};
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("EEEE");
                int leapYear = 366;
                int noLeapYear = 365;
                String status;
                Random random = new Random();
                for (Employee employee: employees) {
                    for (int i = 0; i < 152; i++) {
                        int rand = random.nextInt(100);
                        if (rand <= 20) {
                            status = statusOtherDays[1];
                        } else if (rand >= 80) {
                            status = statusOtherDays[2];
                        } else status = statusOtherDays[0];

                        for (String date : datesOfHolidays) {
                            if (dateFormat1.format(calendar.getTime()).equals(date)) {
                                if (random.nextInt(10) >= 3) {
                                    status = statusHolidays[0];
                                } else {
                                    status = statusHolidays[1];
                                }
                            }
                        }
                        if (dateFormat2.format(calendar.getTime()).equals("суббота") || dateFormat2.format(
                                calendar.getTime()).equals("воскресенье")) {
                            if (random.nextInt(10) >= 3) {
                                status = statusHolidays[0];
                            } else {
                                status = statusHolidays[1];
                            }
                        }

                        reportService.createReport(
                                new Report(Date.valueOf(dateFormat1.format(calendar.getTime())), status, employee)
                        );
                        calendar.add(Calendar.DAY_OF_MONTH, 1);
                    }
                    calendar.setTime(Date.valueOf("2020-01-01"));
                }
            }
        };
    }
}

