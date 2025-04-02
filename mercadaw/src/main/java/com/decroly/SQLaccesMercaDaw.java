package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class SQLaccesMercaDaw {

    //toda la info
    public List<String> getallInfo(){
        List<String> allInfo = new LinkedList<>();

        String getAll = "SELECT * FROM producto";

                try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                allInfo.add(dataSet.getNString("nombre"));
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return allInfo;
    }


    //Buscar producto por referencia
    
    public List<CharacterDC> getCharacterByName(String characterName){
        List<CharacterDC> charactersNames = new LinkedList<>();

        String sqlStatement = "SELECT * FROM characters where heroName = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setString(1, characterName);
            ResultSet dataSet = statement.executeQuery();

            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String name = dataSet.getNString(2);
                String fullname = dataSet.getNString(3);
                String gender = dataSet.getNString(7);
                String race = dataSet.getNString(8);
                String aligment = dataSet.getNString(9);

                CharacterDC c1 =  new CharacterDC(id, name, fullname, gender, race, aligment);
                charactersNames.add(c1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return charactersNames;
    }

}
