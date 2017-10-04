package com.service;

import com.CommonResp;
import com.aliyuncs.exceptions.ClientException;
import com.dao.MessageDao;
import com.dao.SystemDao;
import com.entity.Message;
import com.util.SmsUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private SystemDao systemDao;

    public void sendMessage(String phone,String signName,String templateCode) throws ClientException {
        JSONObject object = new JSONObject();
        StringBuilder sb = new StringBuilder("");
        Random random = new Random();
        for (int i = 0; i <6 ; i++) {
            int num = random.nextInt(9);
            sb.append(num);
        }
        object.put("sn",sb.toString());

        try {
            SmsUtil.sendSms(object.toString(),phone,signName,templateCode);
            Message message = new Message();
            message.setContent(sb.toString());
            message.setPhone(phone);
//            message.setSystemId(setSystemId);
            message.setTitle("验证码");
            messageDao.save(message);
        } catch (ClientException e) {
//            e.printStackTrace();
            throw e;
        }

    }
    public CommonResp validateCode(String phone,String content){
        Message byPhoneAndContent = messageDao.findByPhoneAndContent(phone, content);

        if(byPhoneAndContent==null){
            return new CommonResp("error","验证码错误");
        }else{
            Calendar calendar = Calendar.getInstance();
            long now = calendar.getTimeInMillis();
            calendar.setTime(byPhoneAndContent.getCreateDate());
            long last = calendar.getTimeInMillis();
            if((now-last)/60000>10) {
                return new CommonResp("error", "验证码超时,请重新获取");
            }else{
                return new CommonResp("success","验证成功");
            }
        }

    }

}
