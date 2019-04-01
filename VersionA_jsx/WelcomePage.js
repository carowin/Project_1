import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/Welcome.css';
//import NavigationPanel from './NavigationPanel.js';
import Login from './Login.js';
import SignUpPage from './SignUpPage';

class WelcomePage extends Component {
  constructor(props){
  	super(props);
    this.state = {
      signIn : false, signUp : false
    };

    this.setSignIn = this.setSignIn.bind(this);
    this.setSignUp = this.setSignUp.bind(this);
  /*	this.state = {
  	connected : false, pageCourante : 'connection'}; //specifie page courante

  	this.getConnected = this.getConnected.bind(this);
  	this.setLogout = this.setLogout.bind(this);
  */
  }
/*
  //modifie l'etat du composant (page courante: mur de tweet | utilisateur:connecté)
  getConnected(){
  	this.setState({connected : true});
  	this.setState({pageCourante:"mur de tweet"});
  }

  //modifie l'etat du composant (page courante: connection | utilisateur: non connecté)
  setLogout(){
  	this.setState({connected : false});
  	this.setState({pageCourante : 'connection'});

  }
*/

  setSignIn() {
    this.setState({signIn : true});
  }

  setSignUp() {
    this.setState({signUp : true});
  }

  render() {
    if(this.state.signIn == true){
      return(<Login/>);
    }
    else if(this.state.signUp == true){
      return (<SignUpPage/>);
    }else{
      return(
      	<div>
      		<div className="row">
  		      <div className="col-md-7">
  		      	<h1>HI ! </h1>
  		        <h1>WELCOME TO TWISTER ! </h1>
  		        <div className="button">
                <button onClick ={this.setSignIn}>SIGN IN</button>
                <button onClick ={this.setSignUp}>SIGN UP</button>
  		        </div>
  		      </div>

  		      <div className="col-md-5">
  		        <img className="img" src={marble}/>
  		      </div>
  		    </div>
  		</div>
      );
    }
  }
}

export default WelcomePage;
