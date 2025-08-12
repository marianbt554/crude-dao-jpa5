package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);


	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}


	private void createStudent(StudentDAO studentDAO) {
		//cream un obiect Student
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Vasile", "Branza", "branza@pixelacademy.md");

		//salvam obiectul Student in baza de date
		System.out.println("Saving student object...");
		studentDAO.save(newStudent);

		//afisam ID-ul studentului salvat
		System.out.println("Saved student. Generated id: " + newStudent.getId());


	}
	private void createMultipleStudents(StudentDAO studentDAO) {
	System.out.println("Creating 3 students...");
	Student newStudent1 = new Student("Andrei", "Munteanu", "andrei@pixelacademy.md");
	Student newStudent2 = new Student("Iulian", "Vataman", "iulic@pixelacademy.md");
	Student newStudent3 = new Student("Maria", "Mirabela", "mira@pixelacademy.md");

	//salvam obiectele student in baza de date
		System.out.println("Saving the students...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

	}

	private void readStudent(StudentDAO studentDAO) {

		//creeaza un obiect de tip student
		System.out.println("Creating new studetn object...");
		Student newStudent = new Student("Mircea", "Popescu","mircea@pixel.academy");

		//salveaza studentul in baza de date
		System.out.println("Saving student object...");
		studentDAO.save(newStudent);
		//afiseaza id-ul studentului
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
		//recupereaza studentul pe baza id-ului
		System.out.println("Retrieving student with id " + theId);
		Student student = studentDAO.findById(theId);
		//afiseza detaliile studentului
		System.out.println("Student found: " + student);
	}


	private void queryForStudents(StudentDAO studentDAO) {
		//obtine lista de studenti
		List<Student> theStudents = studentDAO.findAll();
		//afiseaza lista de studenti
		for (Student newStudent : theStudents) {
			System.out.println(newStudent);
		}
	}


	private void updateStudent(StudentDAO studentDAO) {
		//gasezte studentul in baza de date folosind ID-ul
		int studentID = 1;
		System.out.println("Getting student with ID: " + studentID);
		Student newStudent = studentDAO.findById(studentID);
		//modifica prenumele studentului in ION
		System.out.println("Updating student with ID: " + studentID);
		newStudent.setFirstName("Ion");
		//solveaza modificarile in baza de date
		studentDAO.update(newStudent);
		//afiseaza detaliile studentului actualizat
		System.out.println("Updated student: " +  newStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		System.out.println("Deleting student with ID: " + studentId);
		studentDAO.delete(studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all students. ");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted all students. Number of rows deleted: " + numRowsDeleted);
	}


}
