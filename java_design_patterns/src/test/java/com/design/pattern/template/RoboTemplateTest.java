package com.design.pattern.template;

import org.junit.BeforeClass;
import org.junit.Test;

public class RoboTemplateTest {
	private static RoboTemplate rt;

	@BeforeClass
	public static void setUp() {
		rt = new InternetBot("am a internet bot");
	}

	@Test
	public void testInternetBotGoTemplate() {
		rt.goDoWork();
	}
}
