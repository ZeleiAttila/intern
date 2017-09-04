package hu.neuron.junior.service.impl.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.junior.client.api.service.message.MessageService;
import hu.neuron.junior.client.api.vo.MessageVo;
import hu.neuron.junior.client.api.vo.UserVo;
import hu.neuron.junior.core.dao.MessageDao;
import hu.neuron.junior.core.entity.Message;
import hu.neuron.junior.core.entity.User;
import hu.neuron.junior.service.mapper.message.MessageVoMapper;
import hu.neuron.junior.service.mapper.user.UserVoMapper;

@Service("messageService")
@Transactional(propagation=Propagation.REQUIRED)
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public List<MessageVo> getMessages(UserVo from, UserVo to) {
		User fromEntity = UserVoMapper.toEntity(from);
		User toEntity = UserVoMapper.toEntity(to);

		List<Message> messages = messageDao.findMessage(fromEntity, toEntity);

		return MessageVoMapper.toVo(messages);
	}

	@Override
	public void saveMessage(MessageVo message) {
		messageDao.save(MessageVoMapper.toEntity(message));

	}

}
