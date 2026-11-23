package com.example.demo1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;


@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
    private EntityManager em;
    @Bean
    CommandLineRunner run(StudentRepository studentRepository){


        class Student1 {
            public void addStuudent(String name, int age, String email) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaRush");
                EntityManager entityManager = emf.createEntityManager();
                Student student1 = new Student("Milek", 17, "milek@gmail.com");

                try {
                    entityManager.getTransaction().begin();
                    entityManager.persist(student1);
                    entityManager.flush();

                    entityManager.getTransaction().commit();


                } catch (Exception e) {
                    entityManager.getTransaction().rollback();
                } finally {
                    entityManager.close();
                }

            }

        }
        return args -> {

            Student student1 = new Student("Ivan",18, "ivan@gmail.com");
            Student student2 = new Student("Kolja",17 , "kolja@gmail.com");
            Student student3 = new Student("Sasha",18, "sasha@gmail.com");



            System.out.println(student1.toString());
            System.out.println(student2.toString());
            System.out.println(student3.toString());

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);



            Student student = studentRepository.findById(1L).orElseThrow();

            student1.setEmail("ivan32@gmail.com");

            studentRepository.save(student1);



            Student studentt = studentRepository.findById(1L).orElseThrow();



            studentRepository.save(studentt);




            Student studenttt = studentRepository.findById(1L).orElseThrow();



            studentRepository.save(studenttt);

            studentRepository.delete(studenttt);





            System.out.println("5. Students by name:");

            studentRepository.findByNameStartingWith("A")
                    .forEach(System.out::println);









        };







        }

    }


