package untitled.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import untitled.LikeApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { LikeApplication.class })
public class CucumberSpingConfiguration {}
