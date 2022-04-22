package com.example.demowebsocket.controller;

import com.example.demowebsocket.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataOutputStream;
import java.net.Socket;

@RestController
public class SimpleController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/test")
    public Message testMessage(@RequestBody Message message)
    {
        try{
            Socket s= new Socket("localhost",8080);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            s.close();
        }catch (Exception ex)
        {

        }
//        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        return message;
    }
}
