package az.spring.jdbc.dao.impl;

import az.spring.jdbc.config.SpringJdbcConfig;
import az.spring.jdbc.dao.EmployeeDao;
import az.spring.jdbc.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

   private final NamedParameterJdbcTemplate jdbcTemplate;
   // private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insert(Employee employee) {
        String query = "insert into employee(id,name,surname,age,salary) values(:id,:name,:surname,:age,:salary)";
       SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);
        //  SqlParameterSource parameter = new BeanPropertySqlParameterSource(employee); insert edeceyimiz parametrler
        // employee klasinin parameterleriyle ust uste dusurse (yeni id ve name insert edeceyikse ) bu varianti istifade edirik

        //ust uste dusmurse (ancaq name elave etmek isdedikde ) asagdaki varianti istifade edirik

//        SqlParameterSource parameterSource = new MapSqlParameterSource().
//                addValue("name",employee.getName())
//                .addValue("surname",employee.getSurname())
//                .addValue("age",employee.getAge())
//                .addValue("salary",employee.getSalary());
        jdbcTemplate.update(query,parameterSource);
    }

    @Override
    public void update(Employee employee) {
        String query = "update employee set name=:name,surname=:surname,age=:age,salary=:salary where id=?";
      SqlParameterSource parameterSource  = new BeanPropertySqlParameterSource(employee);
        jdbcTemplate.update(query,parameterSource);

    }

    @Override
    public void delete(int id) {
        String query = "delete from employee where id = :id  ";
     SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id",id);
        jdbcTemplate.update(query, parameterSource);
    }

    @Override
    public Employee getEmployeeById(int id) {
        String query = "select * from employee where id =:id";
        SqlParameterSource parameterSource= new MapSqlParameterSource().addValue("id",id);
        Employee employee = jdbcTemplate.queryForObject(query,parameterSource, new BeanPropertyRowMapper<>(Employee.class));

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "select * from employee";

        List<Employee> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<Employee>(Employee.class));

        return list;
    }

    @Override
    public long count() {
        String query = "select count(*) from employee";
        long count = jdbcTemplate.queryForObject(query,new MapSqlParameterSource(),Long.class);
        return count;
    }

    public static class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getInt("age"),
                    rs.getDouble("salary")
            );
        }
    }
}
