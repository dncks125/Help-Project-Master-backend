package com.shincom.graduation_project_backend_server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LikeVO {
    private Integer id;
    private boolean like;
    private boolean unlike;
    private Integer feed_no;
    private Integer user_id;

}
