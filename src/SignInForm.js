import React, { Component } from 'react';
import marble from './css/marble.jpeg';
import './bootstrap/css/bootstrap.min.css';
import './css/ConnectionB.css';
import axios from 'axios';
import {cookie} from './MainPage';

class SignInForm extends Component {
  constructor(props){
    super(props);
    this.state = { username:'', password:''};
    this.loginPage = this.loginPage.bind(this);
    this.checkLogin = this.checkLogin.bind(this);
  }

  checkLogin(r){
    if(r.data.Succes === "OK"){
        this.props.setConnection(true);
        this.props.setWall();
        cookie.set("mykey", r.data.Key);
        cookie.set("mylog", r.data.Login);
        cookie.set("myid", r.data.User_Id);
    }else{
      alert("ERROR WRONG PASSWORD/LOGIN");
    }
  }

  loginPage(){
    var formData = new URLSearchParams();
    formData.append('login', this.state.username);
    formData.append('password', this.state.password);
    axios.get('http://localhost:8080/Twister/Servlets/Login?'+formData)
      .then (r => { this.checkLogin(r); })
      .catch(r => { alert("Erreur"); });
  }

  render(){
    return(
      <div className="row">
        <div className="col-md-7">
          <h1>TWISTER</h1>

          <div className="form">
              <input type="text"
                    ref="log"
                    name="login"
                    id="login"
                    placeholder="LOGIN"
                    value={ this.state.username }
                    onChange={(e) => {this.setState({username: e.target.value})}}
              /><br />
              <input type="password"
                    ref="pass"
                    name="password"
                    id="password"
                    placeholder="PASSWORD"
                    value={ this.state.password }
                    onChange={(e) => {this.setState({password: e.target.value})}}
              /><br />

              <div className="submit">
                <input type="submit"
                    className="enter"
                    value="ENTER"
                    onClick={this.loginPage.bind(this)}
                /> <br/>
              </div>

              <div className="link">
                <a  className="resetPwd" href=" ">Reset password</a>
                <a className="signUp" onClick={this.props.setSignUp}>Sign Up</a>
              </div>
          </div>
        </div>
        <h1> {this.props.response} </h1>

        <div className="col-md-5">
          <img className="img" src={marble}/>
        </div>
    </div>
    );
  }
}

export default SignInForm;
