package com.kedzier.spring.feature;

import com.kedzier.spring.feature.caching.CachingApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CachingApp.class)
public class SpringFeaturesApplicationTests {

	@Test
	public void contextLoads() {
	}

}
