package com.webservice.service.testcase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MessageServiceTest.class, MessageTest.class })
public class AllTests {

}
