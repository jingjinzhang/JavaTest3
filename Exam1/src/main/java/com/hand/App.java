package com.hand;

import com.hand.util.ConnectionFactory;

import java.sql.*;

public class App
{
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/sakila","root","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main( String[] args )
    {
        query1(87);
        query2(130);
    }


    public static void query1(int countryId){
        Connection conn = getConnection();
        String querySQL = "SELECT city_id as cityId,city From city WHERE city.country_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(querySQL);
            ps.setInt(1,countryId);
            ResultSet rs = ps.executeQuery();
            System.out.println("Country ID: "+countryId);
            while(rs.next()){
                System.out.println(rs.getInt("cityId")+" | " + rs.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void query2(int customerId){
        Connection conn = getConnection();
        String querySQL = "select rental.rental_date,inventory.film_id,film.title from rental,inventory,film where rental.inventory_id=inventory.inventory_id and inventory.film_id=film.film_id and rental.customer_id=? order by rental_date desc";
        try {
            PreparedStatement ps = conn.prepareStatement(querySQL);
            ps.setInt(1,customerId);
            ResultSet rs = ps.executeQuery();
            System.out.println("Customer ID: "+customerId);
            while(rs.next()){
                System.out.println(rs.getInt("inventory.film_id")+" | " + rs.getString("film.title") + " | " + rs.getString("rental.rental_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
