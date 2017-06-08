package com.greatbank.transactionprocessor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sinto
 *
 */
public class TaskExecutorImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TaskExecutor exe = new TaskExecutorImpl();
		exe.execute();
		String envVar = System.getenv("TRANSACTION_PROCESSING");
		File directory = new File(envVar+"\\reports");
		assertTrue(directory.exists());
		File[] files = directory.listFiles();
		assertNotNull(files);
	}
}
