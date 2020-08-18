package com.incloud.hcp.job;


import com.incloud.hcp.repository.delta.AppParametriaDeltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");



    @Autowired
    private AppParametriaDeltaRepository appParametriaDeltaRepository;






}