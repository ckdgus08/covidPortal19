package com.covidPotar19.Member;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class MemberDAO
{

    private String user_id;
    private String user_password;
    private String user_name;
    private Connection con;
    private ResultSet rs;

    public MemberDAO()
    {
        try
        {
            String dbURL = "jdbc:mysql://localhost:3306/demo_test?characterEncoding=UTF-8&serverTimezone=UTC";
            String dbID = "root";
            String dbPassword = "1004";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 로그인
     * 아이디 없음 : -2
     * 서버오류 : -1
     * 비밀번호 틀림 : 0
     * 성공 : 1
     */
    public int login(String user_id, String user_password)
    {
        try
        {
            PreparedStatement pst = con.prepareStatement("SELECT user_password FROM member WHERE user_id = ?");
            pst.setString(1, user_id);
            rs = pst.executeQuery();
            if (rs.next())
            {
                return rs.getString(1).equals(user_password) ? 1 : 0;
            } else
            {
                return -2;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 중복여부 확인
     */
    public boolean ID_Check(String user_id)
    {
        try
        {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM member WHERE user_id = ?");
            pst.setString(1, user_id);
            rs = pst.executeQuery();
            return !rs.next();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 회원가입
     * 서버오류 : -1
     * 이미 존재하는 아아디 : 0
     * 성공 : 1
     */
    public int join(MemberDAO memberDAO)
    {
        if (!ID_Check(memberDAO.getUser_id()))
        {
            return 0;
        }

        try
        {
            PreparedStatement pst = con.prepareStatement("INSERT INTO member VALUES (?,?,?)");
            pst.setString(1, memberDAO.getUser_id());
            pst.setString(2, memberDAO.getUser_name());
            pst.setString(3, memberDAO.getUser_password());
            return pst.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 유저 데이터 가져오기
     */
    public MemberDAO getUser(String user_id)
    {
        try
        {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM member WHERE user_id = ?");
            pst.setString(1, user_id);
            rs = pst.executeQuery();
            if (rs.next())
            {
                MemberDAO memberDAO = new MemberDAO();
                memberDAO.setUser_id(rs.getString(1));
                memberDAO.setUser_password(rs.getString(2));
                memberDAO.setUser_name(rs.getString(3));

                return memberDAO;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String getUser_id()
    {
        return user_id;
    }

    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }

    public String getUser_password()
    {
        return user_password;
    }

    public void setUser_password(String user_password)
    {
        this.user_password = user_password;
    }

    public String getUser_name()
    {
        return user_name;
    }

    public void setUser_name(String user_name)
    {
        this.user_name = user_name;
    }

    public Connection getCon()
    {
        return con;
    }

    public void setCon(Connection con)
    {
        this.con = con;
    }

    public ResultSet getRs()
    {
        return rs;
    }

    public void setRs(ResultSet rs)
    {
        this.rs = rs;
    }
}
