package com.example.demo.src.user;


import com.example.demo.src.membership.model.Membership;
import com.example.demo.src.membership.model.UserMembership;
import com.example.demo.src.user.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private JdbcTemplate jdbcTemplate;


    //JdbcTemplate 이 null 아니려면 아래 필수 
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private final EntityManager em;


    @Transactional
    public PostMembershipRes postMembership(User user, Membership membership) {
        UserMembership userMembership = new UserMembership(user, membership);
        em.persist(userMembership);
        return new PostMembershipRes(userMembership.getUserMembershipIdx());
    }

    public GetUserRes getUser(int userIdx){
        User u = em.createQuery("select u from User u where u.userIdx = :idx", User.class)
                .setParameter("idx", userIdx)
                .getSingleResult();
        return new GetUserRes(u.getUserIdx(), u.getEmail(), u.getPasswd());

    }
    public User getUserById(int userIdx) {
        User user =  em.createQuery("select u from User u where u.userIdx = :idx", User.class)
                .setParameter("idx", userIdx)
                .getSingleResult();
        return user;
    }

    //jpa 에서는 select exists 지원 X -> JDBC로
    public int checkEmail(String email){
        String checkEmailQuery = "select exists(select email from user where email = ?)";
        String checkEmailParams = email;
        return this.jdbcTemplate.queryForObject(checkEmailQuery,
                int.class,
                checkEmailParams);

    }

    public int saveUser(User user) {
        em.persist(user);
        return user.getUserIdx();
    }

    public User getPwd(String email){
        String getPwdQuery = "select u from User u where u.email = :email";
        return em.createQuery(getPwdQuery, User.class)
                        .setParameter("email", email)
                        .getSingleResult();
    }

    public int modifyUserName(PatchUserReq patchUserReq){
        String modifyUserNameQuery = "update User u set u.email = :email where u.userIdx = :userIdx";
        return em.createQuery(modifyUserNameQuery)
                .setParameter("email",patchUserReq.getEmail())
                .setParameter("userIdx", patchUserReq.getUserIdx())
                .executeUpdate();
    }

    public int modifyUserPwd(PatchUserPwd patchUserPwd) {
        return em.createQuery("update User u set u.passwd = :newPwd where u.userIdx = :userIdx")
                .setParameter("newPwd", patchUserPwd.getNewPwd())
                .setParameter("userIdx", patchUserPwd.getUserIdx())
                .executeUpdate();
    }




    /*


    public List<GetUserRes> getUsers(){
        String getUsersQuery = "select * from UserInfo";
        return this.jdbcTemplate.query(getUsersQuery,
                (rs,rowNum) -> new GetUserRes(
                        rs.getInt()
                        rs.getInt("userIdx"),
                        rs.getString("userName"),
                        rs.getString("ID"),
                        rs.getString("Email"),
                        rs.getString("password"))
                );
    }


    public List<GetUserRes> getUsersByEmail(String email){
        String getUsersByEmailQuery = "select * from UserInfo where email =?";
        String getUsersByEmailParams = email;
        return this.jdbcTemplate.query(getUsersByEmailQuery,
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("userName"),
                        rs.getString("ID"),
                        rs.getString("Email"),
                        rs.getString("password")),
                getUsersByEmailParams);
    }

    public GetUserRes getUser(int userIdx){
        String getUserQuery = "select * from UserInfo where userIdx = ?";
        int getUserParams = userIdx;
        return this.jdbcTemplate.queryForObject(getUserQuery,
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("userName"),
                        rs.getString("ID"),
                        rs.getString("Email"),
                        rs.getString("password")),
                getUserParams);
    }



    public int createUser(PostUserReq postUserReq){
        String createUserQuery = "insert into UserInfo (userName, ID, password, email) VALUES (?,?,?,?)";
        Object[] createUserParams = new Object[]{postUserReq.getUserName(), postUserReq.getId(), postUserReq.getPassword(), postUserReq.getEmail()};
        this.jdbcTemplate.update(createUserQuery, createUserParams);

        String lastInserIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInserIdQuery,int.class);
    }

    public int checkEmail(String email){
        String checkEmailQuery = "select exists(select email from UserInfo where email = ?)";
        String checkEmailParams = email;
        return this.jdbcTemplate.queryForObject(checkEmailQuery,
                int.class,
                checkEmailParams);

    }

    public int modifyUserName(PatchUserReq patchUserReq){
        String modifyUserNameQuery = "update UserInfo set userName = ? where userIdx = ? ";
        Object[] modifyUserNameParams = new Object[]{patchUserReq.getUserName(), patchUserReq.getUserIdx()};

        return this.jdbcTemplate.update(modifyUserNameQuery,modifyUserNameParams);
    }

    public User getPwd(PostLoginReq postLoginReq){
        String getPwdQuery = "select userIdx, password,email,userName,ID from UserInfo where ID = ?";
        String getPwdParams = postLoginReq.getId();

        return this.jdbcTemplate.queryForObject(getPwdQuery,
                (rs,rowNum)-> new User(
                        rs.getInt("userIdx"),
                        rs.getString("ID"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getString("email")
                ),
                getPwdParams
                );

    }*/


}
