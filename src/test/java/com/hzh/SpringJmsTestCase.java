package com.hzh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzh.service.EsUserService;

/**
 * Created by 123 on 2017/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:applicationContext-dubbo-consumer.xml" })
public class SpringJmsTestCase {

	@Autowired
	private EsUserService esUserService;

    @Test
	public void sendMessageToQueue() {

		System.out.println(esUserService.loadPieData().size());
    }



}


