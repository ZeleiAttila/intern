package hu.neuron.junior.client.api.service.message;

import java.util.List;

import hu.neuron.junior.client.api.vo.MessageVo;
import hu.neuron.junior.client.api.vo.UserVo;

public interface MessageService {

	
	
	void saveMessage(MessageVo message);

	List<MessageVo> getMessages(UserVo from, UserVo to);

}
