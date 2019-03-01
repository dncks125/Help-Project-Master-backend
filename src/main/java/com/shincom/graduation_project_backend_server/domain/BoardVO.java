package com.shincom.graduation_project_backend_server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BoardVO {
    private Integer board_no;
    private String title;
    private String contents;
    private String writer;
    private String created;
    private Integer menu;


}
