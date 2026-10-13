package in.strikes.crudSpringBootDemo.repository;

import in.strikes.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
//iske andar component hota h ,ye hme spring framework ko btata h ye repository class h just like service
public interface StudentRepository extends JpaRepository<Student,Long> {


    Optional<Student> findByIdAndDeletedIsFalse(Long id);

   List<Student> findByDeletedIsFalse();



}

// interact to db