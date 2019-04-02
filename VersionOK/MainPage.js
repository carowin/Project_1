import React, { Component } from 'react';
import NavigationPanel from './NavigationPanel';
import ContentPanel from './ContentPanel'

class MainPage extends Component {
  constructor(props){
    super(props);
  	this.state = {
    isConnected : false, pageCourante : 'connection'}; //specifie page courante

    this.setLogin = this.setLogin.bind(this);
    this.setLogout = this.setLogout.bind(this);
    this.setSignIn = this.setSignIn.bind(this);
    this.setSignUp = this.setSignUp.bind(this);
  }


  //modifie l'etat du composant (page courante: connection | utilisateur: non connecté)
  setLogout(){
    this.setState({isCconnected : false});
    this.setState({pageCourante : 'connection'});
  }

  setLogin(){
    this.setState({isCconnected : true});
    this.setState({pageCourante : 'mur de tweet'});
  }

  setSignIn(){
    this.setState({pageCourante : 'signInForm'});
  }

  setSignUp(){
    this.setState({pageCourante : 'signUpForm'});
  }


  render(){
    let navPanel, contentPanel;

    navPanel = <NavigationPanel
                  isConnected={this.state.isConnected}
                  signIn={this.setSignIn}
                  signUp={this.setSignUp}
                  login={this.setLogin}
                  logout={this.setLogout}
               />;
    contentPanel = <ContentPanel
                      isConnected={this.state.isConnected}
                      pageCourante={this.state.pageCourante}
                      signIn={this.setSignIn}
                      signUp={this.setSignUp}
                      login={this.setLogin}
                      logout={this.setLogout}
                   />;

    return (<div> {navPanel}{contentPanel} </div>);
  }
}

export default MainPage;
