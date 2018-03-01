package com.hzh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzh.dao.UserMapper;
import com.hzh.index.User;
import com.hzh.mq.EsConverter;
import com.hzh.mq.MsgPojo;
import com.hzh.service.UserService;
import com.hzh.util.ActionType;
import com.hzh.util.Strings;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private JmsTemplate jmsTemplate;


	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAllUser(Map<String, Object> params) {
		return userMapper.findByDataTable(params);
	}

	@Override
	public Long count() {
		return userMapper.count();
	}

	@Override
	public Long findUserCountByParam(Map<String, Object> params) {
		return userMapper.findUserCountByParam(params);
	}

	@Override
	public User findUserByName(String username) {
		return userMapper.findUserByName(username);
	}

	@Override
	public void saveNewUser(User user) {
		user.setFullpinyin(Strings.toPinyiin(user.getUserName()));
		userMapper.saveNewUser(user);
		sendMsgToElasticSearch(ActionType.add, Long.valueOf(user.getId()));
	}


	@Override
	public User findUserByid(Long id) {
		return userMapper.findUserByid(id);
	}

	@Override
	public void delUserById(Long id) {
		userMapper.delUserById(id);
		sendMsgToElasticSearch(ActionType.delete, id);
	
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
		sendMsgToElasticSearch(ActionType.update, Long.valueOf(user.getId()));
	}

	public void sendMsgToElasticSearch(ActionType type, Long id) {
		jmsTemplate.setMessageConverter(new EsConverter());
		jmsTemplate.convertAndSend(new MsgPojo(type, id));
	}

}
