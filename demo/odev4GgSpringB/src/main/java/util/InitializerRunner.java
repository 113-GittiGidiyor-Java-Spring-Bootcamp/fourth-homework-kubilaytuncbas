package util;
import model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import repository.CourseDao;

public class InitializerRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    CourseDao courseDao;

    @Override
    public void run(String... args) throws Exception {
        courseDao.deleteAll();

        courseDao.save(Course.builder().courseCode("101").courseName("Fizik").creditScore(5).build());
        courseDao.save(Course.builder().courseCode("102").courseName("Matematik").creditScore(6).build());
        courseDao.save(Course.builder().courseCode("103").courseName("Kimya").creditScore(5).build());


        courseDao.findAll().forEach(course -> logger.info("{}", course));

    }
}
