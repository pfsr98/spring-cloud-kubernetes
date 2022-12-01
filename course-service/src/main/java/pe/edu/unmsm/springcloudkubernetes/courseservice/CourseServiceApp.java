package pe.edu.unmsm.springcloudkubernetes.courseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CourseServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApp.class, args);
    }
}