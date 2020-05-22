package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportUser {
    private String username;
    private String password;
    private String name;
    private String role;
    private String classname;
    private String tel;
}
