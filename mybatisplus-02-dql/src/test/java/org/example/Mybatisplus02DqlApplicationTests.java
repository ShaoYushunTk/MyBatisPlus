package org.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.dao.UserDao;
import org.example.domain.User;
import org.example.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

    @Autowired
    private UserDao userDao;

    /**
     * 按条件查询
     */
    @Test
    void testGetAll() {
        //方式1
        /*QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.lt("age",18); //小于18岁的查询条件
        List<User> users = userDao.selectList(queryWrapper);
        System.out.println(users);*/

        //方式2 lambda
        /*QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().lt(User::getAge,18);
        List<User> users = userDao.selectList(queryWrapper);
        System.out.println(users);*/

        //方式3 lambda
        /*LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.lt(User::getAge,18);
        List<User> users = userDao.selectList(lambdaQueryWrapper);
        System.out.println(users);*/


        //多条件查询
        /*LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        //10到30岁之间 and
        //lambdaQueryWrapper.lt(User::getAge,30).gt(User::getAge,10);
        //小于10岁或者大于30 or
        lambdaQueryWrapper.lt(User::getAge,10).or().gt(User::getAge,30);
        List<User> users = userDao.selectList(lambdaQueryWrapper);
        System.out.println(users);*/


        //条件查询存在null的处理
        //模拟页面传递的查询数据
        UserQuery userQuery = new UserQuery();
//        userQuery.setAge(10);
        userQuery.setAge2(30);

        /*LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.lt(User::getAge,userQuery.getAge2());
        lambdaQueryWrapper.gt(User::getAge,userQuery.getAge());
        List<User> users = userDao.selectList(lambdaQueryWrapper);
        System.out.println(users);*/


        /*LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //先判定第一个条件是否为true，如果为true连接当前条件
        lambdaQueryWrapper.lt(null != userQuery.getAge2(),User::getAge,userQuery.getAge2());
        lambdaQueryWrapper.gt(null != userQuery.getAge(),User::getAge,userQuery.getAge());
        List<User> users = userDao.selectList(lambdaQueryWrapper);
        System.out.println(users);*/


        //查询投影 只显示某一些字段
        /*LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId,User::getName,User::getAge);
        List<User> users = userDao.selectList(lambdaQueryWrapper);
        System.out.println(users);*/

        /*QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("count(*) as count");
        List<Map<String, Object>> maps = userDao.selectMaps(queryWrapper);
        System.out.println(maps);*/


        //查询条件
        //等值查询
        /*LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,"admin").eq(User::getPassword,"admin");
        User loginUser = userDao.selectOne(lambdaQueryWrapper);
        System.out.println(loginUser);*/

        //范围查询 lt le gt ge eq between
        /*LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.between(User::getAge,10,30);
        List<User> users = userDao.selectList(lambdaQueryWrapper);
        System.out.println(users);*/


        //模糊匹配 like
        /**
         * likeRight j%
         * likeLeft  %j
         */
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,"j");
        List<User> users = userDao.selectList(lambdaQueryWrapper);
        System.out.println(users);

    }

}
