package com.example.myqrztest.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dmitriy on 17.06.15.
 */
public class CountryModel {
   private int id;
   private String country;


   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public static class List extends ArrayList<CountryModel> implements Collection<CountryModel> {
   }
}
