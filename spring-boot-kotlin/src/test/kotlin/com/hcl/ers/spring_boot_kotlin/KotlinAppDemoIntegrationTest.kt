package com.hcl.ers.spring_boot_kotlin

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(
  classes = arrayOf(KotlinAppDemo::class),
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KotlinAppDemoIntegrationTest {

	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
	fun whenCalled_thenShouldReturnHello() {
		val result = testRestTemplate.withBasicAuth("user", "pass")
                .getForEntity("/kotlin", String::class.java)

		assertNotNull(result)
		assertEquals(HttpStatus.OK, result?.statusCode)
		assertEquals("Hello world message from KotlinController program", result?.body)
	}

	@Test
	fun whenCalled_thenShouldReturnHelloService() {
		val result = testRestTemplate.withBasicAuth("user", "pass")
                .getForEntity("/kotlin-service", String::class.java)

		assertNotNull(result)
		assertEquals(HttpStatus.OK, result?.statusCode)
		assertEquals(result?.body, "Service message from KotlinService program")
	}

	@Test
	fun whenCalled_thenShouldReturnJson() {
		val result = testRestTemplate.withBasicAuth("user", "pass")
                .getForEntity("/kotlin-dto", KotlinDTO::class.java)

		assertNotNull(result)
		assertEquals(HttpStatus.OK, result?.statusCode)
		assertEquals(result?.body, KotlinDTO("Hello message from new KotlinDTO instance"))
	}

}