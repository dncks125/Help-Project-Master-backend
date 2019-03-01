package com.shincom.graduation_project_backend_server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProjectVO {
    private Integer project_no;
    private String title;
    private String description;
    private String master;
    private String created;
    private boolean edit;
    private String member;
    private String sday;
    private String eday;

}
