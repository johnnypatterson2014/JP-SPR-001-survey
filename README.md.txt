# JP-SPR-001-survey


TO-DO:
 - add spring profile for test vs. integration-test
 - add servlet request/response listener
 - add jaccoco unit test coverage report generation
 - add code from InstallCert
 - add code from LoadTest and LoadTestApplication (uses cert when calling https backends)
 - add AEP code from: D:\CCI\2021\2021.08.21 - backup TD laptop\code\processor\txn
       AlertConditionAndValueMatchProcessor
       AlertEventConfigProperties
       application.yml.txt - has config for event matching rules engine
       FisJmsMessage.txt - example of a generated java pojo based on a json schema
       JsonPathWrapper
 
 - add global controller advice for exception handling - @ControllerAdvice BaseControllerAdvice extends ResponseEntityExceptionHandler; @ExceptionHandler
 - add loading config map data from property file
       @Value("${aep.mdp.ump.get.alertsetupnotificationparties.url}")
	   private String umpGetAlertpartiesUrl;
	   
 - add unit test which uses json file as a stub request/response
       
       private ObjectMapper mapper = new ObjectMapper();
       
       @Value("classpath:json/createAlertSubscriptionRequest_001.json")
       Resource createAlertSubscriptionRequest_001;
       
       AlertSubscription alertSubscriptionStub = mapper.readValue(createAlertSubscriptionRequest_001.getFile(), AlertSubscription.class);
       
 - add logging (logback?)
 - add swagger/openapi (springfox-swagger2 ?)
 - add metrics dashboard - use spring actuator? or micrometer?
 
 - add AOP to create and send messages to kafka and/or JMS queue
 
 - add MaskingPatternLayout (see DCA) for common utils
 
 
 ----- example from scheduled/batch AEP
 @SpringBootApplication
 @EnableScheduling
 @EnableJms
 @EnableCircuitBreaker
 
 @Scheduled(cron = "${aep.batch.cron.expression}")
 @Transactional(propagation = Propagation.REQUIRES_NEW)
 
 	private void handleExitLogging(long entryTimeMillis) {
 		long endTimeMillis = System.currentTimeMillis();
    	double elapsedTimeSeconds = (endTimeMillis - entryTimeMillis) / 1000l;
    	entryExitLog.error("Exit for AEP Batch processor. Elapsed processing time is: " + elapsedTimeSeconds + " seconds.");
	}
 
 // manually call a rest api, add an oauth2 token
     	HttpHeaders headers = new HttpHeaders();
    	headers.set("Authorization", "Bearer " + umpOAuthToken);
    	headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    	HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<RetrieveAlertSetupNotificationPartyListRs> response = restTemplate.exchange(umpGetAlertpartiesUrl, HttpMethod.GET, entity, RetrieveAlertSetupNotificationPartyListRs.class,partyTypeCd,internalPartyId);
 
 
 
 
 	<build>
		<pluginManagement>
			<plugins>

			    <plugin>
			        <groupId>org.jacoco</groupId>
			        <artifactId>jacoco-maven-plugin</artifactId>
			        <version>0.8.7</version>
			        <configuration>
					    <excludes>
					        <exclude>com/td/digital/midtier/aep/mdp/txn/jms/model/**/*</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/lce/jms/model/**/*</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/txn/SpringBootAppTxn.class</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/lce/SpringBootAppLce.class</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/types/**/*</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/exception/**/*</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/common/**/*</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/txn/processor/MessagingProviderService.class</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/lce/processor/MessagingProviderService.class</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/**/AepJms*</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/**/JmsMessageConverter*</exclude>
					        <exclude>com/td/digital/midtier/aep/mdp/AepJmsListenerConfig.class</exclude>
					    </excludes>
					</configuration>
			        <executions>
			            <execution>
			                <id>prepare-agent</id>
			                <phase>initialize</phase>
			                <goals>
			                    <goal>prepare-agent</goal>
			                </goals>
			            </execution>
			            <execution>
			                <id>report</id>
			                <goals>
			                    <goal>report-aggregate</goal>
			                </goals>
			                <phase>verify</phase>
			            </execution>
			        </executions>
			    </plugin>

		    </plugins>
		</pluginManagement>
	</build>
 
 
 