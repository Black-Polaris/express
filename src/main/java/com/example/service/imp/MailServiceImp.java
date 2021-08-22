package com.example.service.imp;

import com.example.entity.Kuaidi;
import com.example.mapper.MailMapper;
import com.example.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImp implements MailService {
    @Autowired
    MailMapper mailMapper;

    @Override
    public void add(Kuaidi kuaidi) {
        mailMapper.add(kuaidi);
    }


}
