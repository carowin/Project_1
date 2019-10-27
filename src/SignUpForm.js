import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/SignUpB.css';
import axios from 'axios';


class SignUpForm extends Component {
  constructor(props){
    super(props);
    this.state = {
      firstname:'', name:'', login:'', mail:'', password:'', passwordConfirmation:''
    };
    this.checkSignUp = this.checkSignUp.bind(this);
  }

  checkSignUp(){
    var formData = new URLSearchParams();
    formData.append('login', this.state.login);
    formData.append('password', this.state.password);
    formData.append('mail', this.state.mail);
    formData.append('name', this.state.name);
    formData.append('firstName', this.state.firstname);

    axios.get('http://localhost:8080/Twister/Servlets/CreateUser?'+formData)
    .then (r => {
      if(this.state.password === this.state.passwordConfirmation){
        if(r.data.Status === "succes"){
          this.props.setLogout();
          
        }else{
          alert("ERROR CANNOT CREATE USER, TRY AGAIN");
        }
      }else{
        alert("YOU MUST TYPE THE SAME PASSWORD, TRY AGAIN");
      }
     })
    .catch(r => { alert("Erreur"); });
  }

  render(){

    return (
      <div className="row">
     <div className="col-md-7">
       <div className="form">
         <h1>SIGN UP</h1>

         <div className="input">
          <input
            type="text"
            name="firstname"
            id="firsname"
            placeholder="FIRSTNAME"
            value={ this.state.firstname }
            onChange={(e) => {this.setState({firstname: e.target.value})}}
          /><br />

          <input
            type="text"
            name="name"
            id="name"
            placeholder="NAME"
            value={ this.state.name }
            onChange={(e) => {this.setState({name: e.target.value})}}
          /><br />

          <input
            type="text"
            name="login"
            id="login"
            placeholder="LOGIN"
            value={ this.state.login }
            onChange={(e) => {this.setState({login: e.target.value})}}
          /><br />

          <input
            type="text"
            name="mail"
            id="email"
            placeholder="MAIL"
            value={ this.state.mail }
            onChange={(e) => {this.setState({mail: e.target.value})}}
          /><br />

          <input
            type="password"
            name="password"
            id="password"
            placeholder="PASSWORD"
            value={ this.state.password }
            onChange={(e) => {this.setState({password: e.target.value})}}
          /><br />
          <input
            type="password"
            name="retype"
            id="retype"
            placeholder="TYPE AGAIN"
            value={ this.state.passwordConfirmation }
            onChange={(e) => {this.setState({passwordConfirmation: e.target.value})}}
          /><br />
         </div>

         <div className="submit"><br />
           <input
            onClick = {this.props.setLogout}
            type="submit"
            value="Cancel"
           />
           <input
            onClick = {this.checkSignUp.bind(this)}
            type="submit"
            value="Enter" />
         </div>
       </div>
     </div>

     <div className="col-md-5">
       <img className="img" src={marble}/>
     </div>
   </div>
    );
  }

}

export default SignUpForm;
