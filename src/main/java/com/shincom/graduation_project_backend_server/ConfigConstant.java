package com.shincom.graduation_project_backend_server;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@Component
@PropertySource("classpath:application-dev.properties")
public class ConfigConstant {
    @Value("${backend.host}")
    public String backendHost;

    @Value("${front.host}")
    public String frontHost;

    @Value("${root_folder}")
    public String rootFolder;

    @Value("${upload_folder}")
    public String uploadFolder;


}
