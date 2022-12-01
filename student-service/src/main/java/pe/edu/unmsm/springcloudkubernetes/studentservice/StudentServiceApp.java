package pe.edu.unmsm.springcloudkubernetes.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StudentServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApp.class, args);
    }
}