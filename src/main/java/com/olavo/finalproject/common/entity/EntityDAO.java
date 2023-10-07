package com.olavo.finalproject.common.entity;

import com.olavo.finalproject.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EntityDAO {

    protected final Connection connection = new Connect().connectBD();

    protected PreparedStatement pstm;

    protected ResultSet rs;

}
