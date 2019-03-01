package com.shincom.graduation_project_backend_server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MenuVO {
    private Integer menu_no;
    private String title;
    private String description;
    private String created;

}
