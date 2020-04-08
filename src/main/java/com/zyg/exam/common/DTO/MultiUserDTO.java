package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiUserDTO {

    private String username;

    private String password;

    private String name;

    private String tel;

    private String role;

    private String classname;
}
