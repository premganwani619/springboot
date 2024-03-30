package com.dailycodebuffer.springboot.tutorial;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTutorialApplicationTests {


}
//every application should have and should do the unit testing for all the functionality of that application
//Integration test -> for entire application for entire end to end flow
//unit testing for particular layer/component or functionality, apis
//for that we will use junit 5 and mockito libraries

//---Mocking---
//we can see that beans and data are mocked for unit testing
//ex we are testing controller layer and this layer is calling the service layer(functionalities of service layer) as well
//So we mock the department service object by @Mockbean
//We are testing controller layer, so we do not care about how service layer is working and how data is returning
//So we can mock those things
//like whenever there is a call for service layer return me this thing
//simplests way of unit testing is to create test files for all layers

//we should do unit testing for all scenerios