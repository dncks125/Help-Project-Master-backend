package com.shincom.graduation_project_backend_server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResultVO {
    private int result;
    private String msg;

    public ResultVO() {
    }

    public ResultVO(int result, String msg) {
        this.result = result;
        this.msg = msg;
    }



}
