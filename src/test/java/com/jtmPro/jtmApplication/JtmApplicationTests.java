package com.jtmPro.jtmApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.testcontainers.shaded.org.checkerframework.checker.compilermsgs.qual.CompilerMessageKey;

@SpringBootTest
@Testcontainers
class JtmApplicationTests {
	@Container
static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.4");
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);

	}
	@Test
	void shouldCreateProduct() {
	}

}
