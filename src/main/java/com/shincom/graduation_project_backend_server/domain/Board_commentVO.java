package com.shincom.graduation_project_backend_server.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Board_commentVO {
    private Integer board_no;
    private Integer comment_no;
    private String contents;
    private Integer parent;
    private String created;
    private String writer;
    private boolean edit;

}
