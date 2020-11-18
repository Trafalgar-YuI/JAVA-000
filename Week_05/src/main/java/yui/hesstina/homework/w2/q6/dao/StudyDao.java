package yui.hesstina.homework.w2.q6.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import yui.hesstina.homework.w2.q6.entity.Study;

import java.util.List;

@Repository
public class StudyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Study queryStudyOne(Integer id) {
        String sql = "select n_id as id,\n" +
                "       c_login_name as loginName,\n" +
                "       c_password as password,\n" +
                "       c_nick_name as nickName,\n" +
                "       n_age as age,\n" +
                "       c_location as location\n" +
                "from db_study.t_account\n" +
                "where n_id = ?";


        List<Study> study = jdbcTemplate.query(sql,
                preparedStatement -> preparedStatement.setInt(1, id),
                new BeanPropertyRowMapper<>(Study.class));

        return study.get(0);
    }

}
