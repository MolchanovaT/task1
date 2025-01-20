package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
//        Connection connection = Util.getConnection();
//        if (connection != null) {
//            System.out.println("Успешное соединение с базой данных");
//        } else {
//            System.out.println("Не удалось подключиться к базе данных");
//        }

        UserDao userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();
        System.out.println("Таблица пользователей создана");

        userDao.saveUser("Tatiana", "Molchanova", (byte) 37);
        userDao.saveUser("Sergei", "Kuzminok", (byte) 36);
        userDao.saveUser("Samuel", "Kuzminok", (byte) 2);
        userDao.saveUser("Padma", "Kuzminok", (byte) 0);

        System.out.println("Список всех пользователей:");
        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }

        userDao.cleanUsersTable();
        System.out.println("Таблица очищена");

        userDao.dropUsersTable();
        System.out.println("Таблица удалена");
    }
}
