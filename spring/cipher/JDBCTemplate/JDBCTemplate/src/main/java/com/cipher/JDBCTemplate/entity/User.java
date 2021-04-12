package com.cipher.JDBCTemplate.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer userId;
    String fname;
    String lname;
    String email;

}
