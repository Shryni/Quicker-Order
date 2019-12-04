package com.nci.cad.quickerorder;

//import com.nci.cad.quickerorder.service.XMyTopic;
//import com.nci.cad.quickerorder.service.XMyTopic;
//import com.nci.cad.quickerorder.service.XMyTopicSubscriber;
import com.nci.cad.quickerorder.utils.Observer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


@SpringBootApplication
@EntityScan(basePackageClasses = {
		QuickerOrderApplication.class,
		Jsr310JpaConverters.class
})
public class QuickerOrderApplication  {
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}


	public static void main(String[] args) {
		SpringApplication.run(QuickerOrderApplication.class, args);
	}

//	public static void main(String[] args) {
//		XMyTopic topic = new XMyTopic();
//
//		Observer ob1 = new XMyTopicSubscriber("Obj1");
//		Observer ob2 = new XMyTopicSubscriber("Obj3");
//		Observer ob3 = new XMyTopicSubscriber("Obj3");
//
//		topic.register(ob1);
//		topic.register(ob2);
//		topic.register(ob3);
//
//		ob1.setSubject(topic);
//		ob2.setSubject(topic);
//		ob3.setSubject(topic);
//
//		ob1.update();
//
//		topic.postMessage("Hello");
//	}
}