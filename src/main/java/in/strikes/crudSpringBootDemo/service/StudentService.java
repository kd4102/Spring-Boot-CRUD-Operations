package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// ye ek specialised annotation h jo btata h ki ye service class h but andar se componenet ka hi kaam krta h ,hm yaha pe componenet v use kr skte h
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    yha pe emre kaam hoga end point ko listen krna like example (/app/students post)
// business logic
//    interact with db to store
//    response back to client(postman)

    public Student createStudent(Student studentReq) {
        //business logic
        // store to db

        studentReq.setDeleted(false);

        Student studentResp = studentRepository.save(studentReq);

        return studentResp;


    }


    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);

        if (studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;
    }

// select * from student where id=1 and deleted =false
    // findByIdAnddeletedfalse


    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList;
    }
//select * from students where deleted=false;



    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isEmpty()) {
            return null;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());

        studentToSave.setDeleted(false);
       return studentRepository.save(studentToSave);
    }


    public Boolean deleteStudent(Long id){
      Boolean isStudent =   studentRepository.existsById(id);

      if(!isStudent){
          return false;
      }
      studentRepository.deleteById(id);

      return true;
    }


    public Boolean deleteStudentSoftly(Long id){
        //get
        //delete=1
        //sa ve


        Optional<Student> existingstudent =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if (existingstudent.isEmpty()){
            return false;
        }
       Student studentTosave =  existingstudent.get();

        studentTosave.setDeleted(true);

        studentRepository.save(studentTosave);


        return true;

    }

}
//after student controller
// business logic
//forward to student repository
// manager bw controller and repository
