package dao;

import java.util.List;

import model.Message;


public interface MessageDAO {
    void saveMessage(model.Message message);
    List<Message> getAllMessages();
}
