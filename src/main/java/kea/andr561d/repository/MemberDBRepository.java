package kea.andr561d.repository;

import kea.andr561d.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDBRepository implements IMemberRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    SqlRowSet sqlRowSet;

    @Override
    public boolean create(Member m) {
        String email = m.getEmail();
        String password = m.getPassword();
        String sql = "INSERT INTO member (email, password) VALUES ('" + email + "','" + password + "')";
        jdbcTemplate.execute(sql);
        return true;
    }

    @Override
    public Member read(String email) {
        String sql = "SELECT * FROM member WHERE email = '" + email + "'";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        if (sqlRowSet.next()) {
            return new Member(sqlRowSet.getString("email"), sqlRowSet.getString("password"));
        }
        return null;
    }

    @Override
    public List<Member> readAll() {
        String sql = "SELECT * FROM member";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        List<Member> tmp = new ArrayList<>();
        while (sqlRowSet.next()) {
            tmp.add(new Member(sqlRowSet.getString("email"), sqlRowSet.getString("password")));
        }

        return tmp;
    }
}
