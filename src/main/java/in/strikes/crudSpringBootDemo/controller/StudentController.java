package in.strikes.crudSpringBootDemo.controller;

import ch.qos.logback.classic.boolex.StubEventEvaluator;
import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// restcontroller k andrr , component v aata h or ye specl h kuki ye btata h ki ye incoming request ko hit kregA
//incoming http request ko handle kregi and response return kregi
@RequestMapping("/api/students")
// request mapping take the url to hits this class
public class StudentController {


    private StudentService studentService;

  public  StudentController(StudentService studentService){
      this.studentService=studentService;
  }




    // create student
    @PostMapping("/create")
    // postmapping btatta h end point kon sa end krna h
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
      // requestbody annotation json k incoming response objeeect k andar map kr dega

       Student craetedStudent = studentService.createStudent(student);

       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(craetedStudent);
    }







    //read student
    @GetMapping("/get")
    //getmapping bta rha h ki hme get krnah
    public ResponseEntity<Student> getStudent( @RequestParam Long id){
      //pathvariale se mai bta rha hu jomujhe id milegi wo path variable higi
        // @PathVariable URL se value nikalta hai.
        Student studentResp=studentService.getStudent(id);

        if(studentResp==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(studentResp);

        return ResponseEntity.ok(studentResp);

    }






    //readall
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }






    // update student
    @PutMapping("/update")
    public ResponseEntity<Student>  updateStudent(@RequestParam Long id, @RequestBody Student studentReq){
      Student studentResp = studentService.updateStudent(id,studentReq);

      if(studentResp==null){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(studentResp);
    }





    // delete student
    @DeleteMapping("/delete")
    public ResponseEntity<String> deletestudent(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("record deleted");
    }


    @PatchMapping("/delete-soft")
    // koi ek column ka key ko change krne k liye use krte h
    public ResponseEntity<String> deletestudentsoftly(@RequestParam Long id){
        Boolean isdeleted = studentService.deleteStudentSoftly(id);

        if(!isdeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("record deleted");
    }
}


// postman ki baad ki layer ye bs handle krega post ki request
// handle http request
// forward to student service