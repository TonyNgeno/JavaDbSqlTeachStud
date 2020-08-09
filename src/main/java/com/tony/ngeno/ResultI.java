package com.tony.ngeno;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ResultI {
    int getTotal();

    double getAverage();

    int getSize();

    String getResult();

    String getRemarks();


    ArrayList<ResultM> viewAll() throws SQLException, ClassNotFoundException;

    Result getResults(String admNo) throws SQLException, ClassNotFoundException;

    boolean addResult(ResultM resultM) throws SQLException, ClassNotFoundException;

    boolean deleteResult(int id) throws SQLException;

    boolean updateResult(int id, ResultM resultM) throws SQLException;

    void clearAll() throws SQLException;
}
