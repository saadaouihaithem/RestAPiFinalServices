package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    PhoneRepository phoneRepository;

}
