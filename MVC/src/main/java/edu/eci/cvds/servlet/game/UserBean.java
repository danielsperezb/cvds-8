package edu.eci.cvds.servlet.game;


import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.cvds.servlet.ConfigurationService;




@Component
@ManagedBean
@SessionScoped
public class UserBean {

   private String userName;
   @Autowired
   private ConfigurationService configurationService;
   @Autowired
   private GuessBean guessBean;

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public void ingresar(){
      int premio = Integer.parseInt(configurationService.getConfiguration("Premio").getValor());
      guessBean.setPrize(premio); 
   }
   
   
}
